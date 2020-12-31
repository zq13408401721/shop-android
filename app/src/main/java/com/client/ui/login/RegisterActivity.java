package com.client.ui.login;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.client.R;
import com.client.base.BaseActivity;
import com.client.interfaces.Callback;
import com.client.interfaces.IBasePresenter;
import com.client.interfaces.login.IRegister;
import com.client.model.login.RegisterBean;
import com.client.net.CommonSubscriber;
import com.client.net.HttpManager;
import com.client.presenter.login.RegisterPresenter;
import com.client.utils.RxUtils;
import com.client.utils.SpUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity<IRegister.Presenter> implements IRegister.View {

    @BindView(R.id.et_username)
    EditText username;
    @BindView(R.id.et_pw)
    EditText password;
    @BindView(R.id.btn_register)
    Button register;

    private String um,pw;

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected IRegister.Presenter createPrenter() {
        return new RegisterPresenter();
    }

    @Override
    protected void initView() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    @Override
    protected void initData() {

    }

    private void register(){
        um = username.getText().toString();
        pw = password.getText().toString();
        if(!TextUtils.isEmpty(um) && !TextUtils.isEmpty(pw)){
            presenter.register(um,pw);
            Log.i("TAG",um + pw);
        }
    }

    @Override
    public void registerReturn(RegisterBean registerBean) {
        Log.i("TAG","registerReturn");
        if(registerBean.getErrno() == 0){
            Log.i("TAG","registerReturn:"+um);
            SpUtils.getInstance().setValue("username",um);
            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
