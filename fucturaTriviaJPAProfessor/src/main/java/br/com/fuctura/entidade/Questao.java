package br.com.fuctura.entidade;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Questao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String enunciado;
	private double valor;
	private LocalDateTime dhCadastro;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	List<Alternativa> alternativas;
}
