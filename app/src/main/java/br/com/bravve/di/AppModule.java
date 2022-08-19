package br.com.bravve.di;

import android.app.Application;
import android.util.Log;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    Application application;
    private static final String TAG = "Module";

    public AppModule(Application application) {
        Log.d(TAG, "AppModule: ");
        this.application = application;
    }

    @Provides
    public Application provideApplication() {
        Log.d(TAG, "provideApplication: ");
        return application;
    }
}
