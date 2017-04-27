package com.jay.aiweather.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.schedulers.Schedulers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jay on 17/4/27.
 */

public class AiWeatherRetrofit {

    final AiWeather service;

    private static boolean debug = true;

    public static final String ENDPOINT = "https://free-api.heweather.com/v5/";

    public static final Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    AiWeatherRetrofit() {
        OkHttpClient.Builder clienBuilder = new OkHttpClient.Builder();

        if (debug) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            clienBuilder.addInterceptor(logging);
        }

        OkHttpClient client = clienBuilder.build();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                .baseUrl(HttpUrl.parse(ENDPOINT))
                .addConverterFactory(GsonConverterFactory.create(GSON))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(client);

        Retrofit retrofit = builder.build();
        service = retrofit.create(AiWeather.class);
    }

    public static void setDebug(boolean debug) {
        AiWeatherRetrofit.debug = debug;
    }

    AiWeather getService() {
        return service;
    }

}
