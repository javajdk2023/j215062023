package br.com.fuctura;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fuctura.entidade.Alternativa;
import br.com.fuctura.entidade.Jogador;
import br.com.fuctura.entidade.Questao;
import br.com.fuctura.repository.JogadorRepositoryImpl;
import br.com.fuctura.repository.QuestaoRepositoryImpl;

public class AplicacaoRepository {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU"); // DEVE SER IGUAL AO DO XML
		var em1 = emf.createEntityManager();
		
		
		var j1 = new Jogador();
		j1.setNome("Lucas");

		//instanciar 1 repositorio e invocar o metodo save
		var repo = new JogadorRepositoryImpl(em1);
		repo.save(j1);
		
		em1.detach(j1);
		
		j1 = em1.find(Jogador.class, j1.getCodigo());
		
		var resultadoConsulta = repo.findAll();
		
		for (Jogador jogador : resultadoConsulta) {
			System.out.println(jogador.toString());
		}
		
		repo.delete(j1);
		
		var q1 = new Questao();
		q1.setEnunciado("Qual das seguintes palavras eh reservada");
		q1.setDhCadastro(LocalDateTime.now());
		
		var alt1  = new Alternativa();
		alt1.setDescricao("void");
		alt1.setVerdadeira(true);
		
		var alt2  = new Alternativa();
		alt2.setDescricao("codigo");
		
		var listaDeAlternativas = new ArrayList<Alternativa>();
		listaDeAlternativas.add(alt1);
		listaDeAlternativas.add(alt2);
		
		q1.setAlternativas(listaDeAlternativas);
			
		var questaoRepo = new QuestaoRepositoryImpl(em1);
		questaoRepo.save(q1);

		em1.detach(q1);
		
		var resultadoQuestao = questaoRepo.findAll();
		
		//lazy x eager
		for (Questao questao : resultadoQuestao) {
			//System.out.println(questao);
		}
		
	}

}
