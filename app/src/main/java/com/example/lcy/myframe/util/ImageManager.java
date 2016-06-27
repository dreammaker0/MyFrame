package com.example.lcy.myframe.util;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lcy.myframe.R;

/**
 * Glide图片加载管理类
 * Created by lcy on 16/4/6.
 */
public class ImageManager {

    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    private ImageManager() {}

    private static class ImageManagerHolder {
        private static ImageManager instance = new ImageManager();
    }

    public static ImageManager getInstance() {
        return ImageManagerHolder.instance;
    }

    /**
     * 将资源ID转为Uri
     * @param context       上下文
     * @param resourceId    资源id
     * @return
     */
    public Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }

    /**
     * 加载网络图片
     * @param context   上下文
     * @param url       url地址
     * @param imageView 显示的imageView
     */
    public void loadUrlImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.color.font_black_6)
                .error(R.color.font_black_6)
                .crossFade()
                .into(imageView);
    }

    /**
     * 加载drawable图片
     * @param context   上下文
     * @param resId     资源id
     * @param imageView 显示的imageView
     */
    public void loadResImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resourceIdToUri(context, resId))
                .placeholder(R.color.font_black_6)
                .error(R.color.font_black_6)
                .crossFade()
                .into(imageView);
    }

    /**
     * 加载本地图片
     * @param context   上下文
     * @param path      本地路径
     * @param imageView 显示的imageView
     */
    public void loadLocalImage(Context context, String path, ImageView imageView) {
        Glide.with(context)
                .load("file://" + path)
                .placeholder(R.color.font_black_6)
                .error(R.color.font_black_6)
                .crossFade()
                .into(imageView);
    }

    /**
     * 加载网络圆形图片
     * @param context   上下文
     * @param url       url地址
     * @param imageView 显示的imageView
     */
    public void loadCircleImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.color.font_black_6)
                .error(R.color.font_black_6)
                .crossFade()
                .transform(new GlideCircleTransform(context))
                .into(imageView);
    }

    /**
     * 加载drawable圆形图片
     * @param context   上下文
     * @param resId     资源id
     * @param imageView 显示的imageView
     */
    public void loadCircleResImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resourceIdToUri(context, resId))
                .placeholder(R.color.font_black_6)
                .error(R.color.font_black_6)
                .crossFade()
                .transform(new GlideCircleTransform(context))
                .into(imageView);
    }

    /**
     * 加载本地圆形图片
     * @param context   上下文
     * @param path      本地路径
     * @param imageView 显示的imageView
     */
    public void loadCircleLocalImage(Context context, String path, ImageView imageView) {
        Glide.with(context)
                .load("file://" + path)
                .placeholder(R.color.font_black_6)
                .error(R.color.font_black_6)
                .crossFade()
                .transform(new GlideCircleTransform(context))
                .into(imageView);
    }

    /**
     * 加载网络圆角图片
     * @param context   上下文
     * @param url       url地址
     * @param imageView 显示的imageView
     */
    public void loadRoundImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.color.font_black_6)
                .error(R.color.font_black_6)
                .crossFade()
                .transform(new GlideRoundTransform(context))
                .into(imageView);
    }

}
