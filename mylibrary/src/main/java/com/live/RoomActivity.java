package com.live;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RoomActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyRoom;
    ImageView imgBack;
    ImageView imgStartLive;
    List<String> list;
    MyAdapter myAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        initView();
        initListener();
    }

    private void initView() {
        recyRoom = findViewById(R.id.recy_room);
        imgBack = findViewById(R.id.img_back);
        imgStartLive = findViewById(R.id.img_startLive);

        imgStartLive.setOnClickListener(this);
        imgBack.setOnClickListener(this);

        list = new ArrayList<>();
        list.add("美女1");
        myAdapter = new MyAdapter();
        recyRoom.setLayoutManager(new GridLayoutManager(this,2));
        recyRoom.setAdapter(myAdapter);
    }

    private void initListener(){

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.img_startLive) {
            Intent intent = new Intent(RoomActivity.this,PushActivity.class);
            startActivity(intent);
        }else if(id == R.id.img_back){

            finish();
        }
    }

    class MyAdapter extends RecyclerView.Adapter{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(RoomActivity.this).inflate(R.layout.layout_room_item,parent,false);
            MyVH myVH = new MyVH(view);
            return myVH;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            MyVH myVH = (MyVH) holder;
            myVH.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RoomActivity.this,LiveActivity.class);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class MyVH extends RecyclerView.ViewHolder{

        public MyVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
