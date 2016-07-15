package com.jim.androidtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.jim.recyclerviewitemanimation.adapter.SlideAdapter;
import com.jim.recyclerviewitemanimation.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by JimGong on 2016/7/15.
 */
public class RecyclerViewItemAnimationActivity extends AppCompatActivity {

    @Bind(R.id.test_editBtn)
    CheckBox mEditBtn;
    SlideAdapter mSlideAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_item_animation);

        ButterKnife.bind(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.test_recyclerView);
        mSlideAdapter = new SlideAdapter();
        mSlideAdapter.setItemBeans(getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mSlideAdapter);

        mEditBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mSlideAdapter.openItemAnimation();
                } else {
                    mSlideAdapter.closeItemAnimation();
                }
            }
        });
    }

    private List<ItemBean> getData() {
        ArrayList<ItemBean> data = new ArrayList<>();
        for (int i=0; i<20; i++) {
            Random random = new Random();
            ItemViewEntry entry = new ItemViewEntry();
            entry.setChecked(random.nextBoolean());
            data.add(entry);
        }
        return data;
    }

    static class ItemViewEntry extends ItemBean {
        public String mTitle;
    }
}
