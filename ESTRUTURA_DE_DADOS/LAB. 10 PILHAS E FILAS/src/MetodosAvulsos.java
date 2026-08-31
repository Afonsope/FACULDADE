// --------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: CARLOS MAGNUS CARLSON FILHO - FATEC S J Rio Preto
// Lab. : DIVERSOS
// Ano/S: 2026/1S
// --------------------------------------------------------

// importação para permitir uso de gerador de números aleatórios
// ver, por exemplo:
// 1. https://www.geeksforgeeks.org/java/java-util-random-class-java/
// 2. https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
import java.util.Random;

// classe que define métodos de uso geral,
// que podem ser acionados de maneira avulsa
// -----------------------------------------
public class MetodosAvulsos {
    
	// Uso geral - geração de número randômico inteiro num certo intervalo [min,max)
	// Observação: min (inclusive), max (exclusive)
	// -------------------------------------------------------------------
	public int geraNumeroRandomico( int min, int max ) {

		// geração do número
		int numeroRandomico = (int)( Math.random() * (max-min+1) + min);  // [min,max]

		// finalização
		return numeroRandomico;
	}

	// Uso geral - geração de número randômico inteiro num certo intervalo [min,max)
	// Observação: min (inclusive), max (exclusive)
	// Neste caso: utiliza a classe 'Random' fornecida pelo Java
	// -------------------------------------------------------------------
	public int geraNumeroRandomico2( int min, int max ) {

		// instanciação do gerador randômico (objeto da classe 'Random')
		Random gerador = new Random();
			 
		// geração do número
		int numeroRandomico = gerador.nextInt(min, max+1);  // [min,max]

		// finalização
		return numeroRandomico;
	}

	// Uso geral - construção de linha separadora customizada nos 'prints'
	// ------------------------------------------------------------------
	public String criaSeparadora(String padrao, int qtd) {
		// exibe o 'padrão' indicado exatamente 'qtd' vezes
		//return padrao.repeat(qtd);

		// se a versão do Java suportar o método 'repeat',
		// então fazer simplesmente ...
		// return padrao.repeat(qtd);
		// senão...
		// inicializa a linha separadora
		String linha = "";
		// adiciona a ela (por concatenação) o 'padrao' na 'qtd' de vezes indicada
		for ( int i = 0; i < qtd; i++ ) {
			linha += padrao;
		}
		// retorna a linha separadora assim construída
		return linha;
	}

}