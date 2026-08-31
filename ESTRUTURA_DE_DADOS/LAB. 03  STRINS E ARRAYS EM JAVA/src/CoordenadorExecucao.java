// ------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : STRINGS, MATH e ARRAYS JAVA
// Ano/S: 2026/1S
// ------------------------------------

// classe que coordena a execução dos métodos

// importação de class para leitura de dados do teclado
import java.util.Scanner;

// PROGRAMA PRINCIPAL
// ------------------
public class CoordenadorExecucao {
	
    public void executaTudo() {

        // criação de uma instância (objeto) da classe 'TesteStrings' para permitir o acesso
        // aos respectivos métodos
        TestesStrings tstStrings = new TestesStrings();
        
        // criação de uma instância (objeto) da classe 'TesteArrays' para permitir o acesso
        // aos respectivos métodos
        // AQUI...
        TestesArrays tstArrays = new TestesArrays();
        
        // criação de um objeto 'Scanner' para a interação com o teclado
        Scanner teclado = new Scanner(System.in, "CP850");
        
        // declaração de constantes para uso no menu
        final int ATIVIDADE_STRINGS = 1;
        final int ATIVIDADE_ARRAYS  = 2;
        final int SAIR              = 9;

        // declaração de variáveis a serem usadas (independentemente da Atividade)
        int escolha;

        // menu de escolha da Atividade a ser executada
        do {
            // apresentação das opções de escolha
            System.out.println("\n\n");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1 - Atividade 1 - Teste de Strings");
            System.out.println("2 - Atividade 2 - Teste de Arrays");
            System.out.println("9 - Sair");
            
            System.out.print("\nDigite aqui a sua opção: ");
            // coleta da opção digitada
            escolha = teclado.nextInt();
            teclado.nextLine();
		
		    // avaliação da opção e acionamento da respectiva Atividade
		    switch ( escolha ) {
			
			    // opção 1
                case ATIVIDADE_STRINGS:
                        System.out.println("Atividade 1: Teste de Strings !\n");
					    // declarar variável para armazenar o nome da sua turma (exemplo: 3_INFO_M")
					    String nomeTurma;
					    // obtenção do valor via teclado
				        System.out.println("Informe o nome da sua turma: ");
					    nomeTurma = teclado.nextLine();
					    // acionamento do método para teste de Strings
					    tstStrings.realizaTestes( nomeTurma );
			            break;
			    
 			    // opção 2
                case ATIVIDADE_ARRAYS:
                        System.out.println("Atividade 2: Teste de Arrays !\n");
 					    // acionamento do método
                        // AQUI...
                        tstArrays.realizaTestes();

                        break;
				
			    // opção 9
                case SAIR:
                        System.out.println("Sair ...\n");
				        break;
				
			    default: System.out.println("Opção inválida !  Tente novamente ...\n");
		    }
			
	    } while ( escolha != SAIR );

        teclado.close();

        // criação de uma instância (objeto) da classe 'Autor' para permitir o acesso
        // aos respectivos métodos
        Autor autor = new Autor();
        
	    // aciona método para exibição dos dados do autor do trabalho
	    autor.exibeDadosAutor();
	
    }
}
