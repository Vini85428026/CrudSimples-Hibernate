package com.exemplos.teste;

import java.util.List;

import com.exemplos.entidade.Cliente;
import com.exemplos.repositorios.RepositoriosCliente;

public class Teste {

	public static void main(String[] args) {
		RepositoriosCliente rc = new RepositoriosCliente();
		//Cliente ct = new Cliente();
		
		//ct.setNome("Lucas Moura");
		//ct.setIdade(32);
		
		//rc.salvar(ct);
		
		
		/*List<Cliente> clientes = rc.listaTodos();
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
			System.out.println(cliente.getIdade());
		}*/
		
		Cliente clt = rc.obterId(3);
		//clt.setNome("Victoria Maria");
		//rc.salvar(clt);
		//System.out.println(clt.getNome());
		
		rc.deletar(clt);

	}

}
