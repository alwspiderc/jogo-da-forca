package br.com.ester.jogoDaForca;

import br.com.ester.jogoDaForca.modelo.Jogo;
import br.com.ester.jogoDaForca.visao.VisaoJogo;

public class Aplicacao {

	public static void main(String[] args) {
		
		Jogo jogo = new Jogo();
		new VisaoJogo(jogo);
	}
}
