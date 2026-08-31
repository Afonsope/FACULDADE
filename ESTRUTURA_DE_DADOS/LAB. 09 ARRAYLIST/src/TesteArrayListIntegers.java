// ----------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : ARRANJOS DINÂMICOS em JAVA
// Ano/S: 2026/1S
// ----------------------------------------

// classe para realização de testes com
// 'ArrayList' contendo objetos 'Integer'
// --------------------------------------

// importação para permitir o uso de 'ArrayList'
import java.util.ArrayList;
// importação para permitir o uso de 'sort'
import java.util.Collections;
// importação para permitir o uso de 'iterator'
import java.util.Iterator;

public class TesteArrayListIntegers {

    // método da classe para realização do teste
    public void executaTeste() {
        
        // declaração de variáveis auxiliares para a manipulação do 'ArrayList'
        int valor;
        int posicao;
        int qtdElementos;
        
        // declaração de constante para indicar nível de 'verbosidade'
        // (grau de detalhe da exibição de dados de saída)
        final boolean VERBOSO = true;
        
        // instanciação de um objeto da classe 'ArrayList'
        // para armazenar 'Integer' (inicialmente vazio)
        ArrayList<Integer> numeros = new ArrayList<Integer>();

        // instanciação de um objeto da classe 'MetodosAvulsos'
        // para poder acessar o método 'geraNumeroRandomico'
        MetodosAvulsos avulso = new MetodosAvulsos();
        
        // obtenção da quantidade de 'Integer' desejada
        // - valor aleatório entre 11 e 20
        qtdElementos = avulso.geraNumeroRandomico(11,20);
        System.out.printf("Qtd. elementos a armazenar: %2d\n",qtdElementos);
        
        // armazenamento no 'ArrayList'
        // - valores aleatórios entre 10 e 99
        // - posição aleatória em uma dentre 4 inserções
        for ( int i = 0; i < qtdElementos; i++ ) {

            // obtém o valor a ser armazanado (aleatório)
            valor = avulso.geraNumeroRandomico(10,99);
            // se deve exibir...
            if ( VERBOSO ) {
                System.out.printf("Valor a armazenar: %2d - ",valor);
            }

            // verifica se deve inserir no final ou em posição aleatória no 'ArrayList'
            if ( (i % 4) == 0 ) {
                // em posição aleatória
                posicao = avulso.geraNumeroRandomico(0,numeros.size());
                // se deve exibir...
                if ( VERBOSO ) {
                    System.out.printf("Posição %2d", posicao);
                }
                // insere na posição sorteada
                numeros.add(posicao,valor);
            }
            else {
                // no final
                // se deve exibir...
                if ( VERBOSO ) {
                    System.out.printf("Posição %2d", numeros.size());
                }
                // insere no final
                numeros.add(valor);
            }
            // exibe o conteúdo atual do 'ArrayList' via 'toString' 
            if ( VERBOSO ) {
                System.out.println(" - 'numeros' -> " + numeros);
            }
        }
        
        // exibição da quantidade de elementos efetivamente armazenados
        System.out.println("\nApós inserções ...");
        System.out.printf("Qtd. elementos armazenados: %2d\n", numeros.size());
        
        // exibição do conteúdo do 'ArrayList'
        System.out.print("Conteúdo de 'numeros' (exibição via 'toString' de 'ArrayList'):\n");
        System.out.println(numeros);
        
        // remoção de elementos
        // - quantidade de remoções aleatória entre 5 e 10
        // - posição aleatória
        qtdElementos = avulso.geraNumeroRandomico(5,10);
        System.out.printf("\nQtd. elementos a remover: %2d\n",qtdElementos);
        for ( int i = 0; i < qtdElementos; i++ ) {
            // em posição aleatória
            posicao = avulso.geraNumeroRandomico(0,numeros.size()-1);
            // se deve exibir...
            if ( VERBOSO ) {
                System.out.printf("Posição a remover: %2d - Valor %2d",
                    posicao,numeros.get(posicao));
            }
            // remove o elemento da posição 
            numeros.remove(posicao);
            // exibe o conteúdo atual do 'ArrayList' via 'toString' 
            if ( VERBOSO ) {
                System.out.println(" - 'numeros' -> " + numeros);
            }
            
        }
        
        // exibição da quantidade restante de elementos
        System.out.println("\nApós remoções ...");
        System.out.printf("Qtd. elementos restantes: %2d\n", numeros.size());
        System.out.print("Conteúdo de 'numeros' (exibição via 'toString' de 'ArrayList'):\n");
        System.out.println(numeros);
        
        // classificação dos elementos do 'ArrayList'
        Collections.sort(numeros);
        
        // exibição do conteúdo classificado do 'ArrayList'
        System.out.println("\nApós a classificação ...");
        System.out.print("Conteúdo de 'numeros' (exibição via 'iterator' de 'ArrayList'):\n[");
        Iterator< Integer > iterador = numeros.iterator();
        while ( iterador.hasNext() ) {
            System.out.printf(" %2d,",iterador.next());
        }
        System.out.println(" ]");
                
        // transferência do conteúdo para um vetor convencional

        // Modo 1: cópia de cada elemento,individualmente, para vetor de 'int'
        int[] vetor1 = new int[numeros.size()];
        for ( int i = 0; i < numeros.size(); i++ ) {
            vetor1[i] = numeros.get(i);
        }
        
        // Modo 1 (exibição do conteúdo do vetor assim criado)
        System.out.println("\nApós a cópia para vetor (Modo 1) ...");
        System.out.print("Conteúdo de 'vetor1' (exibição via 'for' simplificado):\n[");
        for ( int n : vetor1 ) {
            System.out.printf(" %2d,",n);
        }
        System.out.println(" ]");
        
        // Modo 2: cópia direta para um vetor de 'Object'
        Object[] vetor2;
        vetor2 = numeros.toArray();
        
        // Modo 2 (exibição do conteúdo do vetor assim criado)
        System.out.println("\nApós a cópia para vetor (Modo 2) ...");
        System.out.print("Conteúdo de 'vetor2' (exibição via 'for' simplificado):\n[");
        for ( Object n : vetor2 ) {
            System.out.printf(" %2s,",n.toString());
        } 
        System.out.println(" ]");
        
        // Modo 3: cópia para um vetor de 'Integer'
        Integer[] vetor3 = new Integer[numeros.size()];
        numeros.toArray(vetor3);
        
        // Modo 3 (exibição do conteúdo do vetor assim criado)
        System.out.println("\nApós a cópia para vetor (Modo 3) ...");
        System.out.print("Conteúdo de 'vetor3' (exibição via 'for' convencional):\n[");
        for ( int i = 0; i < vetor3.length; i++ ) {
            if ( i == 0 ) {
                System.out.printf(" %2d",vetor3[i]);
            }
            else {
                System.out.printf(", %2d",vetor3[i]);
            }
        }
        System.out.println(" ]");
        
    }

}

