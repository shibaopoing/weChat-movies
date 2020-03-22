package com.cloud.wechat.movies.movie.service;

import com.cloud.wechat.movies.dto.rsp.BaseRsp;
import com.cloud.wechat.movies.movie.api.dto.QueryMovieListDto;

/**
 * 电影信息服务
 */
public interface IMovieInfoService {
    /**
     * 查询电影信息
     */
    public BaseRsp queryMovieList(QueryMovieListDto queryMovieListDto);
}
