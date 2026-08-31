// -------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : ARRAYS de OBJETOS em JAVA
// Ano/S: 2026/1S
// -------------------------------------

// importação de class para leitura de dados do teclado
import java.util.Scanner;

// classe que coordena a execução dos métodos
// ------------------------------------------
public class CoordenadorExecucao {
	
    public void executaTudo() {

        // criação de uma instância (objeto) da classe 'TestesArrayAlunos' para permitir o acesso
        // aos respectivos métodos
        TestesArrayAlunos tstAlunos = new TestesArrayAlunos();
        
        // criação de uma instância (objeto) da classe 'TestesArrayPessoas' para permitir o acesso
        // aos respectivos métodos
        TestesArrayPessoas tstPessoas = new TestesArrayPessoas();
        
        // criação de um objeto 'Scanner' para a interação com o teclado
        Scanner teclado = new Scanner(System.in,"CP850");
        
        // declaração de constantes para uso no menu
        final int ATIVIDADE_ARRAY_ALUNOS  = 1;
        final int ATIVIDADE_ARRAY_PESSOAS = 2;
        final int SAIR                    = 9;

        // declaração de variáveis a serem usadas (independentemente da Atividade)
        int escolha;

        // menu de escolha da Atividade a ser executada
        do {
            // apresentação das opções de escolha
            System.out.println("\n\n");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1 - Atividade 1 - Testes com Array de Alunos");
            System.out.println("2 - Atividade 2 - Testes com Array de Pessoas");
            System.out.println("9 - Sair");
            
            // coleta da opção digitada
            System.out.print("\nDigite aqui a sua opção: ");
            escolha = teclado.nextInt();
            teclado.nextLine();
		
		    // avaliação da opção e acionamento da respectiva Atividade
		    switch ( escolha ) {
			
                // OPÇÃO 1
			    case ATIVIDADE_ARRAY_ALUNOS:
                        System.out.println("Atividade 1: Testes com Array de Alunos !\n");
					    // acionamento do método para testes com array de Alunos
                        // (envia objeto 'Scanner' para garantir a integridade no acesso ao teclado)
					    tstAlunos.realizaTestes( teclado );
			            break;
			    
                // OPÇÃO 2
 			    case ATIVIDADE_ARRAY_PESSOAS:
                        System.out.println("Atividade 2: Testes com Array de Pessoas !\n");
 					    // acionamento do método para testes com array de Pessoas
                        // (envia objeto 'Scanner' para garantir a integridade no acesso ao teclado)
                        tstPessoas.realizaTestes( teclado );
                        break;
				
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
