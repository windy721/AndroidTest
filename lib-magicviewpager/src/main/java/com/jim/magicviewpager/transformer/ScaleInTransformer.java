package com.jim.magicviewpager.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by JimGong on 2016/7/7.
 */
public class ScaleInTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;
    @Override
    public void transformPage(View page, float position) {
        if (position < -1) {                // [-Infinity, -1]
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
        } else if (position <= 1) {         // [-1,1]

            if (position < 0)               // [0,-1]
            {
                float scale = MIN_SCALE + (1 - MIN_SCALE) * (1 + position);
                page.setScaleX(scale);
                page.setScaleY(scale);
            } else                          // [1,0]
            {
                float scale = MIN_SCALE + (1 - MIN_SCALE) * (1 - position);
                page.setScaleX(scale);
                page.setScaleY(scale);
            }
        } else {                            // (1,+Infinity]
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
        }

    }
}
