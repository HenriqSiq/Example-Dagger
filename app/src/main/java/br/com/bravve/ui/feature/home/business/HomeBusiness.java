package br.com.bravve.ui.feature.home.business;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import br.com.bravve.data.model.CatFactDTO;
import br.com.bravve.data.model.response.CatFactResponse;
import br.com.bravve.data.repository.CatFactRepository;
import br.com.bravve.ui.utils.SharedPrefUtils;
import io.reactivex.rxjava3.core.Observable;

public class HomeBusiness {
    private static final String TAG = "Module";
    
    @Inject
    CatFactRepository catFactRepository;

    public HomeBusiness(CatFactRepository catFactRepository) {
        Log.d(TAG, "HomeBusiness: Constructor");
        this.catFactRepository = catFactRepository;
    }

    public Observable<CatFactDTO> getCatFact(Context context) {
        Log.d(TAG, "getCatFact: getFactObservable - HOMEBUSINESS");
        if (SharedPrefUtils.getStringData(context, SharedPrefUtils.CAT_FACT_KEY) != null) {
            return Observable.just(new CatFactDTO(SharedPrefUtils.getStringData(context, SharedPrefUtils.CAT_FACT_KEY)));
        }

        return Observable.defer(() -> catFactRepository.getCatFact().map(catFactResponse -> {
            SharedPrefUtils.saveData(context, SharedPrefUtils.CAT_FACT_KEY, catFactResponse.fact);
            return new CatFactDTO(catFactResponse);
        }));
    }
}
