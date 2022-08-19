package br.com.bravve.di;

import android.util.Log;

import javax.inject.Singleton;

import br.com.bravve.BuildConfig;
import br.com.bravve.data.remote.BravveApiService;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    private static final String TAG = "Module";

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttp() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient.Builder httpClient) {
        Log.d(TAG, "provideRetrofit: ");
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(httpClient.build())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    BravveApiService provideBravveApiServices(Retrofit retrofit) {
        Log.d(TAG, "provideBravveApiServices: ");
        return retrofit.create(BravveApiService.class);
    }
}
