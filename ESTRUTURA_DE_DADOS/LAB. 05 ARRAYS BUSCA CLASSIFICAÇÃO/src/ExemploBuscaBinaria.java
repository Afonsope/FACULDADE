// -------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: CARLOS MAGNUS CARLSON FILHO
// Lab. : BUSCA e CLASSIFICAÇÃO EM ARRAYS JAVA
// Ano/S: 2026/1S
// -------------------------------------------

// código da classe
public class ExemploBuscaBinaria {

    // ATRIBUTOS
    // ---------

    // constante: tamanho de vetor para teste do método de busca binária
    final int TAMANHO_VETOR_TESTE_BUSCA_BINARIA = 16;
    
    // constante: quantidade de testes do método de busca binária
    final int QTD_TESTES_BUSCA_BINARIA = 10;
    
    // DEMAIS métodos
    // --------------
    
    // auxiliar para impressão de cabeçalho (só depende do tamanho do vetor)
    // uso na BUSCA BINÁRIA
    // ---------------------------------------------------------------------
    private void imprimeCabecalho ( int n ) {
        
        int i;
        
        System.out.print("\nPosição: ");
        
        for ( i = 0; i < n; i++ ) {
            System.out.printf(" %3d",i);
        }
        System.out.println();
        
        System.out.print("          ");
        for ( i = 1; i < 4*n; i++ ) {
            System.out.print("-");
        }
        System.out.println();
    }

    // impressão de uma linha (um passo da busca)
    // uso na BUSCA BINÁRIA
    // ------------------------------------------
    private void imprimeLinha( int a[], int primeiro, int meio, int ultimo, int n ) {
    
        int i;
        
        System.out.print("Conteúdo: ");
        for ( i = 0; i < n; i++ ) {
            if ( i < primeiro || i > ultimo ) {
                System.out.print("    ");
            }
		    else {
                if ( i == meio ) {
                    System.out.printf("%3s*", a[i]);
                }
                else {
                    System.out.printf("%3s ", a[i]);
                }
            }
        }
        System.out.println();
    }

    // BUSCA BINÁRIA 
    // ------------- 
    private int buscaBinaria (
            int a[], // nome do vetor 
            int n,   // comprimento do vetor a ser utilizado nas buscas
            int c,   // valor procurado
            boolean imprimir )
    {
        int primeiro = 0;      // menor posição do vetor a ser analisado (ajustada durante a busca)
        int ultimo   = n - 1;  // maior posição do vetor a ser analisado (ajustada durante a busca)
        int meio;              // posição central do vetor a ser analisado (calculado durante a busca)
        
        // impressão do cabeçalho (auxiliar)
        if ( imprimir ) {
            imprimeCabecalho( n );
        }
    
        // loop de comparações, enquanto não acabar o vetor e enquanto não encontrar o que procura
        while ( primeiro <= ultimo ) {
            // calcula a posição central
            meio = ( primeiro + ultimo ) / 2;
            // imprime os dados da busca no momento
            if ( imprimir ) {
                imprimeLinha( a, primeiro, meio, ultimo, n );
            }
            // se encontrou, retorna a posição do vetor em que isso aconteceu
            if ( c == a[meio] ) {
                return meio;
            }
            // se não encontrou, decide qual das metades do vetor será utilizada no próximo passo
            else {
                if ( c < a[meio] ) {  // utilizará a metade "de baixo"
                    ultimo = meio - 1;
                }
                else {                // utilizará a metade "de cima"
				    primeiro = meio + 1;
                }
            }
        }
        
        // se está aqui é porque não encontrou o que buscava
        return -1;
    }

    // método de "entrada" da classe: realização dos testes
    public void executaExemplos() {
        
        // declaração de variáveis
        int[]  vetorTeste;   // referência para o vetor já classificado sobre o qual ocorrerá a busca
        int    chave; // valor do elemento a ser buscado no 'vetorTeste'
        int    posicao; // posição no 'vetorTeste' em que a 'chave' foi encontrada (ou -1 se não encontrar)

        // criação de uma instância (objeto) da classe 'MetodosAvulsos'
        // para permitir o acesso aos respectivos métodos
        MetodosAvulsos avulsos = new MetodosAvulsos();
        
        // alocação de memória para o vetor a ser testado
        vetorTeste = new int[TAMANHO_VETOR_TESTE_BUSCA_BINARIA];
            
        // preenchimento do conteúdo dos elementos do vetor com conteúdo classificado crescente
        // valor da posição inicial do vetor: número entre 10 e 15, inclusive
        vetorTeste[0] = avulsos.geraNumeroRandomico( 10, 15 );
        for (int i = 1; i < vetorTeste.length; i++) {
            // valor das demais posições: valor da posição anterior aumentado entre 0 e 9
            vetorTeste[i] = vetorTeste[i-1] + avulsos.geraNumeroRandomico( 0, 9 );
        }

        // loop de buscas no mesmo vetor 
        for ( int j = 0; j < QTD_TESTES_BUSCA_BINARIA; j++ ) {
            // estabelecimento da chave de forma aleatória (mas com valor entre os extremos do vetor)
            chave = avulsos.geraNumeroRandomico( vetorTeste[0]-5, vetorTeste[TAMANHO_VETOR_TESTE_BUSCA_BINARIA-1]+5 );
            System.out.printf("\n-----\nTeste %3s - Valor procurado: %3s", j+1,chave);
            
            // acionamento da busca binária
            posicao = buscaBinaria( vetorTeste, vetorTeste.length, chave, true );  // último número indica impressões intermediárias (1) ou não (0)
        
            // indoca o 'status' resultante da busca
            if ( posicao >= 0 ) {
                System.out.printf("--> Sim !  Valor %3s encontrado na posição %3s\n", chave, posicao);
            }
            else {
                System.out.printf("--> Valor %3s não encontrado ... \n",chave);
            }
        }

    } // fim do método 'executaExemplos'

}
