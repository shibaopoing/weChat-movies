package com.cloud.wechat.movies.security.utils;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Hex;

import java.io.*;
import java.util.Properties;


/**
 * 恒生核心系统MAC算法移植。他们将整个报文使用默认的12345678为密钥进行加密，算法是DES-ECB， 64位块长算法，自定义的填充方法(最少填一个块，填0x80打头的全0)
 * 这里假定运行环境JDK肯定支持DES/ECB/NoPadding加密，所以将所有的checked exception转化为runtime exception了
 * @author binarier
 *
 */
public class HSDES {

	/**
	 * 使用"12345678"为密钥生成4字节的MAC，ASCII字符
	 * @param datain 整个报文
	 * @return 4字节的MAC，ASCII字符
	 */
	public static byte[] genMAC(byte datain[])
	{
		return genMAC(datain, "30202000");
	}

	/**
	 * 生成4字节的MAC，ASCII字符
	 * @param datain 整个报文
	 * @paramkey DES加密密钥
	 * @return 4字节的MAC，ASCII字符
	 */
	public static byte[] genMAC(byte datain[], String macKey)
	{
		try
		{
			byte key[] = macKey.getBytes();
			//初始化密钥基础设施
			SecretKey desKey = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(key));
			Cipher c = Cipher.getInstance("DES/ECB/NoPadding");
	        c.init(Cipher.ENCRYPT_MODE, desKey);

	        //至少补一个8字节块
			int len = (datain.length / 8 + 1) * 8;

			byte data[] = new byte[len];
			System.arraycopy(datain, 0, data, 0, datain.length);
			//补的数据以0x80打头，后面是0;
			data[datain.length] = (byte)0x80;

			//加密缓冲区
			byte buff[] = new byte[8];
			for (int j=0;j<len;j+=8)
			{
				//以8字节为一块循环
				for (int i=0;i<8;i++)
				{
					if (j == 0)
						buff[i] = data[i];
					else
						buff[i] ^= data[j + i];
				}
				buff = c.doFinal(buff);

				//使用加密后值的前四字节的大写HEX码作为下一次运算的值 —— 略奇葩
				char hex[] = Hex.encodeHex(buff, false);
				for (int i=0;i<8;i++)
					buff[i] = (byte)hex[i];
			}
			//取最后值的前四字节为MAC值
			return buff;
		}
		catch (Exception e)
		{
			//所有异常都当运行时抛出
			throw new IllegalArgumentException(e);
		}
	}
	public static String toHexString(byte[] byteArray) {
		  if (byteArray == null || byteArray.length < 1)
		   throw new IllegalArgumentException("this byteArray must not be null or empty");

		  final StringBuilder hexString = new StringBuilder();
		  for (int i = 0; i < byteArray.length; i++) {
		   if ((byteArray[i] & 0xff) < 0x10)//0~F前面不零
		    hexString.append("0");
		   hexString.append(Integer.toHexString(0xFF & byteArray[i]));
		  }
		  return hexString.toString().toLowerCase();
	}
	/**
	 *获取MAC值4位
	 * @author Spping
	 * @throws UnsupportedEncodingException
	 *
	 */
	public static String getBodyMac(String str) throws UnsupportedEncodingException {
		//解密mac密钥
		//String macKey = ConfigUtils.getProperty("galaxy.eai.macKey");
		String macKey = getCurrentPropertiesValue("galaxy.eai.macKey","galaxy.properties");
		byte buf[]=HSDES.genMAC(str.getBytes("GBK"),macKey);
		//取最后值的前四字节为MAC值
		byte mac[] = new byte[4];
		System.arraycopy(buf,0,mac,0,4);
		return new String(mac);
	}
	/**
	 * 根据配置变量实时获取配置文件中的值
	 * @param key 配置名
	 * @param filePath 配置文件路径名，例如：test.properties
	 * @return 配置值
	 */
	private static String getCurrentPropertiesValue(String key,String filePath){
		String value="";
		Properties p = new Properties();
		try {
			String dirPath = Thread.currentThread().getContextClassLoader().getResource(filePath).getPath();//获取config.properties文件所在的父目录
			InputStream is = new FileInputStream(dirPath);
			p.load(is);
			value = p.get(key ).toString();
		} catch (FileNotFoundException e) {
			//log.error("获取mac属性值文件没找到"+e.getMessage());
			return "";
		} catch (IOException e) {
			//log.error("获取mac属性值错误"+e.getMessage());
			return "";
		}
		return value;
	}
	/**
	 * 加密一串文字
	 */
	public static void main(String[] args) {
		String src = "12345578";
		System.out.println(toHexString(genMAC(src.getBytes())));
	}
}
