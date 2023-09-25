package app.daaziv1.appclientevip.controler;

import java.util.Objects;

import app.daaziv1.appclientevip.model.Cliente;

public class ClienteController {

    public static boolean validarDadosDoCliente(Cliente cliente, String email, String senha){

        boolean retorno = (cliente.getEmail().equals(email)) && (cliente.getSenha().equals(senha));

        return  retorno;
    }

    public static Cliente getClienteFake(){

        Cliente fake = new Cliente();
        fake.setPrimeiroNome("Marco");
        fake.setSobreNome("Maddo");
        fake.setEmail("madoo@teste.com");
        fake.setSenha("12345");
        fake.setPessoaFisica(true);

        return fake;
    }

}
