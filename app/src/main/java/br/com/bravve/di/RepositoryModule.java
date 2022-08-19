package br.com.bravve.di;

import android.util.Log;

import javax.inject.Singleton;

import br.com.bravve.data.remote.BravveApiService;
import br.com.bravve.data.repository.CatFactRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    private static final String TAG = "Module";
    @Provides
    @Singleton
    CatFactRepository providesCatFactRepository(BravveApiService bravveApiService) {
        Log.d(TAG, "providesCatFactRepository: ");
        return new CatFactRepository(bravveApiService);
    }
}
