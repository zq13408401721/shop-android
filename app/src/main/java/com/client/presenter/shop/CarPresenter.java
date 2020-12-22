package com.client.presenter.shop;

import com.client.base.BasePresenter;
import com.client.interfaces.Callback;
import com.client.interfaces.shop.ICar;
import com.client.interfaces.shop.IShop;
import com.client.model.shop.CarBean;
import com.client.model.shop.CarModel;
import com.client.model.shop.GoodDetailBean;
import com.client.model.shop.ShopModel;

public class CarPresenter extends BasePresenter<ICar.View> implements ICar.Presenter {

    ICar.Model model;
    public CarPresenter(){
        model = new CarModel();
    }
    @Override
    public void getCarList() {
        model.getCarList(new Callback<CarBean>() {
            @Override
            public void success(CarBean data) {
                if(mView != null){
                    mView.getCarListReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
