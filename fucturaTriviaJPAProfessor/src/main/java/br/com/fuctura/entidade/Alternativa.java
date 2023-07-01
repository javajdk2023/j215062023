package br.com.fuctura.entidade;

public class Alternativa {
	private int codigo;
	private String descricao;
	private boolean isVerdadeira;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isVerdadeira() {
		return isVerdadeira;
	}

	public void setVerdadeira(boolean isVerdadeira) {
		this.isVerdadeira = isVerdadeira;
	}
}
