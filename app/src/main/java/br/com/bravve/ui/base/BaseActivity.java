package br.com.bravve.ui.base;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("DESTINO", this.getClass().getSimpleName());
    }
}
