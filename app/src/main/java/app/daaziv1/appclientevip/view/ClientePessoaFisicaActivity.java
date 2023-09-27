package app.daaziv1.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.daaziv1.appclientevip.R;
import app.daaziv1.appclientevip.api.AppUtil;
import app.daaziv1.appclientevip.model.Cliente;
import app.daaziv1.appclientevip.model.ClientePF;

public class ClientePessoaFisicaActivity extends AppCompatActivity {

    // Declarar Objetos
    Cliente novoVip;
    ClientePF novoClientePF;

    private SharedPreferences preferences;

    EditText editCPF, editNomeCompleto;
    Button btnSalvarContinuarPF, btnVoltarPessoaFisica, btnCancelar;

    boolean isFormularioOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_pessoa_fisica);

        initFormulario();

        btnSalvarContinuarPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isFormularioOk = validarFormulario()){

                    novoClientePF.setCpf(editCPF.getText().toString());
                    novoClientePF.setNomeCompleto(editNomeCompleto.getText().toString());

                    salvarSharedPreferences();

                    Intent intent = new Intent(ClientePessoaFisicaActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();

                }

            }
        });

        btnVoltarPessoaFisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ClientePessoaFisicaActivity.this, ClienteVipActivity.class);
                startActivity(intent);
                finish();

            }
        });

       btnCancelar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               //TODO: implementar
               Toast.makeText(getApplicationContext(), "Apertado botão Cancelar", Toast.LENGTH_LONG).show();

           }
       });
    }

    private void initFormulario() {

        editCPF = findViewById(R.id.editCPF);
        editNomeCompleto = findViewById(R.id.editNomeCompleto);
        btnSalvarContinuarPF = findViewById(R.id.btnSalvarContinuarPF);
        btnVoltarPessoaFisica = findViewById(R.id.btnVoltarPessoaFisica);
        btnCancelar = findViewById(R.id.btnCancelarPessoaFisica);

        isFormularioOk = false;

        novoClientePF = new ClientePF();
        novoVip = new Cliente();

        restaurarSharedPreferences();

    }

    public boolean validarFormulario(){

        boolean retorno = true;

        if (TextUtils.isEmpty(editCPF.getText().toString())){
            editCPF.setError("*");
            editCPF.requestFocus();
            retorno = false;
        }

        if (TextUtils.isEmpty(editNomeCompleto.getText().toString())){
            editNomeCompleto.setError("*");
            editNomeCompleto.requestFocus();
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