package com.cloud.wechat.movies.movie.api.dto;

import com.cloud.wechat.movies.dto.req.BaseReq;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: 石保平
 * @Description: ${description}
 * @Date: 2019/3/16 22:27
 * @Version: 1.0
 */
public class QueryMovieListDto extends BaseReq implements Serializable {
    private  static final  long serialVersionUID=233120897433423L;
    //@NotBlank(message = "不能为空")
    private String movieName;
    private String movieYear;
    private String movieType;
    private String movieUrl;
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getMovieUrl() {
        return movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }
}
