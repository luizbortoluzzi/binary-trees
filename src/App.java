import java.util.Scanner;

public class App {

	static ListaDeArvores lista = new ListaDeArvores();
	static Scanner ler = new Scanner(System.in);
	static int opcao = 0;

	public static void recebeTexto(String texto, String nome) {
		Arvore arvore = null;

		texto = texto.replaceAll("[:,.!?;-]", " ");
		texto = texto.replace("  ", " ");
		texto = texto.toLowerCase();
		String[] array = texto.split(" ");

		for (String palavra : array) {

			if (arvore == null) {
				Nodo raiz = new Nodo(palavra);
				arvore = new Arvore(raiz, nome);
				continue;
			}
			arvore.inserirNodo(palavra);

		}

		lista.adicionaArvore(arvore);

	}

	public static void imprimir(String nome) {

		Arvore arvore = null;
		arvore = lista.pegaArvore(nome);
		arvore.imprimeEmOrdem(arvore.getRaiz());

	}

	private static void removerArvore() {
		// TODO Auto-generated method stub

	}

	private static void escolherArvore() {
		
		ler.nextLine();

		System.out.println("Digite o nome da árvore a ser buscada: ");
		String nome = ler.nextLine();
		Arvore arvore = null;
		String palavra = null;
		
		if (lista.pegaArvore(nome) != null) {
			
			arvore = lista.pegaArvore(nome);
			opcoesMenuArvore();

			while (opcao != 6) {
				System.out.println("A árvore selecionada é " + arvore.getNomeArvore());
				switch (opcao) {
				case 1:
					System.out.println("Qual palavra você quer buscar? ");
					palavra = ler.nextLine();
					arvore.existePalavra(palavra);
					break;

				case 2:
					ler.nextLine();
					System.out.println("Qual palavra você quer remover? ");
					palavra = ler.nextLine();
					arvore.removerPalavra(palavra);
					break;

				case 3:
					System.out.println("Total de palavras: "+arvore.getTotalDePalavras());
					break;

				case 4:
					arvore.imprimeEmOrdem(arvore.getRaiz());
					break;

				case 5:
					arvore.imprimirPreFixado(arvore.getRaiz());
					break;

				default:
					System.out.println("Opção inválida");
					break;

				}
				opcoesMenuArvore();
			}
		}

	}

	private static void preFixadoTotal() {
		lista.preFixadoTotal();

	}

	public static void exibeOpcoesMenu() {

		opcoesMenu();

		while (opcao != 7) {

			switch (opcao) {
			case 1:
				//inserirTexto();
				break;

			case 2:
				lista.emOrdemTotal();
				break;

			case 3:
				lista.contaTotal();
				break;

			case 4:
				lista.preFixadoTotal();
				break;

			case 5:
				escolherArvore();
				break;

			case 6:
				System.out.println("Digite o nome da árvore a ser buscada: ");
				String nome = ler.nextLine();
				lista.removeArvore(nome);
				break;

			default:
				System.out.println("Opção inválida");
				break;

			}
			opcoesMenu();
		}
	}

	public static void imprimirArvore() {

		System.out.println("Digite o nome da árvore: ");
		String nome = ler.nextLine();
		Arvore arvore = null;
		arvore = lista.pegaArvore(nome);
		arvore.imprimeTeste(arvore.getRaiz());

	}

	public static void opcoesMenuArvore() {
		System.out.println("******** Escolha de Árvores********");
		System.out.println("1 - Verificar existência de palavra");
		System.out.println("2 - Remover palavra");
		System.out.println("3 - Número de palavras");
		System.out.println("4 - Listar em ordem alfábética");
		System.out.println("5 - Listar Pré-Fixado");
		System.out.println("6 - Sair");

		opcao = ler.nextInt();
	}

	public static void opcoesMenu() {
		System.out.println("******** Árvores Binárias ********");
		System.out.println("1 - Inserir um texto");
		System.out.println("2 - Exibir total de palavras em ordem alfabética");
		System.out.println("3 - Exibir contagem total de palavras (únicas)");
		System.out.println("4 - Listar pré fixado total");
		System.out.println("5 - Escolher uma árvore em especial");
		System.out.println("6 - Remover uma árvore");
		System.out.println("7 - Sair");

		opcao = ler.nextInt();
	}

	public static void main(String[] args) {

		/* Textos das árvores */
		String nomeArvore1 = "Ar1";
		String texto1 = "Se Vai fritar, roa xarope, se filé!";

		String nomeArvore2 = "Ar2";
		String texto2 = "tu bi bu bu li lo lo la as busca";
		
		String nomeArvore3 = "Ar3";
		String texto3 = "8 3 1 9";

		recebeTexto(texto1, nomeArvore1);
		recebeTexto(texto2, nomeArvore2);
		recebeTexto(texto3, nomeArvore3);
		
		exibeOpcoesMenu();
	}

}
