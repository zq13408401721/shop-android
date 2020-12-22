package com.client.ui.shop;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.client.R;
import com.client.base.BaseFragment;
import com.client.interfaces.IBasePresenter;
import com.client.interfaces.shop.ICar;
import com.client.model.shop.CarBean;
import com.client.presenter.shop.CarPresenter;
import com.client.utils.SpUtils;

import org.w3c.dom.Text;

import butterknife.BindView;

public class ShopFragment extends BaseFragment<ICar.Presenter> implements ICar.View, View.OnClickListener {

    @BindView(R.id.checkbox_all)
    CheckBox checkBoxAll;
    @BindView(R.id.txt_totalPrice)
    TextView txtTotalPrice;
    @BindView(R.id.txt_edit)
    TextView txtEdit;
    @BindView(R.id.txt_submit)
    TextView txtSubmit;

    private CarBean carBean;

    private boolean isEdit; //是否是编辑状态

    @Override
    protected int getLayout() {
        return R.layout.fragment_shop;
    }

    @Override
    protected ICar.Presenter createPrenter() {
        return new CarPresenter();
    }

    @Override
    protected void initView() {
        checkBoxAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isEdit){
                    updateGoodSelectStateEdit(isChecked);
                }else{
                    updateGoodSelectStateOrder(isChecked);
                }
            }
        });

        txtEdit.setOnClickListener(this);
        txtSubmit.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        String token = SpUtils.getInstance().getString("token");
        if(!TextUtils.isEmpty(token)){
            presenter.getCarList();
        }else{
            gotoLogin();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.getCarList();
    }

    @Override
    public void getCarListReturn(CarBean carBean) {
        this.carBean = carBean;
    }

    /**
     * 下单状态的数据刷新
     * @param bool
     */
    private void updateGoodSelectStateOrder(boolean bool){
        for(CarBean.DataBean.CartListBean item:carBean.getData().getCartList()){
            item.selectOrder = bool;
        }
        totalSelectOrder();
    }

    /**
     * 编辑状态下的数据刷新
     * @param bool
     */
    private void updateGoodSelectStateEdit(boolean bool){
        for(CarBean.DataBean.CartListBean item:carBean.getData().getCartList()){
            item.selectEdit = bool;
        }
        totalSelectOrder();
    }

    /**
     * 下单状态下的总数和价格的计算
     */
    private void totalSelectOrder(){
        int num = 0;
        int totalPrice = 0;
        boolean isSelectAll = true;
        for(CarBean.DataBean.CartListBean item:carBean.getData().getCartList()){
            if(item.selectOrder){
                num += item.getNumber();
                totalPrice += item.getNumber()*item.getRetail_price();
            }else{
                if(isSelectAll){
                    isSelectAll = false;
                }
            }
        }
        String strAll = "全选($)";
        strAll = strAll.replace("$",String.valueOf(num));
        checkBoxAll.setText(strAll);
        txtTotalPrice.setText("￥"+totalPrice);
        checkBoxAll.setChecked(isSelectAll);
    }

    private void totalSelectEdit(){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_edit:
                changeEdit();
                break;
            case R.id.txt_submit:
                submit();
                break;
        }
    }

    /**
     * 修改编辑和完成的状态
     */
    private void changeEdit(){
        if("编辑".equals(txtEdit.getText().toString())){
            txtEdit.setText("完成");
            txtSubmit.setText("删除所选");
        }else if("完成".equals(txtEdit.getText().toString())){
            txtEdit.setText("编辑");
            txtSubmit.setText("下单");
        }
    }

    /**
     * 提交
     */
    private void submit(){
        if("下单".equals(txtSubmit.getText().toString())){
            //下单
        }else if("删除所选".equals(txtSubmit.getText().toString())){
            //删除购物车所选数据
        }
    }


}
