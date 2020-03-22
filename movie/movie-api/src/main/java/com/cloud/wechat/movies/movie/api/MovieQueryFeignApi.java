package com.cloud.wechat.movies.movie.api;

import com.cloud.wechat.movies.dto.rsp.BaseRsp;
import com.cloud.wechat.movies.movie.api.dto.QueryMovieListDto;
import com.cloud.wechat.movies.movie.api.sentinel.MovieQueryFeignSentinel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: 石保平
 * @Description: 获取电影列表
 * @Date: 2019/2/24 14:02
 * @Version: 1.0
 */
@FeignClient(value = "movie-query",fallback = MovieQueryFeignSentinel.class)
public interface MovieQueryFeignApi {
    @PostMapping("/getMovieList")
    public BaseRsp getMovieList(QueryMovieListDto queryMovieListDto);
}
