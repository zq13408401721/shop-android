package com.client.ui.shop;

import android.content.Intent;
import android.util.Log;
import android.webkit.WebView;

import com.client.R;
import com.client.base.BaseActivity;
import com.client.interfaces.IBasePresenter;
import com.client.interfaces.shop.IShop;
import com.client.model.shop.GoodDetailBean;
import com.client.presenter.shop.ShopPresenter;

import butterknife.BindView;

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
        String content = h5.replace("word",webData);
        Log.i("TAG",content);
        webView.loadDataWithBaseURL("about:blank", content, "text/html", "utf-8", null);
    }
}
