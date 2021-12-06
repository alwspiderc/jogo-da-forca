package br.com.ester.jogoDaForca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalTeste {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String nome = "oi";
		List<String> espacos = new ArrayList<>();
		
		for (int i = 0; i < nome.length(); i++) {
			espacos.add("_ ");
		}
		
		for (String es : espacos) {
			System.out.print(es);
		}
		
		List<String> letrasPalavra = new ArrayList<>();
		for (int i = 0; i < nome.length(); i++) {
			letrasPalavra.add(i, nome.substring(i, i + 1));
			System.out.print(letrasPalavra.get(i));
		}
		
		System.out.println("Digite uma letra: ");
		String letraDigitada = entrada.nextLine();
		
		for (int i = 0; i < letrasPalavra.size(); i++) {
			if (letrasPalavra.get(i).equalsIgnoreCase(letraDigitada)) {
				int indice = i;
				for (int j = 0; j < letrasPalavra.size(); j++) {
					if (j == indice) {
						espacos.add(indice, letraDigitada);
					}
				}
			}
			
			System.out.print(espacos.get(i));
		}
		
		entrada.close();
	}
	
}
