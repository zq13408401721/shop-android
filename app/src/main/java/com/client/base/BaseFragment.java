package com.client.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.client.interfaces.IBasePresenter;
import com.client.interfaces.IBaseView;
import com.client.ui.login.LoginActivity;
import com.client.utils.ActivityManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends IBasePresenter> extends Fragment implements IBaseView {

    protected P presenter;
    Unbinder unbinder;
    protected Context mContext;
    protected Activity mActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getContext();
        mActivity = getActivity();
        int layout = getLayout();
        View view = null;
        if(layout <= 0){
            throw new RuntimeException("布局非法");
        }else{
           view = inflater.inflate(layout,container,false);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this,view);
        presenter = createPrenter();
        if(presenter != null){
            presenter.attachView(this);
        }
        initView();
        initData();
    }

    protected abstract int getLayout();
    protected abstract P createPrenter();
    protected abstract void initView();
    protected abstract  void initData();

    @Override
    public void showLoading(int visible) {

    }

    @Override
    public void showToast(String tips) {

    }

    /**
     * 跳转登录
     */
    protected void gotoLogin(){
        ActivityManager.startFragmentForResult(this,100,LoginActivity.class);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(presenter != null){
            presenter.unAttachView();
        }
    }
}
