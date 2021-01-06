package com.live;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.basemodule.base.BaseActivity;
import com.basemodule.base.BaseAdapter;
import com.live.interfaces.IRoom;
import com.live.model.LiveUrlBean;
import com.live.model.MyRoomBean;
import com.live.model.RoomBean;
import com.live.model.StartLiveBean;
import com.live.presenter.RoomPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomActivity extends BaseActivity<IRoom.Presenter> implements View.OnClickListener, IRoom.View {

    private static final int CODE_LIVE = 100;


    RecyclerView recyRoom;
    ImageView imgBack;
    ImageView imgStartLive;
    List<RoomBean.DataBean> roomList;
    RoomListAdapter roomListAdapter;



    @Override
    protected int getLayout() {
        return R.layout.activity_room;
    }

    @Override
    protected IRoom.Presenter createPrenter() {
        return new RoomPresenter();
    }

    @Override
    protected void initView() {
        recyRoom = findViewById(R.id.recy_room);
        imgBack = findViewById(R.id.img_back);
        imgStartLive = findViewById(R.id.img_startLive);

        imgStartLive.setOnClickListener(this);
        imgBack.setOnClickListener(this);

        roomList = new ArrayList<>();
        roomListAdapter = new RoomListAdapter(this,roomList);
        recyRoom.setLayoutManager(new GridLayoutManager(this,2));
        recyRoom.setAdapter(roomListAdapter);
        initListener();
    }

    @Override
    protected void initData() {
        presenter.getRoomList();
    }

    private void initListener(){
        roomListAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                int isopen = roomList.get(pos).getIsopen();
                if(isopen == 1){  //开放的房间
                    Map<String,String> map = new HashMap<>();
                    map.put("roomid",String.valueOf(roomList.get(pos).getId()));
                    presenter.roomLiveUrl(map);
                }else if(isopen == 2){  //密码

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.img_startLive) {
            presenter.getMyRoom();
        }else if(id == R.id.img_back){

            finish();
        }
    }

    @Override
    public void getRoomListReturn(RoomBean result) {
        roomList.clear();
        roomList.addAll(result.getData());
        roomListAdapter.notifyDataSetChanged();
    }

    /**
     * 获取房间地址的返回
     * @param result
     */
    @Override
    public void roomLiveUrlReturn(LiveUrlBean result) {
        if(result.getErrno() == 0){
            if(!TextUtils.isEmpty(result.getData().getPlay_url())){
                Intent intent = new Intent(this,LiveActivity.class);
                intent.putExtra("play_url",result.getData().getPlay_url());
                startActivityForResult(intent,CODE_LIVE);
            }
        }
    }

    /**
     * 获取我的房间信息返回
     * @param result
     */
    @Override
    public void getMyRoomReturn(MyRoomBean result) {
        if(result.getErrno() == 0){
            presenter.startLive(result.getData().getId());
        }
    }

    /**
     * 获取开播的推流地址返回
     * @param result
     */
    @Override
    public void startLiveReturn(StartLiveBean result) {
        if(result.getErrno() == 0){
            Intent intent = new Intent(this,PushActivity.class);
            intent.putExtra("push_url",result.getData().getPush_url());
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
