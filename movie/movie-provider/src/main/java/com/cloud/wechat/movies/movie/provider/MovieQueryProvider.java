package com.cloud.wechat.movies.movie.provider;

import com.cloud.wechat.movies.dto.rsp.BaseRsp;
import com.cloud.wechat.movies.movie.api.MovieQueryFeignApi;
import com.cloud.wechat.movies.movie.api.dto.QueryMovieListDto;
import com.cloud.wechat.movies.movie.service.IMovieInfoService;
import com.cloud.wechat.movies.provider.BaseProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieQueryProvider extends BaseProvider implements MovieQueryFeignApi {
    @Autowired
    IMovieInfoService movieInfoService;

    @Override
    public BaseRsp getMovieList(QueryMovieListDto queryMovieListDto) {
      return   movieInfoService .queryMovieList(queryMovieListDto);
    }
}
