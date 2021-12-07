package br.com.ester.jogoDaForca.visao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.ester.jogoDaForca.excecao.PerderException;
import br.com.ester.jogoDaForca.excecao.SairException;
import br.com.ester.jogoDaForca.modelo.Jogo;

public class VisaoJogo {

	private List<String> espacos = new ArrayList<>();
	private int venceu = 1;
	private Jogo jogo;
	private Scanner entrada = new Scanner(System.in);
	private String letra;

	public VisaoJogo(Jogo jogo) {
		this.jogo = jogo;
		executarJogo();
	}

	private void executarJogo() {

		try {

			boolean continuar = true;
			while (continuar) {
				cicloJogo();
				System.out.println("Outra partida? (S/n)");
				String resposta = entrada.next();

				if ("s".equalsIgnoreCase(resposta)) {
					reiniciar();
					System.out.println("espacos.size(): "+espacos.size());
					
				} else if ("n".equals(resposta)) {
					continuar = false;
				} else {
					console("Por favor, digite uma opção válida!\n");
				}
			}
		} catch (SairException e) {
			System.out.println("Tchau!!");
		} finally {
			entrada.close();
		}
	}

	private void cicloJogo() {
		console("--------- JOGO DA FORCA --------- \n");
		try {

			while (!objetivoConcluido()) {

				console(errosJogo());
				
				System.out.println("Venceu: " + venceu + "\n");
				if (jogo.getErros() < jogo.getProntos() || venceu < jogo.getPalavra().length()) {
					console("Digite uma Letra: ");
					tracosPalavra();
					letra = entrada.nextLine();

				}

				if (venceu == jogo.getPalavra().length()) {
					tracosPalavra();
					console("Você Venceu!");
				}

				if (jogo.compararLetras(letra)) {
					jogo.setErros(jogo.getErros() + 1);
					System.out.println("jogo.getErros():   " + jogo.getErros());
					console(errosJogo());
					jogo.setLetrasErradas(letra);

					if (jogo.getErros() == 6) {
						console("Você Perdeu!");
					}
				}

				console("Letras erradas: " + jogo.getLetrasErradas());
			}

		} catch (PerderException e) {
			System.out.println(e);
		}

	}

	private boolean objetivoConcluido() {
		if (venceu == jogo.getPalavra().length()) {
			return true;
		}
		return false;
	}

	private void tracosPalavra() {
		if (espacos.size() == 0) {
			for (int i = 0; i < jogo.getPalavra().length(); i++) {
				espacos.add("_ ");
			}
		}
		if (venceu < jogo.getPalavra().length()) {
			colocarPalavraAcertadaNoLugar(espacos);
			console(espacos);
		}

	}

	private List<String> colocarPalavraAcertadaNoLugar(List<String> espacos) {
		for (int i = 0; i < jogo.getLetrasPalavra().size(); i++) {
			if (jogo.getLetrasPalavra().get(i).equalsIgnoreCase(letra)) {
				int indice = i;
				for (int j = 0; j < jogo.getLetrasPalavra().size(); j++) {
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

	private void console(String texto) {
		System.out.println(texto);
	}

	private void console(List<String> tracos) {
		for (String es : tracos) {
			System.out.print(es);
		}
		System.out.println("\n");
	}

	private void reiniciar() {
		espacos.clear();
		System.out.println("espacos.size(): "+espacos.size());
		venceu = 1;
		jogo.getLetrasPalavra().clear();
		System.out.println("jogo.getLetrasPalavra().size(): "+ jogo.getLetrasPalavra().size());
		jogo.getLetrasErradas().clear();
		System.out.println("jogo.getLetrasErradas().size(): "+ jogo.getLetrasErradas().size());
		jogo.setPalavra();
		jogo.setErros(0);

	}
}
