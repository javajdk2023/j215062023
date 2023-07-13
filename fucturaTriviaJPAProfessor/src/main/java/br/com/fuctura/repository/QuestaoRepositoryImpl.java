package br.com.fuctura.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fuctura.entidade.Questao;

public class QuestaoRepositoryImpl implements QuestaoRepository {
	
	private EntityManager em;
	
	//construtor
	public QuestaoRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void save(Questao questao) {
		em.persist(questao);
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

	@Override
	public List<Questao> findAll() {
		TypedQuery<Questao> q = em.createQuery("select q from Questao q", 
				Questao.class);
		
		var resultadoConsulta = q.getResultList();
		
		return resultadoConsulta;
	}

}
