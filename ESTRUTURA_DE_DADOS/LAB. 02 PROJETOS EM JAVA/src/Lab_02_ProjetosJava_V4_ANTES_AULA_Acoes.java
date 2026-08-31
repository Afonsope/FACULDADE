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

// importação de classe para leitura de dados do teclado
import java.util.Scanner;

public class Lab_02_ProjetosJava_V4_ANTES_AULA_Acoes {
	
	// ATRIBUTOS que serão usados em vários lugares desta classe...
	// ------------------------------------------------------------

	// 1. objeto 'Scanner' para a interação com o teclado
	private Scanner teclado;

	// CONSTRUTOR (executado unicamente na instanciação de um objeto desta classe)
	// ---------------------------------------------------------------------------
	Lab_02_ProjetosJava_V4_ANTES_AULA_Acoes() {

		// criação de um objeto 'Scanner' para a interação com o teclado
		teclado = new Scanner(System.in);

	}

	// MÉTODOS
	// -------

	// 1. case 1
	public void exibeValoresPares() {

		// exibição da mensagem que anuncia a Ação a ser realizada nesta opção
		System.out.println("Ação 1 -> números pares !\n");
		// declaração de variáveis para esta Ação
		int n1, n2;
		// obtenção dos valores via teclado
		System.out.print("Informe o menor valor (n1): ");
		n1 = teclado.nextInt();
		System.out.print("Informe o maior valor (n2): ");
		n2 = teclado.nextInt();
		// correção AUTOMÁTICA e ARBITRÁRIA do maior e menor valor
		if (n1 > n2) {
			int temp = n1; // 'triângulo de troca'
			n1 = n2;
			n2 = temp;
		}
		// exibição dos números pares do intervalo
		// AQUI...
		System.out.println("Os valores pares entre " + n1 + " e " + n2 + " (inclusive) são:");
		for (int n = n1; n <= n2; n++) {
			if (n % 2 == 0) {
				System.out.print(n + " ");
			}
		}

		// finalização (desnecessária neste caso, pois é 'void')
		return;

	}

	// 2. case 2
	public void exibeDezCaracteres() {

		// exibição da mensagem que anuncia a Ação a ser realizada nesta opção
		System.out.println("Ação 2: -> dez caracteres do alfabeto !\n");
		// exibição dos caracteres
		System.out.println("Os dez primeiros caracteres (em maiúsculas) do alfabeto são:");
		// AQUI...
		for (char c = 65; c < 75; c++) {
			System.out.print(" " + c);
		}
		
		// finalização (desnecessária neste caso, pois é 'void')
		return;

	}

	// 3. case 3
	// AQUI...
	public void exibeMultiplosTres() {

		// exibição da mensagem que anuncia a Ação a ser realizada nesta opção
		System.out.println("Ação 3: -> múltiplos de 3 !\n");
		// declaração de variável para esta Ação
		int valor_inicial;
		// obtenção dos valor via teclado
		System.out.print("Informe o valor de início da série (entre 1 e 50, inclusive): ");
		valor_inicial = teclado.nextInt();
		// correção AUTOMÁTICA e ARBITRÁRIA do valor informado (entre 1 e 50)
		// AQUI...
		if (!(valor_inicial > 0 && valor_inicial < 51)) {
			valor_inicial = valor_inicial % 50;
			if (valor_inicial <= 0) {
				valor_inicial = 1;
			}
		}
		// exibição dos múltiplos
		System.out.println("Os múltiplos de 3 entre " + valor_inicial + " e 99 são:");
		// ajusta o valor inicial para um múltiplo de 3
		// AQUI...
		while ((valor_inicial % 3) != 0) {
			valor_inicial++;
		}
		// repetição para exibição dos múltiplos desejados
		// AQUI...
		for (int n = valor_inicial; n < 100; n += 3) {
			System.out.print(n + " ");
		}
	}

	// 4. case 4
	// AQUI...
	public void converteParaSegundos() {

		// exibição da mensagem que anuncia a Ação a ser realizada nesta opção
		System.out.println("Ação 4 -> horas, minutos e segundos para segundos !\n");
		// declaração de variáveis para esta Ação
		int horas, minutos, segundos;
		// obtenção dos valores via teclado
		System.out.print("Informe a quantidade de horas    (entre 0 e 23): ");
		horas = teclado.nextInt();
		System.out.print("Informe a quantidade de minutos  (entre 0 e 59): ");
		minutos = teclado.nextInt();
		System.out.print("Informe a quantidade de segundos (entre 0 e 59): ");
		segundos = teclado.nextInt();
		// correção AUTOMÁTICA e ARBITRÁRIA dos valores informados
		horas = horas % 24;
		minutos = minutos % 60;
		segundos = segundos % 60;
		// cálculo e exibição do resultado
		System.out.print("Quantidade equivalente em segundos: ");
		// AQUI...
		int segundosEquivalentes = horas * 60 * 60 + minutos * 60 + segundos;
		System.out.print(segundosEquivalentes);
	}

	// 5. case 5
	// AQUI...
	public void converteParaHorasMinutos() {
		
		// exibição da mensagem que anuncia a Ação a ser realizada nesta opção
		System.out.println("Ação 5 -> minutos para horas e minutos !\n");
		// declaração de variável para esta Ação
		int qtdMinutos;
		int qtdHoras;
		// obtenção do valor via teclado
		System.out.print("Informe a quantidade total de minutos (entre 0 e 1439): ");
		qtdMinutos = teclado.nextInt();
		// transformação e exibição do resultado
		// AQUI...
		qtdHoras = qtdMinutos / 60; // divisão inteira (DIV)
		qtdMinutos = qtdMinutos % 60; // resto inteiro da divisão (MOD)
		System.out.println("Valor informado equivale a " + qtdHoras + " horas e " + qtdMinutos + " minutos.");
	}

	// método que apresenta o menu de opções e retorna a opção escolhida
	public int trataMenu() {
		// apresentação das opções de escolha
		System.out.println("\n\n");
		System.out.println("Escolha uma das opções abaixo:");
		System.out.println("1 - Ação 1 -> números pares");
		System.out.println("2 - Ação 2 -> dez caracteres do alfabeto");
		System.out.println("3 - Ação 3 -> múltiplos de 3");
		System.out.println("4 - Ação 4 -> horas, minutos e segundos para segundos");
		System.out.println("5 - Ação 5 -> minutos para horas e minutos");
		System.out.println("9 - Sair");
	
		System.out.print("\nDigite aqui a sua opção: ");
		// coleta da opção digitada
		int escolha = teclado.nextInt();

		// retorno desta opção para o programa chamador
		return escolha;
		
	}

}