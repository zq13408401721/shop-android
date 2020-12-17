package com.client.ui.home;

import android.content.Context;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.client.R;
import com.client.base.BaseAdapter;
import com.client.model.home.HomeBean;
import com.client.utils.TxtUtils;

import java.util.List;

public class CategoryAdapter extends BaseAdapter<HomeBean.DataBean.CategoryListBean> {
    public CategoryAdapter(Context context, List<HomeBean.DataBean.CategoryListBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.layout_category_item;
    }

    @Override
    protected void bindData(HomeBean.DataBean.CategoryListBean data, VH vh) {
        TextView txtTitle = (TextView) vh.getViewById(R.id.txt_category_title);
        TxtUtils.setTextView(txtTitle,data.getName());
        RecyclerView recyclerView = (RecyclerView) vh.getViewById(R.id.recy_category);
        GoodAdapter goodAdapter = new GoodAdapter(context,data.getGoodsList());
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        recyclerView.setAdapter(goodAdapter);
    }

}
