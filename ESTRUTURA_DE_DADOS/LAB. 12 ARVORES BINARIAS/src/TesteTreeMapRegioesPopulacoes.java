// -----------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : ÁRVORES DE BUSCA BINÁRIA (TREESET E TREEMAP) em JAVA
// Ano/S: 2026/1S
// -----------------------------------------------------------

// classe para realização de testes com
// 'TreeMap' contendo pares (região, população acumulada)
// -------------------------------------------------------

// importações para uso de Map e suas implementações
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
// importações para leitura de arquivo
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
// importação para uso de Comparator
import java.util.Comparator;


public class TesteTreeMapRegioesPopulacoes {

    // -------------------------------------------------------
    // método principal: orquestra toda a atividade
    // -------------------------------------------------------
    public void executaTeste() {

        // PASSO 1: Ler o arquivo e acumular as populações por região
        // Resultado: um HashMap<String, Integer> onde:
        //   - chave  = região  (ex: "Sudeste")
        //   - valor  = soma das populações de todos os estados daquela região
        HashMap<String, Integer> dadosPorRegiao = obtemDados();

        // PASSO 2: Construir TreeMap ordenado por REGIÃO (chave)
        // O TreeMap<String, Integer> sem Comparator já ordena
        // alfabeticamente pela chave por padrão (ordem natural de String)
        Map<String, Integer> treemapPorRegiao = new TreeMap<>(dadosPorRegiao);

        // PASSO 3: Construir TreeMap ordenado por POPULAÇÃO (valor)
        // Como TreeMap só ordena por chave, usamos um Comparator que,
        // ao comparar duas regiões (chaves), busca suas populações no
        // mapa acumulado e compara pelos valores.
        // O 'dadosPorRegiao' é acessível aqui por ser uma variável local
        // capturada pela expressão lambda (Comparator).
        Comparator<String> comparadorPorPopulacao = (regiao1, regiao2) -> {
            // busca a população de cada região no mapa acumulado
            int pop1 = dadosPorRegiao.get(regiao1);
            int pop2 = dadosPorRegiao.get(regiao2);

            // se as populações forem iguais, desempata pela região (evita perda de chave)
            if (pop1 != pop2) {
                return pop1 - pop2; // crescente: menor população primeiro
            } else {
                return regiao1.compareTo(regiao2);
            }
        };

        // instancia o TreeMap passando o Comparator já definido
        Map<String, Integer> treemapPorPopulacao = new TreeMap<>(comparadorPorPopulacao);
        // insere todos os dados do mapa acumulado neste TreeMap
        treemapPorPopulacao.putAll(dadosPorRegiao);

        // PASSO 4: Exibir os dois TreeMaps
        System.out.println("\n--- TreeMap 1: ordenado por REGIÃO (ordem alfabética) ---");
        exibeMap(treemapPorRegiao);

        System.out.println("\n--- TreeMap 2: ordenado por POPULAÇÃO (crescente) ---");
        exibeMap(treemapPorPopulacao);

    } // fim do método 'executaTeste'


    // -------------------------------------------------------
    // Lê o arquivo e acumula as populações por região
    // Retorna um HashMap<região, populaçãoAcumulada>
    // -------------------------------------------------------
    public HashMap<String, Integer> obtemDados() {

        // mapa que irá acumular as populações por região
        HashMap<String, Integer> dadosPorRegiao = new HashMap<>();

        try {
            // abre o arquivo com os três campos por linha
            File arquivo = new File("Estados_Regioes_Populacoes.txt");
            Scanner leitura = new Scanner(arquivo, "CP850");

            while (leitura.hasNextLine()) {
                // lê os três campos da linha atual
                // o nome do estado é descartado (não é necessário para o mapa)
                leitura.next();
                String regiao    = leitura.next();
                int    populacao = leitura.nextInt();

                // LÓGICA DE ACUMULAÇÃO:
                // verifica se essa região já foi inserida no mapa
                if (dadosPorRegiao.containsKey(regiao)) {
                    // região já existe → soma a nova população à existente
                    int populacaoAcumulada = dadosPorRegiao.get(regiao);
                    dadosPorRegiao.put(regiao, populacaoAcumulada + populacao);
                } else {
                    // região nova → insere com a população deste estado
                    dadosPorRegiao.put(regiao, populacao);
                }

                leitura.nextLine(); // avança para a próxima linha
            }

            leitura.close();

        } catch (FileNotFoundException e) {
            System.out.println("ERRO: arquivo 'Estados_Regioes_Populacoes.txt' não encontrado!");
            e.printStackTrace();
        }

        return dadosPorRegiao;

    } // fim do método 'obtemDados'


    // -------------------------------------------------------
    // Exibe o conteúdo de um Map usando Iterator
    // Mostra chave (região) e valor (população acumulada)
    // -------------------------------------------------------
    private void exibeMap(Map<String, Integer> mapa) {

        System.out.printf("Qtd. de regiões: %d\n", mapa.size());
        System.out.println("{");

        Iterator<Map.Entry<String, Integer>> iterador = mapa.entrySet().iterator();
        while (iterador.hasNext()) {
            Map.Entry<String, Integer> entrada = iterador.next();
            System.out.printf("  %-15s : %3d milhões\n", entrada.getKey(), entrada.getValue());
        }

        System.out.println("}");

    } // fim do método 'exibeMap'

}
