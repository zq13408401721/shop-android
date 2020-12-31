package com.client.presenter.app;

import com.client.base.BasePresenter;
import com.client.interfaces.Callback;
import com.client.interfaces.app.IApp;
import com.client.model.app.AppBean;
import com.client.model.app.AppModel;
import com.client.model.home.HomeBean;

public class AppPresenter extends BasePresenter<IApp.View> implements IApp.Presenter {

    IApp.Model model;

    public AppPresenter(){
        model = new AppModel();
    }

    @Override
    public void getAppInfo() {
        model.getAppInfo(new Callback<AppBean>() {
            @Override
            public void success(AppBean data) {
                if(mView != null){
                    mView.getAppInfoReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
