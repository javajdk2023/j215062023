package br.com.fuctura.dto;

//@Getter
//@Setter
//@AllArgsConstructor
public class JogadorDTO {
	private Integer idade;
	private String nome;

	public JogadorDTO(Integer idade, String nome) {
		this.idade = idade;
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
