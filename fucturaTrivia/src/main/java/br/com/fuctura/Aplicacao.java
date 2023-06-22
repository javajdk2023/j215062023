package br.com.fuctura;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Jogador;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {
		
		Driver driver = new org.postgresql.Driver();
		DriverManager.registerDriver(driver);

		
		Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fuctura","fuctura", "123");
	
		
		//aspas simples -> varchar
		String sql = "insert into jogador values ( ?, ? )";
												 //1 , 2	
		
		System.out.println("conectado com sucesso!");
		
		
		PreparedStatement pstm = conexao.prepareStatement(sql);//analogia 
		
		pstm.setString(2, "Love");
		pstm.setInt(1, 2000);
		
		pstm.execute();
		
		
		String sqlConsulta = " select * from jogador "; 
		PreparedStatement pstmConsulta = conexao.prepareStatement(sqlConsulta);
		ResultSet rs = pstmConsulta.executeQuery();
		
		//rs.next() -> true, cursor = 0

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
		
		for(Jogador ref : jogadores) {
			System.out.println("Código: " + ref.getCodigo());
			System.out.println("Nome: " + ref.getNome());
		}
		
	}
	
	
	//metodo q consulta os dados
	
}
