package br.com.bravve;

import android.app.Application;
import android.content.Context;

import br.com.bravve.di.ApiModule;
import br.com.bravve.di.AppComponent;
import br.com.bravve.di.AppModule;
import br.com.bravve.di.BusinessModule;
import br.com.bravve.di.DaggerAppComponent;
import br.com.bravve.di.RepositoryModule;
import br.com.bravve.di.ViewModelModule;

public class App extends Application {
    private static AppComponent appComponent;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .repositoryModule(new RepositoryModule())
                .viewModelModule(new ViewModelModule())
                .businessModule(new BusinessModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    public static Context getContext() {
        if (instance == null) {
            instance = new App();
        }
        return instance.getApplicationContext();
    }
}
