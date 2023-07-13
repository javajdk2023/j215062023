package br.com.fuctura.entidade;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Partida {
	@Id
	private Long codigo;
	
	private LocalDateTime horaPartida;
}
