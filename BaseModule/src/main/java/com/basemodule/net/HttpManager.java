package com.basemodule.net;

import android.util.Log;
import android.widget.ListView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager<T> {
    private static HttpManager instance;


    public static HttpManager getInstance(){
        if(instance == null){
            synchronized(HttpManager.class){
                if(instance == null){
                    instance = new HttpManager();
                }
            }
        }
        return instance;
    }

    private T liveApi;

    private static Map<String,String> headerMap;


    private Retrofit getRetrofit(String url){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    private OkHttpClient getOkHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .addInterceptor(new HeaderInterceptor())
                .build();
        return okHttpClient;
    }

    static class LoggingInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            ResponseBody responseBody = response.peekBody(Integer.MAX_VALUE);
            Log.i("responseBody",responseBody.string());
            return response;
        }
    }

    /**
     * 拦截的头处理
     */
    static class HeaderInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();
            if(headerMap != null){
                Iterator<String> it = headerMap.keySet().iterator();
                while (it.hasNext()){
                    String key = it.next();
                    builder.addHeader(key,headerMap.get(key));
                }
            }
            Request request = builder.build();
            return chain.proceed(request);
        }
    }

    /**
     * 设置请求头信息
     * @param map
     */
    public void setHeaders(Map<String,String> map){
        headerMap = map;
    }

    /**
     * ServiceApi
     * @return
     */
    public T getService(Class<T> api,String url){
        if(liveApi == null){
            liveApi = getRetrofit(url).create(api);
        }
        return liveApi;
    }
}
