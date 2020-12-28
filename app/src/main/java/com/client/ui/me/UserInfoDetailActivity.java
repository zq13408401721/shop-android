package com.client.ui.me;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.client.R;
import com.client.app.Constants;
import com.client.base.BaseActivity;
import com.client.interfaces.IBasePresenter;
import com.client.interfaces.me.IUser;
import com.client.model.me.UserInfoBean;
import com.client.presenter.me.UserPresenter;
import com.client.utils.BitmapUtils;
import com.client.utils.GlideEngine;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;

public class UserInfoDetailActivity extends BaseActivity<IUser.Presenter> implements IUser.View, View.OnClickListener {

    @BindView(R.id.layout_avatar)
    ConstraintLayout layoutAvatar;
    @BindView(R.id.layout_nickname)
    ConstraintLayout layoutNickname;
    @BindView(R.id.txt_nickname)
    TextView txtNickname;

    @Override
    protected int getLayout() {
        return R.layout.activity_userinfo;
    }

    @Override
    protected IUser.Presenter createPrenter() {
        return new UserPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_avatar:
                openPhoto();
                break;
            case R.id.layout_nickname:
                break;
        }
    }

    /**
     * 打开相册
     */
    private void openPhoto(){
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
                .loadImageEngine(GlideEngine.createGlideEngine()) // Please refer to the Demo GlideEngine.java
                .maxSelectNum(1)
                .imageSpanCount(4)
                .selectionMode(PictureConfig.MULTIPLE)
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PictureConfig.CHOOSE_REQUEST:
                // onResult Callback
                List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                if (selectList.size() == 0) return;
                //获取本地图片的选择地址，上传到服务器
                //头像的压缩和二次采样
                //把选中的图片插入到列表
                try {
                    Bitmap scaleBitmp = BitmapUtils.getScaleBitmap(selectList.get(0).getPath(), Constants.HEAD_WIDTH,Constants.HEAD_HEIGHT);
                    // 上传图片
                    uploadAvatar();
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    private void uploadAvatar(){

    }

    /**
     * 更新用户信息返回
     * @param result
     */
    @Override
    public void updateUserInfoReturn(UserInfoBean result) {

    }
}
