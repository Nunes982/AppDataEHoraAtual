package app.daaziv1.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import app.daaziv1.appclientevip.R;

public class RecuperarSenha extends AppCompatActivity {

    EditText editEmailRecuperarSenha;

    Button btnRecuperarSenha, btnVoltar;

    boolean isFormularioOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        initFormulario();

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RecuperarSenha.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void initFormulario() {

        editEmailRecuperarSenha = findViewById(R.id.editEmailRecuperarSenha);
        btnRecuperarSenha =findViewById(R.id.btnRecuperarSenha);
        btnVoltar =findViewById(R.id.btnVoltar);

        isFormularioOk = false;

    }
}