package com.tree.mvpdemo.model;

/*
 *  @项目名：  MVPDemo 
 *  @包名：    com.tree.mvpdemo.model
 *  @文件名:   BaseModel
 *  @创建者:   Administrator
 *  @创建时间:  2018/3/23 16:34
 *  @描述：    TODO
 */

import com.tree.mvpdemo.MvpCallBack;

import java.util.Map;

public abstract class BaseModel<T> {
    protected String[] mParams;

    public BaseModel params(String... args) {
        mParams = args;
        return this;
    }

    /**
     * 添加callback并执行数据请求
     * 具体的数据请求由子类实现
     * @param callback
     */
    public abstract void execute(MvpCallBack<T> callback);

    /**
     * 执行get网络请求,此类看需求由自己选择写与不写
     * @param url
     * @param callBack
     */
    public void requestGetAPI(String url, MvpCallBack<T> callBack) {
        //这里写具体的网络请求
    }

    /**
     * 执行get网络请求,此类看需求由自己选择写与不写
     * @param url
     * @param callBack
     */
    public void requestPostAPI(String url, Map params, MvpCallBack<T> callBack) {
        //这里写具体的网络请求
    }

}
