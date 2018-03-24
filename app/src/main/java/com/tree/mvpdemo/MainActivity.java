package com.tree.mvpdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tree.mvpdemo.presenter.MvpPresenter;
import com.tree.mvpdemo.view.MvpView;

public class MainActivity
        extends BaseActivity
        implements MvpView
{

    private Button       mBtnOk;
    private Button       mBtnFail;
    private Button       mBtnError;
    private MvpPresenter mMvpPresenter;
    private LinearLayout mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootView = findViewById(R.id.rootview);
        mBtnOk = findViewById(R.id.btn_ok);
        mBtnFail = findViewById(R.id.btn_fail);
        mBtnError = findViewById(R.id.btn_error);



        mMvpPresenter = new MvpPresenter();
        //绑定view 与 activity 的生命周期
        mMvpPresenter.attachView(this);

        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMvpPresenter.getData("normal");
            }
        });

        mBtnFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMvpPresenter.getData("failed");
            }
        });

        mBtnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMvpPresenter.getData("error");
            }
        });
    }


    @Override
    public void showData(String data) {

        Snackbar snackbar = Snackbar.make(mRootView, "showData:" + data, Snackbar.LENGTH_LONG)
                                    .setAction("这是action", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Toast.makeText(MainActivity.this,
                                                           "点一点",
                                                           Toast.LENGTH_SHORT)
                                                 .show();
                                        }
                                    });

        setSnackbarColor(snackbar, Color.GREEN, Color.YELLOW);
        snackbar.show();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        //断开view 引用
        mMvpPresenter.dettachView();

    }
}
