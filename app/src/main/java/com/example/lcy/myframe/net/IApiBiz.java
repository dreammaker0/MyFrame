package com.example.lcy.myframe.net;

import com.example.lcy.myframe.entity.CommonEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lcy on 2016-5-12.
 */
public interface IApiBiz {
    // 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
    @GET("/api/data/{type}/{pageSize}/{pageNo}")
    Call<CommonEntity> getAndroid(@Path("type") String type, @Path("pageSize") int pageSize, @Path("pageNo") int pageNo);
}
