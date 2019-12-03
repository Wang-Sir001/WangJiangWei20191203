package com.bawei.wangjiangwei.modle;

import com.bawei.wangjiangwei.contract.INewsContract;
import com.bawei.wangjiangwei.entity.NewsEntity;
import com.bawei.wangjiangwei.presenter.NewsPresenter;
import com.bawei.wangjiangwei.utils.NetUtils;
import com.google.gson.Gson;

/**
 * 姓名：王江伟
 * 时间：2019年12月3日10:28:24
 * 作用：model层
 */
public class NewsModle implements INewsContract.IModle {
    @Override
    public void getData(String url, final ModelCallBack modelCallBack) {
        NetUtils.getInstance().getJson(url, new NetUtils.MyCallBack() {
            @Override
            public void onGetJson(String json) {
                NewsEntity newsEntity = new Gson().fromJson(json, NewsEntity.class);
                modelCallBack.success(newsEntity);
            }
        });
    }
}
