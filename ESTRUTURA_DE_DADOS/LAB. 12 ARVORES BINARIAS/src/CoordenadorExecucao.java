// -----------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : ÁRVORES DE BUSCA BINÁRIA (TREESET E TREEMAP) em JAVA
// Ano/S: 2026/1S
// -----------------------------------------------------------
 
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
        final int STRING_TREESET  = 1;
        final int ALUNOS_TREESET_COMPARATOR  = 2;
        final int ESTADOS_POPULACOES_TREEMAP = 3;
        final int REGIOES_POPULACOES_TREEMAP = 4;
        final int SAIR = 9;

        // declaração de variáveis a serem usadas (independentemente da Atividade)
        int escolha;

        // menu de escolha da Atividade a ser executada
        do {
            // apresentação das opções de escolha
            System.out.println("\n----------------------------------------------------\n");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1 - Atividade 1: Criação e uso de TREESET para armazenar objetos STRING");
            System.out.println("2 - Atividade 2: Criação e uso de TREESET para armazenar dados de ALUNOS via COMPARATOR");
            System.out.println("3 - Atividade 3: Criação e uso de TREEMAP para armazenar pares (estado,população)");
            System.out.println("4 - Atividade 4: Criação e uso de TREEMAP para armazenar pares (região,população)");
            System.out.println("9 - Sair");

            System.out.print("\nDigite aqui a sua opção: ");
            // coleta da opção digitada
            escolha = teclado.nextInt();
            teclado.nextLine();

            // avaliação da opção e acionamento da respectiva Atividade
            switch (escolha) {

                // opção 1
                case STRING_TREESET:
                    System.out.println("\nAtividade 1: Criação e uso de TREESET para armazenar objetos STRING");
                    System.out.println("---------------------------------------------------------------------");

                    // instanciação de um objeto da classe 'TesteTreeSetString'
                    TesteTreeSetString teste1 = new TesteTreeSetString();
                    
                    // acionamento do método de 'entrada' da classe 'TesteTreeSetString'
                    teste1.executaTeste();

                    break;

                // opção 2
                case ALUNOS_TREESET_COMPARATOR:
                    System.out.println("\nAtividade 2: Criação e uso de TREESET para armazenar dados de ALUNOS via COMPARATOR");
                    System.out.println("-------------------------------------------------------------------------------------");

                    // instanciação de um objeto da classe 'TesteTreeSetComparator'
                    TesteTreeSetComparator teste2 = new TesteTreeSetComparator();
                    
                    // acionamento do método de 'entrada' da classe 'TesteTreeSetComparator'
                    teste2.executaTeste();

                    break;

                // opção 3
                case ESTADOS_POPULACOES_TREEMAP:
                    System.out.println("\nAtividade 3: Criação e uso de TREEMAP para armazenar pares (estado,população)");
                    System.out.println("-------------------------------------------------------------------------------");

                    // instanciação de um objeto da classe 'TesteTreeMapEstadosPopulacoes'
                    TesteTreeMapEstadosPopulacoes teste3 = new TesteTreeMapEstadosPopulacoes();
                    
                    // acionamento do método de 'entrada' da classe 'TesteTreeMapEstadosPopulacoes'
                    teste3.executaTeste();

                    break;

                
                // opção 4
                case REGIOES_POPULACOES_TREEMAP:
                    System.out.println("\nAtividade 4: Criação e uso de TREEMAP para armazenar pares (região,população)");
                    System.out.println("-------------------------------------------------------------------------------");

                    // instanciação de um objeto da classe 'TesteTreeMapRegioesPopulacoes'
                    TesteTreeMapRegioesPopulacoes teste4 = new TesteTreeMapRegioesPopulacoes();
                    
                    // acionamento do método de 'entrada' da classe 'TesteTreeMapRegioesPopulacoes'
                    teste4.executaTeste();

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
            "IED-001 - ESTRUTURAS DE DADOS - 2026/1S",
            "ÁRVORES DE BUSCA BINÁRIA (TREESET E TREEMAP)",
            "PEDRO AFONSO PAULINA ATAIDE",
            "121 092 251 1 018"
        );

    }

}
