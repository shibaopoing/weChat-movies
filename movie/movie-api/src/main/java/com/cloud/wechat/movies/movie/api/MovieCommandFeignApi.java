package com.cloud.wechat.movies.movie.api;

import com.cloud.wechat.movies.movie.api.sentinel.MovieCommandFeignSentinel;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: 石保平
 * @Description: 提供CHAT命令服务
 * @Date: 2019/2/24 14:00
 * @Version: 1.0
 */
@FeignClient(value = "movie-command",fallback = MovieCommandFeignSentinel.class)
public interface MovieCommandFeignApi {

}
