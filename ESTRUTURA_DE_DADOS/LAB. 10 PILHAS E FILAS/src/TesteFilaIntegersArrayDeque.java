// --------------------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : PILHAS E FILAS BASEADAS EM ARRAYDEQUE E PRIORITYQUEUE em JAVA
// Ano/S: 2026/1S
// --------------------------------------------------------------------
 
// classe para realização de testes com
// 'Fila' contendo objetos 'Integer'
// ------------------------------------

// importação para permitir o uso de 'ArrayDeque'
import java.util.ArrayDeque;
// importação para permitir o uso de 'iterator'
import java.util.Iterator;

public class TesteFilaIntegersArrayDeque {

    // método da classe para realização do teste
    // -----------------------------------------
    public void executaTeste() {
        
        // declaração de variáveis auxiliares para a manipulação da 'Fila'
        int valor;
        int qtdOperacoes;
        
        // declaração de constante para indicar nível de 'verbosidade'
        final boolean VERBOSO = true;
        
        // instanciação de um objeto da classe 'MetodosAvulsos'
        // para poder acessar o método 'geraNumeroRandomico'
        MetodosAvulsos avulso = new MetodosAvulsos();
        
        // FILA por meio de ARRAYDEQUE
        // ---------------------------
        System.out.println("\nFILA por meio de ARRAYDEQUE");
        System.out.println(  "---------------------------");
        
        // instanciação de um objeto da classe 'ArrayDeque'
        // para armazenar 'Integer' (inicialmente vazio)
        ArrayDeque<Integer> numerosD = new ArrayDeque<>();
        
        // obtenção da quantidade de operações desejada
        // - valor aleatório entre 15 e 20
        qtdOperacoes = avulso.geraNumeroRandomico2( 15, 20 );
        System.out.printf("Qtd. operações a realizar na Fila: %2d\n",qtdOperacoes);
        
        // armazenamento e manipulação da 'Fila'
        // - valores aleatórios entre 10 e 99
        // - fazer 4 operações de inserção ('offer') e uma de remoção ('poll')
        for ( int i = 1; i <= qtdOperacoes; i++ ) {
            
            // verifica se deve inserir ou remover
            if ( (i % 5) != 0 ) {
                
                // INSERIR ('offer')
                // obtém o valor a ser armazenado (aleatório)
                valor = avulso.geraNumeroRandomico2( 10, 99 );
                if ( VERBOSO ) {
                    System.out.printf("Operação %2d - INSERÇÃO (offer) - Valor: %2d",i,valor);
                }
                // na 'Fila' a inserção ocorre sempre numa extremidade ...
                numerosD.offer( valor );
            }
            else {
                
                // REMOVER ('poll')
                if ( VERBOSO ) {
                    System.out.printf("Operação %2d - REMOÇÃO (poll)  - Valor: ",i);
                }
                // na 'Fila' a remoção ocorre sempre na outra extremidade ...
                valor = numerosD.poll();
                if ( VERBOSO ) {
                    System.out.printf("%2d",valor);
                }
            }
            if ( VERBOSO ) {
                System.out.println(" - 'numerosD' -> " + numerosD);
            }
        }
        
        // exibição da quantidade de elementos efetivamente armazenados
        System.out.printf("Qtd. elementos restantes na Fila        : %2d\n", numerosD.size());
        System.out.printf("Valor do próximo elemento a ser atendido: %2d\n", numerosD.peek());
        
        // exibição direta do conteúdo da 'Fila' (usa o método 'toString')
        System.out.println("Exibição direta                : " + numerosD);
        
        // exibição do conteúdo da 'Fila' por meio de 'iterator'
        System.out.print("Exibição via 'iterator'        : [ ");
        Iterator< Integer > iteradorF = numerosD.iterator();
        while ( iteradorF.hasNext() ) {
            System.out.printf("%2d, ",iteradorF.next());
        }
        System.out.println(" ]");

        // exibicao do conteúdo da 'FILA' POR MEIO de 'forEach' e 'funcao lambda'
        System.out.print("Exibição via 'forEach'        : [ ");
        numerosD.forEach(numero -> System.out.print(" " + numero + ","));
        System.out.println(" ]");
                
    }

}