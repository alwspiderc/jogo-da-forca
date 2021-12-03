package br.com.ester.jogoDaForca.modelo;

import java.util.ArrayList;
import java.util.List;

public class Jogo {

	private String palavra;
	private List<String> letrasPalavra = new ArrayList<String>();
	private Palavras palavras = new Palavras();
	private final int totalPontos = 6;
	private int erros;

	public Jogo() {
		this.palavra = palavras.palavraAleatoria();
		separoLetra(palavra);
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra() {
		this.palavra = palavras.palavraAleatoria();
	}

	public List<String> getLetrasPalavra() {
		return letrasPalavra;
	}

	public void setLetrasPalavra(String letrasPalavra) {
		this.letrasPalavra.add(letrasPalavra);
	}

	public int getErros() {
		return erros;
	}

	public void setErros(int erros) {
		this.erros = erros;
	}

	public void separoLetra(String palavra) {
		for (int i = 0; i < palavra.length(); i++) {
			setLetrasPalavra(palavra.substring(i, i + 1));
		}
		System.out.println(getLetrasPalavra());
	}

	public boolean compararLetras(String letra) {
		for (String letraPalavra : letrasPalavra) {
			if (letra.equalsIgnoreCase(letraPalavra)) {
				
				System.out.println("Acertou!");
				return true;
			}

			if (!letra.equalsIgnoreCase(letraPalavra)) {
				
				//setErros(erros + 1);
				return false;
			}
		}
		System.out.println(getErros());
		return false;
	}

	public int getTotalPontos() {
		return totalPontos;
	}
}
