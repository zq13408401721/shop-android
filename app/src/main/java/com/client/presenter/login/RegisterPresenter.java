package com.client.presenter.login;

import com.client.base.BasePresenter;
import com.client.interfaces.Callback;
import com.client.interfaces.login.ILogin;
import com.client.interfaces.login.IRegister;
import com.client.model.login.LoginBean;
import com.client.model.login.LoginModel;
import com.client.model.login.RegisterBean;
import com.client.model.login.RegisterModel;

import java.util.Map;

public class RegisterPresenter extends BasePresenter<IRegister.View> implements IRegister.Presenter {
    IRegister.Model model;
    public RegisterPresenter(){
        model = new RegisterModel();
    }
    @Override
    public void register(Map<String,String> map) {
        model.register(map,new Callback<RegisterBean>() {
            @Override
            public void success(RegisterBean data) {
                if(mView != null){
                    mView.registerReturn(data);
                }
            }

            @Override
            public void fail(String err) {
                if(mView != null){
                    mView.showToast(err);
                }
            }
        });
    }

    public void test(){

    }
}
