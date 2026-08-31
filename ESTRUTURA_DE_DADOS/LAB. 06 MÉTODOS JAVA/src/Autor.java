// -------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : MÉTODOS GENÉRICOS em JAVA
// Ano/S: 2026/1S
// -------------------------------------

// classe para montagem e exibição dos dados do autor do programa
public class Autor {

	// Uso geral - exibição de dados do autor do trabalho
	// --------------------------------------------------
	void exibeDadosAutor( String anoSemestre, String nomeLab, String nomeAutor, String RAAutor ) {
	
		// identificação do autor do trabalho
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("Disc.: ESTRUTURAS DE DADOS - " + anoSemestre);
		System.out.println("Lab. : " + nomeLab);
		System.out.println("-----------------------------------");
		System.out.println("Nome : " + nomeAutor);
		System.out.println("R.A. : " + RAAutor);
		System.out.println("-----------------------------------");
		System.out.println();
	
		// finalização (desnecessário neste caso, pois é procedimento 'void')
		return;	
	}
    
}
