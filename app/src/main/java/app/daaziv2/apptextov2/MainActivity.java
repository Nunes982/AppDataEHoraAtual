package app.daaziv2.apptextov2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import app.daaziv2.apptextov2.api.AppUtil;

public class MainActivity extends AppCompatActivity {

    // Nome da Classe - declara um Objeto
    TextView txtTitulo;
    TextView txtDataAtual;
    TextView txtHoraAtual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = findViewById(R.id.txtTitulo);
        txtDataAtual = findViewById(R.id.txtDataAtual);
        txtHoraAtual = findViewById(R.id.txtHoraAtual);

        txtTitulo.setText("Curso Android");
        txtTitulo.setTextColor(getResources().getColor(R.color.colorTextView));

        txtDataAtual.setText(AppUtil.getDataAtual());
        txtHoraAtual.setText(AppUtil.getHoraAtual());


    }
}