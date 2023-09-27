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

import app.daaziv1.appclientevip.R;
import app.daaziv1.appclientevip.api.AppUtil;
import app.daaziv1.appclientevip.model.Cliente;
import app.daaziv1.appclientevip.model.ClientePJ;

public class ClientePessoaJuridicaActivity extends AppCompatActivity {

    Cliente novoVip;
    ClientePJ novoClientePJ;

    private SharedPreferences preferences;

    EditText editCNPJ, editRazaoSocial, editDataAbertura;
    CheckBox ckSimpleNacional, ckMEI;
    Button btnSalvarContinuar, btnVoltarPessoaJuridica, btnCancelarPessoaJuridica;

    boolean isFormularioOk, isSimplesNacional, isMEI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_pessoa_juridica);

        initFormulario();

        btnSalvarContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isFormularioOk == validarFormulario()){

                    novoClientePJ.setCnpj(editCNPJ.getText().toString());
                    novoClientePJ.setRazaoSocial(editRazaoSocial.getText().toString());
                    novoClientePJ.setDataAbertura(editDataAbertura.getText().toString());
                    novoClientePJ.setSimplesNacional(isSimplesNacional);
                    novoClientePJ.setMei(isMEI);

                    salvarSharedPreferences();

                    Intent intent = new Intent(ClientePessoaJuridicaActivity.this, LoginActivity.class);
                    startActivity(intent);

                }

            }
        });

        btnVoltarPessoaJuridica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ClientePessoaJuridicaActivity.this, ClienteVipActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    public void simplesNacional(View view){

        isSimplesNacional = ckSimpleNacional.isChecked();

    }

    public void mei(View view){

        isMEI = ckMEI.isChecked();

    }

    private void initFormulario() {

        editCNPJ = findViewById(R.id.editCNPJ);
        editRazaoSocial = findViewById(R.id.editRazaoSocial);
        editDataAbertura = findViewById(R.id.editDataAbertura);
        ckSimpleNacional = findViewById(R.id.ckSimplesNaciona);
        ckMEI = findViewById(R.id.ckMEI);
        btnSalvarContinuar = findViewById(R.id.btnSalvarContinuar);
        btnVoltarPessoaJuridica = findViewById(R.id.btnVoltarPessoaJuridica);
        btnCancelarPessoaJuridica = findViewById(R.id.btnCancelarPessoaJuridica);

        isFormularioOk = false;

        novoClientePJ = new ClientePJ();
        novoVip = new Cliente();

        restaurarSharedPreferences();

    }

    public boolean validarFormulario(){

        boolean retorno = true;

        if (TextUtils.isEmpty(editCNPJ.getText().toString())){
            editCNPJ.setError("*");
            editCNPJ.requestFocus();
            retorno = false;
        }

        if (TextUtils.isEmpty(editRazaoSocial.getText().toString())){
            editRazaoSocial.setError("*");
            editRazaoSocial.requestFocus();
            retorno = false;
        }

        if (TextUtils.isEmpty(editDataAbertura.getText().toString())){
            editDataAbertura.setError("*");
            editDataAbertura.requestFocus();
            retorno = false;
        }

        return retorno;

    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PRE_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        // Adicionando dados no SharedPreferences


    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PRE_APP, MODE_PRIVATE);

    }

}