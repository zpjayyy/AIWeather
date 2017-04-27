package com.jay.aiweather;

import android.app.ActivityManager;
import android.content.Context;

import com.jay.aiweather.api.AiWeatherRetrofit;
import com.jay.aiweather.tool.Toasts;
import com.squareup.leakcanary.LeakCanary;

import org.litepal.LitePalApplication;

import java.util.List;

/**
 * Created by jay on 17/4/27.
 */

public class App extends LitePalApplication{

    @Override
    public void onCreate() {
        super.onCreate();

        if (isMainProcess(this)) {
            initLeakcanary();
            AiWeatherRetrofit.setDebug(BuildConfig.DEBUG);
//            RxJavaPlugins.setErrorHandler(ErrorHandlers.displayErrorConsumer(this));
            Toasts.install(this);
        }

    }

    public static boolean isMainProcess(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> processInfoList = am.getRunningAppProcesses();
        String mainProcessName = context.getPackageName();
        int myPid = android.os.Process.myPid();
        for (ActivityManager.RunningAppProcessInfo info : processInfoList) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }

    private void initLeakcanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
