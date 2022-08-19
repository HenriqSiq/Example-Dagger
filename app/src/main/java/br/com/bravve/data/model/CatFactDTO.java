package br.com.bravve.data.model;

import android.util.Log;

import br.com.bravve.data.model.response.CatFactResponse;

public class CatFactDTO {
    private static final String TAG = "Module";
    private String fact;

    public CatFactDTO(String fact) {
        this.fact = fact;
    }

    public CatFactDTO(CatFactResponse catFactResponse) {
        Log.d(TAG, "CatFactDTO: Constructor");
        this.fact = catFactResponse.fact;
    }

    public String getFact() {
        Log.d(TAG, "getFact: GET");
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
