package br.com.bravve.di;

import javax.inject.Singleton;

import br.com.bravve.ui.feature.home.business.HomeBusiness;
import br.com.bravve.ui.feature.home.presentation.MainActivity;
import br.com.bravve.ui.feature.home.viewmodel.MainViewModel;
import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        ApiModule.class,
        RepositoryModule.class,
        ViewModelModule.class,
        BusinessModule.class,
})

public interface AppComponent {
    void inject(MainViewModel mainViewModel);
    void inject(MainActivity mainActivity);
    void inject(HomeBusiness homeBusiness);
}
