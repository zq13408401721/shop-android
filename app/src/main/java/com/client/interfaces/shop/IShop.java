package com.client.interfaces.shop;

import com.client.interfaces.Callback;
import com.client.interfaces.IBaseModel;
import com.client.interfaces.IBasePresenter;
import com.client.interfaces.IBaseView;
import com.client.model.shop.GoodDetailBean;

public interface IShop {
    interface View extends IBaseView {
        void getGoodDetail(GoodDetailBean goodDetailBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void getGoodDetail(int id);
    }


    interface Model extends IBaseModel {
        void getGoodDetail(int id,Callback callback);
    }
}
