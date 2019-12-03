package com.bawei.wangjiangwei.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.base.BaseActivity;
import com.bawei.wangjiangwei.view.fragment.OtherFragment;
import com.bawei.wangjiangwei.view.fragment.ShopingCartFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager vp;
    private RadioGroup rg;
    private List<Fragment> fragments;

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(OtherFragment.getInstance("首页"));
        fragments.add(OtherFragment.getInstance("分类"));
        fragments.add(OtherFragment.getInstance("发现"));
        fragments.add(new ShopingCartFragment());
        fragments.add(OtherFragment.getInstance("我的"));

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
    }

    @Override
    protected void initView() {
        vp = findViewById(R.id.vp_main);
        rg = findViewById(R.id.rg_main);

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }
}
