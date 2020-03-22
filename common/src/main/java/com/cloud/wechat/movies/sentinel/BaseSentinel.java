package com.cloud.wechat.movies.sentinel;

import com.cloud.wechat.movies.constants.RspCodeEnum;
import com.cloud.wechat.movies.dto.rsp.BaseRsp;

/**
 * @Author huabao.fang
 * @Date 14:43 2019-02-21
 **/
public class BaseSentinel {

    protected BaseRsp defualt(){
        return BaseRsp.returnFail(RspCodeEnum.ERROR.SYS_BUSY);
    }

}
