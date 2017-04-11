package com.example.zhang.horizontalgridview.ui.adapter;

import com.example.zhang.horizontalgridview.R;
import com.example.zhang.horizontalgridview.base.MyBaseAdapter;
import com.example.zhang.horizontalgridview.http.bean.VideoInfo;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by 12345 on 2017/3/9.
 */

public class SolftAdapter extends MyBaseAdapter<VideoInfo> {
    public SolftAdapter(List<VideoInfo> data, int layoutId) {
        super(data, layoutId);
    }

    @Override
    protected void bindData(VideoInfo videoInfo, int position, ViewHolder holder) {
        JCVideoPlayerStandard jcVideoPlayer= (JCVideoPlayerStandard) holder.getView(R.id.video);
        jcVideoPlayer.setUp(videoInfo.getVideoUrl(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,videoInfo.getVideoTitle());
        jcVideoPlayer.thumbImageView.setImageResource(R.mipmap.ic_launcher);
        jcVideoPlayer.cancelDismissControlViewTimer();

        /**
         * loadingProgressBar 加載的進度條 progressbar
         * bottomProgressBar 頂端進度條 progressbar
         * backButton  返回按鈕（ImageView）
         * thumbImageView 封面（就是一个ImageView）
         */
    }
}
