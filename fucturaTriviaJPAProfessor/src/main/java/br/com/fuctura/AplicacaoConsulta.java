package br.com.fuctura;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.github.javafaker.Faker;

import br.com.fuctura.entidade.Jogador;

public class AplicacaoConsulta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU"); // DEVE SER IGUAL AO DO XML

		var em1 = emf.createEntityManager();

		
		//inserir 100 jogadora aletorios
		var faker = new Faker();
		
		for(int i = 0; i < 100; i++) {
			
			var jogador = new Jogador();
			
			jogador.setNome(faker.name().firstName());
			//jogador.setSobrenome(faker.name().lastName());
			jogador.setIdade(i);
			
			em1.persist(jogador);
			
		}
		
		em1.getTransaction().begin();
		em1.getTransaction().commit();
		
		//sql - select * from tb_jogador
		Query q1 = em1.createQuery("select j from Jogador j");
		var resultadoConsulta = (List<Jogador>) q1.getResultList(); //cast
		
		for (Jogador jogador : resultadoConsulta) {
			System.out.println(jogador.toString());
		}
		
		TypedQuery<Jogador> q2 = em1
				.createQuery("select j from Jogador j", Jogador.class);
		
		var resultadoConsulta2 = q2.getResultList();
		
		for (Jogador jogador : resultadoConsulta2) {
			System.out.println(jogador.toString());
		}
	
		//select * from tb_jogador => select j from Jogador j
		//select * from tb_jogador where idade > 20
		
		TypedQuery<Jogador> q3 = em1
				.createQuery("select j from Jogador j where j.idade > 20", 
						Jogador.class);

		var resultadoConsulta3 = q3.getResultList();
		
		for (Jogador jogador : resultadoConsulta3) {
			System.out.println(jogador.toString());
		}
		
		//pedir pra o usuario digitar a idade que ele deseja filtrar
		
		System.out.println("Digite a idade que deseja filtrar: ");
		
		var sc = new Scanner(System.in);
		var idadeFiltro = sc.nextInt();
		
		
		//passagem de parametro
		TypedQuery<Jogador> q4 = em1
				.createQuery("select j from Jogador j where j.idade > :idade", 
						Jogador.class);
		
		q4.setParameter("idade", idadeFiltro);
		
		var resultadoConsulta4 = q4.getResultList();
		
		for (Jogador jogador : resultadoConsulta4) {
			System.out.println(jogador.toString());
		}

		
		/* digite string -> buscar todos os usuarios que a primeira
		 * do nome comeca comeca com a letra digitada
		 */
		//select * from tb_jogador where nome like 'd%'
		TypedQuery<Jogador> q5 = em1
				.createQuery("select j from Jogador j"
						+ " where j.nome like :iniciarComD", 
						Jogador.class);
		
		q5.setParameter("iniciarComD", "D%");
		
		var resultadoConsulta5 = q5.getResultList();
		
		for (Jogador jogador : resultadoConsulta5) {
			System.out.println(jogador.toString());
		}
		
		var continuar = true;
		
		//D
		//DA
		//DAR
		
		//StringBuilder
		
		while( continuar ) {
			System.out.println("Digite o nome do usuario que deseja filtrar");
			var nomeFiltro = sc.next();
			
			TypedQuery<Jogador> q6 = em1
					.createQuery("select j from Jogador j"
							+ " where j.nome like :iniciarComD", 
							Jogador.class);
			
			q6.setParameter("iniciarComD", nomeFiltro + "%");
			
			var resultadoConsulta6 = q6.getResultList();
			
			if(resultadoConsulta6.isEmpty()) {
				continuar = false;
			}
			
			for (Jogador jogador : resultadoConsulta6) {
				System.out.println(jogador.toString());
			}
		}
	}
	

}
