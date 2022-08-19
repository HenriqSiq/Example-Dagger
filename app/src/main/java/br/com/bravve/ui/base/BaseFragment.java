package br.com.bravve.ui.base;

import android.util.Log;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {
    @Override
    public void onStart() {
        super.onStart();
        Log.d("DESTINO", this.getClass().getSimpleName());
    }
}
