package com.bawei.wangjiangwei.view.fragment;

import android.view.View;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.base.BaseFragment;
import com.bawei.wangjiangwei.contract.INewsContract;
import com.bawei.wangjiangwei.entity.NewsEntity;

public class ShopingCartFragment extends BaseFragment implements INewsContract.IView {
    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_shoping_cart;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void success(NewsEntity newsEntity) {

    }

    @Override
    public void finishs(Throwable throwable) {

    }
}
