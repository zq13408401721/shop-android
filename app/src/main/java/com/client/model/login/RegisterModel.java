package com.client.model.login;

import android.util.Log;

import com.client.base.BaseModel;
import com.client.interfaces.Callback;
import com.client.interfaces.login.IRegister;
import com.client.net.CommonSubscriber;
import com.client.net.HttpManager;
import com.client.utils.RxUtils;

import java.util.Map;

public class RegisterModel extends BaseModel implements IRegister.Model {
    @Override
    public void register(String um,String pw, Callback callback) {
        Log.i("TAG","model register");
        addDisposible(HttpManager.getInstance().getShopApi().register(um,pw).
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<RegisterBean>(callback) {
                    @Override
                    public void onNext(RegisterBean registerBean) {
                        Log.i("TAG","model onNext register");
                        if(registerBean.getErrno() == 0){
                            callback.success(registerBean);
                        }else{
                            callback.fail(registerBean.getErrmsg());
                        }

                    }
                }));
    }
}
