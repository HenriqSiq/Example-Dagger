package br.com.bravve.di;

import android.util.Log;

import javax.inject.Singleton;

import br.com.bravve.data.repository.CatFactRepository;
import br.com.bravve.ui.feature.home.business.HomeBusiness;
import dagger.Module;
import dagger.Provides;

@Module
public class BusinessModule {
    private static final String TAG = "Module";
    @Provides
    @Singleton
    HomeBusiness providesHomeBusiness(CatFactRepository catFactRepository) {
        Log.d(TAG, "providesHomeBusiness: ");
        return new HomeBusiness(catFactRepository);
    }
}
