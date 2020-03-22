package com.cloud.wechat.movies.movie.api.sentinel;

import com.cloud.wechat.movies.dto.rsp.BaseRsp;
import com.cloud.wechat.movies.movie.api.MovieQueryFeignApi;
import com.cloud.wechat.movies.movie.api.dto.QueryMovieListDto;
import com.cloud.wechat.movies.sentinel.BaseSentinel;
import org.springframework.stereotype.Component;

@Component
public class MovieQueryFeignSentinel extends BaseSentinel implements MovieQueryFeignApi {
    @Override
    public BaseRsp getMovieList(QueryMovieListDto queryMovieListDto) {
        return defualt();
    }
}
