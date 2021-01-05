package com.live.interfaces;

import com.basemodule.interfaces.IBaseModel;
import com.basemodule.interfaces.IBasePresenter;
import com.basemodule.interfaces.IBaseView;

public interface IPush {
    interface View extends IBaseView{

    }

    interface Presenter extends IBasePresenter<View>{

    }

    interface Model extends IBaseModel{

    }
}
