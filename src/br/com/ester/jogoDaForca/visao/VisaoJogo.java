package br.com.ester.jogoDaForca.visao;

import java.util.Scanner;

import br.com.ester.jogoDaForca.excecao.SairException;
import br.com.ester.jogoDaForca.modelo.Jogo;

public class VisaoJogo {

	Jogo jogo;
	Scanner entrada = new Scanner(System.in);
	String letra;
	
	public VisaoJogo(Jogo jogo) {
		this.jogo = jogo;
		executarJogo();
	}

	
	private void executarJogo(){
		try{
			tracosPalavra();
			for (int i = 0; i < 2; i++) {
				console("Digite uma Letra: ");
				letra = entrada.nextLine();
				
				if (!jogo.compararLetras(letra)) {
					jogo.setErros(4);
					console(errosJogo());
				}
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void tracosPalavra() {
		String[] espacos = new String[jogo.getPalavra().length()];
		
		for (int i = 0; i < jogo.getPalavra().length(); i++) {
			espacos[i] = "_ ";
		}
	console(espacos);
	}
	
	private Lis<String> colocarPalavraAcertadaNoLugar() {
		
		return null;
	}
	
	
	
//	private void ExecutarJogo() {
//		try {
//			boolean continuar = true;
//
//		} catch (SairException e) {
//			System.out.println("Saiu!");
//		} finally {
//			entrada.close();
//		}
//	}
//
//	private void executarJogo() {
//		try {
//			boolean continuar = true;
//			while(continuar){
//				cicloDoJogo();
//				System.out.println("Outra partida? (S/n)");
//				String resposta = entrada.nextLine();
//				if("n".equalsIgnoreCase(resposta)){
//					continuar = false;
//				}else{
//					jogo.();
//				}
//
//		} catch (SairException e) {
//			System.out.println("Tchau!!!");
//		} finally {
//			entrada.close();
//		}
//	}

//	private void cicloDoJogo() {
//		
//	}
//
//	public void iniciarJogo() {
//		for (int i = 0; i < jogo.; i++) {
//			System.out.print("- ");
//		}
//	}

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
	private void console(String[] tracos){
		for (String es : tracos) {
			System.out.print(es);
		}
		System.out.println();
	}
	
}
