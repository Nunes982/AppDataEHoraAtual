package app.daaziv1.appclientevip.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import app.daaziv1.appclientevip.R;
import app.daaziv1.appclientevip.api.AppUtil;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences preferences;

    boolean isLembrarSenha = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        salvarSharedPreferences();
        restaurarSharedPreferences();

        iniciarAplicativo();

    }

    private void iniciarAplicativo() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent;

                if (isLembrarSenha) {

                    intent = new Intent(SplashActivity.this, MainActivity.class);

                } else {

                    intent = new Intent(SplashActivity.this, LoginActivity.class);

                }
                startActivity(intent);
                finish();
            }
        }, AppUtil.TIME_SPLASH);
    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PRE_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PRE_APP, MODE_PRIVATE);
        isLembrarSenha = preferences.getBoolean("loginAutomativo", false);


    }


}