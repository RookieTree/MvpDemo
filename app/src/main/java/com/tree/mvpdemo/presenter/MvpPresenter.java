package com.tree.mvpdemo.presenter;

/*
 *  @项目名：  MVPDemo 
 *  @包名：    com.tree.mvpdemo.presenter
 *  @文件名:   MvpPresenter
 *  @创建者:   Administrator
 *  @创建时间:  2018/3/22 14:12
 *  @描述：    TODO
 */

import com.tree.mvpdemo.MvpCallBack;
import com.tree.mvpdemo.model.DataModelManager;
import com.tree.mvpdemo.model.UserDataModel;
import com.tree.mvpdemo.view.MvpView;

public class MvpPresenter
        extends BasePresenter<MvpView>
{

    public void getData(String params) {
        if (!isAttchView()) {
            //如果没有view引用 就不加载数据
            return;
        }
        getView().showLoading();

        DataModelManager.request(UserDataModel.class.getName())
                        .params(params)
                        .execute(new MvpCallBack<String>() {
                            @Override
                            public void onSuccess(String data) {
                                //调用view接口 显示数据
                                if (isAttchView()) { getView().showData(data); }
                            }

                            @Override
                            public void onFailed(String msg) {
                                if (isAttchView()) { getView().showError(); }
                            }

                            @Override
                            public void onError() {
                                if (isAttchView()) { getView().showError(); }
                            }

                            @Override
                            public void onComplete() {
                                if (isAttchView()) { getView().hideLoading(); }
                            }

                        });


    }
}
