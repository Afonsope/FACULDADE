// -------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: CARLOS MAGNUS CARLSON FILHO
// Lab. : BUSCA e CLASSIFICAÇÃO EM ARRAYS JAVA
// Ano/S: 2026/1S
// -------------------------------------------

// classe que realiza testes de CLASSIFICAÇÃO
// ------------------------------------------

public class TesteMetodosClassificacao {

    // ATRIBUTOS
    // ---------
    
    // constantes
    private final int QTDMETODOS = 7;
    private final int QTDTAMANHOS = 2;
    private final int QTDPREENCHIMENTOS = 2;

    // enumeração: tipos de métodos
    private enum MetodoClassificacao {
        SELEÇÃO,
        INSERÇÃO,
        BOLHA_DIRETO,
        BOLHA_INVERSO,
        MESCLAGEM_ITERATIVO,
        MESCLAGEM_RECURSIVO,
        QUICK
    }

    // enumeração: tipos de tamanhos de vetor para teste dos métodos
    private enum TamanhoVetor {
        G40000,
        G80000
    }

    // enumeração: tipos de preenchimento de vetor para teste dos métodos
    private enum PreenchimentoVetor {
        ALEATÓRIO,
        DECRESCENTE
    }

    // atributo: matriz que armazena os tempos de execução dos testes
    private float[][][] tempos;
    
    // método CONSTRUTOR
    // -----------------
    TesteMetodosClassificacao() {
        
        // instanciação da matriz que armazena os tempos de execução dos testes
        tempos = new float[QTDMETODOS][QTDTAMANHOS][QTDPREENCHIMENTOS];
    }
    
    // DEMAIS métodos
    // --------------
    
    // método auxiliar para exibir dados da enumeração de métodos
    public void exibeEnum() {
        for (MetodoClassificacao m : MetodoClassificacao.values()) {
            System.out.print("Identificador: " + m);
            System.out.print(" - ToString: " + m.toString());
            System.out.print(" - Ordinal: " + m.ordinal());
            System.out.println(" - ValueOf: " + m.name());
        }
    }

    // método para exibição dos resultados (tempos de classificação)
    private void exibeTempos() {
        
        // monta o cabeçalho da saída
        System.out.println("\nResultados da classificação");
        System.out.println("+----------------------+------------+---------------+-----------+");
        System.out.println("| MÉTODO UTILIZADO     | TAM. VETOR | PREENCHIMENTO | TEMPO (s) |");
        System.out.println("+----------------------+------------+---------------+-----------+");

        // percorre métodos, tamanhos e preenchimentos
        for (MetodoClassificacao metodo : MetodoClassificacao.values()) {
            int m = metodo.ordinal();
            for (PreenchimentoVetor preenchimento : PreenchimentoVetor.values()) {
                int p = preenchimento.ordinal();
                for (TamanhoVetor tamanho : TamanhoVetor.values()) {
                    int t = tamanho.ordinal();

                    // exibe os dados
                    //System.out.printf("Resultado[%19s][%6s][%11s]: %.3f\n",
                    System.out.printf("| %-20s |   %6s   |  %-11s  |  %8.3f |\n",
                            metodo.toString(),
                            tamanho.toString(),
                            preenchimento.toString(),
                            tempos[m][t][p]);
                }
            }
            System.out.println("+----------------------+------------+---------------+-----------+");
        }
    }

    // método de "entrada" da classe: realização dos testes
    public void realizaTestes() {
        
        // declaração de variáveis
        MeuVetor teste;   // vetor a ser classificado é um atributo de um objeto 'MeuVetor'
        long inicio, fim; // auxiliares para medição dos tempos

        for (TamanhoVetor tamanho : TamanhoVetor.values()) {
            int t = tamanho.ordinal();
            
            for (PreenchimentoVetor preenchimento : PreenchimentoVetor.values()) {
                int p = preenchimento.ordinal();

                // exibe dados do vetor para este grupo de testes
                System.out.println("-----");
                System.out.printf("Vetor: tamanho %s - preenchimento %s\n", tamanho.name(), preenchimento.name());
                System.out.println("-----");
                
                for (MetodoClassificacao metodo : MetodoClassificacao.values()) {
                    int m = metodo.ordinal();
                    
                    // instancia (cria) o vetor para este teste
                    teste = new MeuVetor(t, p);
                    
                    switch ( metodo ) {
                        case SELEÇÃO :
                            System.out.println("Executando testes de classificação por SELEÇÃO...");
                            inicio = System.currentTimeMillis();
                            teste.selectionSort();
                            fim    = System.currentTimeMillis();
                            //teste.verificaClassificacao();
                            break;
                        case INSERÇÃO :
                            System.out.println("Executando testes de classificação por INSERÇÃO...");
                            inicio = System.currentTimeMillis();
                            teste.insertionSort();
                            fim    = System.currentTimeMillis();
                            //teste.verificaClassificacao();
                            break;
                        case BOLHA_DIRETO :
                            System.out.println("Executando testes de classificação por BOLHA DIRETO...");
                            inicio = System.currentTimeMillis();
                            teste.bubbleSort();
                            fim    = System.currentTimeMillis();
                            //teste.verificaClassificacao();
                            break;
                        case BOLHA_INVERSO :
                            System.out.println("Executando testes de classificação por BOLHA INVERSO...");
                            inicio = System.currentTimeMillis();
                            teste.bubbleSortInvertido();
                            fim    = System.currentTimeMillis();
                            //teste.verificaClassificacao();
                            break;
                        case MESCLAGEM_ITERATIVO :
                            System.out.println("Executando testes de classificação por MESCLAGEM ITERATIVO...");
                            inicio = System.currentTimeMillis();
                            teste.mergeSortIterativo();
                            fim    = System.currentTimeMillis();
                            //teste.verificaClassificacao();
                            break;
                        case MESCLAGEM_RECURSIVO :
                            System.out.println("Executando testes de classificação por MESCLAGEM RECURSIVO...");
                            inicio = System.currentTimeMillis();
                            teste.mergeSortRecursivoWrapper();
                            fim    = System.currentTimeMillis();
                            //teste.verificaClassificacao();
                            break;
                        case QUICK :
                            System.out.println("Executando testes de classificação por QUICKSORT...");
                            inicio = System.currentTimeMillis();
                            teste.quickSortRecursivoTail_2_Wrapper();
                            fim    = System.currentTimeMillis();
                            //teste.verificaClassificacao();
                            break;
                        default:
                            inicio = fim = 0;
                    }
                    
                    // armazena o tempo de execução desta classificação
                    tempos[m][t][p] = (float) (fim-inicio)/1000;
                    /*
                    System.out.printf("Resultado[%s][%s][%s]: %.3f\n",
                            metodo.toString(),
                            tamanho.toString(),
                            preenchimento.toString(),
                            tempos[m][t][p]);*/
                    
                    // destroi o vetor (necessário, pois os métodos são internos,
                    // isto é, classificam fisicamente os elementos no próprio vetor)
                    teste = null;
                    System.gc();

                }
            }
        }
        
        // exibe resultados (tempos)
        exibeTempos();

        // instanciação de objeto da classe 'Autor'
        Autor autor = new Autor();

        // exibição dos dados do autor do trabalho
        autor.exibeDadosAutor();


    }  // fim do método 'realizaTestes'

}
