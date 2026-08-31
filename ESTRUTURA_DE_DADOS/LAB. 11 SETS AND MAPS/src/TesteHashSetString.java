// --------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : CONJUNTOS (SET) E DICIONÁRIOS (MAP) em JAVA
// Ano/S: 2026/1S
// --------------------------------------------------
 
// classe para realização de testes com
// 'HashSet' contendo objetos 'String'
// ------------------------------------

// importação para permitir o uso de 'Arrays'
import java.util.Arrays;
// importação para permitir o uso de 'Set'
import java.util.Set;
// importação para permitir o uso de 'HashSet'
import java.util.HashSet;
// importação para permitir o uso de 'iterator'
import java.util.Iterator;


// código da classe
public class TesteHashSetString {

    // método da classe para realização do teste
    // -----------------------------------------
    public void executaTeste() {
        
        // declaração de um 'array' convencional
        // para armazenar 'String' (assunto: cores)
        // Obs.: inicializado na própria declaração
        //       com algumas repetições de valores
        String[] cores = {
            "amarelo", "bege",   "branco", "azul",  "cinza",
            "laranja", "marrom", "verde",  "preto", "vermelho",
            "amarelo", "azul",   "branco", "bege",  "cinza",    "violeta" };
        
        // exibição da quantidade de elementos efetivamente armazenados no 'String[]'
        System.out.printf("\nQtd. elementos no 'String[]': %2d", cores.length);
        
        // exibição do conteúdo do 'String[]' por meio de 'for' convencional
        System.out.print("\nExibição do 'String[]' via 'for' convencional:\n[ ");
        for ( int i = 0; i < cores.length; i++ ) {
            if ( i == 0 ) {
                System.out.printf("%s", cores[i]);
            }
            else {
                System.out.printf(", %s",cores[i]);                    
            }
        }
        System.out.println(" ]");

        // declaração de um objeto da classe 'HashSet'
        // para armazenar 'String' (inicialmente vazio)
        // Obs.: usa 'Set' para ficar mais genérico
        Set<String> conjuntoCores;
        
        // instanciação e preenchimento do 'HashSet' a partir do 'String[]' - versão 1   
        conjuntoCores = new HashSet<>();
        System.out.println("\nExibindo os 'hashCode' de cada elemento a ser inserido no 'HashSet'...");
        for ( String cor : cores ) {
            System.out.printf("Elemento %-10s - hashCode %12d\n", cor, cor.hashCode());
            conjuntoCores.add(cor);
        }
        
        // exibição da quantidade de elementos efetivamente armazenados no 'HashSet'
        System.out.printf("\nQtd. elementos no 'HashSet': %2d", conjuntoCores.size());
        
        // exibição direta do conteúdo do 'HashSet' (usa o método 'toString')
        System.out.println("\nExibição direta: \n" + conjuntoCores);
        
        // exibição do conteúdo do 'HashSet' por meio de 'for' convencional
        System.out.println("\nExibição via 'for' convencional: IMPOSSÍVEL, pois 'Set' não tem índice !");
        
        // exibição do conteúdo do 'HashSet' por meio de 'for' abreviado
        System.out.print("\nExibição via 'for' abreviado:\n[");
        for ( String cor : conjuntoCores ) {
            System.out.printf("%s, ",cor);
        }
        System.out.println("]");
        
        // exibição do conteúdo do 'HashSet' por meio de 'iterator'
        System.out.print("\nExibição via 'iterator':\n[");
        Iterator< String > iteradorA = conjuntoCores.iterator();
        while ( iteradorA.hasNext() ) {
            System.out.printf("%s, ",iteradorA.next());
        }
        System.out.println("]");

        // se quiser exibição CLASSIFICADA do conteúdo do 'HashSet',
        // é necessário:
        // 1. transferir o conteúdo para um 'array'
        String[] vetorSet = new String[conjuntoCores.size()];
        conjuntoCores.toArray(vetorSet);
        // 1 (cont.) exibição do 'array' assim construído
        System.out.println("\nApós a cópia para vetor ...");
        System.out.print("Conteúdo de 'vetorSet' : [");
        for ( String cor : vetorSet ) {
            System.out.printf(" %s,",cor);
        } 
        System.out.println(" ]");
        // 2. efetuar a classificação do 'array' por meio do método 'sort'
        //    da classe estática 'Arrays'
        Arrays.sort(vetorSet);
        // 2. (cont.) exibição do 'array' classificado
        System.out.println("\nApós a classificação ...");
        System.out.print("Conteúdo de 'vetorSet' : [");
        for ( String cor : vetorSet ) {
            System.out.printf(" %s,",cor);
        } 
        System.out.println(" ]");

        // OBSERVAÇÃO - outra maneira de povoar o 'HashSet'
        // instanciação e preenchimento do 'HashSet' a partir do 'String[]' - versão 2
        Set<String> conjuntoCores2 = new HashSet<>();
        conjuntoCores2.addAll(Arrays.asList( cores ));
        // exibição do 'HashSet' assim criado
        System.out.printf("\nQtd. elementos no 'HashSet' 2: %2d", conjuntoCores2.size());
        System.out.println("\nExibição direta 2: \n" + conjuntoCores);        
                
    }

}