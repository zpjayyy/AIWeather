package com.jay.aiweather.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by jay on 17/3/13.
 */

public class BaseActivity extends RxAppCompatActivity {

    ProgressDialog dialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new ProgressDialog(this);
        dialog.setIndeterminate(true);
        dialog.setMessage("请稍后...");
        dialog.setCanceledOnTouchOutside(false);
    }

    public void showProgress(boolean show) {
        if (show) {
            dialog.show();
        } else {
            dialog.dismiss();
        }
    }
}
