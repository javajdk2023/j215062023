package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Alternativa;

public class AlternativaDAO {
	public List<Alternativa> consultarPorCodigoDaQuestao(Connection conexao, int codigoQuestao) throws SQLException {
		String sqlConsulta = " select * from alternativa where codigoQuestao = ?";
		
		PreparedStatement pstmConsulta = conexao.prepareStatement(sqlConsulta);
		pstmConsulta.setInt(1, codigoQuestao);
		
		ResultSet rs = pstmConsulta.executeQuery();

		List<Alternativa> alternativas = new ArrayList<>();

		while (rs.next()) {
			// cursor = 2
			int codigo = rs.getInt(1);
			String descricao = rs.getString(2);
			boolean isVerdadeira = rs.getBoolean(3);
			// System.out.println("Row: " + rs.getRow());
			Alternativa alternativa = new Alternativa();
			alternativa.setCodigo(codigo);
			alternativa.setDescricao(descricao);
			alternativa.setVerdadeira(isVerdadeira);
			
			alternativas.add(alternativa);
		}

		return alternativas;
	}
}
