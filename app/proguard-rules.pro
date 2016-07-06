# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:\Program Files\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
# This is a configuration file for ProGuard.
# http://proguard.sourceforge.net/index.html#manual/usage.html
#
# Starting with version 2.2 of the Android plugin for Gradle, these files are no longer used. Newer
# versions are distributed with the plugin and unpacked at build time. Files in this directory are
# no longer maintained.



##-----------------第三方jar包配置（选择性添加）-------------------------
# ImageLoader
-dontwarn com.nostra13.universalimageloader.**
-keep class com.nostra13.universalimageloader.** { *; }

# 融云
-dontwarn io.rong.**
-keep class io.rong.** {*;}
-keepclassmembers class **.R$* {
    public static <fields>;
}
-keep class *.R$ { *;}

# 腾讯
-dontwarn com.tencent.**
-keep class com.tencent.** { *;}

# SlidingMenu
-dontwarn com.jeremyfeinstein.slidingmenu.**
-keep class com.jeremyfeinstein.slidingmenu.** { *; }

# xutils
-dontwarn com.lidroid.xutils.**
-keep class com.lidroid.** { *; }
-keep class * extends java.lang.annotation.Annotation { *; }

# 友盟在线更新
-dontwarn com.umeng.**
-keep public class * extends com.umeng.**
-keep class com.umeng.** {*;}

# 友盟推送
-keep class com.umeng.message.* {
        public <fields>;
        public <methods>;
}
-keep class com.umeng.message.protobuffer.* {
        public <fields>;
        public <methods>;
}
-keep class com.squareup.wire.* {
        public <fields>;
        public <methods>;
}
-keep class org.android.agoo.impl.*{
        public <fields>;
        public <methods>;
}
-keep class org.android.agoo.service.* {*;}
-keep class org.android.spdy.**{*;}

# 新浪微博
-dontwarn com.sina.weibo.sdk.**
-keep class com.sina.weibo.sdk.** { *; }

# fastjson
-dontwarn com.alibaba.fastjson.**
-keep class com.alibaba.fastjson.** { *; }

# pulltorefresh
-dontwarn com.handmark.pulltorefresh.library.**
-dontwarn com.handmark.pulltorefresh.library.extras.**
-dontwarn com.handmark.pulltorefresh.library.internal.**
-keep class com.handmark.pulltorefresh.library.** { *;}
-keep class com.handmark.pulltorefresh.library.extras.** { *;}
-keep class com.handmark.pulltorefresh.library.internal.** { *;}

# 百度地图
# 地图组件包括图层、定位等接口所有的类及类里面的内容都不要混淆
# 交通实况相关的类及类里面的所有内容不要混淆
-keep class com.baidu.** { *; }
-keep class vi.com.gdi.bgl.android.**{*;}

# android v4 v7扩展包
-dontwarn android.support.**
-keep class android.support.v4.** { *; }
-keep class android.support.v7.** { *; }
#Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
#materialdrawer
-dontwarn com.mikepenz.materialdrawer.**
-keep class com.mikepenz.materialdrawer.** {*;}
#butterknife
-keep class butterknife.** {*;}
#materialdialogs
-dontwarn com.afollestad.materialdialogs.commons.**
-keep class com.afollestad.materialdialogs.commons.** {*;}
#android.support
-dontwarn android.support.**
-keep class android.support.** {*;}
#Gson
-dontwarn retrofit2.**
-keep class retrofit2.** {*;}

-dontwarn com.google.gson.**
-keep class com.google.gson.** {*;}


#okhttp3
-dontwarn okhttp3.**
-keep class okhttp3.** {*;}

-dontwarn com.mikepenz.**
-keep class com.mikepenz.** {*;}

-dontwarn com.lzy.okhttputils.**
-keep class com.lzy.okhttputils.** {*;}

-dontwarn okio.**
-keep class okio.Okio.** {*;}

-keep class com.example.lcy.myframe.widget.** {*;}

-keep class com.facebook.stetho.** {*;}

-keep class com.facebook.stetho.** {*;}

-keep class com.zhy.autolayout.** {*;}

-keep class com.lzy.** {*;}

-keep class me.zhanghai.** {*;}

-keep class com.chad.library.** {*;}



#忽略警告
-ignorewarning

#####################记录生成的日志数据,gradle build时在本项目根目录输出################

#apk 包内所有 class 的内部结构
-dump class_files.txt
#未混淆的类和成员
-printseeds seeds.txt
#列出从 apk 中删除的代码
-printusage unused.txt
#混淆前后的映射
-printmapping mapping.txt

#####################记录生成的日志数据，gradle build时 在本项目根目录输出-end################
# webview + js
-keepattributes *JavascriptInterface*
# keep 使用 webview 的类
-keepclassmembers class  com.example.lcy.myframe.ui.view.WebViewActivity {
   public *;
}
# keep 使用 webview 的类的所有的内部类
-keepclassmembers  class  com.example.lcy.myframe.ui.view.WebViewActivity$*{
    *;
}

#保持 native 方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

#保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

#保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
#保持自定义控件类不被混淆
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

#保持 Parcelable 不被混淆
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

#保持 Serializable 不被混淆
-keepnames class * implements java.io.Serializable

#保持 Serializable 不被混淆并且enum 类也不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    !private <fields>;
    !private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

#保持枚举 enum 类不被混淆 如果混淆报错，建议直接使用上面的 -keepclassmembers class * implements java.io.Serializable即可
#-keepclassmembers enum * {
#  public static **[] values();
#  public static ** valueOf(java.lang.String);
#}

-keepclassmembers class * {
    public void *ButtonClicked(android.view.View);
}

#不混淆资源类
-keepclassmembers class **.R$* {
    public static <fields>;
}