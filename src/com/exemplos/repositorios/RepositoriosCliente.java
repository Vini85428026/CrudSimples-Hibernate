package com.exemplos.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplos.entidade.Cliente;

public class RepositoriosCliente {
	
	//Gerencia as conexões com o BD
	EntityManagerFactory emf;
	//Faz todas as transações
	EntityManager em;
	
	public RepositoriosCliente(){
		emf = Persistence.createEntityManagerFactory("vinic"); //Trazer as configurações da persistence.xml
		em = emf.createEntityManager();
	}
	
	//Class Cliente
	public Cliente obterId(int id){
		em.getTransaction().begin();
		Cliente clt = em.find(Cliente.class, id); //Pega a classe que deseja e o parâmetro
		em.getTransaction().commit();
		emf.close();
		return clt;
	}
	
	public void salvar(Cliente clt){
		em.getTransaction().begin(); //Abri a conexão com o BD
		em.merge(clt); //Tanto cria como atualiza
		em.getTransaction().commit();//executar BD
		emf.close(); //fechar conexão
	}
	
	public void deletar(Cliente clt){
		em.getTransaction().begin();
		em.remove(clt);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listaTodos(){
		em.getTransaction().begin();
		Query consultas = em.createQuery("select cliente from Cliente cliente");
		List<Cliente> clientes = consultas.getResultList();
		em.getTransaction().commit();
		emf.close();
		return clientes;
	}

}
