package com.client.interfaces.login;

import com.client.interfaces.Callback;
import com.client.interfaces.IBaseModel;
import com.client.interfaces.IBasePresenter;
import com.client.interfaces.IBaseView;
import com.client.model.login.LoginBean;
import com.client.model.login.RegisterBean;

import java.util.Map;

public interface IRegister {
    interface View extends IBaseView {
        void registerReturn(RegisterBean loginBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void register(Map<String,String> map);
    }


    interface Model extends IBaseModel {
        void register(Map<String,String> map, Callback callback);
    }
}
