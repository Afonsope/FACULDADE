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
public class TesteHashSetPalavrasFrase {

    // método da classe para realização do teste
    // -----------------------------------------
    public void executaTeste() {
        
        // frase a ser analisada ('String' comum)
        String fraseOriginal =
                "O professor Carlos é o professor de Estruturas de Dados no curso de INFO " +
                "e também é o professor de Estruturas de Dados no curso de ADS";

        // exibição da 'String' com a frase original
        System.out.printf("\nFrase original:\n%s\n", fraseOriginal);
        
        // frase preparada ('array' convencional de 'Strings')
        String[] frasePreparada = fraseOriginal.split("\\s"); // critério: espaço em branco
        
        // exibição da quantidade TOTAL de palavras da frase original
        System.out.printf("\nQtd. TOTAL de palavras da frase: %3d", frasePreparada.length);
        
        // exibição do conteúdo do 'String[]' por meio de 'for' convencional
        System.out.print("\nExibição do 'String[]' de palavras da frase via 'for' convencional:\n[ ");
        for ( int i = 0; i < frasePreparada.length; i++ ) {
            if ( i == 0 ) {
                System.out.printf("%s", frasePreparada[i]);
            }
            else {
                System.out.printf(", %s",frasePreparada[i]);                    
            }
        }
        System.out.println(" ]");

        // declaração de um objeto da classe 'HashSet'
        // para armazenar 'String' (inicialmente vazio)
        // Obs.: usa 'Set' para ficar mais genérico
        Set<String> conjuntoPalavras;
        
        // instanciação e preenchimento do 'HashSet' a partir do 'String[]' - versão 1
        /*
        conjuntoPalavras = new HashSet<>();
        for ( String palavra : frasePreparada ) {
            conjuntoPalavras.add(palavra);
        }*/
        
        // instanciação e preenchimento do 'HashSet' a partir do 'String[]' - versão 2
        conjuntoPalavras = new HashSet<>( Arrays.asList( frasePreparada ));
        
        // exibição da quantidade de elementos efetivamente armazenados no 'HashSet'
        System.out.printf("\nQtd. elementos no 'HashSet': %2d", conjuntoPalavras.size());
        
        // exibição direta do conteúdo do 'HashSet' (usa o método 'toString')
        System.out.println("\nExibição direta: \n" + conjuntoPalavras);
        
        // exibição do conteúdo do 'HashSet' por meio de 'for' convencional
        System.out.println("\nExibição via 'for' convencional: IMPOSSÍVEL, pois 'Set' não tem índice !");
        
        // exibição do conteúdo do 'HashSet' por meio de 'for' abreviado
        System.out.print("\nExibição via 'for' abreviado:\n[");
        for ( String palavra : conjuntoPalavras ) {
            System.out.printf("%s, ",palavra);
        }
        System.out.println("]");
        
        // exibição do conteúdo do 'HashSet' por meio de 'iterator'
        System.out.print("\nExibição via 'iterator':\n[");
        Iterator< String > iteradorA = conjuntoPalavras.iterator();
        while ( iteradorA.hasNext() ) {
            System.out.printf("%s, ",iteradorA.next());
        }
        System.out.println("]");
        
    }

}