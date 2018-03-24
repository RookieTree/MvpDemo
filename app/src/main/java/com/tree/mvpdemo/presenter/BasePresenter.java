package com.tree.mvpdemo.presenter;

/*
 *  @项目名：  MVPDemo 
 *  @包名：    com.tree.mvpdemo.presenter
 *  @文件名:   BasePresenter
 *  @创建者:   Administrator
 *  @创建时间:  2018/3/23 14:07
 *  @描述：    TODO
 */

import com.tree.mvpdemo.view.BaseView;

public class BasePresenter<V extends BaseView> {
    private V mvpView;

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    public void dettachView() {
        this.mvpView = null;
    }

    public boolean isAttchView() {
        return mvpView != null;
    }

    public V getView() {
        return mvpView;
    }

}
