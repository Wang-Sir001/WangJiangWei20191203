package com.bawei.wangjiangwei.view.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.base.BaseFragment;
import com.bawei.wangjiangwei.contract.INewsContract;
import com.bawei.wangjiangwei.entity.NewsEntity;
import com.bawei.wangjiangwei.utils.MyAdapter;
import com.bawei.wangjiangwei.view.activity.MainActivity;

import java.util.List;
/**
 * 姓名：王江伟
 * 时间：2019年12月3日10:28:24
 * 作用：展示页
 */
public class ShopingCartFragment extends BaseFragment implements INewsContract.IView {

    private Button button;
    private GridView gv;

    @Override
    protected void initView(View inflate) {
        button = inflate.findViewById(R.id.button_shoping);
        gv = inflate.findViewById(R.id.gv_shoping);
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_shoping_cart;
    }

    @Override
    protected void initData() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void success(NewsEntity newsEntity) {
        List<NewsEntity.ShopGridDataBean> shopGridData = newsEntity.getShopGridData();
        gv.setAdapter(new MyAdapter(shopGridData));
    }

    @Override
    public void finishs(Throwable throwable) {
        Toast.makeText(getActivity(), "连接失败", Toast.LENGTH_SHORT).show();
    }
}
