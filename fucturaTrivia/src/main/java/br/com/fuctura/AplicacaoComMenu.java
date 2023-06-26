package br.com.fuctura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.fuctura.dao.AlternativaDAO;
import br.com.fuctura.dao.JogadorDAO;
import br.com.fuctura.dao.QuestoesDAO;
import br.com.fuctura.entidade.Jogador;
import br.com.fuctura.entidade.Partida;
import br.com.fuctura.entidade.Questao;

public class AplicacaoComMenu {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {

		Driver driver = new org.postgresql.Driver();
		DriverManager.registerDriver(driver);
		//Configurar com os dados da sua conexao
		var usuario = "fuctura";
		var senha = "123";
		
		Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fuctura", usuario, senha);
		
		var questoesDAO = new QuestoesDAO();
		var alternativaDAO = new AlternativaDAO();
		var jogadorDAO = new JogadorDAO();
		
		var is = new InputStreamReader(System.in);
		var brf = new BufferedReader(is);
		var opcao = 0;

		do {

			System.out.println("+#####################################+");
			System.out.println("+#                                   #+");
			System.out.println("+#    BEM VINDO AO TRIVIA FUCUTURA   #+");
			System.out.println("+#                                   #+");
			System.out.println("+# 1 - Jogar   						 #+");
			System.out.println("+# 5 - Sair     					 #+");
			System.out.println("+#                                   #+");
			System.out.println("+#####################################+");
				
			System.out.println("Digite: ");
			
			opcao = Integer.valueOf(brf.readLine());

			//Enum?
			if(opcao == 1) {
				System.out.println("Digite seu nome: ");
				var nome = brf.readLine();
				
				var jogador = new Jogador();
				jogador.setNome(nome);
				
				jogadorDAO.inserir(conexao, jogador);
				
				//você deve implementar esssa lógica
				var partida = new Partida();
				
				System.out.println("Carregando banco de dados de questões:");
				
				var questoes = questoesDAO.consultarTodos(conexao);
				
				int contadorPontos = 0;
				
				for (Questao questao : questoes) {
					System.out.println("Enunciado: " + questao.getEnunciado());
					System.out.println("Valor: " + questao.getValor());
					
					System.out.println("Alternativas: ");
					
					var alternativas = alternativaDAO.consultarPorCodigoDaQuestao(conexao, questao.getCodigo());
					
					var codAlternativaCorreta = 0;
					
					for (int i = 0; i < alternativas.size(); i++) {
						System.out.println(i + " - " + alternativas.get(i).getDescricao());
						
						if(alternativas.get(i).isVerdadeira()) {
							codAlternativaCorreta = i;
						}
					}
					
					System.out.println("Selecione 1 das alternativas: ");
					int alternativaSelecionada = Integer.valueOf(brf.readLine());
					
					if(alternativaSelecionada == codAlternativaCorreta) {
						contadorPontos++;
					}
					
				}
				
				System.out.println(jogador.getNome() + ", parabéns! Sua pontuação foi: " + contadorPontos );
			}
			
		} while (opcao != 5);
	}
}