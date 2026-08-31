// ------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : COMPOSIÇÃO E HERANÇA em JAVA
// Ano/S: 2026/1S
// ------------------------------------
 
// classe principal (faz o papel efetivo de 'main',
// sendo instanciada pelo programa principal do projeto)
// -----------------------------------------------------
import java.util.Scanner;

// classe coordenadora da execução dos testes
public class CoordenadorExecucao {

    // método que realiza todos os testes
    public void executaTudo() {

        // criação de um objeto 'Scanner' para a interação com o teclado
        Scanner teclado = new Scanner(System.in);

        // criação de um objeto 'MatodosAvulsos' para acesso a funções utilitárias diversas
        MetodosAvulsos utilitarios = new MetodosAvulsos();

        // declaração de constantes para uso no menu
        final int CLASSE_BASE_PURA  = 0;
        final int SEM_HERANCA       = 1;
        final int HERANCA_PROTECTED = 2;
        final int HERANCA_PRIVATE   = 3;
        final int SAIR = 9;

        // declaração de variáveis a serem usadas (independentemente da Atividade)
        int escolha;

        // menu de escolha da Atividade a ser executada
        do {
            // apresentação das opções de escolha
            System.out.println("\n");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("0 - Atividade 0: Classe base 'pura'");
            System.out.println("1 - Atividade 1: Situação que permite herança, mas sem utilizá-la");
            System.out.println("2 - Atividade 2: Teste de Herança, classe Base com atributos 'protected'");
            System.out.println("3 - Atividade 3: Teste de Herança, classe Base com atributos 'private'");
            System.out.println("9 - Sair");

            System.out.print("\nDigite aqui a sua opção: ");
            // coleta da opção digitada
            escolha = teclado.nextInt();
            teclado.nextLine();

            // avaliação da opção e acionamento da respectiva Atividade
            switch (escolha) {

                case CLASSE_BASE_PURA:
                    System.out.println("\n0 - Atividade 0: Classe base 'pura'");
                    System.out.println(  "-----------------------------------");

                    // instancia um objeto da classe 'EmpregadoComissionado_Avulso0'
                    EmpregadoComissionado_Avulso0 empregado0
                            = new EmpregadoComissionado_Avulso0(
                                    "Jerry",
                                    "Lewis",
                                    "000.000.000-00",
                                    5000,
                                    .04);

                    // obtém os dados do empregado comissionado com salário-base 
                    System.out.println(
                            "\nInformação ORIGINAL sobre o Empregado (comissionado):");
                    System.out.println(utilitarios.criaSeparadora("-", 53));
                    System.out.printf("%s %s\n", "O nome é",
                            empregado0.getNome());
                    System.out.printf("%s %s\n", "O sobrenome é",
                            empregado0.getSobrenome());
                    System.out.printf("%s %s\n", "O CPF é",
                            empregado0.getCPF());
                    System.out.printf("%s %.2f\n", "As vendas brutas são",
                            empregado0.getVendasBrutas());
                    System.out.printf("%s %.2f\n", "A taxa de comissão é",
                            empregado0.getTaxaComissao());

                    // altera alguns dados para testar métodos da classe
                    empregado0.setVendasBrutas(500); // configura as vendas brutas                                  
                    empregado0.setTaxaComissao(.1); // configura a taxa de comissão

                    // exibe novamente, agora por meio de 'toString'
                    System.out.printf("\n%s:\n%s\n%s\n",
                            "Informação ATUALIZADA sobre o Empregado (exibida por meio de 'toString')",
                            utilitarios.criaSeparadora("-", 73),
                            empregado0.toString());

                    break;

                case SEM_HERANCA:
                    System.out.println("\nAtividade 1: Situação que permite herança, mas sem utilizá-la");
                    System.out.println(  "-------------------------------------------------------------");

                    // instancia um objeto da classe 'EmpregadoComissionadoMaisFixo_Avulso1'
                    EmpregadoComissionadoMaisFixo_Avulso1 empregado1
                            = new EmpregadoComissionadoMaisFixo_Avulso1(
                                    "Emma",
                                    "Stone",
                                    "111.111.111-11",
                                    5000,
                                    .04,
                                    300);

                    // obtém os dados do empregado comissionado com salário-base (vencimentos fixos)
                    System.out.println(
                            "\nInformação ORIGINAL sobre o Empregado (comissionado + fixo):");
                    System.out.println(utilitarios.criaSeparadora("-", 60));
                    System.out.printf("%s %s\n", "O nome é",
                            empregado1.getNome());
                    System.out.printf("%s %s\n", "O sobrenome é",
                            empregado1.getSobrenome());
                    System.out.printf("%s %s\n", "O CPF é",
                            empregado1.getCPF());
                    System.out.printf("%s %.2f\n", "As vendas brutas são",
                            empregado1.getVendasBrutas());
                    System.out.printf("%s %.2f\n", "A taxa de comissão é",
                            empregado1.getTaxaComissao());
                    System.out.printf("%s %.2f\n", "O salário fixo é",
                            empregado1.getSalarioFixo());

                    // altera alguns dados para testar métodos da classe
                    empregado1.setSalarioFixo(1000); // configura o salário-base                                    

                    // exibe novamente, agora por meio de 'toString'
                    System.out.printf("\n%s:\n%s\n%s\n",
                            "Informação ATUALIZADA sobre o Empregado (exibida por meio de 'toString')",
                            utilitarios.criaSeparadora("-", 73),
                            empregado1.toString());

                    break;

                case HERANCA_PROTECTED:
                    System.out.println("\nAtividade 2: Teste de Herança, classe Base com atributos 'protected'");
                    System.out.println(  "--------------------------------------------------------------------");

                    // instancia um objeto da classe 'EmpregadoComissionadoMaisFixo_Derivada_2'
                    EmpregadoComissionadoMaisFixo_Derivada2 empregado2
                            = new EmpregadoComissionadoMaisFixo_Derivada2(
                                    "Lady",
                                    "Gaga",
                                    "222.222.222-22",
                                    5000,
                                    .04,
                                    300);

                    // obtém os dados do empregado comissionado com salário-base (vencimentos fixos)
                    System.out.println(
                            "\nInformação ORIGINAL sobre o Empregado (comissionado + fixo):");
                    System.out.println(utilitarios.criaSeparadora("-", 60));
                    System.out.printf("%s %s\n", "O nome é",
                            empregado2.getNome());
                    System.out.printf("%s %s\n", "O sobrenome é",
                            empregado2.getSobrenome());
                    System.out.printf("%s %s\n", "O CPF é",
                            empregado2.getCPF());
                    System.out.printf("%s %.2f\n", "As vendas brutas são",
                            empregado2.getVendasBrutas());
                    System.out.printf("%s %.2f\n", "A taxa de comissão é",
                            empregado2.getTaxaComissao());
                    System.out.printf("%s %.2f\n", "O salário fixo é",
                            empregado2.getSalarioFixo());

                    // altera alguns dados para testar métodos da classe
                    empregado2.setSalarioFixo(1000); // configura o salário-base                                    

                    // exibe novamente, agora por meio de 'toString'
                    System.out.printf("\n%s:\n%s\n%s\n",
                            "Informação ATUALIZADA sobre o Empregado (exibida por meio de 'toString')",
                            utilitarios.criaSeparadora("-", 73),
                            empregado2.toString());

                    break;

                case HERANCA_PRIVATE:
                    System.out.println("\nAtividade 3: Teste de Herança, classe Base com atributos 'private'");
                    System.out.println(  "------------------------------------------------------------------");

                    // instancia um objeto da classe 'EmpregadoComissionadoMaisFixo_Derivada3'
                    EmpregadoComissionadoMaisFixo_Derivada3 empregado3
                            = new EmpregadoComissionadoMaisFixo_Derivada3(
                                    "Pedro Afonso",          // <-- substitua pelo SEU NOME
                                    "Paulina Ataide",      // <-- substitua pelo SEU SOBRENOME
                                    "333.333.333-33",
                                    5000,
                                    .04,
                                    300,
                                    new DiaMesAno(03, 29, 2007));

                    // obtém os dados do empregado comissionado com salário-base (vencimentos fixos)
                    System.out.println(
                            "\nInformação ORIGINAL sobre o Empregado (comissionado + fixo):");
                    System.out.println(utilitarios.criaSeparadora("-", 60));
                    System.out.printf("%s %s\n", "O nome é",
                            empregado3.getNome());
                    System.out.printf("%s %s\n", "O sobrenome é",
                            empregado3.getSobrenome());
                    System.out.printf("%s %s\n", "O CPF é",
                            empregado3.getCPF());
                    System.out.printf("%s %s\n", "A data de nascimento é",
                            empregado3.getDataNascimento());
                    System.out.printf("%s %.2f\n", "As vendas brutas são",
                            empregado3.getVendasBrutas());
                    System.out.printf("%s %.2f\n", "A taxa de comissão é",
                            empregado3.getTaxaComissao());
                    System.out.printf("%s %.2f\n", "O salário fixo é",
                            empregado3.getSalarioFixo());

                    // altera alguns dados para testar métodos da classe
                    empregado3.setSalarioFixo(1000); // configura o salário-base                                    

                    // exibe novamente, agora por meio de 'toString'
                    System.out.printf("\n%s:\n%s\n%s\n",
                            "Informação ATUALIZADA sobre o Empregado (exibida por meio de 'toString')",
                            utilitarios.criaSeparadora("-", 73),
                            empregado3);

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
                "COMPOSIÇÃO e HERANÇA em JAVA",
                "PEDRO AFONSO PAULINA ATAIDE",
                "121 092 251 1 018");

    }

}
