package br.com.ester.jogoDaForca;

import java.util.Scanner;

public class PrincipalTeste {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String nome = "oi";
		String[] espacos = new String[nome.length()];
		
		for (int i = 0; i < nome.length(); i++) {
			espacos[i] = "_ ";
		}
		
		for (String es : espacos) {
			System.out.print(es);
		}
		
		String[] letrasPalavra = new String[nome.length()];
		for (int i = 0; i < nome.length(); i++) {
			letrasPalavra[i] = nome.substring(i, i + 1);
			System.out.print(letrasPalavra[i]);
		}
		
		System.out.println("Digite uma letra: ");
		String letraDigitada = entrada.nextLine();
		
		for (int i = 0; i < letrasPalavra.length; i++) {
			if (letrasPalavra[i].equalsIgnoreCase(letraDigitada)) {
				int indice = i;
				for (int j = 0; j < letrasPalavra.length; j++) {
					if (j == indice) {
						espacos[indice] = letraDigitada;
					}
				}
			}
			
			System.out.print(espacos[i]);
		}
		
		entrada.close();
	}
	
}
