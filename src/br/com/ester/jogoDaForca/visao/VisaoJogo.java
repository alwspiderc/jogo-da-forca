package br.com.ester.jogoDaForca.visao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.ester.jogoDaForca.excecao.PerderException;
import br.com.ester.jogoDaForca.excecao.SairException;
import br.com.ester.jogoDaForca.modelo.Jogo;

public class VisaoJogo {

	private List<String> espacos = new ArrayList<>();
	private int venceu;
	private Jogo jogo;
	private Scanner entrada = new Scanner(System.in);
	private String letra;
	
	public VisaoJogo(Jogo jogo) {
		this.jogo = jogo;
		cicloJogo();
	}

	
	private void executarJogo(){
		try{
			boolean continuar = true;
			while(continuar) {
				System.out.println("Outra partida? (S/n)");
				String resposta = entrada.next();
				if("n".equalsIgnoreCase(resposta)) {
					continuar = false;
					break;
				}
				
				if("s".equalsIgnoreCase(resposta)) {
					reiniciar();
					cicloJogo();
				}
				
				console("Por favor, digite uma opção válida!\n");
			}
		}catch (SairException e) {
			System.out.println("Tchau!!");
		}finally {
			entrada.close();
		}
	}
	
	private void cicloJogo() {
		console("--------- JOGO DA FORCA --------- \n");
		try {
			
			
			for (int i = 0; i < jogo.getProntos(); i++) {
				console(errosJogo());
				if(jogo.getErros() < 6) {
					console("Digite uma Letra: ");
					letra = entrada.nextLine();
					tracosPalavra();
				}
				
				if(jogo.getErros() == 6) {
					console("Você Perceu Venceu!");
					executarJogo();
				}
				
				if(venceu == jogo.getPalavra().length()) {
					console("Você Venceu!");
					executarJogo();
				}
				
				
				if (!jogo.compararLetras(letra)) {
					jogo.setErros(jogo.getErros() + 1);
					jogo.setLetrasErradas(letra);
				}
				
				
				
				console("Letras erradas: " + jogo.getLetrasErradas());
			}
		} catch (PerderException e) {
			console("Você perdeu o jogo!");
		}
		
	}
	
	
	private void tracosPalavra() {				
		if (espacos.size() == 0) {
			for (int i = 0; i < jogo.getPalavra().length(); i++) {
				espacos.add("_ ");
			}
		}
	colocarPalavraAcertadaNoLugar(espacos);	
	console(espacos);
	}
	
	private List<String> colocarPalavraAcertadaNoLugar(List<String> espacos) {
		
		List<String> letrasPalavra = new ArrayList<>();
		for (int i = 0; i < jogo.getPalavra().length(); i++) {
			letrasPalavra.add(i, jogo.getPalavra().substring(i, i + 1));
		}
		
		for (int i = 0; i < letrasPalavra.size(); i++) {
			if (letrasPalavra.get(i).equalsIgnoreCase(letra)) {
				int indice = i;
				for (int j = 0; j < letrasPalavra.size(); j++) {
					if (j == indice) {
						espacos.set(indice, letra);
						venceu++;
					}
				}
			}
		}
		return espacos;
	}
	
	

	public String errosJogo() {
		StringBuilder sb = new StringBuilder();

		if (jogo.getErros() == 0) {
			sb.append("|-----------------------|\n");
			sb.append("|                       \n");
			sb.append("|                       \n");
			sb.append("|                       \n");
			return sb.toString();
		}

		if (jogo.getErros() == 1) {
			sb.append("|----------------------| \n");
			sb.append("|                      O \n");
			sb.append("|                        \n");
			sb.append("|                        \n");
			return sb.toString();
		}

		if (jogo.getErros() == 2) {
			sb.append("|----------------------| \n");
			sb.append("|                      O \n");
			sb.append("|                      | \n");
			sb.append("|                        \n");
			return sb.toString();
		}

		if (jogo.getErros() == 3) {
			sb.append("|----------------------| \n");
			sb.append("|                      O \n");
			sb.append("|                      |\\ \n");
			sb.append("|                        \n");
			return sb.toString();
		}

		if (jogo.getErros() == 4) {
			sb.append("|----------------------| \n");
			sb.append("|                      O \n");
			sb.append("|                     /|\\ \n");
			sb.append("|                        \n");
			return sb.toString();
		}

		if (jogo.getErros() == 5) {
			sb.append("|----------------------| \n");
			sb.append("|                      O \n");
			sb.append("|                     /|\\ \n");
			sb.append("|                       \\ \n");
			return sb.toString();
		}

		if (jogo.getErros() == 6) {
			sb.append("|----------------------| \n");
			sb.append("|                      O \n");
			sb.append("|                     /|\\ \n");
			sb.append("|                     / \\ \n");
			return sb.toString();
		}
		sb.append("\n");
		
		return null;

	}

	private void console(String texto){
		System.out.println(texto);
	}
	
//	private void console(VisaoJogo erro){
//		System.out.println(erro);
//	}
	
	private void console(List<String> tracos){
		for (String es : tracos) {
			console(es);
		}
	}
	
	private void reiniciar() {
		espacos = new ArrayList<>();
		jogo.setPalavra();
		jogo.setErros(0);
		
	}
}
