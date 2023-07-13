package br.com.fuctura.repository;

import java.util.List;

import br.com.fuctura.entidade.Jogador;

//crud
public interface Repository {
	void save(Jogador jogador);
	void delete(Jogador jogador);
	//update
	List<Jogador> findAll();
	List<Jogador> findByNome(String nome);
	List<Jogador> findBySobrenome(String sobrenome);
}
