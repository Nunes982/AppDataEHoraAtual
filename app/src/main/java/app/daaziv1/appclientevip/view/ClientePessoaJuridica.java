package app.daaziv1.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import app.daaziv1.appclientevip.R;

public class ClientePessoaJuridica extends AppCompatActivity {

    EditText editCNPJ, editRazaoSocial, editDataAbertura;
    CheckBox ckSimpleNacional, ckMEI;
    Button btnSalvarContinuar, btnVoltarPessoaJuridica, btnCancelarPessoaJuridica;

    boolean isFormularioOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_pessoa_juridica);

        initFormulario();

        btnVoltarPessoaJuridica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ClientePessoaJuridica.this, ClienteVip.class);
                startActivity(intent);
                finish();

            }
        });

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

    }
}