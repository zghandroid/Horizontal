package com.example.zhang.horizontalgridview.ui.fragment.home;

import android.hardware.Camera;
import android.hardware.camera2.CameraDevice;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.zhang.horizontalgridview.R;

import java.io.IOException;

/**
 * Created by 12345 on 2017/3/3.
 */

public class GameFragment extends Fragment implements View.OnClickListener, SurfaceHolder.Callback {
    private SurfaceView surfaceView;
    private Button start;
    private  Button stop;
    private MediaRecorder mediaRecorder;
    private SurfaceHolder holder;
    private Camera camera;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_frag, container, false);
        surfaceView = (SurfaceView) view.findViewById(R.id.video_surface);
        start = (Button) view.findViewById(R.id.video_start);
        start.setOnClickListener(this);
        stop = (Button) view.findViewById(R.id.video_stop);
        stop.setOnClickListener(this);
        holder=surfaceView.getHolder();
        holder.addCallback(this);
        //holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.video_start:
                camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK);
                camera.setDisplayOrientation(90);
                camera.unlock();
                mediaRecorder=new MediaRecorder();
                mediaRecorder.setCamera(camera);
                //1.设置采集声音
                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                //设置采集图像
                mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
                mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
                mediaRecorder.setVideoSize(176,144);
                mediaRecorder.setVideoFrameRate(20);
                mediaRecorder.setPreviewDisplay(holder.getSurface());
                mediaRecorder.setOrientationHint(90);
                mediaRecorder.setOutputFile("/sdcard/love.3gp");
                try {
                    mediaRecorder.prepare();
                    mediaRecorder.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.video_stop:
                if(mediaRecorder!=null){
                    mediaRecorder.stop();
                    mediaRecorder.release();
                    mediaRecorder=null;
                }
                break;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
            this.holder=holder;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        this.holder = holder;

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        surfaceView = null;
        this.holder = null;
        mediaRecorder = null;
    }
}
