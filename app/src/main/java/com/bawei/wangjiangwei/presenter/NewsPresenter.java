package com.bawei.wangjiangwei.presenter;

import com.bawei.wangjiangwei.contract.INewsContract;
import com.bawei.wangjiangwei.entity.NewsEntity;
import com.bawei.wangjiangwei.modle.NewsModle;
import com.bawei.wangjiangwei.utils.NetUtils;

public class NewsPresenter implements INewsContract.IPresenter {
    private NewsModle newsModle;
    private INewsContract.IView iView;

    public NewsPresenter(INewsContract.IView iView) {
        this.iView = iView;
    }

    @Override
    public void getData(String url) {
        newsModle = new NewsModle();
        newsModle.getData(url, new INewsContract.IModle.ModelCallBack() {
            @Override
            public void success(NewsEntity newsEntity) {
                iView.success(newsEntity);
            }
        });
    }
}
