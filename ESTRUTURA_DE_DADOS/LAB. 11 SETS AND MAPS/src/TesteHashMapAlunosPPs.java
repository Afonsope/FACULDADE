// --------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : CONJUNTOS (SET) E DICIONÁRIOS (MAP) em JAVA
// Ano/S: 2026/1S
// --------------------------------------------------
 
// classe para realização de testes com
// 'HashMap' contendo dados de alunos:
// - R.A. (objeto 'String')
// - P.P. (objeto 'Double')
// ------------------------------------

// importação para permitir o uso de 'Map'
import java.util.Map;
//import java.util.Entry;
// importação para permitir o uso de 'HashMap'
import java.util.HashMap;
// importação para permitir o uso de 'iterator'
import java.util.Iterator;
// importações para permitir entrada de dados via teclado
import java.io.File;  // importa a classe 'File'
import java.io.FileNotFoundException;  // importa classe para manipular erros
import java.util.Scanner; // importa a classe 'Scanner' para ler arquivos txt


// código da classe
public class TesteHashMapAlunosPPs {

    // método da classe para realização do teste
    // -----------------------------------------
    public void executaTeste() {
        
        // declaração de um objeto da classe 'HashMap'
        // para armazenar pares (RA,PP) (inicialmente vazio)
        // Obs.: usa 'Map' para ficar mais genérico
        Map<String,Double> alunosProgressoes;
        
        // obtenção dos dados dos alunos (RA e PP) por LEITURA DE ARQUIVO TXT
        // os dados já virão na forma de um 'HashMap' (RA,PP)
        alunosProgressoes = obtemDados();
        
        // exibição da quantidade de elementos efetivamente armazenados no 'HashMap'
        System.out.printf("\nQtd. elementos no 'HashMap': %2d", alunosProgressoes.size());
        
        // exibição direta do conteúdo do 'HashMap' (usa o método 'toString')
        System.out.println("\nExibição direta: \n" + alunosProgressoes);
        
        // exibição do conteúdo do 'HashMap' por meio de 'for' convencional
        System.out.println("\nExibição via 'for' convencional: IMPOSSÍVEL, pois 'Map' não tem índice !");
        
        // exibição do conteúdo do 'HashMap' por meio de 'for' abreviado
        System.out.println("\nExibição via 'for' abreviado (MODO 1 - keySet): {");
        for ( String ra : alunosProgressoes.keySet() ) {
            System.out.printf("Aluno: %s - PP: %4.1f\n",ra,alunosProgressoes.get(ra));
        }
        System.out.println("}");
                
        System.out.println("\nExibição via 'for' abreviado (MODO 2 - entrySet): {");
        for ( Map.Entry<String,Double> entrada : alunosProgressoes.entrySet() ) {
            System.out.printf("Aluno: %s - PP: %4.1f\n",entrada.getKey(),entrada.getValue());
        }
        System.out.println("}");
                
        // exibição do conteúdo do 'HashMap' por meio de 'iterator'
        System.out.println("\nExibição via 'iterator': {");
        Iterator< Map.Entry<String,Double> > iteradorA = alunosProgressoes.entrySet().iterator();
        while ( iteradorA.hasNext() ) {
            Map.Entry<String,Double> entry = iteradorA.next();
            System.out.printf("Aluno: %s - PP: %4.1f\n",entry.getKey(),entry.getValue());
        }
        System.out.println("}");

    } // fim do método 'executaTeste'
    
    // Método 'obtemDados'
    // Acessa arquivo txt no disco e retorna os dados lidos
    // na forma de um 'HashMap' (<String>,<Double>)
    // ----------------------------------------------------
    public Map<String,Double> obtemDados() {
        
        // declaração e instanciação de um objeto da classe 'HashMap'
        // para armazenar pares (RA,PP) (inicialmente vazio)
        Map<String,Double> dadosAlunos = new HashMap<>();
        
        // bloco try-catch
        try {
            
            // abertura do arquivo
            File arquivo = new File("Alunos_PPs.txt");
            
            // associação do ponteiro de leitura com o arquivo aberto
            Scanner leitura = new Scanner(arquivo);
            
            // leitura (enquanto houver dados)
            while (leitura.hasNextLine()) {
                
                // leitura do RA e da nota do aluno nesta linha
                String ra = leitura.next();
                Double pp = leitura.nextDouble();
                
                // inserção condicional no 'HashMap'
                // se RA (chave) ainda não existe no 'HashMap'
                if ( ! dadosAlunos.containsKey(ra) ) {
                    // incluir o novo aluno e o PP atual (único por enquanto)
                    dadosAlunos.put(ra, pp);
                }
                // senão
                else {
                    // acumular o PP recém-lido, somando-o ao valor atualmente armazenado
                    Double ppAtual = dadosAlunos.get(ra);
                    dadosAlunos.replace(ra, ppAtual+pp);
                }
                
                //avança para a próxima linha do arquivo
                leitura.nextLine();
            }
            
            // fecha o ponteiro de leitura, fechando assim o arquivo
            leitura.close();
        // trata o erro, se houver
        } catch (FileNotFoundException e) {
            System.out.println("ERRO no acesso ao arquivo Alunos_PPs.txt.");
            e.printStackTrace();
        }
        
        return dadosAlunos;
        
    } // fim do método 'obtemDados'
    
}