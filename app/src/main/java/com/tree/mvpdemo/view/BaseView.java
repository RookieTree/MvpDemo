package com.tree.mvpdemo.view;

/*
 *  @项目名：  MVPDemo 
 *  @包名：    com.tree.mvpdemo.view
 *  @文件名:   BaseView
 *  @创建者:   Administrator
 *  @创建时间:  2018/3/23 14:02
 *  @描述：    TODO
 */

import android.content.Context;

public interface BaseView {

    void showLoading();

    void hideLoading();

    void showToast(String msg);

    void showError();

    Context getContext();
}
