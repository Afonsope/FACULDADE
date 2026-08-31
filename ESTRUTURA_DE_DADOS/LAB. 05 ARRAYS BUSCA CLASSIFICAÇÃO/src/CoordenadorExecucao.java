// -------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: CARLOS MAGNUS CARLSON FILHO
// Lab. : BUSCA e CLASSIFICAÇÃO EM ARRAYS JAVA
// Ano/S: 2026/1S
// -------------------------------------------

// classe que coordena a execução dos métodos
// ------------------------------------------

// importação de class para leitura de dados do teclado
import java.util.Scanner;

public class CoordenadorExecucao {

    // método de "entrada" da classe: realização dos testes
    public void executaTudo() {
        
        // criação de um objeto 'Scanner' para a interação com o teclado
        Scanner teclado = new Scanner(System.in);
        
        // declaração de constantes para uso no menu
        final int ATIVIDADE_BUSCA_LINEAR          = 1;
        final int ATIVIDADE_BUSCA_BINARIA         = 2;
        final int ATIVIDADE_METODOS_CLASSIFICACAO = 3;
        final int EXEMPLO_BUSCA_BINARIA           = 4;
        final int SAIR                            = 9;

        // criação de uma instância (objeto) da classe 'TesteBuscaLinear'
        // para permitir o acesso aos respectivos métodos
        TesteBuscaLinear tstBuscaLinear = new TesteBuscaLinear();
        
        // criação de uma instância (objeto) da classe 'TesteBuscaBinaria'
        // para permitir o acesso aos respectivos métodos
        TesteBuscaBinaria tstBuscaBinaria = new TesteBuscaBinaria();

        // criação de uma instância (objeto) da classe 'TesteMetodosClassificacao'
        // para permitir o acesso aos respectivos métodos
        TesteMetodosClassificacao tstMetodosClassificacao = new TesteMetodosClassificacao();

        // criação de uma instância (objeto) da classe 'ExemploBuscaBinaria'
        // para permitir o acesso aos respectivos métodos
        ExemploBuscaBinaria exmBuscaBinaria = new ExemploBuscaBinaria();

        // declaração de variáveis a serem usadas (independentemente da Atividade)
        int escolha;

        // menu de escolha da Atividade a ser executada
        do {
            // limpeza da tela
            //System.out.print("\033[2J\033[H"); // ESC + [2J limpa a tela - ESC + [H leva o cursor "para cima"
            System.out.print("\033[2J"); // ESC + [2J limpa a tela
            System.out.print("\033[H");  // ESC + [H  leva o cursor "para cima"
            System.out.flush();            // "descarrega" o 'stream' de saída
            // apresentação das opções de escolha
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1 - Atividade 1 - Busca Linear");
            System.out.println("2 - Atividade 2 - Busca Binária");
            System.out.println("3 - Atividade 3 - Métodos de Classificação");
            System.out.println("4 - Exemplo     - Busca Binária");
            System.out.println("9 - Sair");
            
            System.out.print("\nDigite aqui a sua opção: ");
            // coleta da opção digitada
            escolha = teclado.nextInt();
            teclado.nextLine();
		
		    // avaliação da opção e acionamento da respectiva Atividade
		    switch ( escolha ) {
			
			    case ATIVIDADE_BUSCA_LINEAR:
                        System.out.println("Atividade 1: Busca Linear !\n");
					    // acionamento do método para testes da Busca Linear
					    tstBuscaLinear.realizaTestes();
			            break;
			    
 			    case ATIVIDADE_BUSCA_BINARIA:
                        System.out.println("Atividade 2: Busca Binária !\n");
					    // acionamento do método para testes da Busca Binária
					    tstBuscaBinaria.realizaTestes();
					    break;
				
 			    case ATIVIDADE_METODOS_CLASSIFICACAO:
                        System.out.println("Atividade 3: Métodos de Classificação !\n");
 					    // acionamento do método para testes dos Métodos de Classificação
			 	 	    tstMetodosClassificacao.realizaTestes();
					    break;
				
 			    case EXEMPLO_BUSCA_BINARIA:
                        System.out.println("Atividade 4: Exemplo de Busca Binária !\n");
 					    // acionamento do método para exemplos da Busca Binária
			 	 	    exmBuscaBinaria.executaExemplos();
					    break;
				
			    case SAIR:
                        System.out.println("Sair ...\n");
				        break;
				
			    default: System.out.println("Opção inválida !  Tente novamente ...\n");
		    }

            // pausa na execução para leitura dos resultados
            if ( escolha != SAIR ) {
                System.out.print("\nPressione <Enter> para LIMPAR A TELA e reapresentar o menu de opções...");
                teclado.nextLine();
            }
			
	    } while ( escolha != SAIR );

        teclado.close();

        // instanciação de objeto da classe 'Autor'
        Autor autor = new Autor();

        // exibição dos dados do autor do trabalho
        autor.exibeDadosAutor();

    }

}
