package com.bawei.wangjiangwei.presenter;

import com.bawei.wangjiangwei.contract.INewsContract;
import com.bawei.wangjiangwei.entity.NewsEntity;
import com.bawei.wangjiangwei.modle.NewsModle;
import com.bawei.wangjiangwei.utils.NetUtils;
/**
 * 姓名：王江伟
 * 时间：2019年12月3日10:28:24
 * 作用：presenter层
 */
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
