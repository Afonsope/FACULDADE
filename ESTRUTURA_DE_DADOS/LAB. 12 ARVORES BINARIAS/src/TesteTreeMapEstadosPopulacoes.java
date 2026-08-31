// -----------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : ÁRVORES DE BUSCA BINÁRIA (TREESET E TREEMAP) em JAVA
// Ano/S: 2026/1S
// -----------------------------------------------------------
 
// classe para realização de testes com
// 'TreeMap' contendo objetos 'String'
// ------------------------------------

// importação para permitir o uso de 'Map'
import java.util.Map;
// importação para permitir o uso de 'HashMap'
import java.util.HashMap;
// importação para permitir o uso de 'LinkedHashMap'
import java.util.LinkedHashMap;
// importação para permitir o uso de 'TreeMap'
import java.util.TreeMap;
// importação para permitir o uso de 'iterator'
import java.util.Iterator;
// importações para permitir o uso de arquivos
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


// código da classe
public class TesteTreeMapEstadosPopulacoes {

    // método da classe para realização do teste
    // -----------------------------------------
    public void executaTeste() {
                        
        // declaração de objetos da classe 'Map'
        // para armazenar <'String','Integer'> (inicialmente vazio)
        // Obs.: usa 'Map' para ficar mais genérico
        Map<String,Integer> estadosPopulacoes1;   // este será 'LinkedHashMap'
        Map<String,Integer> estadosPopulacoes2;   // este será 'HashMap'
        Map<String,Integer> estadosPopulacoes3;   // este será 'TreeMap'
        
        // obtenção dos dados dos <Estados,Populações> por LEITURA DE ARQUIVO TXT
        // os dados já virão na forma de um 'LinkedHashMap<String,Integer>'
        estadosPopulacoes1 = new LinkedHashMap<>( obtemDados() );
   
        // instanciação e preenchimento do 'HashMap' e do 'TreeMap' a partir do 'LinkedHashMap'
        estadosPopulacoes2 = new HashMap<>( estadosPopulacoes1 );
        estadosPopulacoes3 = new TreeMap<>( estadosPopulacoes2 );
        
        // exibição de informações sobre os 'Map'
        exibeMap("LinkedHashMap","estadosPopulacoes1",estadosPopulacoes1,3);
        exibeMap("HashMap","estadosPopulacoes2",estadosPopulacoes2,3);
        exibeMap("TreeMap","estadosPopulacoes3",estadosPopulacoes3,3);
                
    } // fim do método 'executaTeste'
    
    // Método 'obtemDados'
    // Acessa arquivo txt no disco e retorna os dados lidos
    // na forma de um 'LinkedHashMap<String,Integer>'
    // ----------------------------------------------------
    public LinkedHashMap<String,Integer> obtemDados() {
        
        // declaração e instanciação de um objeto da classe 'LinkedHashMap'
        // para armazenar pares (estado,população) (inicialmente vazio)
        LinkedHashMap<String,Integer> dadosEstadosPopulacoes = new LinkedHashMap<>();
        
        // bloco try-catch
        try {
            
            // abertura do arquivo
            File arquivo = new File("Estados_Populacoes.txt");
            
            // associação do ponteiro de leitura com o arquivo aberto
            Scanner leitura = new Scanner(arquivo,"CP850");
            
            // leitura (enquanto houver dados)
            while (leitura.hasNextLine()) {
                
                // leitura do estado e da respectiva população nesta linha
                String  estado    = leitura.next();
                int populacao = leitura.nextInt();
                
                // inserção no 'LinkedHashMap'
                dadosEstadosPopulacoes.put(estado,populacao);

                //avança para a próxima linha do arquivo
                leitura.nextLine();
            }
            
            // fecha o ponteiro de leitura, fechando assim o arquivo
            leitura.close();
        // trata o erro, se houver
        } catch (FileNotFoundException e) {
            System.out.println("ERRO no acesso ao arquivo Estados_Populacoes.txt!");
            e.printStackTrace();
        }
        
        return dadosEstadosPopulacoes;
        
    }  // fim do método 'obtemDados'
    
    // método auxiliar de impressão de informações sobre 'Map'
    private < K,V > void exibeMap(
            String     tipoMap,
            String     nomeMap,
            Map< K,V > elementosMap,
            int        modoExibicao ) {
        
        System.out.printf("\nMap %s: - tipo: %s",nomeMap,tipoMap);
        System.out.printf("\n-------");
        
        // exibição da quantidade de elementos efetivamente armazenados no 'Map'
        System.out.printf("\nQtd. elems.: %2d", elementosMap.size());
        
        // aciona o modo de exibição solicitado
        switch ( modoExibicao ) {
            case 1:
                // exibição direta do conteúdo do 'Map' (usa o método 'toString')
                System.out.printf("\nConteúdo (exibição direta): ",nomeMap);
                System.out.print(elementosMap);
                break;
            case 2:
                // exibição do conteúdo do 'Map' por meio de 'for' abreviado
                System.out.print("\nConteúdo ('for' abreviado usando 'keySet'): {\n");
                for ( K key : elementosMap.keySet() ) {
                    System.out.printf(" %-20s: %2d\n",key,elementosMap.get(key));
                }
                System.out.println("}");
                break;
            case 3:
                // exibição do conteúdo do 'Map' por meio de 'iterator'
                System.out.print("\nConteúdo ('iterator'): {\n");
                Iterator< Map.Entry<K,V> > iteradorA = elementosMap.entrySet().iterator();
                while ( iteradorA.hasNext() ) {
                    Map.Entry<K,V> entry = iteradorA.next();
                    System.out.printf(" %-20s: %2d\n",entry.getKey(),entry.getValue());
                }
                System.out.println("}");
                break;
            default:
                // nenhum modo de exibição foi especificado...
                System.out.print("\nNenhum modo de exibição do conteúdo foi especificado !!!");
        }
        
        System.out.println();

    } // fim do método 'exibeMap'

}

