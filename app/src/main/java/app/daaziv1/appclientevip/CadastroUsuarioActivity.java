package app.daaziv1.appclientevip;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroUsuarioActivity extends AppCompatActivity {

    Button btnCadastrar;
    EditText editNome;
    EditText editEmail;
    EditText editSenhaA;
    EditText editSenhaB;
    CheckBox ckTermo;

    boolean isFormularioOK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        initFormulario();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isFormularioOK = true;

                if (TextUtils.isEmpty(editNome.getText().toString())){
                    editNome.setError("*");
                    editNome.requestFocus();
                    isFormularioOK = false;
                }

                if (TextUtils.isEmpty(editEmail.getText().toString())){
                    editEmail.setError("*");
                    editEmail.requestFocus();
                    isFormularioOK = false;
                }

                if (TextUtils.isEmpty(editSenhaA.getText().toString())){
                    editSenhaA.setError("*");
                    editSenhaA.requestFocus();
                    isFormularioOK = false;
                }

                if (TextUtils.isEmpty(editSenhaB.getText().toString())){
                    editSenhaB.setError("*");
                    editSenhaB.requestFocus();
                    isFormularioOK = false;
                }

                if (!ckTermo.isChecked()){
                    ckTermo.setError("*");
                    ckTermo.requestFocus();
                    isFormularioOK = false;
                }

                if (isFormularioOK) {

                    if (!validarSenha()){

                        editSenhaA.setError("*");
                        editSenhaB.setError("*");
                        editSenhaA.requestFocus();

                    }else {

                        Intent iMenuPrincipal = new Intent(CadastroUsuarioActivity.this, MainActivity.class);
                        startActivity(iMenuPrincipal);

                        Toast.makeText(getApplicationContext(), "Usuário Cadastrado com Sucesso...", Toast.LENGTH_LONG).show();

                    }

                }

            }
        });

    }

    private void initFormulario() {

        btnCadastrar = findViewById(R.id.btnCadastrar);
        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        editSenhaA = findViewById(R.id.editSenhaA);
        editSenhaB = findViewById(R.id.editSenhaB);

        ckTermo = findViewById(R.id.ckTermo);

        isFormularioOK = false;

    }

    public void validarTermo(View view) {

        if (!ckTermo.isChecked()){

            Toast.makeText(getApplicationContext(),
                    "É necessário aceitar os termos de uso para continuar o cadastro...",
                    Toast.LENGTH_LONG).show();

        }

    }

    public boolean validarSenha(){

        boolean retono;

        int senhaA, senhaB;

        senhaA = Integer.parseInt(editSenhaA.getText().toString());
        senhaB = Integer.parseInt(editSenhaB.getText().toString());

        retono = (senhaA == senhaB);

        return retono;
    }
}