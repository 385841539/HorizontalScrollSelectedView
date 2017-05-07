package com.example.horizontalselectedviewlibrary;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.TintTypedArray;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruedy on 2017/5/5.
 */

public class HorizontalselectedView extends View {

    private Context context;
    private List<String> strings = new ArrayList<String>();//数据源字符串数组
    private ImageView leftImageView;//左面的图片
    private ImageView rightImageView;//右面的图片
    private int imageViewWidth = 50;//图片宽
    private int seeSize = 5;//可见个数
    private float totalOffset;//总偏移量
    private float everyoffset;//每次按下以后的偏移量；
    private int anInt;//每个字母所占的大小；
    private TextPaint textPaint;
    private float textSize = 40;
    private boolean firstVisible = true;
    private int width;
    private int height;
    private Paint paint1;
    private int n;
    private float downX;
    private float anOffset;
    private float firstDownX;

    public HorizontalselectedView(Context context) {
        this(context, null);
    }

    public HorizontalselectedView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalselectedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setWillNotDraw(false);
        setClickable(true);
        initAttrs(attrs);
//        initDatas();
        initPaint();
    }


    private void initDatas() {
        for (int i = 0; i < 20; i++) {
            strings.add(i + "00");
        }
        n = strings.size() / 2;
    }

    private void initPaint() {
        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(textSize);
        textPaint.setColor(Resources.getSystem().getColor(android.R.color.darker_gray));
    }


    private void initAttrs(AttributeSet attrs) {
        TintTypedArray tta = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                R.styleable.HorizontalselectedView);
        seeSize = tta.getInteger(R.styleable.HorizontalselectedView_HorizontalselectedViewSeesize, 5);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("action", "onTouchEvent: " + event.getAction());
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                downX = event.getX();
                firstDownX = downX;

                break;

            case MotionEvent.ACTION_MOVE:

                float scrollX = event.getX();

                if (n != 0 && n != strings.size() - 1)
                    anOffset = scrollX - downX;
                else {
                    anOffset = (float) ((scrollX - downX) / 1.5);
                }


                if (scrollX > downX) {
                    if (scrollX - downX >= anInt) {

                        if (n > 0) {
                            anOffset = 0;
                            n = n - 1;
                            downX = scrollX;
                        }

                    }

                } else {

                    if (downX - scrollX >= anInt) {

                        if (n < strings.size() - 1) {
                            anOffset = 0;
                            n = n + 1;
                            downX = scrollX;
                        }


                    }
                }

                invalidate();
                break;

            case MotionEvent.ACTION_UP:
                anOffset = 0;
                invalidate();

                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (firstVisible) {//第一次得到宽高；
            width = getWidth();
            height = getHeight();
            anInt = width / seeSize;
            firstVisible = false;
        }


        //TODO 左右判断 ， 此处应有哪个该变大了，yes


        if (n >= 0 && n <= strings.size() - 1) {//加个保护；

            Log.e("nn", "onDraw: " + n);
            String s = strings.get(n);

            paint1 = new TextPaint(Paint.ANTI_ALIAS_FLAG);
            paint1.setColor(Resources.getSystem().getColor(android.R.color.black));
            paint1.setTextSize(50);

            //以下操作可以获取所需要绘制文本内容的宽高
            //1 初始化矩形区域对象
            Rect rect = new Rect();
            //使用画笔对象将文本内容填充到矩形区域中
            paint1.getTextBounds(s, 0, s.length(), rect);
            //3从矩形区域中读出文本内容的宽高
            int textWidth = rect.width();
            int textHeight = rect.height();
            canvas.drawText(strings.get(n), getWidth() / 2 - textWidth / 2 + anOffset, getHeight() / 2 + textHeight / 2, paint1);
            for (int i = 0; i < strings.size(); i++) {
                if (i != n) {
                    if (i < n)
                        canvas.drawText(strings.get(i), (i - n) * anInt + getWidth() / 2 - textWidth / 2 + anOffset, getHeight() / 2 + textHeight / 2, textPaint);
                    else {
                        canvas.drawText(strings.get(i), (i - n) * anInt + getWidth() / 2 - textWidth / 2 + anOffset, getHeight() / 2 + textHeight / 2, textPaint);

                    }
                }

            }
        }
    }

    public void setSeeSize(int seeSizes) {
        if (seeSize > 0) {
            seeSize = seeSizes;
            invalidate();
        }

    }


    /**
     * 向左移动
     */
    public void setAnLeftOffset() {
        if (n < strings.size() - 1) {
            n = n + 1;
            invalidate();
        }

    }

    /**
     * 向右移动
     */
    public void setAnRightOffset() {
        if (n > 0) {
            n = n - 1;
            invalidate();
        }
    }

    public void setData(List<String> strings) {
        this.strings = strings;
        n = strings.size() / 2;
        invalidate();
    }
}
