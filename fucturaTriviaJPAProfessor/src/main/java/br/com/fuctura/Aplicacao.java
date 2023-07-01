package br.com.fuctura;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Aplicacao {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU"); //DEVE SER IGUAL AO DO XML
		
		
		System.out.println("Conectado com sucesso!");
	}

}
