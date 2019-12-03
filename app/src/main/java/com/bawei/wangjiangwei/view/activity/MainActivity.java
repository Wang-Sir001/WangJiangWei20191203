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
/**
 * 姓名：王江伟
 * 时间：2019年12月3日10:28:24
 * 作用：首页
 */
public class MainActivity extends BaseActivity {

    private ViewPager vp;
    private RadioGroup rg;
    private List<Fragment> fragments;

    @Override
    protected void initData() {
        //将fragment存入集合
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

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.rb4:
                        vp.setCurrentItem(3);
                        break;
                    case R.id.rb5:
                        vp.setCurrentItem(4);
                        break;
                }
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
    public void tiao(){
        vp.setCurrentItem(0);
    }
}
