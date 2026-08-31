// -------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: CARLOS MAGNUS CARLSON FILHO
// Lab. : BUSCA e CLASSIFICAÇÃO EM ARRAYS JAVA
// Ano/S: 2026/1S
// -------------------------------------------

// classe que realiza testes de BUSCA BINÁRIA
// ------------------------------------------

public class TesteBuscaBinaria {

    // ATRIBUTOS
    // ---------
    
    // enumeração: tipos de tamanhos de vetor para teste do método de BUSCA LINEAR
    private enum TamanhoVetor {
        G2,     G4,      G8,      G16,     G32,
        G64,    G128,    G256,    G512,    G1024,
        G2048,  G4096,   G8192,   G16384,  G32768,
        G65536, G131072, G262144, G524288, G1048576
    }

    // array com os tamanhos para testes da BUSCA BINÁRIA
    private final int[] tamanhos = {
        2,     4,      8,      16,     32,
        64,    128,    256,    512,    1024,
        2048,  4096,   8192,   16384,  32768,
        65536, 131072, 262144, 524288, 1048576 };

    // atributo: array que armazena os tempos de execução dos testes
    private float[] tempos;
    
    // atributo: array que armazena a qtd. perguntas realizadas em cada um dos testes
    private int[] qtdPerguntas;
    
    // valor "PROBIDO", isto é,que não pode constar do vetor de testes
    // para que ocorra sempre o 'pior caso' da busca linear
    private final int VALOR_PROIBIDO = 12345;

    // método CONSTRUTOR
    // -----------------
    TesteBuscaBinaria() {
        
        // instanciação do array que armazena os tempos de execução dos testes
        tempos = new float[TamanhoVetor.values().length];

        // instanciação do array que armazena as qtd. perguntas realizadas nos testes
        qtdPerguntas = new int[TamanhoVetor.values().length];
    }
    
    // DEMAIS métodos
    // --------------
    
    // método para exibição dos resultados (qtd. perguntas em cada busca)
    private void exibeTemposQtdPerguntas() {
        
        // monta o cabeçalho da saída
        System.out.println("\nResultados da BUSCA BINÁRIA");
        System.out.println("+--------------+-------------+-----------+");
        System.out.println("|  TAM. VETOR  | QTD. PERGS. | TEMPO (S) |");
        System.out.println("+--------------+-------------+-----------+");

        // percorre tamanhos
        for (TamanhoVetor tamanho : TamanhoVetor.values()) {
            
            int t = tamanho.ordinal();
            
            // exibe os dados
            System.out.printf("|   %-8s   |      %4d   |  %8.3f |\n",
                tamanho.toString(),
                qtdPerguntas[t],
                tempos[t]);
        }
        System.out.println("+--------------+-------------+-----------+");
    }
    
    // BUSCA BINÁRIA 
    // ------------- 
    private int buscaBinaria (
            int a[], // nome do vetor 
            int n,   // comprimento do vetor a ser utilizado nas buscas 
			int c,   // valor procurado 
			boolean imprimir )
    {
  	    int pInicial = 0;      // menor posição do vetor a ser analisado (ajustada durante a busca)
  	    int pFinal   = n - 1;  // maior posição do vetor a ser analisado (ajustada durante a busca)
  	    int meio;              // posição central do vetor a ser analisado (calculado durante a busca)

        int qtdPerg  = 0;      // armazena a qtd. perguntas realizadas na busca
  	
        // loop de comparações, enquanto não acabar o vetor e enquanto não encontrar o que procura 
	    while ( pInicial <= pFinal ) {
		    // calcula a posição central
		    meio = ( pInicial + pFinal ) / 2;
            // incrementa o contador de perguntas
            qtdPerg++;
		    // se encontrou, pode encerrar a busca
		    if ( c == a[meio] ) {
                // indica posição em que encontrou
                if (imprimir) {
                    System.out.printf(" Posição %7d - valor %8d - Achou!\n", meio, a[meio]);
                }

			    //return meio;
                return qtdPerg;
		    }
		    else {
                // ainda não encontrou
                /*
                if (imprimir) {
                    System.out.printf(" Posição %7d - valor %8d - Não achou!\n", meio, a[meio]);
                }*/

		        // decide qual das metades do vetor será utilizada no próximo passo
			    if ( c < a[meio] ) {  // utilizará a metade "de baixo"
				    pFinal = meio - 1;
			    }
			    else {                // utilizará a metade "de cima"
				    pInicial = meio + 1;
			    }
		    }
	    }
	
	    // se está aqui é porque não encontrou o que buscava
        System.out.println("Não achou!");
	    //return -1;
        return qtdPerg;
    }
    
    // método de "entrada" da classe: realização dos testes
    public void realizaTestes() {
        
        // declaração de variáveis
        int[]  vetorTeste;   // referência para o vetor já classificado sobre o qual ocorrerá a busca
        long   inicio, fim;  // auxiliares para medição dos tempos

        // criação de uma instância (objeto) da classe 'MetodosAvulsos'
        // para permitir o acesso aos respectivos métodos
        MetodosAvulsos avulsos = new MetodosAvulsos();
        
        // loop de testes
        for (TamanhoVetor tamanho : TamanhoVetor.values()) {

            int t = tamanho.ordinal(); // posição no 'enum'

            // alocação de memória para o vetor a ser testado
            vetorTeste = new int[tamanhos[t]];
            
            // preenchimento do conteúdo dos elementos do vetor com conteúdo classificado crescente
            // valor da posição inicial do vetor: número entre 0 e 99, inclusive
            vetorTeste[0] = avulsos.geraNumeroRandomico( 0, 99 );
            for (int i = 1; i < vetorTeste.length; i++) {
                // valor das demais posições: valor da posição anterior aumentado entre 0 e 99
                vetorTeste[i] = vetorTeste[i-1] + avulsos.geraNumeroRandomico( 0, 99 );
                // garante que valor seja diferente daquele "PROBIDO"
                if ( vetorTeste[i] == VALOR_PROIBIDO ) {
                    vetorTeste[i]++;
                }
            }

            // acionamento da busca binária e coleta da qtd. de perguntas realizadas nesta busca
            inicio = System.currentTimeMillis();
            qtdPerguntas[t] = buscaBinaria( vetorTeste, vetorTeste.length, VALOR_PROIBIDO, true );
            fim    = System.currentTimeMillis();

            // armazena o qtd. de perguntas realizadas nesta busca
            tempos[t] = (float) (fim-inicio)/1000;
                    
            // destroi o vetor (necessário, pois o objeto 'teste'
            // será reutilizado para outro tamenho de vetor
            vetorTeste = null;
            System.gc();

        }

        // exibe resultados (tempos)
        exibeTemposQtdPerguntas();

        // instanciação de objeto da classe 'Autor'
        Autor autor = new Autor();

        // exibição dos dados do autor do trabalho
        autor.exibeDadosAutor();

    } // fim do método 'realizaTestes'
        
} // fim da classe
