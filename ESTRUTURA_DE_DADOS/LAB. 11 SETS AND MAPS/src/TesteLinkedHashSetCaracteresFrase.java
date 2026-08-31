// --------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : CONJUNTOS (SET) E DICIONÁRIOS (MAP) em JAVA
// Ano/S: 2026/1S
// --------------------------------------------------
 
// classe para realização de testes com
// 'LinkedHashSet' contendo objetos 'Character'
// --------------------------------------------

// importação para permitir o uso de 'Set'
import java.util.Set;
// importação para permitir o uso de 'LinkedHashSet'
import java.util.LinkedHashSet;
// importação para permitir o uso de 'iterator'
import java.util.Iterator;


// código da classe
public class TesteLinkedHashSetCaracteresFrase {

    // método da classe para realização do teste
    // -----------------------------------------
    public void executaTeste() {
        
        // frase a ser analisada ('String' comum)
        String fraseOriginal =
                "O professor Carlos é o professor de Estruturas de Dados no curso de INFO " +
                "e também é o professor de Estruturas de Dados no curso de ADS";

        // exibição da 'String' com a frase original
        System.out.printf("\nFrase original:\n%s\n", fraseOriginal);
        
        // frase preparada ('array' convencional 'char[]')
        char[] frasePreparada = new char[ fraseOriginal.length() ];
        fraseOriginal.getChars( 
                0,
                fraseOriginal.length(),
                frasePreparada,
                0 );
        
        // exibição da quantidade TOTAL de caracteres da frase original
        System.out.printf("\nQtd. TOTAL de caracteres da frase: %3d", frasePreparada.length);
        
        // exibição do conteúdo do 'char[]' por meio de 'for' convencional
        System.out.print("\nExibição do 'char[]' de caracteres da frase via 'for' convencional:\n[ ");
        for ( int i = 0; i < frasePreparada.length; i++ ) {
            if ( i == 0 ) {
                System.out.printf("%s", frasePreparada[i]);
            }
            else {
                System.out.printf(", %s",frasePreparada[i]);                    
            }
        }
        System.out.println(" ]");

        // declaração de um objeto da classe 'LinkedHashSet'
        // para armazenar 'Character' (inicialmente vazio)
        // Obs.: usa 'Set' para ficar mais genérico
        Set<Character> conjuntoCaracteres;
        
        // instanciação e preenchimento do 'LinkedHashSet' a partir do 'char[]'
        conjuntoCaracteres = new LinkedHashSet<>();
        for ( Character caracter : frasePreparada ) {
            conjuntoCaracteres.add(caracter);
        }
        
        // exibição da quantidade de elementos efetivamente armazenados no 'LinkedHashSet'
        System.out.printf("\nQtd. elementos no 'LinkedHashSet': %2d", conjuntoCaracteres.size());
        
        // exibição direta do conteúdo do 'LinkedHashSet' (usa o método 'toString')
        System.out.println("\nExibição direta: \n" + conjuntoCaracteres);
        
        // exibição do conteúdo do 'LinkedHashSet' por meio de 'for' convencional
        System.out.println("\nExibição via 'for' convencional: IMPOSSÍVEL, pois 'Set' não tem índice !");
        
        // exibição do conteúdo do 'LinkedHashSet' por meio de 'for' abreviado
        System.out.print("\nExibição via 'for' abreviado:\n[");
        for ( Character caracter : conjuntoCaracteres ) {
            System.out.printf("%s, ",caracter);
        }
        System.out.println("]");
        
        // exibição do conteúdo do 'LinkedHashSet' por meio de 'iterator'
        System.out.print("\nExibição via 'iterator':\n[");
        Iterator< Character > iteradorA = conjuntoCaracteres.iterator();
        while ( iteradorA.hasNext() ) {
            System.out.printf("%s, ",iteradorA.next());
        }
        System.out.println("]");
        
    }

}