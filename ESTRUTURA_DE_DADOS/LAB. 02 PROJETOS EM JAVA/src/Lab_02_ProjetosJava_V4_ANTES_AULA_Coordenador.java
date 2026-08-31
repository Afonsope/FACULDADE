// ------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : PROJETOS JAVA
// Ano/S: 2026/1S
// ------------------------------------

// VERSÃO 4 (antes da aula): idem final da versão 3
// - dois arquivos separados
// - ações realizadas por métodos separados do 'main'
// --------------------------------------------------

// importação de classe para leitura de dados do teclado -> NÃO PRECISA MAIS
//import java.util.Scanner;

// classe que contém o PROGRAMA PRINCIPAL ('main')
public class Lab_02_ProjetosJava_V4_ANTES_AULA_Coordenador {

	// PROGRAMA PRINCIPAL
	// ------------------
	public void executarTudo() {
		// System.out.println("Hello, World!");

		// instanciação de um objeto da classe que contém os métodos do 'switch'
		Lab_02_ProjetosJava_V4_ANTES_AULA_Acoes acoes =  
			new Lab_02_ProjetosJava_V4_ANTES_AULA_Acoes();

		// criação de um objeto 'Scanner' para a interação com o teclado
		// (NÃO PRECISA MAIS, porque 'teclado' agora é um atributo da classe '...Acoes')
		//Scanner teclado = new Scanner(System.in);

		// declaração de variáveis a serem usadas (independentemente da Ação)
		int escolha;

		// menu de escolha da Ação a ser executada
		do {

			// acionamento do método que apresenta o menu e retorna a escolha
			escolha = acoes.trataMenu();

			// avaliação da opção e acionamento da respectiva Ação
			switch (escolha) {

				case 1:
					// acionamento do método respectivo
					acoes.exibeValoresPares();
					break;

				case 2:
					// acionamento do método respectivo
					acoes.exibeDezCaracteres();
					break;

				case 3:
					// acionamento do método respectivo
					acoes.exibeMultiplosTres();
					break;

				case 4:
					// acionamento do método respectivo
					acoes.converteParaSegundos();
					break;

				case 5:
					// acionamento do método respectivo
					acoes.converteParaHorasMinutos();
					break;

				case 9:
					System.out.println("Sair ...\n");
					break;

				default:
					System.out.println("Opção inválida !  Tente novamente ...\n");
			}

		} while (escolha != 9);

		//teclado.close();  // desnecessário, pois neste Modo o 'main' não utiliza o 'Scanner'

		// identificação do autor do trabalho -> TAMBÉM PODE TORNAR-SE UM MÉTODO !!!
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("Disc.: ESTRUTURAS DE DADOS - 2026/1S");
		System.out.println("Lab. : PROJETOS JAVA");
		System.out.println("------------------------------------");
		System.out.println("Nome : PEDRO AFONSO PAULINA ATAIDE");
		System.out.println("R.A. : 121 092 251 1 018");
		System.out.println("------------------------------------");
		System.out.println();

	}

}
