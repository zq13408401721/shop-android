package com.client.interfaces.app;

import com.client.interfaces.Callback;
import com.client.interfaces.IBaseModel;
import com.client.interfaces.IBasePresenter;
import com.client.interfaces.IBaseView;
import com.client.interfaces.shop.ICar;
import com.client.model.app.AppBean;
import com.client.model.shop.CarBean;
import com.client.model.shop.DeleteCarBean;
import com.client.model.shop.UpdateCarBean;

import java.util.Map;

public interface IApp {
    interface View extends IBaseView {
        void getAppInfoReturn(AppBean appBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void getAppInfo();
    }


    interface Model extends IBaseModel {
        void getAppInfo(Callback callback);
    }
}
