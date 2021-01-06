package com.live.model;

import com.basemodule.base.BaseModel;
import com.basemodule.interfaces.Callback;
import com.basemodule.net.CommonSubscriber;
import com.basemodule.net.HttpManager;
import com.basemodule.net.RxUtils;
import com.live.api.ServiceApi;
import com.live.interfaces.IRoom;

import java.util.Map;

public class RoomModel extends BaseModel implements IRoom.Model {
    ServiceApi serviceApi;
    public RoomModel(){
        serviceApi = (ServiceApi) HttpManager.getInstance().getService(ServiceApi.class,ServiceApi.BASE_URL);
    }

    @Override
    public void getRoomList(Callback callback) {
        addDisposible(serviceApi.getRoomList().
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<RoomBean>(callback) {
                    @Override
                    public void onNext(RoomBean categoryBean) {
                        callback.success(categoryBean);
                    }
                }));
    }

    /**
     * 回去房间播放地址
     * @param map
     * @param callback
     */
    @Override
    public void roomLiveUrl(Map<String, String> map, Callback callback) {
        addDisposible(serviceApi.roomLiveUrl(map).
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<LiveUrlBean>(callback) {
                    @Override
                    public void onNext(LiveUrlBean liveUrlBean) {
                        callback.success(liveUrlBean);
                    }
                }));
    }

    /**
     * 获取自己房间
     * @param callback
     */
    @Override
    public void getMyRoom(Callback callback) {
        addDisposible(serviceApi.getMyRoom().
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<MyRoomBean>(callback) {
                    @Override
                    public void onNext(MyRoomBean roomBean) {
                        callback.success(roomBean);
                    }
                }));
    }

    /**
     * 开播
     * @param roomid
     * @param callback
     */
    @Override
    public void startLive(int roomid, Callback callback) {
        addDisposible(serviceApi.startLive(roomid).
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<StartLiveBean>(callback) {
                    @Override
                    public void onNext(StartLiveBean startLiveBean) {
                        callback.success(startLiveBean);
                    }
                }));
    }


}
