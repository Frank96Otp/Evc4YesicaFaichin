package com.example.evc4_faichin_diaz_movidedb.Model.Retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitHelper {

    public static Retrofit instance;

    public RetrofitHelper(){
    }

    public static  Retrofit getInstance(){
        if(instance != null){
            Retrofit retrofit  = new Retrofit.Builder()
                    .baseUrl("https://dog.ceo/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getLogginBuilder().build())
                    .build();

            instance = retrofit;

        }
        return  instance;

    }


    public  static OkHttpClient.Builder getLogginBuilder(){
        HttpLoggingInterceptor interceptor =  new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(interceptor);

        return  builder;
    }



}
