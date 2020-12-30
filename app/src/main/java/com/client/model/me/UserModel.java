package com.client.model.me;

import android.util.Log;

import com.client.base.BaseModel;
import com.client.interfaces.Callback;
import com.client.interfaces.me.IUser;
import com.client.model.login.LoginBean;
import com.client.model.login.LogoutBean;
import com.client.net.CommonSubscriber;
import com.client.net.HttpManager;
import com.client.utils.RxUtils;

import java.util.Map;

public class UserModel extends BaseModel implements IUser.Model {
    @Override
    public void updateUserInfo(Map<String, String> map, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().updateUserInfo(map).
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<UserInfoBean>(callback) {
                    @Override
                    public void onNext(UserInfoBean userInfoBean) {
                        callback.success(userInfoBean);
                    }
                }));
    }

    @Override
    public void logout(Callback callback) {
        Log.i("TAG","logout model");
        addDisposible(HttpManager.getInstance().getShopApi().logout().
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<LogoutBean>(callback) {
                    @Override
                    public void onNext(LogoutBean logoutBean) {
                        Log.i("TAG","logout onNext");
                        callback.success(logoutBean);
                    }
                }));
    }
}
