package com.client.utils;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PrintUtils {

    /**
     *
     * @param tag 当前响应事件对象
     * @param status  事件的内容
     *        action  事件类型
     */
    public static void printInfo(String tag,String status,int action){
        String str = "";
        switch (action){
            case MotionEvent.ACTION_DOWN:
                str = "Down";
                break;
            case MotionEvent.ACTION_UP:
                str = "Up";
                break;
            case MotionEvent.ACTION_MOVE:
                str = "Move";
            break;case MotionEvent.ACTION_CANCEL:
                str = "Cancel";
                break;

        }
        Log.i(tag,status+"  "+str);
    }

    /**
     * 解析数据
     * @param word
     * @return
     */
    public static String parseJson(String word){
        String[] arr = word.split(",");
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject items=null;
        for(int i=0; i<arr.length; i++){
            String item = arr[i];
            if(i%2 == 0){
                items = new JSONObject();
                jsonArray.put(items);
            }
            String[] data = item.split(":");
            try{
                items.put(data[0].trim(),data[1].trim());
            }catch (JsonIOException | JSONException e){
                e.printStackTrace();
            }
        }
        try{
            jsonObject.put("data",jsonArray);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    /**
     * 加载assets目录下的json文件
     * @param context
     */
    public static List<LatLng> loadAssetsJson(Context context){
        List<LatLng> list = new ArrayList<LatLng>();
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            is = context.getAssets().open("data.json");
            bos = new ByteArrayOutputStream();
            byte[] bytes = new byte[4 * 1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            final String json = new String(bos.toByteArray());
            final TudeBean tudeBean = new Gson().fromJson(json, TudeBean.class);
            for(TudeBean.DataBean item:tudeBean.getData()){
                LatLng lat = new LatLng(Double.valueOf(item.getLatitude()),Double.valueOf(item.getLongitude()));
                list.add(lat);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
            }
        }
        return null;
    }

}
