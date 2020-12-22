package com.client.model.shop;

import com.client.base.BaseModel;
import com.client.interfaces.Callback;
import com.client.interfaces.shop.ICar;
import com.client.net.CommonSubscriber;
import com.client.net.HttpManager;
import com.client.utils.RxUtils;

public class CarModel extends BaseModel implements ICar.Model {
    @Override
    public void getCarList(Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getCarList().
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<CarBean>(callback) {
                    @Override
                    public void onNext(CarBean carBean) {
                        callback.success(carBean);
                    }
                }));
    }
}
