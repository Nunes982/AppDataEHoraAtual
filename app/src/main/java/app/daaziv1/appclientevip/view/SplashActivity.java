package app.daaziv1.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import app.daaziv1.appclientevip.R;
import app.daaziv1.appclientevip.api.AppUtil;

public class SplashActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        iniciarAplicativo();

    }

    private void iniciarAplicativo() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        }, AppUtil.TIME_SPLASH);
    }
}