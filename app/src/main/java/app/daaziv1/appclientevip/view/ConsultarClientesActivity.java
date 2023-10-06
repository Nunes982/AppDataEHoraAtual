package app.daaziv1.appclientevip.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.daaziv1.appclientevip.R;
import app.daaziv1.appclientevip.api.ClienteAdapter;
import app.daaziv1.appclientevip.model.Cliente;

public class ConsultarClientesActivity extends AppCompatActivity {


    List<Cliente> clientes;
    ClienteAdapter adapter;

    Cliente obj;

    RecyclerView rvClienteVip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_clientes);

        rvClienteVip = findViewById(R.id.rvClientesVip);

        clientes = new ArrayList<>();

        for (int i = 0; i < 50; i++) {

           obj = new Cliente();

           obj.setPrimeiroNome("Cliente "+i);
           obj.setPessoaFisica(i % 2==0);

           clientes.add(obj);

        }

        adapter = new ClienteAdapter(clientes, getApplicationContext());

        rvClienteVip.setAdapter(adapter);

        rvClienteVip.setLayoutManager(new LinearLayoutManager(this));

    }

}
