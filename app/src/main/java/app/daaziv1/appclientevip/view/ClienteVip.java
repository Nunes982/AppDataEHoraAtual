package app.daaziv1.appclientevip.view;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import app.daaziv1.appclientevip.R;
import app.daaziv1.appclientevip.api.AppUtil;
import app.daaziv1.appclientevip.model.Cliente;

public class ClienteVip extends AppCompatActivity {

    // Declarar Objetos
    Cliente novoVip;
    private SharedPreferences preferences;

    // 1º passo apartir do layout
    EditText editPrimeiroNome, editSobreNome;
    CheckBox ckPessofisica;
    Button btnSalvarContinuar, btnCancelar;

    boolean isFormularioOk, isPessoaFisica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_vip);

        initFormulario();


        btnSalvarContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isFormularioOk = validarFormulario()){

                    novoVip.setPrimeiroNome(editPrimeiroNome.getText().toString());
                    novoVip.setSobreNome(editSobreNome.getText().toString());
                    novoVip.setPessoaFisica(isPessoaFisica);

                    salvarSharedPreferences();

                    if (isPessoaFisica){

                        // Tela de Cadastro do CPF

                        Intent intent = new Intent(ClienteVip.this, ClientePessoaFisica.class);
                        startActivity(intent);
                        finish();

                    }else{

                        // Tela de cadastro de CNPJ

                        Intent intent = new Intent(ClienteVip.this, ClientePessoaJuridica.class);
                        startActivity(intent);
                        finish();

                    }

                }

            }
        });
    }

    private void initFormulario() {

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        ckPessofisica = findViewById(R.id.ckPessofisica);
        btnSalvarContinuar = findViewById(R.id.btnSalvarContinuar);
        btnCancelar = findViewById(R.id.btnCancelarPessoaFisica);

        isFormularioOk = false;

        novoVip = new Cliente();

        restaurarSharedPreferences();

    }

    public boolean validarFormulario(){

        boolean retorno = true;

        if (TextUtils.isEmpty(editPrimeiroNome.getText().toString())){
            editPrimeiroNome.setError("*");
            editPrimeiroNome.requestFocus();
            retorno = false;
        }

        if (TextUtils.isEmpty(editSobreNome.getText().toString())){
            editSobreNome.setError("*");
            editSobreNome.requestFocus();
            retorno = false;
        }

        return retorno;

    }

    public void pessoaFisica(View view){

        isPessoaFisica = ckPessofisica.isChecked();

    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PRE_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        // Adicionando dados no SharedPreferences

        dados.putString("primeiroNome", novoVip.getPrimeiroNome());
        dados.putString("sobreNome", novoVip.getSobreNome());
        dados.putBoolean("pessoaFisica",novoVip.isPessoaFisica());
        dados.apply();

    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PRE_APP, MODE_PRIVATE);

    }


}