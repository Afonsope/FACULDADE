// --------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : CONJUNTOS (SET) E DICIONÁRIOS (MAP) em JAVA
// Ano/S: 2026/1S
// --------------------------------------------------
 
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
        final int STRING_HASHSET  = 1;  
        final int STRING_LINKEDHASHSET  = 2;
        final int STRING_PALAVRAS = 3;
        final int STRING_CARACTERES = 4;
        final int ALUNOS_PPS_HASHMAP = 5;
        final int ALUNOS_PPS_LINKEDHASHMAP = 6;
        final int PALAVRAS_QTDS_HASHMAP = 7;
        final int CARACTERES_QTDS_LINKEDHASHMAP = 8;
        final int SAIR = 9;

        // declaração de variáveis a serem usadas (independentemente da Atividade)
        int escolha;

        // menu de escolha da Atividade a ser executada
        do {
            // apresentação das opções de escolha
            System.out.println("\n----------------------------------------------------\n");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1 - Atividade 1: Criação e uso de HASHSET        para armazenar objetos STRING");
            System.out.println("2 - Atividade 2: Criação e uso de LINKEDHASHSET  para armazenar objetos STRING");
            System.out.println("3 - Atividade 3: Criação e uso de HASHSET        para contabilizar palavras distintas");
            System.out.println("4 - Atividade 4: Criação e uso de HASHSET        para contabilizar caracteres distintos");
            System.out.println("5 - Atividade 5: Criação e uso de HASHMAP        para armazenar pares (RA,PP) de alunos");
            System.out.println("6 - Atividade 6: Criação e uso de LINKEDHASHMAP  para armazenar pares (RA,PP) de alunos");
            System.out.println("7 - Atividade 7: Criação e uso de HASHMAP        para contabilizar qtds ocorrências de palavras distintas");
            System.out.println("8 - Atividade 8: Criação e uso de LINKEDHASHMAP  para contabilizar qtds ocorrências de caracteres distintos");
            System.out.println("9 - Sair");

            System.out.print("\nDigite aqui a sua opção: ");
            // coleta da opção digitada
            escolha = teclado.nextInt();
            teclado.nextLine();

            // avaliação da opção e acionamento da respectiva Atividade
            switch (escolha) {

                // opção 1
                case STRING_HASHSET:
                    System.out.println("\nAtividade 1: Criação e uso de HASHSET        para armazenar objetos STRING");
                    System.out.println("----------------------------------------------------------------------------");

                    // instanciação de um objeto da classe 'TesteHashSetString'
                    TesteHashSetString teste1 = new TesteHashSetString();
                    
                    // acionamento do método de 'entrada' da classe 'TesteHashSetString'
                    teste1.executaTeste();

                    break;

                // opção 2
                case STRING_LINKEDHASHSET:
                    System.out.println("\nAtividade 2: Criação e uso de LINKEDHASHSET  para armazenar objetos STRING");
                    System.out.println("----------------------------------------------------------------------------");

                    // instanciação de um objeto da classe 'TesteLinkedHashSetString'
                    TesteLinkedHashSetString teste2 = new TesteLinkedHashSetString();
                    
                    // acionamento do método de 'entrada' da classe 'TesteLinkedHashSetString'
                    teste2.executaTeste();

                    break;

                // opção 3
                case STRING_PALAVRAS:
                    System.out.println("\nAtividade 3: Criação e uso de HASHSET        para contabilizar palavras distintas");
                    System.out.println("-----------------------------------------------------------------------------------");

                    // instanciação de um objeto da classe 'TesteHashSetPalavrasFrase'
                    TesteHashSetPalavrasFrase teste3 = new TesteHashSetPalavrasFrase();
                    
                    // acionamento do método de 'entrada' da classe 'TesteHashSetPalavrasFrase'
                    teste3.executaTeste();

                    break;

                // opção 4
                case STRING_CARACTERES:
                    System.out.println("\nAtividade 4: Criação e uso de LINKEDHASHSET  para contabilizar caracteres distintos");
                    System.out.println("-------------------------------------------------------------------------------------");

                    // instanciação de um objeto da classe 'TesteLinkedHashSetCaracteresFrase'
                    TesteLinkedHashSetCaracteresFrase teste4 = new TesteLinkedHashSetCaracteresFrase();
                    
                    // acionamento do método de 'entrada' da classe 'TesteLinkedHashSetCaracteresFrase'
                    teste4.executaTeste();

                    break;

                // opção 5
                case ALUNOS_PPS_HASHMAP:
                    System.out.println("\nAtividade 5: Criação e uso de HASHMAP        para armazenar pares (RA,PP) de alunos");
                    System.out.println("-------------------------------------------------------------------------------------");

                    // instanciação de um objeto da classe 'TesteHashMapAlunosPPs'
                    TesteHashMapAlunosPPs teste5 = new TesteHashMapAlunosPPs();
                    
                    // acionamento do método de 'entrada' da classe 'TesteHashMapAlunosPPs'
                    teste5.executaTeste();

                    break;

                
                // opção 6
                case ALUNOS_PPS_LINKEDHASHMAP:
                    System.out.println("\nAtividade 6: Criação e uso de LINKEDHASHMAP  para armazenar pares (RA,PP) de alunos");
                    System.out.println("-------------------------------------------------------------------------------------");

                    // instanciação de um objeto da classe 'TesteLinkedHashMapAlunosPPs'
                    TesteLinkedHashMapAlunosPPs teste6 = new TesteLinkedHashMapAlunosPPs();
                    
                    // acionamento do método de 'entrada' da classe 'TesteLinkedHashMapAlunosPPs'
                    teste6.executaTeste();

                    break;

                
                // opção 7
                case PALAVRAS_QTDS_HASHMAP:
                    System.out.println("\nAtividade 7: Criação e uso de HASHMAP        para contabilizar qtds ocorrências de palavras distintas");
                    System.out.println("-------------------------------------------------------------------------------------------------------");

                    // instanciação de um objeto da classe 'TesteHashMapPalavrasQtds'
                    TesteHashMapPalavrasQtds teste7 = new TesteHashMapPalavrasQtds();
                    
                    // acionamento do método de 'entrada' da classe 'TesteHashMapPalavrasQtds'
                    teste7.executaTeste();

                    break;

                // opção 8
                case CARACTERES_QTDS_LINKEDHASHMAP:
                    System.out.println("\nAtividade 8: Criação e uso de LINKEDHASHMAP  para contabilizar qtds ocorrências de caracteres distintos");
                    System.out.println("---------------------------------------------------------------------------------------------------------");

                    // instanciação de um objeto da classe 'TesteLinkedHashMapCaracteresQtds'
                    TesteLinkedHashMapCaracteresQtds teste8 = new TesteLinkedHashMapCaracteresQtds();
                    
                    // acionamento do método de 'entrada' da classe 'TesteLinkedHashMapCaracteresQtds'
                    teste8.executaTeste();

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
                "CONJUNTOS ('SET') E DICIONÁRIOS ('MAP') em JAVA",
                "PEDRO AFONSO PAULINA ATAIDE",  
                "121 092 251 1 018");

    }

}