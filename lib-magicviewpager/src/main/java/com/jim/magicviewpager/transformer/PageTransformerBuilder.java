package com.jim.magicviewpager.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JimGong on 2016/7/8.
 */
public final class PageTransformerBuilder {

    List<ViewPager.PageTransformer> mPageTransformers = new ArrayList<>();

    public PageTransformerBuilder addPageTransformer(ViewPager.PageTransformer pageTransformer) {
        mPageTransformers.add(pageTransformer);
        return this;
    }

    public ViewPager.PageTransformer build() {
        return new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                for (ViewPager.PageTransformer pageTransformer : mPageTransformers) {
                    pageTransformer.transformPage(page, position);
                }
            }
        };
    }

}
