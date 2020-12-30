package com.client.presenter.me;

import android.util.Log;

import com.client.base.BasePresenter;
import com.client.interfaces.Callback;
import com.client.interfaces.me.IUser;
import com.client.interfaces.me.IUser.Presenter;
import com.client.interfaces.shop.ICar;
import com.client.model.login.LoginBean;
import com.client.model.login.LogoutBean;
import com.client.model.me.UserInfoBean;
import com.client.model.me.UserModel;

import java.util.Map;

public class UserPresenter extends BasePresenter<IUser.View> implements Presenter {

    IUser.Model model;

    public UserPresenter(){
        model = new UserModel();
    }

    @Override
    public void updateUserInfo(Map<String, String> map) {
        model.updateUserInfo(map,new Callback<UserInfoBean>() {
            @Override
            public void success(UserInfoBean data) {
                if(mView != null){
                    mView.updateUserInfoReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void logout() {
        Log.i("TAG","logout 调用");
        model.logout(new Callback<LogoutBean>() {
            @Override
            public void success(LogoutBean data) {
                Log.i("TAG","login    out");
                if(mView != null){
                    mView.logoutReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

}
