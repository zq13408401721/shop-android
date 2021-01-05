package com.live.interfaces;

import com.basemodule.interfaces.IBaseModel;
import com.basemodule.interfaces.IBasePresenter;
import com.basemodule.interfaces.IBaseView;

public interface ILive {
    interface View extends IBaseView {

    }

    interface Presenter extends IBasePresenter<IPush.View> {

    }

    interface Model extends IBaseModel {

    }
}
