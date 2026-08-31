// ------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : STRINGS, MATH e ARRAYS JAVA
// Ano/S: 2026/1S
// ------------------------------------

// classe que contém métodos de uso geral

// código da classe
public class MetodosAvulsos {
    
	// Uso geral - geração de número randômico inteiro num certo intervalo [min,max)
	// Observação: min (inclusive), max (exclusive)
	// -------------------------------------------------------------------
	public int geraNumeroRandomico( int min, int max ) {

		// geração do número
		int numeroRandomico = (int)(Math.random() * (max-min+1)) + min;  // [min,max]

		// finalização
		return numeroRandomico;
	}

}
