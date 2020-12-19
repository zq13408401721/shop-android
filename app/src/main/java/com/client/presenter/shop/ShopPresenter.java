package com.client.presenter.shop;

import com.client.base.BasePresenter;
import com.client.interfaces.Callback;
import com.client.interfaces.shop.IShop;
import com.client.model.home.HotGoodListBean;
import com.client.model.shop.GoodDetailBean;
import com.client.model.shop.ShopModel;

public class ShopPresenter extends BasePresenter<IShop.View> implements IShop.Presenter {
    IShop.Model model;
    public ShopPresenter(){
        model = new ShopModel();
    }
    @Override
    public void getGoodDetail(int id) {
        model.getGoodDetail(id,new Callback<GoodDetailBean>() {
            @Override
            public void success(GoodDetailBean data) {
                if(mView != null){
                    mView.getGoodDetail(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
