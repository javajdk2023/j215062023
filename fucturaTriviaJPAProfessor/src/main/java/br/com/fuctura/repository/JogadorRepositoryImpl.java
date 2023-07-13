package br.com.fuctura.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fuctura.entidade.Jogador;

public class JogadorRepositoryImpl implements Repository {

	private EntityManager em;
	
	//construtor
	public JogadorRepositoryImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(Jogador jogador) {
		em.persist(jogador);
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

	@Override
	public void delete(Jogador jogador) {
		em.remove(jogador);
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

	@Override
	public List<Jogador> findAll() {
		TypedQuery<Jogador> q = em.createQuery("select j from Jogador j", 
				Jogador.class);
		
		var resultadoConsulta = q.getResultList();
		
		return resultadoConsulta;
	}

	@Override
	public List<Jogador> findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jogador> findBySobrenome(String sobrenome) {
		// TODO Auto-generated method stub
		return null;
	}

}
