package com.bawei.wangjiangwei.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 姓名：王江伟
 * 时间：2019年12月3日09:06:05
 * 作用：工具类
 */
public class NetUtils {
    //创建构造器
    private static NetUtils netUtils = new NetUtils();

    //私有化构造器
    private NetUtils() {
    }

    //提供接口
    public static NetUtils getInstance() {
        return netUtils;
    }

    //获取字符串
    @SuppressLint("StaticFieldLeak")
    public void getJson(final String httpUtil, final MyCallBack myCallBack){
        new AsyncTask<Void, Void, String>() {

            @Override
            protected void onPostExecute(String s) {
                myCallBack.onGetJson(s);
            }

            @Override
            protected String doInBackground(Void... voids) {
                String json = "";
                InputStream inputStream = null;
                try {
                    URL url = new URL(httpUtil);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();

                    if (httpURLConnection.getResponseCode() == 200){
                        inputStream = httpURLConnection.getInputStream();
                        json = io2String(inputStream);
                    }else {
                        Log.i("xxx","请求失败");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                return json;
            }
        }.execute();
    }

    //流转字符
    private String io2String(InputStream inputStream) throws IOException {
        int len = -1;
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        while ((len = inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
        byte[] bytes1 = outputStream.toByteArray();
        String json = new String(bytes1);

        return json;
    }

    //获取图片
    @SuppressLint("StaticFieldLeak")
    public void getPhoto(final String a, final ImageView imageView){
        new AsyncTask<Void, Void, Bitmap>() {

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {
                Bitmap bitmap = null;
                InputStream inputStream = null;
                try {
                    URL url = new URL(a);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();

                    if (httpURLConnection.getResponseCode() == 200){
                        inputStream = httpURLConnection.getInputStream();
                        bitmap = io2Bitmap(inputStream);
                    }else {
                        Log.i("xxx","请求失败");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                return bitmap;
            }
        }.execute();
    }

    //流转图片
    private Bitmap io2Bitmap(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }


    //提供回调借口
    public interface MyCallBack{
        void onGetJson(String json);
    }
}
