package com.tree.mvpdemo.model;

/*
 *  @项目名：  MVPDemo 
 *  @包名：    com.tree.mvpdemo.model
 *  @文件名:   MvpModel
 *  @创建者:   Administrator
 *  @创建时间:  2018/3/22 11:44
 *  @描述：    TODO
 */

import android.os.Handler;

import com.tree.mvpdemo.MvpCallBack;


public class MvpModel {

    public static void getNetData(final String params, final MvpCallBack callBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (params) {
                    case "normal":
                        callBack.onSuccess("请求成功");
                        break;
                    case "failed":
                        callBack.onFailed("请求失败");
                        break;
                    case "error":
                        callBack.onError();
                        break;
                    default:
                        break;
                }
                callBack.onComplete();
            }
        }, 2000);
    }
}
