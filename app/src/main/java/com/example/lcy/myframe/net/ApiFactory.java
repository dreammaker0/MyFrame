package com.example.lcy.myframe.net;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-6-7.
 */
public enum ApiFactory {
    INSTANCE;

    private final IApiBiz gankAPI;

    ApiFactory() {
        gankAPI = RetrofitClient.INSTANCE.getRetrofit().create(IApiBiz.class);
    }

    public IApiBiz getAPI() {
        return gankAPI;
    }

}
