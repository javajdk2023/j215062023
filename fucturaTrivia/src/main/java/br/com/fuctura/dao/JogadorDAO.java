package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Jogador;

//inserir
//consultar
public class JogadorDAO {

	public void inserir(Connection conexao, Jogador jogador) throws SQLException {
		String sql = "insert into jogador values ( ?, ?, ? )";
		PreparedStatement pstm = conexao.prepareStatement(sql);//analogia 
		pstm.setString(2, jogador.getNome());
		pstm.setInt(1, jogador.getCodigo());
		pstm.setInt(3, jogador.getIdade());
		
		pstm.execute();
	}
	
	
	public List<Jogador> consultarTodos(Connection conexao) throws SQLException{

		String sqlConsulta = " select * from jogador "; 
		PreparedStatement pstmConsulta = conexao.prepareStatement(sqlConsulta);
		ResultSet rs = pstmConsulta.executeQuery();

		List<Jogador> jogadores = new ArrayList<>();
		
		while( rs.next() ) {
			//cursor = 2
			int codigo = rs.getInt(1);
			String nome = rs.getString(2);
			 //System.out.println("Row: " + rs.getRow());
			Jogador j = new Jogador();
			j.setCodigo(codigo);
			j.setNome(nome);
			
			jogadores.add(j);
		}

		return jogadores;
	}
	
}
