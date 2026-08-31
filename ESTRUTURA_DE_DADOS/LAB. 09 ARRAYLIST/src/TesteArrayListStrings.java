// ----------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : ARRANJOS DINÂMICOS em JAVA
// Ano/S: 2026/1S
// ----------------------------------------

// classe para realização de testes com
// 'ArrayList' contendo objetos 'String'
// -------------------------------------

// importação para permitir o uso de 'ArrayList'
import java.util.ArrayList;
// importação para permitir o uso de 'sort'
import java.util.Collections;


public class TesteArrayListStrings {
    
    // atributo: vetor de String com os nomes para testes (constantes)
    private final String[] BASE_NOMES = {
        "Adriana",   "Bernardo", "Carlos",  "Danila",   "Enzo",    "Flávia",
        "Guilherme", "Helga",    "Inácio",  "José",     "Kauan",   "Luísa",
        "Marcos",    "Nicolas",  "Oswaldo", "Pietra",   "Quirino", "Roberta",
        "Sandra",    "Túlio",    "Ulisses", "Vinícius", "Wilson",  "Ximena",
        "Yasmin",    "Zélia"
    };

    // atributo: qtd de elementos a armazenar no 'ArrayList'
    final int QTD_ELEMENTOS = 12;

    // método da classe para realização do teste
    public void executaTeste() {
        
        // instanciação de um objeto da classe 'ArrayList'
        // para armazenar 'String' (inicialmente vazio, mas
        // com capacidade previamente definida para QTD_ELEMENTOS elementos)
        // -> usar o construtor de 'ArrayList' adequado para este caso
        ArrayList<String> nomes = new ArrayList<String>(QTD_ELEMENTOS);
        
        // instanciação de um objeto da classe 'MetodosAvulsos'
        // para poder acessar o método 'geraNumeroRandomico'
        MetodosAvulsos avulso = new MetodosAvulsos();
        
        // armazenamento no 'ArrayList'
        // - valores arbitrários (nomes)
        // - posição arbitrária em uma dentre 4 inserções
        // declaração de variável auxiliar para posição em BASE_NOMES
        int posicao_base;
        for( int posicao = 0; posicao < QTD_ELEMENTOS; posicao++ ) {
            // sorteia a posição em BASE_NOMES
            // que fornece o nome a ser inserido no 'ArrayList'
            posicao_base = avulso.geraNumeroRandomico(0,BASE_NOMES.length-1);

            String nomeAInserir = BASE_NOMES[posicao_base];

            // SE QUISER PROIBIR NOMES REPETIDOS NO 'ARRAYLIST'
            while(nomes.contains(nomeAInserir)) {
                posicao_base = avulso.geraNumeroRandomico(0,BASE_NOMES.length-1);
                nomeAInserir = BASE_NOMES[posicao_base];
            }

            // insere o respectivo nome no 'ArrayList'
            nomes.add(BASE_NOMES[posicao_base]);

            // exibição do conteúdo do 'ArrayList' até o momento
            System.out.printf("Nome %10s incluído na posição %2d do 'ArrayList'\n",
                                     BASE_NOMES[posicao_base],posicao);

        }
        
        // exibição da quantidade de elementos efetivamente armazenados
        System.out.println("\nQtd. elementos armazenados no 'ArrayList': " + nomes.size());
        
        // exibição do conteúdo do 'ArrayList'
        System.out.println("Conteúdo do 'ArrayList' após todas as inserções:");
        System.out.println(nomes);
        
        // classificação dos elementos do 'ArrayList'
        Collections.sort(nomes);
        
        // exibição do conteúdo do 'ArrayList'
        System.out.println("\nConteúdo do 'ArrayList' após a classificação:");
        System.out.println(nomes);
        
        // realização de buscas por:
        // - nomes efetivamente armazenados no 'ArrayList'
        // - nomes não armazenados no 'ArrayList'
        // SUGESTÃO DE ESTRATÉGIA:
        // - percorrer a lista com todos os nomes para testes ('BASE_NOMES')
        // - verificar, para cada um, se ele está armazenado no 'ArrayList'
        // - utilizar os métodos de 'ArrayList': 'contains', 'indexOf' e 'lastIndexOf'
        for ( posicao_base = 0; posicao_base < BASE_NOMES.length; posicao_base++ ) {

            System.out.println("\nNome inspecionado: " + BASE_NOMES[posicao_base]);
            if ( nomes.contains(BASE_NOMES[posicao_base]) ) {
                // exibe a posição da primeira ocorrência no 'ArrayList'
                System.out.println("Primeira ocorrência na posição " + nomes.indexOf(BASE_NOMES[posicao_base]));
                // exibe a posição da última   ocorrência no 'ArrayList'
                System.out.println("Última   ocorrência na posição " + nomes.lastIndexOf(BASE_NOMES[posicao_base]));
            }
            else {
                // avisa que o nome não foi encontrado no 'ArrayList'
                System.out.println("Não encontrado!");
            }
        }
        
    }

}

