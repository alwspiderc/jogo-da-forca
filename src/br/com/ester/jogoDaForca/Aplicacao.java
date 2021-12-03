package br.com.ester.jogoDaForca;

import java.util.Scanner;

import br.com.ester.jogoDaForca.modelo.Jogo;
import br.com.ester.jogoDaForca.visao.VisaoJogo;

public class Aplicacao {

	public static void main(String[] args) {
		
		Jogo jogo = new Jogo();
		VisaoJogo visao = new VisaoJogo(jogo);
	}
}
