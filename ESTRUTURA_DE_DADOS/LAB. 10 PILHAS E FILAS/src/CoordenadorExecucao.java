// --------------------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : PILHAS E FILAS BASEADAS EM ARRAYDEQUE E PRIORITYQUEUE em JAVA
// Ano/S: 2026/1S
// --------------------------------------------------------------------
 
// classe principal (faz o papel efetivo de 'main',
// sendo instanciada pelo programa principal do projeto)
// -----------------------------------------------------

// importação para permitir entrada de dados via teclado
import java.util.Scanner;

// classe coordenadora da execução dos testes
public class CoordenadorExecucao {

    // método que realiza todos os testes
    public void executaTudo() {

        // criação de um objeto 'Scanner' para a interação com o teclado
        Scanner teclado = new Scanner(System.in);

        // declaração de constantes para uso no menu
        final int PILHA_INTEGERS_ARRAY_DEQUE   = 1;
        final int PILHA_VALIDACAO_SINTATICA    = 2;
        final int FILA_INTEGERS_ARRAY_DEQUE    = 3;
        final int FILA_LIVROS                  = 4;
        final int FILA_INTEGERS_PRIORITY_QUEUE = 5;
        final int FILA_LIVROS_CLASSIFICADA     = 6;
        final int SAIR                         = 9;

        // declaração de variáveis a serem usadas (independentemente da Atividade)
        int escolha;

        // menu de escolha da Atividade a ser executada
        do {
            // apresentação das opções de escolha
            System.out.println("\n----------------------------------------------------\n");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1 - Atividade 1: PILHA contendo elementos INTEGER - ARRAYDEQUE");
            System.out.println("2 - Atividade 2: PILHA para validação sintática de expressão");
            System.out.println("3 - Atividade 3: FILA  contendo elementos INTEGER - ARRAYDEQUE");
            System.out.println("4 - Atividade 4: FILA  contendo objetos LIVRO");
            System.out.println("5 - Atividade 5: FILA  contendo elementos INTEGER - PRIORITYQUEUE");
            System.out.println("6 - Atividade 6: FILA  contendo objetos LIVRO - Classificada");
            System.out.println("9 - Sair");

            System.out.print("\nDigite aqui a sua opção: ");
            // coleta da opção digitada
            escolha = teclado.nextInt();
            teclado.nextLine();

            // avaliação da opção e acionamento da respectiva Atividade
            switch (escolha) {

                // opção 1
                case PILHA_INTEGERS_ARRAY_DEQUE:
                    System.out.println("\nAtividade 1: PILHA contendo elementos INTEGER - ARRAYDEQUE");
                    System.out.println("------------------------------------------------------------");

                    // instanciação de um objeto da classe 'TestePilhaIntegersArrayDeque'
                    TestePilhaIntegersArrayDeque teste1 = new TestePilhaIntegersArrayDeque();
                    
                    // acionamento do método de 'entrada' da classe 'TestePilhaIntegersArrayDeque'
                    teste1.executaTeste();

                    break;

                // opção 2
                case PILHA_VALIDACAO_SINTATICA:
                    System.out.println("\nAtividade 2: PILHA para validação sintática de expressão");
                    System.out.println("----------------------------------------------------------");

                    // instanciação de um objeto da classe 'TestePilhaValidacaoSintatica'
                    TestePilhaValidacaoSintatica teste2 = new TestePilhaValidacaoSintatica();
                    
                    // acionamento do método de 'entrada' da classe 'TestePilhaValidacaoSintatica'
                    teste2.executaTeste();

                    break;

                // opção 3
                case FILA_INTEGERS_ARRAY_DEQUE:
                    System.out.println("\nAtividade 3: FILA contendo elementos INTEGER - ARRAYDEQUE");
                    System.out.println("-----------------------------------------------------------");

                    // instanciação de um objeto da classe 'TesteFilaIntegersArrayDeque'
                    TesteFilaIntegersArrayDeque teste3 = new TesteFilaIntegersArrayDeque();
                    
                    // acionamento do método de 'entrada' da classe 'TesteFilaIntegersArrayDeque'
                    teste3.executaTeste();

                    break;

                // opção 4
                case FILA_LIVROS:
                    System.out.println("\nAtividade 4: FILA  contendo objetos LIVRO");
                    System.out.println("-------------------------------------------");

                    // instanciação de um objeto da classe 'TesteFilaLivros'
                    TesteFilaLivros teste4 = new TesteFilaLivros();
                    
                    // acionamento do método de 'entrada' da classe 'TesteFilaLivros'
                    teste4.executaTeste();

                    break;

                // opção 5
                case FILA_INTEGERS_PRIORITY_QUEUE:
                    System.out.println("\nAtividade 5: FILA contendo elementos INTEGER - PRIORITYQUEUE");
                    System.out.println("--------------------------------------------------------------");

                    // instanciação de um objeto da classe 'TesteFilaIntegersPriorityQueue'
                    TesteFilaIntegersPriorityQueue teste5 = new TesteFilaIntegersPriorityQueue();
                    
                    // acionamento do método de 'entrada' da classe 'TesteFilaIntegersPriorityQueue'
                    teste5.executaTeste();

                    break; 

                // opção 6
                case FILA_LIVROS_CLASSIFICADA:
                    System.out.println("\nAtividade 6: FILA  contendo objetos LIVRO - Classificada");
                    System.out.println("----------------------------------------------------------");

                    // instanciação de um objeto da classe 'TesteFilaLivrosClassificada'
                    TesteFilaLivrosClassificada teste6 = new TesteFilaLivrosClassificada();
                    
                    // acionamento do método de 'entrada' da classe 'TesteFilaLivrosClassificada'
                    teste6.executaTeste();

                    break;

                case SAIR:
                    System.out.println("\nSair ...\n");
                    break;

                default:
                    System.out.println("\nOpção inválida !  Tente novamente ...\n");
            }

        } while (escolha != SAIR);

        teclado.close();

        // aciona método para exibição dos dados do autor do trabalho
        Autor autor = new Autor();
        autor.exibeDadosAutor(
                "ESTRUTURAS DE DADOS - 2026/1S",
                "PILHAS E FILAS BASEADAS EM ARRAYDEQUE E PRIORITYQUEUE em JAVA",
                "PEDRO AFONSO PAULINA ATAIDE",
                "121 092 251 1 018");

    } // fim do método 'executaTudo'

} // fim da classe 'CoordenadorExecucao'