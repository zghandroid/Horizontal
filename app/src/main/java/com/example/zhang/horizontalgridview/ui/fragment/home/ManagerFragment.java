package com.example.zhang.horizontalgridview.ui.fragment.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import com.example.zhang.horizontalgridview.R;

/**
 * Created by 12345 on 2017/3/3.
 */

public class ManagerFragment extends Fragment implements View.OnClickListener {
    private ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.manager_frag, container, false);
        imageView = (ImageView) view.findViewById(R.id.test_image);
        imageView.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationY", imageView.getTranslationY(), 500f);
        animator.setInterpolator(new BounceInterpolator());
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
        AnimatorSet set=new AnimatorSet();
        set.play(animator).after(animator1);
        set.setDuration(5000);
        set.start();

    }
}
