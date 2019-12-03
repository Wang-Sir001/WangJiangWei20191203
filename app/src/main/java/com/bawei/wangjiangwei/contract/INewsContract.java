package com.bawei.wangjiangwei.contract;

import com.bawei.wangjiangwei.entity.NewsEntity;

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
