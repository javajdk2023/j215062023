package br.com.fuctura.repository;

import java.util.List;

import br.com.fuctura.entidade.Questao;

public interface QuestaoRepository {
	void save(Questao questao);
	List<Questao> findAll();
}
