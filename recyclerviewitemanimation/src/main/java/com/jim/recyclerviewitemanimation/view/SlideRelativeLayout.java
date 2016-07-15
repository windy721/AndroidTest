package com.jim.recyclerviewitemanimation.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import com.jim.recyclerviewitemanimation.R;

/**
 * Created by JimGong on 2016/7/13.
 */
public class SlideRelativeLayout extends RelativeLayout {

    private int mOffset;
    CheckBox mCheckBox;
    RelativeLayout mContentSlide;

    public SlideRelativeLayout(Context context) {
        this(context, null);
    }

    public SlideRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlideRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setOffset(int offset) {
        mOffset = (int) (getContext().getResources().getDisplayMetrics().density * offset + 0.5f);
    }

    private void init() {

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mCheckBox = (CheckBox) findViewById(R.id.item_checkbox);
        mContentSlide = (RelativeLayout) findViewById(R.id.item_content_rl);
        setOffset(35);
    }

    private void doAnimationSet(int dx, float fraction) {
        mContentSlide.scrollTo(dx, 0);
        mCheckBox.setScaleX(fraction);
        mCheckBox.setScaleY(fraction);
        mCheckBox.setAlpha(fraction * 255);
    }

    public void openAnimation() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, 1);
        valueAnimator.setDuration(300);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animation.getAnimatedFraction();
                int endX = (int) (-mOffset * fraction);
                doAnimationSet(endX, fraction);
            }
        });
        valueAnimator.start();
    }

    public void closeAnimation() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, 1);
        valueAnimator.setDuration(300);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animation.getAnimatedFraction();
                int endX = (int) (-mOffset *(1 - fraction));
                doAnimationSet(endX, fraction);
            }
        });
        valueAnimator.start();
    }

    public void open() {
        mContentSlide.scrollTo(-mOffset, 0);
    }

    public void close() {
        mContentSlide.scrollTo(0, 0);
    }
}
