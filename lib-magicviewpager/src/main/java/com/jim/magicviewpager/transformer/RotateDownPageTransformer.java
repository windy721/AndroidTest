package com.jim.magicviewpager.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by JimGong on 2016/7/6.
 */
public class RotateDownPageTransformer implements ViewPager.PageTransformer {

    private static final float DEFAULT_MIN_ROTATE = 15.0f;
    private float mMaxRotate = DEFAULT_MIN_ROTATE;

    @Override
    public void transformPage(View view, float position) {
        if (position < -1) {                // [-Infinity, -1]
            view.setRotation(mMaxRotate * -1);
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight());
        } else if (position <= 1) {         // [-1,1]

            if (position < 0)               // [0,-1]
            {
                view.setPivotX(view.getWidth() * 0.5f * (1 - position));
                view.setPivotY(view.getHeight());
                view.setRotation(mMaxRotate * position);
            } else                          // [1,0]
            {
                view.setPivotX(view.getWidth() * 0.5f * (1 - position));
                view.setPivotY(view.getHeight());
                view.setRotation(mMaxRotate * position);
            }
        } else {                            // (1,+Infinity]
            view.setRotation(mMaxRotate);
            view.setPivotX(0);
            view.setPivotY(view.getHeight());
        }

    }
}
