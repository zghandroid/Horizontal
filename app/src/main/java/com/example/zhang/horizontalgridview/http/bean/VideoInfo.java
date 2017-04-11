package com.example.zhang.horizontalgridview.http.bean;

/**
 * Created by 12345 on 2017/3/9.
 */

public class VideoInfo {
    private String videoTitle;
    private String videoUrl;
    private String videoThumb;

    public VideoInfo(String videoTitle, String videoUrl, String videoThumb) {
        this.videoTitle = videoTitle;
        this.videoUrl = videoUrl;
        this.videoThumb = videoThumb;
    }

    public VideoInfo() {
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoThumb() {
        return videoThumb;
    }

    public void setVideoThumb(String videoThumb) {
        this.videoThumb = videoThumb;
    }
}
