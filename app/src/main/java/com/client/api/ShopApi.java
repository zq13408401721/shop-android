package com.client.api;

import com.client.model.home.CategoryBean;
import com.client.model.home.CategoryGoodBean;
import com.client.model.home.GoodBean;
import com.client.model.home.HomeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShopApi {

    String BASE_URL = "https://cdplay.cn/";

    @GET("api/index")
    Flowable<HomeBean> getHome();

    @GET("goods/category")
    Flowable<CategoryBean> getCategory(@Query("id") int id);

    @GET("api/goods/list")
    Flowable<CategoryGoodBean> getGoodList(@Query("categoryId") int categoryId, @Query("page") int page, @Query("size") int size);

}
