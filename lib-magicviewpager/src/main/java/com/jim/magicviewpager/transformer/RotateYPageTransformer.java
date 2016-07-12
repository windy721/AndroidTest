package com.jim.magicviewpager.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by JimGong on 2016/7/7.
 */
public class RotateYPageTransformer implements ViewPager.PageTransformer {
    private static final float MAX_ROTATE = 35f;

    @Override
    public void transformPage(View page, float position) {
        if (position < -1) {                // [-Infinity, -1]
            page.setRotationY(-MAX_ROTATE);
            page.setPivotX(page.getWidth());
        } else if (position <= 1) {         // [-1,1]

            if (position < 0)               // [0,-1]
            {
                page.setRotationY(MAX_ROTATE * position);
                page.setPivotX(page.getWidth());
            } else                          // [1,0]
            {
                page.setRotationY(MAX_ROTATE * position);
                page.setPivotX(0);
            }
        } else {                            // (1,+Infinity]
            page.setRotationY(MAX_ROTATE);
            page.setPivotX(0);
        }

    }
}
