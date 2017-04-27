package com.jay.aiweather.tool;

import android.app.Application;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Created by jay on 17/3/14.
 */

public class Toasts {

    @SuppressWarnings("StaticFieldLeak")
    private static Application application;

    public static void install(Application application) {
        Toasts.application = application;
    }

    public static void showShort(String text) {
        Toast.makeText(application, text, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(@StringRes int resId) {
        showShort(application.getString(resId));
    }

    public static void showLong(String text) {
        Toast.makeText(application, text, Toast.LENGTH_LONG).show();
    }

    public static void showLong(@StringRes int resId) {
        showLong(application.getString(resId));
    }

}
