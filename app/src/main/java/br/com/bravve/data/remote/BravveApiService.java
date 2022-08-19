package br.com.bravve.data.remote;

import br.com.bravve.data.model.response.CatFactResponse;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface BravveApiService {
    @GET("fact")
    Observable<CatFactResponse> getCatFact();
}
