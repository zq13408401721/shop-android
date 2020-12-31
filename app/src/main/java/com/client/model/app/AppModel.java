package com.client.model.app;

import android.util.Log;

import com.client.base.BaseModel;
import com.client.interfaces.Callback;
import com.client.interfaces.app.IApp;
import com.client.model.login.RegisterBean;
import com.client.net.CommonSubscriber;
import com.client.net.HttpManager;
import com.client.utils.RxUtils;

public class AppModel extends BaseModel implements IApp.Model {
    @Override
    public void getAppInfo(Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getAppInfo().
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<AppBean>(callback) {
                    @Override
                    public void onNext(AppBean appBean) {
                        Log.i("TAG","model onNext register");
                        callback.success(appBean);
                    }
                }));
    }
}
