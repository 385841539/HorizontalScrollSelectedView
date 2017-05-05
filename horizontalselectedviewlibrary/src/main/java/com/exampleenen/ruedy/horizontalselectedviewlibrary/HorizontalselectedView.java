package com.exampleenen.ruedy.horizontalselectedviewlibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by ruedy on 2017/5/5.
 */

public class HorizontalselectedView extends ViewGroup {

    private List<String> strings;//数据源字符串数组
    private ImageView leftImageView;//左面的图片
    private ImageView rightImageView;//右面的图片
    private int imageViewWidth;//图片宽
    private int seeSize;//可见个数
    private float totalOffset;//总偏移量
    private float everyoffset;//每次按下以后的偏移量；
    private int anInt;//每个字母所占的大小；
    private TextPaint textPaint;
    private float textSize;

    public HorizontalselectedView(Context context) {
        super(context);
    }

    public HorizontalselectedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontalselectedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addTwoImageView();
        initPaint();

    }

    private void initPaint() {
        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(textSize);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        anInt = getWidth() / seeSize;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //把左右两个图片放上去
        leftImageView.layout(0, 0, imageViewWidth, getHeight());
        leftImageView.layout(getWidth() - imageViewWidth, 0, getWidth(), getHeight());
        //布局字符串
    }

    private void addTwoImageView() {
        leftImageView = new ImageView(getContext());
        rightImageView = new ImageView(getContext());
        addView(leftImageView, 0, new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT));
        addView(rightImageView, 1, new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT));
        imageViewWidth = leftImageView.getWidth();
    }

//宽高无须重写；

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }


}
