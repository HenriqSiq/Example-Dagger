package br.com.bravve.ui.feature.home.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.core.splashscreen.SplashScreen;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import br.com.bravve.App;
import br.com.bravve.R;
import br.com.bravve.databinding.ActivityMainBinding;
import br.com.bravve.di.AppComponent;
import br.com.bravve.ui.base.BaseActivity;
import br.com.bravve.ui.feature.home.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity {
    @Inject
    public MainViewModel mainViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SplashScreen.installSplashScreen(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        AppComponent appComponent = App.getInstance().getAppComponent();
        appComponent.inject(this);
        appComponent.inject(mainViewModel);

        mainViewModel.catFact.observe(this, catFact -> {
            binding.tvHello.setText(catFact.getFact());
            Picasso.get()
                    .load("https://cdn2.thecatapi.com/images/MTk0NDg2MA.jpg")
                    .placeholder(R.drawable.bravve)
                    .into(binding.ivImage);
        });
        mainViewModel.loading.observe(this, loading -> {
            if (loading) {
                // show loading
            } else {
                // hide loading
            }
        });
        mainViewModel.error.observe(this, error -> {
            Toast.makeText(this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        });
        mainViewModel.getCatFact(this);
    }
}
