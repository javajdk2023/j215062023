package br.com.fuctura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fuctura.entidade.Jogador;

public class Aplicacao {

	public static void main(String[] args) throws IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU"); // DEVE SER IGUAL AO DO XML

		// ApplicationContext context = new ClassPathXmlApplicationContext(new String[]
		// {"spring.xml"});
		// var em1 = (EntityManager) context.getBean("myEntityManager");

		var continuar = true;

		var em1 = emf.createEntityManager();
		var em2 = emf.createEntityManager();

		var jogador1 = new Jogador();
		jogador1.setNome("Lucas");

		var jogador2 = new Jogador();
		jogador2.setNome("Silva");

		var jogador3 = new Jogador();
		jogador3.setNome("Carlos");

		em1.persist(jogador1); // create - vai preencher o codigo
		em1.persist(jogador2);

		jogador1.setNome("Dimas");
		
		em1.getTransaction().begin();
		em1.getTransaction().commit(); //

		em1.detach(jogador1);

		var resultadoEM1 = em1.find(Jogador.class, jogador1.getCodigo());
		var ref1 = em1.getReference(Jogador.class, jogador1.getCodigo());
		var contem1 = em1.contains(jogador1);
		var contemEM1 = em1.contains(resultadoEM1);

		var resultadoEM2 = em2.find(Jogador.class, jogador1.getCodigo());
		var ref2 = em2.getReference(Jogador.class, jogador1.getCodigo());
		var contem2 = em2.contains(jogador1);
		var contemEM2 = em2.contains(resultadoEM2);

		System.out.println("Contem1:" + contem1); // false
		System.out.println("Contem2:" + contem2); // false
		System.out.println("ContemEM1:" + contemEM1); // true
		System.out.println("ContemEM2:" + contemEM2); // true

		var resultado = em1.find(Jogador.class, jogador1.getCodigo());
		
		//em1.detach(resultado);
		
		em1.remove(resultado);
		
		em1.getTransaction().begin();
		em1.getTransaction().commit();
		
		
		//consultar
		var query = em1.createQuery("select j from Jogador j");
		
		var resultadoConsulta = query.getResultList();
		
		//como imprimir o resultado?
		
	}

}
