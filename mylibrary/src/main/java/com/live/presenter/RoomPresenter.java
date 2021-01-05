package com.live.presenter;

import com.basemodule.base.BasePresenter;
import com.basemodule.interfaces.Callback;
import com.live.interfaces.IPush;
import com.live.interfaces.IRoom;
import com.live.model.LiveUrlBean;
import com.live.model.RoomBean;
import com.live.model.RoomModel;

import java.util.Map;

public class RoomPresenter extends BasePresenter<IRoom.View> implements IRoom.Presenter {

    IRoom.Model model;
    public RoomPresenter(){
        model = new RoomModel();
    }

    @Override
    public void getRoomList() {
        model.getRoomList(new Callback<RoomBean>() {
            @Override
            public void success(RoomBean data) {
                if(mView != null){
                    mView.getRoomListReturn(data);
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

    /**
     * 获取当前直播间的播放地址
     * @param map
     */
    @Override
    public void roomLiveUrl(Map<String, String> map) {
        model.roomLiveUrl(map,new Callback<LiveUrlBean>() {
            @Override
            public void success(LiveUrlBean data) {
                if(mView != null){
                    mView.roomLiveUrlReturn(data);
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
}
