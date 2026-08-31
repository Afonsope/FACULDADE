// -------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: CARLOS MAGNUS CARLSON FILHO
// Lab. : DIVERSOS
// Ano/S: 2026/1S
// -------------------------------------------

// código da classe
public class MetodosAvulsos {
    
	// Uso geral - geração de número randômico inteiro num certo intervalo [min,max]
	// Observação: min (inclusive), max (inclusive)
	// -------------------------------------------------------------------
	public int geraNumeroRandomico( int min, int max ) {

		// geração do número
		int numeroRandomico = (int)( Math.random() * (max-min+1) + min);  // [min,max]

		// finalização
		return numeroRandomico;
	}

	// Uso geral - construção de linha separadora customizada nos 'prints'
	// ------------------------------------------------------------------
	public String criaSeparadora(String padrao, int qtd) {

		// exibe o 'padrão' indicado exatamente 'qtd' vezes
		//return padrao.repeat(qtd);
		
		// se o método 'repeat' não estiver disponível ...
		 String linha = "";
		 for ( int i = 0; i < qtd; i++ ) {
		    linha += padrao;
		 }
		 return linha;
	}

}

