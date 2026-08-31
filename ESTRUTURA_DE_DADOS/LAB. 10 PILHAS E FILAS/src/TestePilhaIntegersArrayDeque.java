// --------------------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : PILHAS E FILAS BASEADAS EM ARRAYDEQUE E PRIORITYQUEUE em JAVA
// Ano/S: 2026/1S
// --------------------------------------------------------------------
 
// classe para realização de testes com
// 'Pilha' contendo objetos 'Integer'
// ------------------------------------

// importação para permitir o uso de 'ArrayDeque'
import java.util.ArrayDeque;
// importação para permitir o uso de 'iterator'
import java.util.Iterator;

public class TestePilhaIntegersArrayDeque {

    // método da classe para realização do teste
    // -----------------------------------------
    public void executaTeste() {
        
        // declaração de variáveis auxiliares para a manipulação da 'Pilha'
        int valor;
        int qtdOperacoes;
        
        // declaração de constante para indicar nível de 'verbosidade'
        final boolean VERBOSO = true;
        
        // instanciação de um objeto da classe 'MetodosAvulsos'
        // para poder acessar o método 'geraNumeroRandomico'
        MetodosAvulsos avulso = new MetodosAvulsos();
        
        // PILHA por meio de ARRAYDEQUE
        // ----------------------------
        System.out.println("\nPILHA por meio de ARRAYDEQUE");
        System.out.println(  "----------------------------");
        
        // instanciação de um objeto da classe 'Pilha'
        // para armazenar 'Integer' (inicialmente vazio)
        ArrayDeque<Integer> numerosD = new ArrayDeque<>();
        
        // obtenção da quantidade de operações desejada
        // - valor aleatório entre 15 e 20
        qtdOperacoes = avulso.geraNumeroRandomico2( 15, 20 );
        System.out.printf("Qtd. operações a realizar na Pilha: %2d\n",qtdOperacoes);
        
        // armazenamento e manipulação da 'Pilha'
        // - valores aleatórios entre 10 e 99
        // - fazer 4 operações de inserção ('push') e uma de remoção ('pop')
        for ( int i = 1; i <= qtdOperacoes; i++ ) {
            
            // verifica se deve inserir ou remover
            if ( (i % 5) != 0 ) {
                
                // INSERIR ('push')
                // obtém o valor a ser armazenado (aleatório)
                valor = avulso.geraNumeroRandomico2( 10, 99 );
                if ( VERBOSO ) {
                    System.out.printf("Operação %2d - INSERÇÃO (push) - Valor: %2d",i,valor);
                }
                // na 'Pilha' a inserção ocorre sempre no topo ...
                numerosD.push( valor );
            }
            else {
                
                // REMOVER
                if ( VERBOSO ) {
                    System.out.printf("Operação %2d - REMOÇÃO (pop)  - Valor: ",i);
                }
                // na 'Pilha' a remoção refere-se sempre ao elemento que está no topo ...
                valor = numerosD.pop();
                if ( VERBOSO ) {
                    System.out.printf("%2d",valor);
                }
            }
            if ( VERBOSO ) {
                System.out.println(" - 'numerosD' -> " + numerosD);
            }
        }
        
        // exibição da quantidade de elementos efetivamente armazenados
        System.out.printf("Qtd. elementos restantes na Pilha   : %2d\n", numerosD.size());
        System.out.printf("Valor do elemento do topo da Pilha  : %2d\n", numerosD.peek());
        
        // exibição direta do conteúdo da 'Pilha' (usa o método 'toString')
        System.out.println("Exibição direta                : " + numerosD);
        
        // exibição do conteúdo da 'Pilha' por meio de 'iterator'
        System.out.print("Exibição via 'iterator'        : [ ");
        Iterator< Integer > iteradorP = numerosD.iterator();
        while ( iteradorP.hasNext() ) {
            System.out.printf("%2d, ",iteradorP.next());
        }
        System.out.println(" ]");

        // exibição do conteúdo da 'Pilha' por meio de 'forEach' e 'method reference'
        System.out.print("Exibição via 'forEach'        : [ ");
        numerosD.forEach(System.out::println);
        System.out.println(" ]");
                
    }

}