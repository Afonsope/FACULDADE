// -----------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : ÁRVORES DE BUSCA BINÁRIA (TREESET E TREEMAP) em JAVA
// Ano/S: 2026/1S
// -----------------------------------------------------------
 
// classe para realização de testes com
// 'TreeSet' contendo dados de alunos:
// - nome (objeto 'String')
// - R.A. (objeto 'String')
// - P.R. (objeto 'Double') -> critério de ordenação
// - P.P. (objeto 'Double')
// -------------------------------------------------

// importação para permitir o uso de 'Set'
import java.util.Set;
// importação para permitir o uso de 'TreeSet'
import java.util.TreeSet;
// importação para permitir o uso de 'comparator'
import java.util.Comparator;
// importações para permitir entrada de dados via teclado
import java.io.File;  // importa a classe 'File'
import java.io.FileNotFoundException;  // importa classe para manipular erros
import java.util.Scanner; // importa a classe 'Scanner' para ler arquivos txt


// código da classe
public class TesteTreeSetComparator {

    // enumerações para constantes de comparação
    private enum Criterio {
        NOME, RA, PR, PP;
    }
    private enum Sentido {
        CRESCENTE, DECRESCENTE;
    }

    // método da classe para realização do teste
    // -----------------------------------------
    public void executaTeste() {

        // declaração de um objeto da classe 'TreeSet'
        // para armazenar dados de Alunos (nome,RA,PR,PP) (inicialmente vazio)
        // Obs.: usa 'Set' para ficar mais genérico
        // Obs.: utiliza o construtor que recorre ao 'Comparator' definido pelo usuário
        //Set<Aluno> alunos = new TreeSet<Aluno>( new CriterioAlunosPR() );
        Set<Aluno> alunos = new TreeSet<Aluno>( new AlunoComparator(Criterio.PP.ordinal(),Sentido.DECRESCENTE.ordinal()) );
        
        // obtenção dos dados dos alunos por LEITURA DE ARQUIVO TXT
        // os dados já virão na forma de um 'TreeSet' (RA,PP)
        alunos.addAll( obtemDados() );
        
        // exibição da quantidade de elementos efetivamente armazenados no 'TreeSet'
        System.out.printf("\nQtd. elementos no 'TreeSet' NOVO: %2d", alunos.size());
        
        // exibição do conteúdo do 'TreeSet' por meio de 'for' abreviado
        System.out.println("\nExibição do 'TreeSet' NOVO via 'for' abreviado (classificação de acordo com o critério enviado para 'AlunoComparator'):");
        for ( Aluno aluno : alunos ) {
            System.out.printf("Aluno: %s",aluno);  // utiliza 'toString' de 'Aluno'
        }
                
        // exibição do conteúdo do 'TreeSet' na ordem inversa (exibição direta)
        // neste caso, é necessário fazer 'downcast' para acessar método específico de 'TreeSet'
        TreeSet<Aluno> alunosDowncast = new TreeSet<Aluno>( new CriterioAlunosPR() );
        //TreeSet<Aluno> alunosDowncast = new TreeSet<Aluno>( new AlunoComparator(5) );
        alunosDowncast.addAll(alunos);
        System.out.println("\nExibição do conteúdo do 'TreeSet' DOWNCAST na ordem inversa (classificação de acordo com o critério firmado em 'CriterioAlunosPR'):");
        System.out.println(alunosDowncast.descendingSet());  // utiliza 'toString' de 'Aluno'
                
    } // fim do método 'executaTeste'
    
    // Método 'obtemDados'
    // Acessa arquivo txt no disco e retorna os dados lidos
    // na forma de um 'TreeSet<Aluno>'
    // ----------------------------------------------------
    public TreeSet<Aluno> obtemDados() {
        
        // declaração e instanciação de um objeto da classe 'TreeSet'
        // para armazenar pares (RA,PP) (inicialmente vazio)
        TreeSet<Aluno> dadosAlunos = new TreeSet<>();
        
        // bloco try-catch
        try {
            
            // abertura do arquivo
            File arquivo = new File("Alunos.txt");
            
            // associação do ponteiro de leitura com o arquivo aberto
            Scanner leitura = new Scanner(arquivo);
            
            // leitura (enquanto houver dados)
            while (leitura.hasNextLine()) {
                
                // leitura do RA e da nota do aluno nesta linha
                String nome = leitura.next();
                String ra   = leitura.next();
                Double pr   = leitura.nextDouble();
                Double pp   = leitura.nextDouble();
                
                // inserção no 'TreeSet'
                dadosAlunos.add(new Aluno(nome,ra,pr,pp));

                //avança para a próxima linha do arquivo
                leitura.nextLine();
            }
            
            // fecha o ponteiro de leitura, fechando assim o arquivo
            leitura.close();
        // trata o erro, se houver
        } catch (FileNotFoundException e) {
            System.out.println("ERRO no acesso ao arquivo Alunos.txt.");
            e.printStackTrace();
        }
        
        // exibição da quantidade de elementos efetivamente armazenados no 'TreeSet'
        System.out.printf("\nQtd. elementos no 'TreeSet' ORIGINAL: %2d", dadosAlunos.size());
        
        // exibição do conteúdo do 'TreeSet' por meio de 'for' abreviado
        System.out.println("\nExibição do 'TreeSet' ORIGINAL via 'for' abreviado (classificação de acordo com o critério habilitado em 'Aluno'):");
        for ( Aluno aluno : dadosAlunos ) {
            System.out.printf("Aluno: %s",aluno);  // utiliza 'toString' de 'Aluno'
        }
                
        return dadosAlunos;
        
    }  // fim do método 'obtemDados'
    
    // definição de uma CLASSE que implementa a INTERFACE 'Comparator'
    // ---------------------------------------------------------------
    public static class CriterioAlunosPR implements Comparator<Aluno> {

        @Override
        public int compare(Aluno aluno1, Aluno aluno2) {
            
            int valor =  aluno1.getPr().compareTo(aluno2.getPr());
            
            // estabelece ordem decrescente de valor de PR
            if ( valor > 0 ) {
                // PR do aluno 1 é maior e portanto mais prioritário
                return -1;  // para ordem crescente, inverter o sinal
            }
            else if (valor < 0) {
                // PR do aluno 2 é maior e portanto mais prioritário
                return 1;   // para ordem crescente, inverter o sinal
            }
            else {
                // PR do aluno 1 é igual ao do aluno 2
                return 0;
            }
        }
    }  // fim da classe estática interna 'CriterioAlunosPR'

}

