package com.jim.androidtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jim.magicviewpager.transformer.AlphaPageTransformer;
import com.jim.magicviewpager.transformer.NonPageTransformer;
import com.jim.magicviewpager.transformer.PageTransformerBuilder;
import com.jim.magicviewpager.transformer.RotateDownPageTransformer;
import com.jim.magicviewpager.transformer.RotateUpPageTransformer;
import com.jim.magicviewpager.transformer.RotateYPageTransformer;
import com.jim.magicviewpager.transformer.ScaleInTransformer;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private PagerAdapter mAdapter;

    int[] imgRes = {R.drawable.ic_img1, R.drawable.ic_img2, R.drawable.ic_img1, R.drawable.ic_img3, R.drawable.ic_img4, R.drawable.ic_img5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        //设置Page间间距
        mViewPager.setPageMargin(20);
        //设置缓存的页面数量
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView view = new ImageView(MainActivity.this);
                view.setImageResource(imgRes[position]);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public int getCount() {
                return imgRes.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }
        });
        mViewPager.setPageTransformer(true, new PageTransformerBuilder().addPageTransformer(new ScaleInTransformer()).addPageTransformer(new AlphaPageTransformer()).build());

        startActivity(new Intent(this, RecyclerViewItemAnimationActivity.class));
    }
}
