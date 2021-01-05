package com.live.interfaces;

import com.basemodule.interfaces.Callback;
import com.basemodule.interfaces.IBaseModel;
import com.basemodule.interfaces.IBasePresenter;
import com.basemodule.interfaces.IBaseView;
import com.live.model.LiveUrlBean;
import com.live.model.RoomBean;

import java.util.Map;

public interface IRoom {

    interface View extends IBaseView {
        void getRoomListReturn(RoomBean result);

        void roomLiveUrlReturn(LiveUrlBean result);
    }

    interface Presenter extends IBasePresenter<View> {
        void getRoomList();

        void roomLiveUrl(Map<String,String> map);
    }

    interface Model extends IBaseModel {
        void getRoomList(Callback callback);

        void roomLiveUrl(Map<String,String> map,Callback callback);
    }

}
