package com.tree.mvpdemo;

/*
 *  @项目名：  MVPDemo 
 *  @包名：    com.tree.mvpdemo
 *  @文件名:   BaseActivity
 *  @创建者:   Administrator
 *  @创建时间:  2018/3/23 14:12
 *  @描述：    TODO
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tree.mvpdemo.view.BaseView;

public class BaseActivity
        extends AppCompatActivity
        implements BaseView
{

    public ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new ProgressDialog(this);

        mProgressDialog.setCancelable(false);

        // 初始化进度条
        mProgressDialog.setMessage("正在加载数据");
    }

    @Override
    public void showLoading() {
        if (!mProgressDialog.isShowing()){
            mProgressDialog.show();
        }

    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }


    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
             .show();

    }

    @Override
    public void showError() {
        Toast.makeText(this, "出错了", Toast.LENGTH_SHORT)
             .show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    public static void setSnackbarColor(Snackbar snackbar, int messageColor, int backgroundColor) {
        View view = snackbar.getView();//获取Snackbar的view
        if (view != null) {
            view.setBackgroundColor(backgroundColor);//修改view的背景色
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(messageColor);//获取Snackbar的message控件，修改字体颜色
        }
    }
}
