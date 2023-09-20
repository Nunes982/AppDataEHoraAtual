package app.daaziv2.apptextov2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroUsuarioActivity extends AppCompatActivity {

    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iMenuPrincipal = new Intent(CadastroUsuarioActivity.this, MainActivity.class);
                startActivity(iMenuPrincipal);

            }
        });

    }
}