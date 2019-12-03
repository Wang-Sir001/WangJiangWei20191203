package com.bawei.wangjiangwei.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.base.BaseFragment;

public class OtherFragment extends BaseFragment {

    private TextView tv;

    @Override
    protected void initView(View inflate) {
        tv = inflate.findViewById(R.id.tv_other);

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_other;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        String key = arguments.getString("key");
        tv.setText(key);
    }

    public static OtherFragment getInstance(String value) {
        OtherFragment otherFragment = new OtherFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",value);
        otherFragment.setArguments(bundle);
        return otherFragment;
    }
}
