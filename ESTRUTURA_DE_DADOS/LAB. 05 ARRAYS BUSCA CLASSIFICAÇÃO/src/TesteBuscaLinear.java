// -------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: CARLOS MAGNUS CARLSON FILHO
// Lab. : BUSCA e CLASSIFICAÇÃO EM ARRAYS JAVA
// Ano/S: 2026/1S
// -------------------------------------------

// classe que realiza testes de BUSCA LINEAR
// -----------------------------------------

public class TesteBuscaLinear {

    // ATRIBUTOS
    // ---------
    
    // enumeração: tipos de tamanhos de vetor para teste do método de BUSCA LINEAR
    private enum TamanhoVetor {
        G10,
        G100,
        G1000,
        G10000,
        G100000,
        G1000000
    }

    // array com os respectivos tamanhos
    private int[] tamanhos = { 10, 100, 1000, 10000, 100000, 1000000 };

    // atributo: array que armazena os tempos de execução dos testes
    private float[] tempos;
    
    // valor "PROBIDO", isto é,que não pode constar do vetor de testes
    // para que ocorra sempre o 'pior caso' da busca linear
    final int VALOR_PROIBIDO = 12345;

    // método CONSTRUTOR
    // -----------------
    TesteBuscaLinear() {
        
        // instanciação do array que armazena os tempos de execução dos testes
        tempos = new float[TamanhoVetor.values().length];
    }

    // DEMAIS métodos
    // --------------
    
    // método para exibição dos resultados (tempos de busca)
    private void exibeTempos() {
        
        // monta o cabeçalho da saída
        System.out.println("\nResultados da BUSCA LINEAR");
        System.out.println("+--------------+-----------+");
        System.out.println("|  TAM. VETOR  | TEMPO (s) |");
        System.out.println("+--------------+-----------+");

        // percorre tamanhos
        for (TamanhoVetor tamanho : TamanhoVetor.values()) {
            
            int t = tamanho.ordinal();
            
            // exibe os dados
            System.out.printf("|    %8s  |  %8.3f |\n",
                tamanho.toString(),
                tempos[t]);
        }
        System.out.println("+--------------+-----------+");
    }
    
    // BUSCA LINEAR
    // ------------
    private int buscaLinear (
            int a[], // nome do vetor
            int n,   // comprimento do vetor a ser utilizado nas buscas
            int c,   // valor procurado
            boolean imprimir )
    {
        boolean achou =  false; // auxiliar para indicar se achou ou não o valor procurado
        int     i;              // auxiliar de percurso do vetor, indica também a posição onde achou o valor
    
        // loop de comparações, enquanto não acabar o vetor e enquanto não encontrar o que procura
        for ( i=0; i < n && !achou; i++ ) {
            if ( c == a[i] ) {
                achou = true;
            }
            if (imprimir && ((i+1)%10 == 0)) {
                System.out.printf(" Posição %7d - valor %8d - Achou... %d\n", i, a[i],(achou?1:0));
            }
        }
        if ( !achou ) return  -1;
        else          return i-1; // devido ao i++ do 'for'
    }
    
    // método de "entrada" da classe: realização dos testes
    public void realizaTestes() {
        
        // declaração de variáveis
        int[]  vetorTeste;   // referência para o vetor sobre o qual ocorrerá a busca
        long   inicio, fim;  // auxiliares para medição dos tempos

        // criação de uma instância (objeto) da classe 'MetodosAvulsos'
        // para permitir o acesso aos respectivos métodos
        MetodosAvulsos avulsos = new MetodosAvulsos();
        
        // loop de testes
        for (TamanhoVetor tamanho : TamanhoVetor.values()) {

            int t = tamanho.ordinal(); // posição no 'enum'

            // alocação de memória para o vetor a ser testado
            vetorTeste = new int[tamanhos[t]];
            
            // preenchimento do conteúdo dos elementos do vetor com conteúdo aleatório
            for (int i = 0; i < vetorTeste.length; i++) {
                vetorTeste[i] = avulsos.geraNumeroRandomico( 1, 2 * vetorTeste.length );
                // garante que valor seja diferente daquele "PROBIDO"
                if ( vetorTeste[i] == VALOR_PROIBIDO ) {
                    vetorTeste[i]++;
                }
            }

            // acionamento da busca linear e coleta de tempo para o vetor em teste
            inicio = System.currentTimeMillis();
            buscaLinear( vetorTeste, vetorTeste.length, VALOR_PROIBIDO, true );
            fim    = System.currentTimeMillis();

            // armazena o tempo de execução desta busca
            tempos[t] = (float) (fim-inicio)/1000;
                    
            // destroi o vetor (necessário, pois o objeto 'teste'
            // será reutilizado para outro tamenho de vetor
            vetorTeste = null;
            System.gc();

        }

        // exibe resultados (tempos)
        exibeTempos();

        // instanciação de objeto da classe 'Autor'
        Autor autor = new Autor();

        // exibição dos dados do autor do trabalho
        autor.exibeDadosAutor();

    } // fim do método 'realizaTestes'
        
} // fim da classe
