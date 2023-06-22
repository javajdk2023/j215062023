package br.com.fuctura;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {
		
		Driver driver = new org.postgresql.Driver();
		DriverManager.registerDriver(driver);

		
		Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fuctura","fuctura", "123");
	
		conexao.setAutoCommit(false);
		
		//aspas simples -> varchar
		String sql = "insert into jogador values ( ?, ? )";
												 //1 , 2	
		
		System.out.println("conectado com sucesso!");
		
		
		PreparedStatement pstm = conexao.prepareStatement(sql);//analogia 
		
		pstm.setString(2, "Love");
		pstm.setInt(1, 2000);
		
		pstm.execute();
		
		
		conexao.commit();
		conexao.rollback();
		
		
		
	}

}
