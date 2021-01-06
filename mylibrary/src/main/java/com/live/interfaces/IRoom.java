package com.live.interfaces;

import com.basemodule.interfaces.Callback;
import com.basemodule.interfaces.IBaseModel;
import com.basemodule.interfaces.IBasePresenter;
import com.basemodule.interfaces.IBaseView;
import com.live.model.LiveUrlBean;
import com.live.model.MyRoomBean;
import com.live.model.RoomBean;
import com.live.model.StartLiveBean;

import java.util.Map;

public interface IRoom {

    interface View extends IBaseView {
        void getRoomListReturn(RoomBean result);

        void roomLiveUrlReturn(LiveUrlBean result);

        void getMyRoomReturn(MyRoomBean result);

        void startLiveReturn(StartLiveBean result);
    }

    interface Presenter extends IBasePresenter<View> {
        void getRoomList();

        void roomLiveUrl(Map<String,String> map);

        //获取自己的房间信息
        void getMyRoom();

        //开启直播
        void startLive(int roomid);
    }

    interface Model extends IBaseModel {
        void getRoomList(Callback callback);

        void roomLiveUrl(Map<String,String> map,Callback callback);

        void getMyRoom(Callback callback);

        void startLive(int roomid,Callback callback);
    }

}
