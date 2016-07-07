package com.jim.magicviewpager.transformer;


import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by JimGong on 2016/7/7.
 */
public class RotateUpPageTransformer implements ViewPager.PageTransformer {

    private static final float DEFAULT_MIN_ROTATE = 15.0f;
    private float mMaxRotate = DEFAULT_MIN_ROTATE;
    
    @Override
    public void transformPage(View page, float position) {
        if (position < -1) {                // [-Infinity, -1]
            page.setRotation(mMaxRotate);
            page.setPivotX(page.getWidth());
            page.setPivotY(0);
        } else if (position <= 1) {         // [-1,1]

            if (position < 0)               // [0，-1]
            {
                page.setPivotX(page.getWidth() * 0.5f * (1 - position));
                page.setPivotY(0);
                page.setRotation(mMaxRotate * position * -1);
            } else                          // [1，0]
            {
                page.setPivotX(page.getWidth() * 0.5f * (1 - position));
                page.setPivotY(0);
                page.setRotation(mMaxRotate * position * -1);
            }
        } else {                            // (1,+Infinity]
            page.setRotation(mMaxRotate * -1);
            page.setPivotX(0);
            page.setPivotY(0);
        }
    }
}
