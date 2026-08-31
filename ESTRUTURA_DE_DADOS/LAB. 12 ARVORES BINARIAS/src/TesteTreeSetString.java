// -----------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : ÁRVORES DE BUSCA BINÁRIA (TREESET E TREEMAP) em JAVA
// Ano/S: 2026/1S
// -----------------------------------------------------------
 
// classe para realização de testes com
// 'TreeSet' contendo objetos 'String'
// ------------------------------------

// importação para permitir o uso de 'Arrays'
import java.util.Arrays;
// importação para permitir o uso de 'Set'
import java.util.Set;
// importação para permitir o uso de 'TreeSet'
import java.util.TreeSet;
// importação para permitir o uso de 'iterator'
import java.util.Iterator;


// código da classe
public class TesteTreeSetString {

    // método da classe para realização do teste
    // -----------------------------------------
    public void executaTeste() {
        
        // declaração de 'arrays' convencionais
        // para armazenar 'String' (assunto: cores)
        // Obs.: inicializado na própria declaração
        //       com algumas repetições de valores
        String[] cores1 = {
            "amarelo", "bege",   "branco", "azul"   ,  "verde",
            "laranja", "marrom", "cinza",  "amarelo", "azul" };
        
        String[] cores2 = {
            "laranja", "marrom",   "verde",    "preto" };
        
        String[] cores3 = {
            "laranja", "marrom",   "vermelho", "amarelo" };
        
        String[] cores4 = {
            "preto",   "vermelho", "violeta",  "cinza" };
                
        // declaração de objetos da classe 'TreeSet'
        // para armazenar 'String' (inicialmente vazio)
        // Obs.: usa 'Set' para ficar mais flexível
        Set<String> conjuntoCores1;
        Set<String> conjuntoCores2;
        Set<String> conjuntoCores3;
        Set<String> conjuntoCores4;
        
        // instanciação e preenchimento dos 'TreeSet' a partir dos 'String[]'
        conjuntoCores1 = new TreeSet<>( Arrays.asList( cores1 ));
        conjuntoCores2 = new TreeSet<>( Arrays.asList( cores2 ));
        conjuntoCores3 = new TreeSet<>( Arrays.asList( cores3 ));
        conjuntoCores4 = new TreeSet<>( Arrays.asList( cores4 ));
        
        // exibição de informações sobre os 'String[]' e os respectivos 'TreeSet'
        exibeStringArray("cores1",cores1);
        exibeTreeSet("conjuntoCores1",conjuntoCores1,1);
        
        exibeStringArray("cores2",cores2);
        exibeTreeSet("conjuntoCores2",conjuntoCores2,1);
        
        exibeStringArray("cores3",cores3);
        exibeTreeSet("conjuntoCores3",conjuntoCores3,1);
        
        exibeStringArray("cores4",cores4);
        exibeTreeSet("conjuntoCores4",conjuntoCores4,1);
        
        // exemplos de métodos aplicáveis a qualquer 'Set' (operações de conjuntos)
        // ------------------------------------------------------------------------
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("Exemplos de métodos aplicáveis a qualquer 'Set' (operações de conjuntos)");
        
        // 1. UNIÃO - método 'addAll'
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("1. Resultado: conjuntoCores2 UNIÃO conjuntoCores3 - método 'addAll'");
        System.out.println("----------");
        System.out.print("Antes  da operação...");
        exibeTreeSet("conjuntoCores2",conjuntoCores2,1);
        exibeTreeSet("conjuntoCores3",conjuntoCores3,1);
        conjuntoCores2.addAll(conjuntoCores3);
        System.out.print("\nDepois da operação...");
        exibeTreeSet("conjuntoCores2",conjuntoCores2,1);
        
        // 2. INTERSEÇÃO - método 'retainAll'
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("2. Resultado: conjuntoCores2 INTERSEÇÃO conjuntoCores4 - método 'retainAll'");
        System.out.println("----------");
        System.out.print("Antes  da operação...");
        exibeTreeSet("conjuntoCores2",conjuntoCores2,1);
        exibeTreeSet("conjuntoCores4",conjuntoCores4,1);
        conjuntoCores2.retainAll(conjuntoCores4);
        System.out.print("\nDepois da operação...");
        exibeTreeSet("conjuntoCores2",conjuntoCores2,1);
        
        // 3. DIFERENÇA - método 'removeAll'
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.println("3. Resultado: conjuntoCores3 DIFERENÇA conjuntoCores2 - método 'removeAll'");
        System.out.println("----------");
        System.out.print("Antes  da operação...");
        exibeTreeSet("conjuntoCores3",conjuntoCores3,1);
        exibeTreeSet("conjuntoCores2",conjuntoCores2,1);
        conjuntoCores3.removeAll(conjuntoCores2);
        System.out.print("\nDepois da operação...");
        exibeTreeSet("conjuntoCores3",conjuntoCores3,1);
        
        // 4a. SUBCONJUNTO - método 'containsAll'
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("4a. Resultado: conjuntoCores2 É SUBCONJUNTO de conjuntoCores1 - método 'containsAll'");
        System.out.println("----------");
        System.out.print("Antes  da operação...");
        exibeTreeSet("conjuntoCores2",conjuntoCores2,1);
        exibeTreeSet("conjuntoCores1",conjuntoCores1,1);
        System.out.println("\nResposta  : " + conjuntoCores1.containsAll(conjuntoCores2));
        
        // 4b. SUBCONJUNTO - método 'containsAll'
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("4b. Resultado: conjuntoCores2 É SUBCONJUNTO de conjuntoCores4 - método 'containsAll'");
        System.out.println("----------");
        System.out.print("Antes  da operação...");
        exibeTreeSet("conjuntoCores2",conjuntoCores2,1);
        exibeTreeSet("conjuntoCores4",conjuntoCores4,1);
        System.out.println("\nResposta  : " + conjuntoCores4.containsAll(conjuntoCores2));        
        
        // exemplos de métodos aplicáveis a 'TreeSet' (mas não a 'Set' !!!)
        // ----------------------------------------------------------------
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Exemplos de métodos aplicáveis a 'TreeSet' (mas não a 'Set' !!!)");
        
        // instanciação e preenchimento de um 'TreeSet'
        TreeSet< String > conjuntoCores11 = new TreeSet<>();
        conjuntoCores11.addAll(conjuntoCores1);        
        exibeTreeSet("conjuntoCores11",conjuntoCores11,1);
        
        // exibição do primeiro ('first') e último ('last') elemento de um 'TreeSet'
        String first11 = conjuntoCores11.first();
        String last11  = conjuntoCores11.last();
        System.out.println("\nO FIRST (primeiro) elemento de conjuntoCores11 é " + first11);
        System.out.println(  "O LAST  (último)   elemento de conjuntoCores11 é " + last11);
        
        // exibição dos valores...
        // - imediatamente abaixo do elemento fornecido: 'lower'  (<) e 'floor'   (<=)
        // - imediatamente acima  do elemento fornecido: 'higher' (>) e 'ceiling' (>=)
        String floor11   = conjuntoCores11.floor  ("branco");
        String ceiling11 = conjuntoCores11.ceiling("branco");
        String lower11   = conjuntoCores11.lower  ("branco");
        String higher11  = conjuntoCores11.higher ("branco");
        System.out.println("\nO FLOOR   em relação a 'branco' em conjuntoCores11 é " + floor11);
        System.out.println(  "O CEILING em relação a 'branco' em conjuntoCores11 é " + ceiling11);
        System.out.println(  "O LOWER   em relação a 'branco' em conjuntoCores11 é " + lower11);
        System.out.println(  "O HIGHER  em relação a 'branco' em conjuntoCores11 é " + higher11);

        floor11   = conjuntoCores11.floor  ("lilás");
        ceiling11 = conjuntoCores11.ceiling("lilás");
        lower11   = conjuntoCores11.lower  ("lilás");
        higher11  = conjuntoCores11.higher ("lilás");
        System.out.println("\nO FLOOR   em relação a 'lilás'  em conjuntoCores11 é " + floor11);
        System.out.println(  "O CEILING em relação a 'lilás'  em conjuntoCores11 é " + ceiling11);
        System.out.println(  "O LOWER   em relação a 'lilás'  em conjuntoCores11 é " + lower11);
        System.out.println(  "O HIGHER  em relação a 'lilás'  em conjuntoCores11 é " + higher11);
        
        // remoção do primeiro ('pollFirst') e do último ('pollLast') elementos de um 'TreeSet'
        String pollFirst11 = conjuntoCores11.pollFirst();
        String pollLast11  = conjuntoCores11.pollLast();
        System.out.println("\nRemovendo o primeiro (POLLFIRST) elemento de conjuntoCores11: " + pollFirst11);
        System.out.println(  "Removendo O último   (POLLLAST)) elemento de conjuntoCores11: " + pollLast11);
        exibeTreeSet("conjuntoCores11",conjuntoCores11,1);
        
        // visão de subconjuntos de um 'TreeSet'
        System.out.print("\nVisão de subconjuntos de um 'TreeSet' - HEADSET 'branco'");
        TreeSet< String > conjuntoCores111 = new TreeSet<>();
        conjuntoCores111.addAll(conjuntoCores11.headSet("branco"));        
        exibeTreeSet("conjuntoCores111",conjuntoCores111,1);
        
        System.out.print("\nVisão de subconjuntos de um 'TreeSet' - TAILSET 'branco'");
        TreeSet< String > conjuntoCores112 = new TreeSet<>();
        conjuntoCores112.addAll(conjuntoCores11.tailSet("branco"));        
        exibeTreeSet("conjuntoCores112",conjuntoCores112,1);
        
        System.out.print("\nVisão de subconjuntos de um 'TreeSet' - SUBSET 'bege'-'marrom'");
        TreeSet< String > conjuntoCores113 = new TreeSet<>();
        conjuntoCores113.addAll(conjuntoCores11.subSet("bege","marrom"));        
        exibeTreeSet("conjuntoCores113",conjuntoCores113,1);
        
    } // fim do método 'executaTeste'
    
    // método auxiliar de impressão de informações sobre 'String[]'
    private void exibeStringArray( String nomeString, String[] dadosString ) {
        
        System.out.printf("\n--------");
        System.out.printf("\nString[] %s: ",nomeString);
        
        // exibição da quantidade de elementos efetivamente armazenados no 'String[]'
        System.out.printf("%2d elementos",dadosString.length);
        
        // exibição do conteúdo do 'String[]' por meio de 'for' convencional
        System.out.printf("\nConteúdo: [",nomeString);
        for ( int i = 0; i < dadosString.length; i++ ) {
            if ( i == 0 ) {
                System.out.printf("%s", dadosString[i]);
            }
            else {
                System.out.printf(", %s",dadosString[i]);                    
            }
        }
        System.out.println("]");

    } // fim do método 'exibeStringArray'
    
    // método auxiliar de impressão de informações sobre 'TreeSet'
    private < T > void exibeTreeSet(
            String   nomeTreeSet,
            Set< T > elementosTreeSet,
            int      modoExibicao ) {
        
        System.out.printf("\n-------");
        System.out.printf("\nTreeSet %s: ",nomeTreeSet);
        
        // exibição da quantidade de elementos efetivamente armazenados no 'TreeSet'
        System.out.printf("%2d elementos", elementosTreeSet.size());
        
        // aciona o modo de exibição solicitado
        switch ( modoExibicao ) {
            case 1:
                // exibição direta do conteúdo do 'TreeSet' (usa o método 'toString')
                System.out.printf("\nConteúdo (exibição direta): ",nomeTreeSet);
                System.out.print(elementosTreeSet);
                break;
            case 2:
                // exibição do conteúdo do 'TreeSet' por meio de 'for' abreviado
                System.out.print("\nConteúdo ('for' abreviado):  ");
                for ( T elem : elementosTreeSet ) {
                    System.out.printf("%s, ",elem);
                }
                break;
            case 3:
                // exibição do conteúdo do 'TreeSet' por meio de 'iterator'
                System.out.print("\nConteúdo ('iterator')     :  ");
                Iterator< T > iteradorA = elementosTreeSet.iterator();
                while ( iteradorA.hasNext() ) {
                    System.out.printf("%s, ",iteradorA.next());
                }
                break;
            case 4:
                // exibição do conteúdo do 'TreeSet' por meio de 'forEach' e 'method reference'
                System.out.println("\nConteúdo ('forEach' + 'method reference'):  ");
                elementosTreeSet.forEach(System.out::println);
                break;
            case 5:
                // exibição do conteúdo do 'TreeSet' por meio de 'forEach' e 'função lambda simples'
                System.out.print("\nConteúdo ('forEach' + 'função lambda simples'):  ");
                elementosTreeSet.forEach(elemento -> System.out.print(" " + elemento + ","));
                break;
            default:
                // nenhum modo de exibição foi especificado...
                System.out.print("\nNenhum modo de exibição do conteúdo foi especificado !!!");
        }
        
        System.out.println();

    } // fim do método 'exibeTreeSet'

}

