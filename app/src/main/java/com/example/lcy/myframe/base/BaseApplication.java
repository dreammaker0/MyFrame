package com.example.lcy.myframe.base;

import android.app.Application;
import android.content.Context;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.cookie.store.PersistentCookieStore;
import com.lzy.okhttputils.model.HttpHeaders;
import com.lzy.okhttputils.model.HttpParams;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;


/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-6-7.
 */
public class BaseApplication extends Application {
    public static Context mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        // 默认使用的高度是设备的可用高度，也就是不包括状态栏和底部的操作栏的，如果你希望拿设备的物理高度进行百分比化
        //AutoLayoutConifg.getInstance().useDeviceSize();
        // 初始化日志得到TAG
        Logger.init("lcy");
        LeakCanary.install(this);
        initOkHttpConfig();

    }

    /**
     * 配置OkHttp
     */
    private void initOkHttpConfig() {
        HttpHeaders headers = new HttpHeaders();
        headers.put("commonHeaderKey1", "commonHeaderValue1");    //所有的 header 都 不支持 中文
        headers.put("commonHeaderKey2", "commonHeaderValue2");
        HttpParams params = new HttpParams();
        params.put("imme", "commonParamsValue1");     //所有的 params 都 支持 中文
        params.put("ip", "这里支持中文参数");
        //必须调用初始化
        OkHttpUtils.init(this);
        //以下都不是必须的，根据需要自行选择
        OkHttpUtils.getInstance()//
                .debug("OkHttpUtils")                                              //是否打开调试
                .setConnectTimeout(OkHttpUtils.DEFAULT_MILLISECONDS)               //全局的连接超时时间
                .setReadTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)                  //全局的读取超时时间
                .setWriteTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)                 //全局的写入超时时间
//              .setCookieStore(new MemoryCookieStore())                           //cookie使用内存缓存（app退出后，cookie消失）
                .setCookieStore(new PersistentCookieStore())                       //cookie持久化存储，如果cookie不过期，则一直有效
                .addCommonHeaders(headers)                                         //设置全局公共头
                .addCommonParams(params);                                          //设置全局公共参数
    }

}
