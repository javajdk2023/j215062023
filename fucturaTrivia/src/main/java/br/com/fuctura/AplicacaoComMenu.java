package br.com.fuctura;

import java.util.Scanner;

public class AplicacaoComMenu{

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int opçao, opcPerg = 100;
		String pergunta = null, resposta = null;

		System.out.println("+#####################################+");
		System.out.println("+#                                   #+");
		System.out.println("+#    BEM VINDO AO TRIVIA FUCUTURA   #+");
		System.out.println("+#                                   #+");
		System.out.println("+# 1 - PARA ADICIONAR UMA PERGUNTA   #+");		
		System.out.println("+# 2 - PARA ALTERAR UMA PERGUNTA     #+");
		System.out.println("+# 3 - PARA DELETAR UMA PERGUNTA     #+");
		System.out.println("+# 4 - PARA DLETAR UMA RESPOSTA      #+");
		System.out.println("+# 5 - PARA ALTERAR UMA RESPOSTA     #+");
		System.out.println("+#                                   #+");
		System.out.println("+#####################################+");

		opçao = scan.nextInt();
		scan.nextLine();

		switch (opçao) {

		case 1:

			System.out.println("1- Inserir pergunta / 0- Encerrar");
			opcPerg = scan.nextInt();
			scan.nextLine();
			while (opcPerg != 0) {

				System.out.println("Digite a Pergunta: ");
				pergunta = scan.nextLine();
				
				

				System.out.println("Digite a resposta 1- verdadeiro ou 0- Falso ");
				resposta = scan.nextLine();

				System.out.println("1- Inserir pergunta / 0- Encerrar");
				opcPerg = scan.nextInt();

			}

			break;

		}

		System.out.printf(" a pergunta digitada foi :%s e a resposta correta é: %s", pergunta, resposta);

	}

}