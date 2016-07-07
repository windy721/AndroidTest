package com.jim.magicviewpager.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by JimGong on 2016/7/7.
 */
public class NonPageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        page.setScaleX(0.999f);     //hack
    }

    public static final ViewPager.PageTransformer INSTANCE = new NonPageTransformer();
}
