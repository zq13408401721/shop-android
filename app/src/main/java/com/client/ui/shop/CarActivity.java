package com.client.ui.shop;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import com.client.R;
import com.client.base.BaseActivity;
import com.client.interfaces.IBasePresenter;
import com.client.interfaces.shop.IShop;
import com.client.model.shop.GoodDetailBean;
import com.client.presenter.shop.ShopPresenter;
import com.client.ui.login.LoginActivity;
import com.client.utils.SpUtils;

import org.intellij.lang.annotations.RegExp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

public class CarActivity extends BaseActivity<IShop.Presenter> implements IShop.View {

    @BindView(R.id.webView)
    WebView webView;


    private String h5 = "<html>\n" +
            "            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\"/>\n" +
            "            <head>\n" +
            "                <style>\n" +
            "                    p{\n" +
            "                        margin:0px;\n" +
            "                    }\n" +
            "                    img{\n" +
            "                        width:100%;\n" +
            "                        height:auto;\n" +
            "                    }\n" +
            "                </style>\n" +
            "            </head>\n" +
            "            <body>\n" +
            "                word\n" +
            "            </body>\n" +
            "        </html>";

    @Override
    protected int getLayout() {
        return R.layout.activity_car;
    }

    @Override
    protected IShop.Presenter createPrenter() {
        return new ShopPresenter();
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.layout_collect,R.id.layout_car,R.id.txt_buy,R.id.txt_addCar})
    public void onClick(View view){
        if(!TextUtils.isEmpty(SpUtils.getInstance().getString("token"))){
            switch (view.getId()){
                case R.id.layout_collect:
                    break;
                case R.id.layout_car:

                    break;
                case R.id.txt_buy:

                    break;
                case R.id.txt_addCar:

                    break;
            }
        }else{
            Intent intent = new Intent(CarActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        if(intent.hasExtra("goodid")){
            int id = getIntent().getIntExtra("goodid",0);
            if(id > 0){
                presenter.getGoodDetail(id);
            }else{
                showToast(getString(R.string.tips_error_goodid));
            }
        }


    }

    private void addCar(){

    }

    @Override
    public void getGoodDetail(GoodDetailBean goodDetailBean) {
        //h5 商品详情
        initGoodDetail(goodDetailBean.getData().getInfo().getGoods_desc());
    }

    /**
     * 商品详情数据  h5
     * @param webData
     */
    private void initGoodDetail(String webData){
        getHtmlImgs(webData);
        String content = h5.replace("word",webData);
        Log.i("TAG",content);
        webView.loadDataWithBaseURL("about:blank", content, "text/html", "utf-8", null);
    }

    private void getHtmlImgs(String content){
        String img = "<img[\\s\\S]*?>";
        Pattern pattern = Pattern.compile(img);
        Matcher matcher = pattern.matcher(content);
        List<String> list = new ArrayList<>();
        while(matcher.find()){
            String word = matcher.group();
            int start = word.indexOf("\"")+1;
            int end = word.indexOf(".jpg");
            String url = word.substring(start,end);
            url = url +".jpg";
            list.add(url);
        }

    }
}
