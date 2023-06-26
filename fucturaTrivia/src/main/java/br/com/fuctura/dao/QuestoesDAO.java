package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Questao;

public class QuestoesDAO {
	public List<Questao> consultarTodos(Connection conexao) throws SQLException {
		String sqlConsulta = " select * from questao ";
		
		PreparedStatement pstmConsulta = conexao.prepareStatement(sqlConsulta);
		ResultSet rs = pstmConsulta.executeQuery();

		List<Questao> questoes = new ArrayList<>();

		while (rs.next()) {
			// cursor = 2
			int codigo = rs.getInt(1);
			String enunciado = rs.getString(2);
			double valor = rs.getDouble(3);
			// System.out.println("Row: " + rs.getRow());
			Questao q = new Questao();
			q.setCodigo(codigo);
			q.setEnunciado(enunciado);
			q.setValor(valor);
			q.setAlternativas(new ArrayList<>());
			
			questoes.add(q);
		}

		return questoes;
	}
}
