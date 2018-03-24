package com.tree.mvpdemo.view;

/*
 *  @项目名：  MVPDemo 
 *  @包名：    com.tree.mvpdemo.view
 *  @文件名:   MvpView
 *  @创建者:   Administrator
 *  @创建时间:  2018/3/22 11:51
 *  @描述：    TODO
 */

public interface MvpView extends BaseView {
    /**
     * 数据请求成功后，调用这个方法显示数据
     * @param data
     */
    void showData(String data);
}
