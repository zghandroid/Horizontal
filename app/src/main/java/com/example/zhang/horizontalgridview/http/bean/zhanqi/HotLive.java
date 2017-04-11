package com.example.zhang.horizontalgridview.http.bean.zhanqi;

import java.util.List;

/**
 * Created by 12345 on 2017/4/6.
 */

public class HotLive {

    /**
     * keyword : app.livenow
     * title : 热门直播
     * icon : https://img1.zhanqi.tv/uploads/2016/09/positionicon-2016091118101914138.png
     * channelIds : null
     * gameIds : null
     * moreUrl : /lives
     * nums : 4
     * subTitle : 精彩热门，战旗比你更懂你
     * anchors : [{"nickname":"精彩热门，战旗比你更懂你"}]
     * lists : [{"id":"22946","uid":"104275825","nickname":"丶剑圣怒江丶","gender":"2","avatar":"https://img2.zhanqi.tv/avatar/f9/189/104275825_1432917525.jpg","code":"1128422","url":"/nujiang","title":"虚弱剑神，第一剑圣怒江，三万把的王者剑圣","gameId":"6","spic":"https://img1.zhanqi.tv/live/20170406/22946_2017-04-06-11-35-50.jpg","bpic":"https://img1.zhanqi.tv/live/20170406/22946_2017-04-06-11-35-50_big.jpg","online":"48999","status":"4","hotsLevel":"30","videoId":"22946_97SYY","verscr":"0","gameName":"英雄联盟","gameUrl":"/games/lol","highlight":0,"fireworks":"","fireworksHtml":""},{"id":"46397","uid":"22378685","nickname":"鹏鹏博士","gender":"2","avatar":"https://img2.zhanqi.tv/avatar/68/42c/22378685_1477491442.jpg","code":"1151872","url":"/lipeng","title":"一个歌唱家的炉石之旅！！","gameId":"9","spic":"https://img1.zhanqi.tv/live/20170406/46397_2017-04-06-11-36-35.jpg","bpic":"https://img2.zhanqi.tv/live/20170406/46397_2017-04-06-11-36-35_big.jpg","online":"7651","status":"4","hotsLevel":"26","videoId":"46397_h7QoS","verscr":"0","gameName":"炉石传说","gameUrl":"/games/how","highlight":0,"fireworks":"","fireworksHtml":""},{"id":"50468","uid":"105169617","nickname":"花菜老湿","gender":"2","avatar":"https://img2.zhanqi.tv/avatar/12/d55/105169617_1490972386.jpg","code":"1155943","url":"/1155943","title":"花菜:七日杀纯净联机 呜呜呜","gameId":"49","spic":"https://img1.zhanqi.tv/live/20170406/50468_2017-04-06-11-39-26.jpg","bpic":"https://img1.zhanqi.tv/live/20170406/50468_2017-04-06-11-39-26_big.jpg","online":"581","status":"4","hotsLevel":"14","videoId":"50468_YUpY2","verscr":"0","gameName":"单机游戏","gameUrl":"/games/danji","highlight":0,"fireworks":"","fireworksHtml":""},{"id":"41836","uid":"104264869","nickname":"从不被乐的久雨丷","gender":"2","avatar":"https://img2.zhanqi.tv/avatar/ce/e93/104264869_1483325964.jpg","code":"1147311","url":"/1147311","title":"故意让对面一个天妒","gameId":"13","spic":"https://img1.zhanqi.tv/live/20170406/41836_2017-04-06-11-36-12.jpg","bpic":"https://img1.zhanqi.tv/live/20170406/41836_2017-04-06-11-36-12_big.jpg","online":"1531","status":"4","hotsLevel":"14","videoId":"41836_1ATbr","verscr":"0","gameName":"三国杀","gameUrl":"/games/sanguosha","highlight":0,"fireworks":"","fireworksHtml":""},{"id":"97380","uid":"108085763","nickname":"清风丶破","gender":"2","avatar":"https://img2.zhanqi.tv/avatar/10/110/108085763_1491289262.jpg","code":"11510191","url":"/fanshao66666","title":"战无畏火爆单职业无限激情","gameId":"35","spic":"https://img1.zhanqi.tv/live/20170406/97380_2017-04-06-11-37-38.jpg","bpic":"https://img1.zhanqi.tv/live/20170406/97380_2017-04-06-11-37-38_big.jpg","online":"9740","status":"4","hotsLevel":"24","videoId":"97380_f433t","verscr":"0","gameName":"传奇","gameUrl":"/games/chuanqi","highlight":0,"fireworks":"","fireworksHtml":""}]
     */

    private String keyword;
    private String title;
    private String icon;
    private String channelIds;
    private String gameIds;
    private String moreUrl;
    private String nums;
    private String subTitle;
    private List<AnchorsBean> anchors;
    private List<ListsBean> lists;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(String channelIds) {
        this.channelIds = channelIds;
    }

    public String getGameIds() {
        return gameIds;
    }

    public void setGameIds(String gameIds) {
        this.gameIds = gameIds;
    }

    public String getMoreUrl() {
        return moreUrl;
    }

    public void setMoreUrl(String moreUrl) {
        this.moreUrl = moreUrl;
    }

    public String getNums() {
        return nums;
    }

    public void setNums(String nums) {
        this.nums = nums;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public List<AnchorsBean> getAnchors() {
        return anchors;
    }

    public void setAnchors(List<AnchorsBean> anchors) {
        this.anchors = anchors;
    }

    public List<ListsBean> getLists() {
        return lists;
    }

    public void setLists(List<ListsBean> lists) {
        this.lists = lists;
    }




}
