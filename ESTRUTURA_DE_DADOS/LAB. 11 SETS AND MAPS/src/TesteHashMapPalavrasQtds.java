// --------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : CONJUNTOS (SET) E DICIONÁRIOS (MAP) em JAVA
// Ano/S: 2026/1S
// --------------------------------------------------

// importação para permitir o uso de 'Map'
import java.util.Map;
// importação para permitir o uso de 'HashMap'
import java.util.HashMap;
// importação para permitir o uso de 'iterator'
import java.util.Iterator;

public class TesteHashMapPalavrasQtds {
    
    // método da classe para realização do teste
    // -----------------------------------------
    public void executaTeste() {

        // Criando o mapa: Chave (String = Palavra), Valor (Integer = Quantidade)
        Map<String, Integer> palavrasQtds;
            
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

        // instanciação e preenchimento do 'HashMap'
        palavrasQtds = new HashMap<>();
           
        //armazenando a quantidade de palavras
        for (String qtdPalavra : frasePreparada) {
           palavrasQtds.put(qtdPalavra, palavrasQtds.getOrDefault(qtdPalavra, 0) + 1);
        }

        // exibição da quantidade de elementos efetivamente armazenados no 'HashMap'
        System.out.printf("\nQtd. elementos no 'HashMap': %2d\n", palavrasQtds.size());

        // exibição direta do conteúdo do 'HashMap' (usa o método 'toString')
        System.out.println("\nExibição direta: \n" + palavrasQtds);

        // exibição do conteúdo do 'HashMap' por meio de 'for' convencional
        System.out.println("\nExibição via 'for' convencional: IMPOSSÍVEL, pois 'Map' não tem índice !");

        // exibição do conteúdo do 'HashMap' por meio de 'for' abreviado sobre as entradas (Entry)
        System.out.print("\nExibição via 'for' abreviado (Entry Set):\n[");
        for ( Map.Entry<String, Integer> entrada : palavrasQtds.entrySet() ) {
            System.out.printf("%s=%d, ", entrada.getKey(), entrada.getValue());
        }
        System.out.println("]");

        // exibição do conteúdo do 'HashMap' por meio de 'iterator' sobre as chaves (KeySet)
        System.out.print("\nExibição via 'iterator' (Key Set):\n[");
        Iterator<String> iteradorChaves = palavrasQtds.keySet().iterator();
        while ( iteradorChaves.hasNext() ) {
            String chave = iteradorChaves.next();
            System.out.printf("%s=%d, ", chave, palavrasQtds.get(chave));
        }
        System.out.println("]");

    }

}