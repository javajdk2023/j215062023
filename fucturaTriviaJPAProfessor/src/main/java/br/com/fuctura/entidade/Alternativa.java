package br.com.fuctura.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Alternativa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String descricao;
	private boolean isVerdadeira;
}
