package br.com.fuctura.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_JOGADOR")
@Getter
@Setter
public class Jogador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	private int idade;
	
	@Column(name = "nm_jog")
	private String nome;
	
	private String sobreNome;
	
	@ElementCollection
	private List<Integer> pontuacoes; 

	@Override
	public String toString() {
		return "Jogador [codigo=" + codigo + ", idade=" + idade + ", nome=" + nome + "]";
	}
	
}
