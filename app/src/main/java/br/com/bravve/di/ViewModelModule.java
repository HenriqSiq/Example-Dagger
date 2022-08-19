package br.com.bravve.di;

import android.app.Application;
import android.util.Log;

import br.com.bravve.data.repository.CatFactRepository;
import br.com.bravve.ui.feature.home.business.HomeBusiness;
import br.com.bravve.ui.feature.home.viewmodel.MainViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {
    private static final String TAG = "Module";
    @Provides
    public MainViewModel provideMainViewModel(Application application, HomeBusiness homeBusiness) {
        Log.d(TAG, "provideMainViewModel: ");
        return new MainViewModel(application, homeBusiness);
    }
}
