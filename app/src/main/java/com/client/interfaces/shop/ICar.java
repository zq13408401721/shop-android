package com.client.interfaces.shop;

import com.client.interfaces.Callback;
import com.client.interfaces.IBaseModel;
import com.client.interfaces.IBasePresenter;
import com.client.interfaces.IBaseView;
import com.client.model.shop.CarBean;
import com.client.model.shop.GoodDetailBean;

public interface ICar {
    interface View extends IBaseView {
        void getCarListReturn(CarBean carBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void getCarList();
    }


    interface Model extends IBaseModel {
        void getCarList(Callback callback);
    }

}
