package com.live;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.basemodule.base.BaseAdapter;
import com.bumptech.glide.Glide;
import com.live.model.RoomBean;

import java.util.List;

public class RoomListAdapter extends BaseAdapter<RoomBean.DataBean> {
    public RoomListAdapter(Context context, List<RoomBean.DataBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.layout_room_item;
    }

    @Override
    protected void bindData(RoomBean.DataBean data, VH vh) {
        ImageView imgBg = (ImageView) vh.getViewById(R.id.img_bg);
        TextView txtName = (TextView) vh.getViewById(R.id.txt_name);
        Glide.with(imgBg).load(data.getIcon()).into(imgBg);
        txtName.setText(data.getName());
    }
}
