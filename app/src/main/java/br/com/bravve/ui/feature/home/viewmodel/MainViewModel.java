package br.com.bravve.ui.feature.home.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import br.com.bravve.data.model.CatFactDTO;
import br.com.bravve.data.model.response.CatFactResponse;
import br.com.bravve.data.repository.CatFactRepository;
import br.com.bravve.ui.feature.home.business.HomeBusiness;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = "Module";
    
    @Inject
    HomeBusiness homeBusiness;

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    public MutableLiveData<CatFactDTO> catFact = new MutableLiveData<>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<>();
    public MutableLiveData<Throwable> error = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application,
                         HomeBusiness homeBusiness) {
        super(application);
        Log.d(TAG, "MainViewModel: Constructor");
        this.homeBusiness = homeBusiness;
    }

    public void getCatFact(Context context) {
        loading.postValue(true);
        compositeDisposable.add(
            homeBusiness.getCatFact(context).subscribe(
                    catFactDTO -> catFact.postValue(catFactDTO),
                    throwable -> error.postValue(throwable),
                    () -> loading.postValue(false)
            )
        );
        //Log.d("LOGtesteDoido", "getSpaceDetail: Subscribe" + catFact.getValue().getFact());
        //erro
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
