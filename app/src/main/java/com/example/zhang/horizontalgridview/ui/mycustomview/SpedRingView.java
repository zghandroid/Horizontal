package com.example.zhang.horizontalgridview.ui.mycustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.zhang.horizontalgridview.R;

/**
 * Created by 12345 on 2017/3/2.
 */

public class SpedRingView extends View {

    private int firstColor;
    private int secondColor;
    private int ringWidth;
    private Paint paint;
    private int progress;
    private int speed;
    private RectF rectF;
    private boolean isNext;


    public SpedRingView(Context context) {
        this(context,null);
    }

    public SpedRingView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SpedRingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray =context.getTheme().obtainStyledAttributes(attrs, R.styleable.SpedRingView,defStyleAttr,0);
        int a=typedArray.getIndexCount();
        for(int i=0;i<a;i++){
            int attr=typedArray.getIndex(i);
            switch (attr){
                case R.styleable.SpedRingView_firstColor:
                    firstColor=typedArray.getColor(attr, Color.GREEN);
                    break;
                case R.styleable.SpedRingView_secondColor:
                    secondColor=typedArray.getColor(attr,Color.RED);
                    break;
                case R.styleable.SpedRingView_ringWidth:
                    ringWidth = typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.SpedRingView_ringSpeed:
                    speed=typedArray.getInteger(attr,20);
                    break;

            }
        }

        paint=new Paint();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    progress++;
                    if(progress==360){
                        progress=0;
                        if (isNext){
                            isNext=false;
                        }else {
                            isNext=true;
                        }
                    }

                    postInvalidate();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }.start();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centre = getWidth() / 2; // 获取圆心的x坐标
        int radius = centre - ringWidth / 2;// 半径
        paint.setStrokeWidth(ringWidth); // 设置圆环的宽度
        paint.setAntiAlias(true); // 消除锯齿
        paint.setStyle(Paint.Style.STROKE); // 设置空心
        rectF=new RectF(centre - radius, centre - radius, centre + radius, centre + radius);
        if(isNext) {
            paint.setColor(firstColor);
            canvas.drawCircle(centre, centre, radius, paint); // 画出圆环
            paint.setColor(secondColor); // 设置圆环的颜色
            canvas.drawArc(rectF, -90, progress, false, paint); // 根据进度画圆弧
        }else {
            paint.setColor(secondColor);
            canvas.drawCircle(centre, centre, radius, paint); // 画出圆环
            paint.setColor(firstColor); // 设置圆环的颜色
            canvas.drawArc(rectF, -90, progress, false, paint); // 根据进度画圆弧
        }


    }
}
