// --------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : CONJUNTOS (SET) E DICIONÁRIOS (MAP) em JAVA
// Ano/S: 2026/1S
// --------------------------------------------------
 
// classe para realização de testes com
// 'LinkedHashSet' contendo objetos 'String'
// -----------------------------------------

// importação para permitir o uso de 'Arrays'
import java.util.Arrays;
// importação para permitir o uso de 'Set'
import java.util.Set;
// importação para permitir o uso de 'LinkedHashSet'
import java.util.LinkedHashSet;
// importação para permitir o uso de 'iterator'
import java.util.Iterator;


// código da classe
public class TesteLinkedHashSetString {

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

        // declaração de um objeto da classe 'LinkedHashSet'
        // para armazenar 'String' (inicialmente vazio)
        // Obs.: usa 'Set' para ficar mais genérico (BOA PRÁTICA)
        Set<String> conjuntoCores;
        
        // instanciação e preenchimento do 'LinkedHashSet' a partir do 'String[]' - versão 1
        /*
        conjuntoCores = new LinkedHashSet<>();
        for ( String cor : cores ) {
            conjuntoCores.add(cor);
        }*/
        
        // instanciação e preenchimento do 'LinkedHashSet' a partir do 'String[]' - versão 2
        //conjuntoCores = new LinkedHashSet<>( Arrays.asList( cores ));
        conjuntoCores = new LinkedHashSet<>();
        conjuntoCores.addAll( Arrays.asList( cores ) );

        // exibição da quantidade de elementos efetivamente armazenados no 'LinkedHashSet'
        System.out.printf("\nQtd. elementos no 'LinkedHashSet': %2d", conjuntoCores.size());
        
        // exibição direta do conteúdo do 'LinkedHashSet' (usa o método 'toString')
        System.out.println("\nExibição direta: \n" + conjuntoCores);
        
        // exibição do conteúdo do 'LinkedHashSet' por meio de 'for' convencional
        System.out.println("\nExibição via 'for' convencional: IMPOSSÍVEL, pois 'Set' não tem índice !");
        
        // exibição do conteúdo do 'LinkedHashSet' por meio de 'for' abreviado
        System.out.print("\nExibição via 'for' abreviado:\n[");
        for ( String cor : conjuntoCores ) {
            System.out.printf("%s, ",cor);
        }
        System.out.println("]");
        
        // exibição do conteúdo do 'LinkedHashSet' por meio de 'iterator'
        System.out.print("\nExibição via 'iterator':\n[");
        Iterator< String > iteradorA = conjuntoCores.iterator();
        while ( iteradorA.hasNext() ) {
            System.out.printf("%s, ",iteradorA.next());
        }
        System.out.println("]");
        
    }

}