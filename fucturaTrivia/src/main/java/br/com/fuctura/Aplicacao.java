package br.com.fuctura;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.dao.JogadorDAO;
import br.com.fuctura.entidade.Jogador;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {
		
		Driver driver = new org.postgresql.Driver();
		DriverManager.registerDriver(driver);
		Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fuctura","fuctura", "123");
	
		JogadorDAO dao = new JogadorDAO();
		
		Jogador j1 = new Jogador();
		j1.setNome("pedro");
		j1.setCodigo(52);
		j1.setIdade(27);

		Jogador j2 = new Jogador();
		j2.setNome("joao");
		j2.setCodigo(53);
		j2.setIdade(74);
		
		dao.inserir(conexao, j1);
		dao.inserir(conexao, j2);		
		
		List<Jogador> jogadores = dao.consultarTodos(conexao);	
		
		for(Jogador ref : jogadores) {
			System.out.println("Código: " + ref.getCodigo());
			System.out.println("Nome: " + ref.getNome());
		}
		
	}
	
	
	//metodo q consulta os dados
	
}
