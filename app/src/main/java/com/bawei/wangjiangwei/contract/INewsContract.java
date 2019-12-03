package com.bawei.wangjiangwei.contract;

import com.bawei.wangjiangwei.entity.NewsEntity;

/**
 * 姓名：王江伟
 * 时间：2019年12月3日10:27:49
 * 作用：契约类
 * */
public interface INewsContract {
    interface IModle{
        void getData(String url,ModelCallBack modelCallBack);

        interface ModelCallBack{
            void success(NewsEntity newsEntity);
        }
    }
    interface IView{
        void success(NewsEntity newsEntity);
        void finishs(Throwable throwable);
    }
    interface IPresenter{
        void getData(String url);
    }

}
