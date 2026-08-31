// --------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : CONJUNTOS (SET) E DICIONÁRIOS (MAP) em JAVA
// Ano/S: 2026/1S
// --------------------------------------------------

// importação para permitir o uso de 'Map'
import java.util.Map;
// importação para permitir o uso de 'LinkedHashMap'
import java.util.LinkedHashMap;
// importação para permitir o uso de 'iterator'
import java.util.Iterator;

public class TesteLinkedHashMapCaracteresQtds {
    
    // método da classe para realização do teste
    // -----------------------------------------
    public void executaTeste() {

        // Criando o mapa: Chave (Character = Caractere), Valor (Integer = Quantidade)
        Map<Character, Integer> caracteresQtds;
            
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

        // instanciação e preenchimento do 'LinkedHashMap'
        caracteresQtds = new LinkedHashMap<>();
           
        // armazenando a quantidade de caracteres
        for (Character caractere : frasePreparada) {
           caracteresQtds.put(caractere, caracteresQtds.getOrDefault(caractere, 0) + 1);
        }

        // exibição da quantidade de elementos efetivamente armazenados no 'LinkedHashMap'
        System.out.printf("\nQtd. elementos no 'LinkedHashMap': %2d\n", caracteresQtds.size());

        // exibição direta do conteúdo do 'LinkedHashMap' (usa o método 'toString')
        System.out.println("\nExibição direta: \n" + caracteresQtds);

        // exibição do conteúdo do 'LinkedHashMap' por meio de 'for' convencional
        System.out.println("\nExibição via 'for' convencional: IMPOSSÍVEL, pois 'Map' não tem índice !");

        // exibição do conteúdo do 'LinkedHashMap' por meio de 'for' abreviado sobre as entradas (Entry)
        System.out.print("\nExibição via 'for' abreviado (Entry Set):\n[");
        for ( Map.Entry<Character, Integer> entrada : caracteresQtds.entrySet() ) {
            System.out.printf("%s=%d, ", entrada.getKey(), entrada.getValue());
        }
        System.out.println("]");

        // exibição do conteúdo do 'LinkedHashMap' por meio de 'iterator' sobre as chaves (KeySet)
        System.out.print("\nExibição via 'iterator' (Key Set):\n[");
        Iterator<Character> iteradorChaves = caracteresQtds.keySet().iterator();
        while ( iteradorChaves.hasNext() ) {
            Character chave = iteradorChaves.next();
            System.out.printf("%s=%d, ", chave, caracteresQtds.get(chave));
        }
        System.out.println("]");

    }

}