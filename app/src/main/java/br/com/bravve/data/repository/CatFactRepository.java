package br.com.bravve.data.repository;

import android.util.Log;

import javax.inject.Inject;

import br.com.bravve.data.model.response.CatFactResponse;
import br.com.bravve.data.remote.BravveApiService;
import io.reactivex.rxjava3.core.Observable;

public class CatFactRepository {
    private static final String TAG = "Module";
    BravveApiService bravveApiService;

    @Inject
    public CatFactRepository(BravveApiService bravveApiService) {
        Log.d(TAG, "CatFactRepository: Constructor");
        this.bravveApiService = bravveApiService;
    }

    public Observable<CatFactResponse> getCatFact() {
        Log.d(TAG, "getCatFact: Observable CatFactRepository");
        return bravveApiService.getCatFact();
    }
}
