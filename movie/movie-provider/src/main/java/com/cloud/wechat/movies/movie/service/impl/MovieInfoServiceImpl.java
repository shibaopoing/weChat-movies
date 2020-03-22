package com.cloud.wechat.movies.movie.service.impl;

import com.cloud.wechat.movies.dto.rsp.BaseRsp;
import com.cloud.wechat.movies.movie.api.dto.QueryMovieListDto;
import com.cloud.wechat.movies.movie.service.IMovieInfoService;
import org.springframework.stereotype.Service;

@Service
public class MovieInfoServiceImpl implements IMovieInfoService {
    @Override
    public BaseRsp queryMovieList(QueryMovieListDto queryMovieListDto) {
        return BaseRsp.returnSuccss();
    }
}
