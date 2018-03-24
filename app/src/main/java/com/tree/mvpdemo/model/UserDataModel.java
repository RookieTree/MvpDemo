package com.tree.mvpdemo.model;

/*
 *  @项目名：  MVPDemo 
 *  @包名：    com.tree.mvpdemo.model
 *  @文件名:   UserDataModel
 *  @创建者:   Administrator
 *  @创建时间:  2018/3/23 17:09
 *  @描述：    TODO
 */

import android.os.Handler;

import com.tree.mvpdemo.MvpCallBack;

public class UserDataModel extends BaseModel<String> {
    @Override
    public void execute(final MvpCallBack<String> callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (mParams[0]) {
                    case "normal":
                        callback.onSuccess("根据参数"+mParams[0]+"的请求网络数据成功");
                        break;
                    case "failure":
                        callback.onFailed("请求失败：参数有误");
                        break;
                    case "error":
                        callback.onError();
                        break;
                }
            }
        },2000);
    }
}
