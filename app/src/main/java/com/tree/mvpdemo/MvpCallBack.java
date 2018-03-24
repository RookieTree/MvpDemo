package com.tree.mvpdemo;

/*
 *  @项目名：  MVPDemo 
 *  @包名：    com.tree.mvpdemo
 *  @文件名:   MvpCallBack
 *  @创建者:   Administrator
 *  @创建时间:  2018/3/22 11:41
 *  @描述：    TODO
 */

public interface MvpCallBack<T> {

    void onSuccess(T data);

    void onFailed(String msg);

    void onError();

    void onComplete();

}
