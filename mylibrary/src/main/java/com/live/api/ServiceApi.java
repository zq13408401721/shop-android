package com.live.api;

import com.live.model.LiveUrlBean;
import com.live.model.RoomBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceApi {
    String BASE_URL = "https://cdplay.cn/";

    @GET("api/live/getRoomList")
    Flowable<RoomBean> getRoomList();

    @POST("api/live/roomLiveUrl")
    Flowable<LiveUrlBean> roomLiveUrl(@FieldMap Map<String,String> map);

}
