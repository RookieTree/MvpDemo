package com.tree.mvpdemo;

/*
 *  @项目名：  MVPDemo 
 *  @包名：    com.tree.mvpdemo
 *  @文件名:   BaseFragment
 *  @创建者:   Administrator
 *  @创建时间:  2018/3/23 15:34
 *  @描述：    TODO
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tree.mvpdemo.view.BaseView;

public abstract class BaseFragment extends Fragment implements BaseView {

    private ProgressDialog mProgressDialog;

    public abstract int getContentViewId();

    protected abstract void initAllViews(Bundle saveInstance);

    protected Context mContext;

    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        mRootView = inflater.inflate(getContentViewId(), container, false);
        this.mContext=getActivity();
        initAllViews(savedInstanceState);
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setCancelable(false);
        return mRootView;
    }

    @Override
    public void showLoading() {
        checkActivityAttached();
        if (!mProgressDialog.isShowing()){
            mProgressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        checkActivityAttached();
        if (mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT)
             .show();
    }

    @Override
    public void showError() {
        Toast.makeText(mContext, "出错了", Toast.LENGTH_SHORT)
             .show();
    }

    /**
     * 检查activity连接情况
     */
    public void checkActivityAttached() {
        if (getActivity() == null) {
            throw new ActivityNotAttachedException();
        }
    }
    public static class ActivityNotAttachedException extends RuntimeException {
        public ActivityNotAttachedException() {
            super("Fragment has disconnected from Activity ! - -.");
        }
    }
}
