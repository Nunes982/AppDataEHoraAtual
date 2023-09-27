package app.daaziv1.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import app.daaziv1.appclientevip.R;

public class ClientePessoaFisica extends AppCompatActivity {

    EditText editCPF, editNomeCompleto;
    Button btnSalvarContinuar, btnVoltarPessoaFisica, btnCancelar;

    boolean isFormularioOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_pessoa_fisica);

        initFormulario();

        btnVoltarPessoaFisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ClientePessoaFisica.this, ClienteVip.class);
                startActivity(intent);
                finish();

            }
        });
    }

    private void initFormulario() {

        editCPF = findViewById(R.id.editCPF);
        editNomeCompleto = findViewById(R.id.editNomeCompleto);
        btnSalvarContinuar = findViewById(R.id.btnSalvarContinuar);
        btnVoltarPessoaFisica = findViewById(R.id.btnVoltarPessoaFisica);
        btnCancelar = findViewById(R.id.btnCancelarPessoaFisica);

        isFormularioOk = false;

    }
}