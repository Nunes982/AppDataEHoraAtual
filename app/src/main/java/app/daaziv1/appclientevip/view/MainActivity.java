package app.daaziv1.appclientevip.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.daaziv1.appclientevip.R;
import app.daaziv1.appclientevip.api.AppUtil;

public class MainActivity extends AppCompatActivity {

    // Nome da Classe - declara um Objeto
    TextView txtTitulo;
    TextView txtDataAtual;
    TextView txtHoraAtual;

    Button btnCadastro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = findViewById(R.id.txtTitulo);
        txtDataAtual = findViewById(R.id.txtDataAtual);
        txtHoraAtual = findViewById(R.id.txtHoraAtual);
        btnCadastro = findViewById(R.id.btnCadastro);

        txtTitulo.setText("Curso Android");
        txtTitulo.setTextColor(getResources().getColor(R.color.colorTextView));

        txtDataAtual.setText(AppUtil.getDataAtual());
        txtHoraAtual.setText(AppUtil.getHoraAtual());

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iTelaCadastro = new Intent(MainActivity.this, CadastroUsuarioActivity.class);
                startActivity(iTelaCadastro);

            }
        });

    }
}