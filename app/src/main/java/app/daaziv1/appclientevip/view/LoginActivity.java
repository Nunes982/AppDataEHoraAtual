package app.daaziv1.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.daaziv1.appclientevip.R;
import app.daaziv1.appclientevip.api.AppUtil;
import app.daaziv1.appclientevip.controler.ClienteController;
import app.daaziv1.appclientevip.model.Cliente;

public class LoginActivity extends AppCompatActivity {

    // Declarar Objeto

    Cliente clienteFake;

    SharedPreferences preferences;

    // 1º Passo a partr do layout

    TextView txtRecuperarSenhaLogin, txtLerPolitica;
    EditText editEmailLogin, editSenhaLogin;
    CheckBox ckLembrarLogin;
    Button btnAcessarLogin, btnSejaVipLogin;

    boolean isFormularioOk, isLembrarSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initFormulario();

        btnAcessarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isFormularioOk = validarFormulario()){

                    if (validarDadosDoUsuario()){

                        salvarSharedPreferences();

                        Intent intent =
                                new Intent(LoginActivity.this, MainActivity.class);

                        startActivity(intent);
                        finish();
                    }

                }else {

                    Toast.makeText(getApplicationContext(),
                            "Verifique os dados...",
                            Toast.LENGTH_LONG).show();

                }

            }
        });

        btnSejaVipLogin.setOnClickListener(v -> {

            Intent intent = new Intent(LoginActivity.this, ClienteVip.class);
            startActivity(intent);
            finish();

        });

        txtRecuperarSenhaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),
                        "Carregando tela de recuperação de senha...",
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(LoginActivity.this, RecuperarSenha.class);
                startActivity(intent);
                finish();

            }
        });

        txtLerPolitica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),
                        "Carregando tela com a politica de privacidade...",
                        Toast.LENGTH_LONG).show();

            }
        });

    }

    private boolean validarFormulario() {

        boolean retorno = true;

        if (TextUtils.isEmpty(editEmailLogin.getText().toString())){
            editEmailLogin.setError("*");
            editEmailLogin.requestFocus();
            retorno = false;
        }

        if (TextUtils.isEmpty(editSenhaLogin.getText().toString())){
            editSenhaLogin.setError("*");
            editSenhaLogin.requestFocus();
            retorno = false;
        }

        return retorno;
    }

    private void initFormulario() {

        txtRecuperarSenhaLogin = findViewById(R.id.txtRecuperarSenhaLogin);
        txtLerPolitica = findViewById(R.id.txtLerPolitica);
        editEmailLogin = findViewById(R.id.editEmailLogin);
        editSenhaLogin = findViewById(R.id.editSenhaLogin);
        ckLembrarLogin = findViewById(R.id.ckLembrarLogin);
        btnAcessarLogin = findViewById(R.id.btnAcessarLogin);
        btnSejaVipLogin = findViewById(R.id.btnSejaVipLogin);

        isFormularioOk = false;

        clienteFake = ClienteController.getClienteFake();

        salvarSharedPreferences();
        restaurarSharedPreferences();

    }

    public void lembrarSenha(View view) {

        isLembrarSenha = ckLembrarLogin.isChecked();

    }

    public boolean validarDadosDoUsuario(){

        return ClienteController.validarDadosDoCliente(clienteFake,
                editEmailLogin.getText().toString(),
                editSenhaLogin.getText().toString());

    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PRE_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        // Adicionando dados no SharedPreferences

//        dados.putBoolean("loginAutomativo", isLembrarSenha );
//        dados.putString("emailCliente", editEmailLogin.getText().toString());
//        dados.putString("senhaCliente", editSenhaLogin.getText().toString());
//
//        dados.apply();

    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PRE_APP, MODE_PRIVATE);
        isLembrarSenha = preferences.getBoolean("loginAutomativo", false);

    }


}