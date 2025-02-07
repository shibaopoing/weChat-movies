package com.cloud.wechat.movies.exceptions;

import com.cloud.wechat.movies.constants.RspCodeEnum;

import java.io.Serializable;

public class AppException extends RuntimeException implements Serializable {
    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = 1L;
    private String errCode;
    private String errMsg;

    public String getCode() {
        return errCode;
    }

    public String getMsg() {
        return errMsg;
    }

    public AppException(RspCodeEnum.ERROR rspCode) {
        super(rspCode.getMsg());
        this.errCode = rspCode.getCode();
        this.errMsg = rspCode.getMsg();
    }
    public AppException(RspCodeEnum.ERROR  resp, Object... args) {
        super(getCodeAndMsg(resp, args));
        this.errCode = resp.getCode();
        if(args.length != 0) {
            this.errMsg = resp.getRspMsg(args);
        } else {
            this.errMsg = resp.getRspMsg().replaceAll("%s", "");
        }

    }
    public AppException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
    public RspCodeEnum getErrorMsg() {
        return  new RspCodeEnum(this.errCode,this.errMsg);
    }

    private static String getCodeAndMsg(RspCodeEnum.ERROR resp, Object... args) {
        String code = resp.getCode();
        String msg = null;
        if(args.length != 0) {
            msg = resp.getRspMsg(args);
        } else {
            msg = resp.getMsg().replaceAll("%s", "");
        }

        return code + "-" + msg;
    }
}
