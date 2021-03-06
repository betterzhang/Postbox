package com.jsdttec.postbox.view;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jsdttec.postbox.R;


/**
 * Created by Android Studio.
 * Author : zhangzhongqiang
 * Email  : zhangzhongqiang@jsdttec.com
 * Time   : 2017/05/16 下午 1:51
 * Desc   : 自定义Toast样式
 */

public enum CustomToast {

    INSTANCE;// 实现单例

    private Toast mToast;
    private TextView mTvToast;
    private ImageView mImageToast;
    private LinearLayout mLayoutToast;

    public final static int NORMAL_STATE = 0;
    public final static int SUCCESS_STATE = 1;
    public final static int ERROR_STATE = 2;

    public void showToast(Context ctx, String content, @DrawableRes int resId, int state) {
        if (mToast == null) {
            mToast = new Toast(ctx);
            mToast.setGravity(Gravity.CENTER, 0, 0);//设置toast显示的位置，这是居中
            mToast.setDuration(Toast.LENGTH_SHORT);//设置toast显示的时长
            View _root = LayoutInflater.from(ctx).inflate(R.layout.custom_toast, null);//自定义样式，自定义布局文件
            mTvToast = (TextView) _root.findViewById(R.id.tv_toast);
            mImageToast = (ImageView) _root.findViewById(R.id.iv_toast);
            mLayoutToast = (LinearLayout) _root.findViewById(R.id.layout_toast);
            mToast.setView(_root);//设置自定义的view
        }
        mTvToast.setText(content);//设置文本
        mImageToast.setBackgroundResource(resId);
        if (state == SUCCESS_STATE)
            mLayoutToast.setBackgroundResource(R.drawable.custom_toast_success_bg);
        else if (state == ERROR_STATE)
            mLayoutToast.setBackgroundResource(R.drawable.custom_toast_error_bg);
        else if (state == NORMAL_STATE)
            mLayoutToast.setBackgroundResource(R.drawable.custom_toast_normal_bg);
        mToast.show();//展示toast
    }

    public void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
            mTvToast = null;
            mImageToast = null;
        }
    }
}