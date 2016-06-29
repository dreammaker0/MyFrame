package com.example.lcy.myframe.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-6-28.
 */
public class CommonEntity {

    /**
     * error : false
     * results : [{"_id":"5771d5eb421aa931ddcc50d6","createdAt":"2016-06-28T09:42:03.761Z","desc":"Dagger2图文完全教程","publishedAt":"2016-06-28T11:33:25.276Z","source":"web","type":"Android","url":"https://github.com/luxiaoming/dagger2Demo","used":true,"who":"代码GG陆晓明"},{"_id":"5771c9ca421aa931ca5a7e59","createdAt":"2016-06-28T08:50:18.731Z","desc":"Android Design 设计模板","publishedAt":"2016-06-28T11:33:25.276Z","source":"chrome","type":"Android","url":"https://github.com/andreasschrade/android-design-template","used":true,"who":"代码家"},{"_id":"577107c6421aa97f6e43a4c1","createdAt":"2016-06-27T19:02:30.949Z","desc":"Narrate is a beautiful and functional open source journal for Android https://timothymiko.github.io/narrate-android","publishedAt":"2016-06-28T11:33:25.276Z","source":"web","type":"Android","url":"https://github.com/timothymiko/narrate-android","used":true,"who":"joker"},{"_id":"5770813b421aa94f45912ea7","createdAt":"2016-06-27T09:28:27.375Z","desc":"全新的快速索引导航栏，联系人字母排序侧边栏。","publishedAt":"2016-06-27T11:31:53.48Z","source":"chrome","type":"Android","url":"https://github.com/kongnanlive/SideBar","used":true,"who":"大熊"},{"_id":"576fd347421aa95318978e82","createdAt":"2016-06-26T21:06:15.698Z","desc":"IconFont的制作和在Android上的应用","publishedAt":"2016-06-28T11:33:25.276Z","source":"web","type":"Android","url":"http://hujiaweibujidao.github.io/blog/2016/06/25/Ways-to-Use-Icons-on-Android-2/","used":true,"who":"潇涧"},{"_id":"576fc31a421aa94f45912ea3","createdAt":"2016-06-26T19:57:14.10Z","desc":"超赞！Android 多主题切换库！","publishedAt":"2016-06-27T11:31:53.48Z","source":"chrome","type":"Android","url":"https://github.com/52inc/Scoops","used":true,"who":"代码家"},{"_id":"576f3335421aa934bb278209","createdAt":"2016-06-26T09:43:17.534Z","desc":"Android如何搭建一个局域网web服务器","publishedAt":"2016-06-27T11:31:53.48Z","source":"web","type":"Android","url":"http://www.yanzhenjie.com/andserver.html","used":true,"who":"严振杰"},{"_id":"576d3e21421aa91fb8bc6109","createdAt":"2016-06-24T22:05:21.934Z","desc":"MagicaSakura 是 Android 多主题框架","publishedAt":"2016-06-27T11:31:53.48Z","source":"chrome","type":"Android","url":"https://github.com/Bilibili/MagicaSakura","used":true,"who":"Jason"},{"_id":"576ccd78421aa90c81e16670","createdAt":"2016-06-24T14:04:40.957Z","desc":"图解 Android 事件分发机制","publishedAt":"2016-06-28T11:33:25.276Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/e99b5e8bd67b","used":true,"who":"潇涧"},{"_id":"576ca580421aa94f422c94fb","createdAt":"2016-06-24T11:14:08.166Z","desc":"各种动画效果的LoadingView","publishedAt":"2016-06-24T12:01:16.638Z","source":"chrome","type":"Android","url":"https://github.com/ldoublem/LoadingView","used":true,"who":"dreamxuwj"}]
     */

    private boolean error;
    /**
     * _id : 5771d5eb421aa931ddcc50d6
     * createdAt : 2016-06-28T09:42:03.761Z
     * desc : Dagger2图文完全教程
     * publishedAt : 2016-06-28T11:33:25.276Z
     * source : web
     * type : Android
     * url : https://github.com/luxiaoming/dagger2Demo
     * used : true
     * who : 代码GG陆晓明
     */

    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean extends MultiItemEntity {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "_id='" + _id + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", source='" + source + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", used=" + used +
                    ", who='" + who + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CommonEntity{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
