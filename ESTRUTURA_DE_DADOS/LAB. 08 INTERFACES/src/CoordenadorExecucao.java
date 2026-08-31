// ----------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : INTERFACES em JAVA
// Ano/S: 2026/1S
// ----------------------------------------
 
// importação de pacotes - AMBIENTE
import java.util.Scanner;

// classe principal (faz o papel efetivo de 'main',
// sendo instanciada pelo programa principal do projeto):
// classe coordenadora da execução dos testes
// ------------------------------------------------------
public class CoordenadorExecucao {

    // método que realiza todos os testes
    public void executaTudo() {

        // criação de um objeto 'Scanner' para a interação com o teclado
        Scanner teclado = new Scanner(System.in);

        // declaração de constantes para uso no menu
        final int PROCESSAMENTO_COMPRAS  = 1;
        final int PROCESSAMENTO_SALARIOS = 2;
        final int PROCESSAMENTO_CONJUNTO = 3;
        final int SAIR = 9;

        // declaração de variáveis a serem usadas (independentemente da Atividade)
        int escolha;

        // menu de escolha da Atividade a ser executada
        do {
            // apresentação das opções de escolha
            System.out.println("\n");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1 - Atividade 1: Processamento exclusivo de objetos da  classe  'Compra'");
            System.out.println("2 - Atividade 2: Processamento exclusivo de objetos da  classe  'EmpregadoAssalariado', 'EmpregadoComissionado', 'EmpregadoHorista', 'EmpregadoComissionadoMaisFixo'");
            System.out.println("3 - Atividade 3: Processamento conjunto  de objetos das classes 'Compra' e 'EmpregadoAssalariado', 'EmpregadoComissionado', 'EmpregadoHorista', 'EmpregadoComissionadoMaisFixo'");
            System.out.println("9 - Sair");

            System.out.print("\nDigite aqui a sua opção: ");
            // coleta da opção digitada
            escolha = teclado.nextInt();
            teclado.nextLine();

            // avaliação da opção e acionamento da respectiva Atividade
            switch (escolha) {

                // opção 1
                case PROCESSAMENTO_COMPRAS:
                    System.out.println("\n1 - Atividade 1: Processamento de objetos da classe 'Compra'");
                    System.out.println("--------------------------------------------------------------");

                    // cria um array de objetos 'Compra' de quatro elementos
                    Compra compras[] = new Compra[4];

                    // inicializa o array com objetos da classe 'Compra'          
                    compras[0] = new Compra("012", "celular",  2,  999.00 );
                    compras[1] = new Compra("345", "smartTV",  1, 1999.00 );;
                    compras[2] = new Compra("678", "notebook", 1, 3999.00 );;
                    compras[3] = new Compra("910", "fones",    4,  199.00 );;
                    
                    System.out.println("Compras processadas exclusivamente:\n");

                    // processa genericamente cada elemento do array 'compras'
                    for (Compra compraAtual : compras) {
                        
                        // exibe dados de cada compra, invocando toString e calculando pagamento
                        System.out.printf("%s\n%s: R$%,.2f\n\n",
                                compraAtual,"Valor total", compraAtual.getPagamento());
                    } // final do 'for'

                    // ---------------------------------------------------------
                    // TESTE da interface 'Recompensavel' aplicada em 'Compra'
                    // Regra: cashback de 3% se valor total > R$2.000,00
                    //        cashback de 1% caso contrário
                    // ---------------------------------------------------------
                    System.out.println("-----------------------------------------");
                    System.out.println("Exibindo os valores de cashback");
                    
                    // define o valor limite para aplicar a taxa de cashback maior
                    final double valorAcima = 2000.00;

                    // percorre cada compra do array para calcular e exibir o cashback
                    for(Compra compraAtual : compras) {

                        // variável que armazena o valor do cashback calculado
                        double cashback;

                        // verifica se o valor total da compra (via getRecompensa) supera R$2.000,00
                        if(compraAtual.getRecompensa() > valorAcima) {
                            // aplica cashback de 3% sobre o valor total da compra
                            cashback = compraAtual.getPagamento() * 0.03;
                        }
                        // caso contrário (valor total <= R$2.000,00)
                        else {
                            // aplica cashback de 1% sobre o valor total da compra
                            cashback = compraAtual.getPagamento() * 0.01;
                        }

                        // exibe o nome do produto, o valor total e o cashback calculado
                        System.out.printf("Produto: %s | Valor total: R$%,.2f | Cashback: R$%,.2f\n",
                            compraAtual.getDescricaoProduto(), compraAtual.getPagamento(), cashback);
 
                    } // final do 'for' de cashback

                    break;

                // opçõa 2
                case PROCESSAMENTO_SALARIOS:
                    System.out.println("\n2 - Atividade 2: Processamento de objetos da classe 'EmpregadoAssalariado'");
                    System.out.println("----------------------------------------------------------------------------");

                    // cria um array de objetos 'EmpregadoAssalariado' de quatro elementos
                    EmpregadoAssalariado empregadosAssalariados[] = new EmpregadoAssalariado[4];

                    // cria um array de objetos 'EmpregadoComissionado' de quatro elementos
                    EmpregadoComissionado empregadoComissionado[] = new EmpregadoComissionado[4];

                    // cria um array de objetos 'EmpregadoHorista' de quatro elementos
                    EmpregadoHorista empregadoHorista[] = new EmpregadoHorista[4];

                    // cria um array de obejtos 'EmpregadoComissionado' de quatro elementos
                    EmpregadoComissionadoMaisFixo empregadoComissionadoMaisFixo[] = new EmpregadoComissionadoMaisFixo[4];

                    // inicializa o array com objetos 'EmpregadoAssalariado'

                    empregadosAssalariados[0] =
                        new EmpregadoAssalariado(
                            "Matheus",
                            "de Paula",
                            "111.111.111-11",
                            13,
                            8,
                            1979,
                            1000.00 );

                    empregadosAssalariados[1] =
                        new EmpregadoAssalariado(
                            "Marcos",
                            "Neto",
                            "222.222.222-22",
                            31,
                            3,
                            1991,
                            1500.00 );;

                    empregadosAssalariados[2] =
                        new EmpregadoAssalariado(
                            "Renato",
                            "Sobrinho",
                            "333.333.333-33",
                            5,
                            11,
                            1998,
                            2000.00 );;

                    empregadosAssalariados[3] =
                        new EmpregadoAssalariado(
                            "Robert",
                            "Junior",
                            "444.444.444-44",
                            25,
                            10,
                            2001,
                            2500.00 );;

                    // inicializa o array com objetos 'EmpregadoComissionado'

                    empregadoComissionado[0] =
                        new EmpregadoComissionado(
                            "Carlos",
                            "Silva",
                            "555.555.555-55",
                            10,
                            5,
                            1985,
                            15000.00,
                            0.12 );

                    empregadoComissionado[1] =
                        new EmpregadoComissionado(
                            "Ana",
                            "Oliveira",
                            "666.666.666-66",
                            22,
                            9,
                            1990,
                            20000.00,
                            0.10 );

                    empregadoComissionado[2] =
                        new EmpregadoComissionado(
                            "Pedro",
                            "Santos",
                            "777.777.777-77",
                            3,
                            1,
                            1988,
                            12000.00,
                            0.15 );

                    empregadoComissionado[3] =
                        new EmpregadoComissionado(
                            "Julia",
                            "Costa",
                            "888.888.888-88",
                            17,
                            12,
                            1995,
                            25000.00,
                            0.08 );

                    // inicializa o array com objetos 'EmpregadoHorista'

                    empregadoHorista[0] =
                        new EmpregadoHorista(
                            "Lucas",
                            "Ferreira",
                            "999.999.999-99",
                            8,
                            4,
                            1992,
                            35.00,
                            44.0 );

                    empregadoHorista[1] =
                        new EmpregadoHorista(
                            "Fernanda",
                            "Lima",
                            "123.456.789-01",
                            14,
                            7,
                            1987,
                            42.50,
                            40.0 );

                    empregadoHorista[2] =
                        new EmpregadoHorista(
                            "Gabriel",
                            "Rocha",
                            "234.567.890-12",
                            28,
                            2,
                            1999,
                            28.00,
                            50.0 );

                    empregadoHorista[3] =
                        new EmpregadoHorista(
                            "Camila",
                            "Martins",
                            "345.678.901-23",
                            19,
                            6,
                            1993,
                            50.00,
                            38.0 );

                    // inicializa o array com objetos 'EmpregadoComissionadoMaisFixo'

                    empregadoComissionadoMaisFixo[0] =
                        new EmpregadoComissionadoMaisFixo(
                            "Ricardo",
                            "Almeida",
                            "456.789.012-34",
                            12,
                            3,
                            1983,
                            30000.00,
                            0.10,
                            2000.00 );

                    empregadoComissionadoMaisFixo[1] =
                        new EmpregadoComissionadoMaisFixo(
                            "Beatriz",
                            "Souza",
                            "567.890.123-45",
                            7,
                            11,
                            1991,
                            18000.00,
                            0.12,
                            1800.00 );

                    empregadoComissionadoMaisFixo[2] =
                        new EmpregadoComissionadoMaisFixo(
                            "Diego",
                            "Pereira",
                            "678.901.234-56",
                            30,
                            1,
                            1986,
                            22000.00,
                            0.09,
                            2500.00 );

                    empregadoComissionadoMaisFixo[3] =
                        new EmpregadoComissionadoMaisFixo(
                            "Larissa",
                            "Mendes",
                            "789.012.345-67",
                            5,
                            10,
                            1997,
                            35000.00,
                            0.07,
                            1500.00 );

                    System.out.println("Empregados assalariados processados exclusivamente:\n");

                    // processa cada elemento do array 'empregadosAssalariados'
                    for (EmpregadoAssalariado empregadoAtual : empregadosAssalariados) {
                        
                        // exibe dados de cada empregado, invocando toString e calculando pagamento
                        System.out.printf("%s\n%s: R$%,.2f\n\n",
                                empregadoAtual,"Salário total", empregadoAtual.getPagamento());

                    } // final do 'for'

                    System.out.println("Empregados comissionados processados exclusivamente:\n");

                    // processa cada elemento do array 'empregadoComissionado'
                    for (EmpregadoComissionado empregadoAtual : empregadoComissionado) {
                        
                        // exibe dados de cada empregado, invocando toString e calculando pagamento
                        System.out.printf("%s\n%s: R$%,.2f\n\n",
                                empregadoAtual,"Salário total", empregadoAtual.getPagamento());

                    } // final do 'for'

                    System.out.println("Empregados horistas processados exclusivamente:\n");

                    // processa cada elemento do array 'empregadoHorista'
                    for (EmpregadoHorista empregadoAtual : empregadoHorista) {
                        
                        // exibe dados de cada empregado, invocando toString e calculando pagamento
                        System.out.printf("%s\n%s: R$%,.2f\n\n",
                                empregadoAtual,"Salário total", empregadoAtual.getPagamento());

                    } // final do 'for'

                    System.out.println("Empregados comissionados mais fixo processados exclusivamente:\n");

                    // processa cada elemento do array 'empregadoComissionadoMaisFixo'
                    for (EmpregadoComissionadoMaisFixo empregadoAtual : empregadoComissionadoMaisFixo) {
                        
                        // exibe dados de cada empregado, invocando toString e calculando pagamento
                        System.out.printf("%s\n%s: R$%,.2f\n\n",
                                empregadoAtual,"Salário total", empregadoAtual.getPagamento());

                    } // final do 'for'

                    // -------------------------------------------------------------------
                    // TESTE da interface 'Recompensavel' aplicada em 'Empregado'
                    // Regra: bônus salarial fixo de R$200,00 no mês do aniversário
                    //        R$0,00 caso o mês informado não seja o do aniversário
                    // -------------------------------------------------------------------
                    System.out.println("Bônus salarial do RESPECTIVO MÊS para quem é nascido nesse mês atual: ");

                    // solicita ao usuário o mês de referência para verificar aniversariantes
                    System.out.print("\nDigite um mês: ");
                    int mes = teclado.nextInt();

                    // valores fictícios para dia e ano, pois só o mês é relevante para a comparação
                    int dia = 10;
                    int ano = 1990;

                    //quebra de linha 
                    System.out.println();

                    // instancia um objeto 'DiaMesAno' para utilizar o mês informado na comparação
                    DiaMesAno diaMesAno = new DiaMesAno(mes, dia, ano);

                    // percorre o array de 'EmpregadoAssalariado' verificando o mês de nascimento
                    for(EmpregadoAssalariado empregadoAtual : empregadosAssalariados) {

                        // variável que armazena o valor do bônus de aniversário
                        double recompensa;

                        // compara o mês informado com o mês de nascimento do empregado
                        if(diaMesAno.getMonth() == empregadoAtual.getDataNascimento().getMonth()) {
                            // mês coincide: empregado recebe bônus de R$200,00
                            recompensa = 200.00;
                            System.out.printf("Empregado: %s %s | Salário: R$%,.2f | Bônus aniversário: R$%,.2f\n",
                                empregadoAtual.getNome(), empregadoAtual.getSobrenome(),
                                empregadoAtual.getPagamento(), recompensa);
                        }
                        else {
                            // mês não coincide: sem bônus (R$0,00)
                            recompensa = 0.00;
                            System.out.printf("Empregado: %s %s | Salário: R$%,.2f | Bônus aniversário: R$%,.2f\n",
                                empregadoAtual.getNome(), empregadoAtual.getSobrenome(),
                                empregadoAtual.getPagamento(), recompensa);
                        }
 
                    } // final do 'for' de EmpregadoAssalariado

                    // percorre o array de 'EmpregadoComissionado' verificando o mês de nascimento
                    for(EmpregadoComissionado empregadoAtual : empregadoComissionado) {

                        // variável que armazena o valor do bônus de aniversário
                        double recompensa;

                        // compara o mês informado com o mês de nascimento do empregado
                        if(diaMesAno.getMonth() == empregadoAtual.getDataNascimento().getMonth()) {
                            // mês coincide: empregado recebe bônus de R$200,00
                            recompensa = 200.00;
                            System.out.printf("Empregado: %s %s | Salário: R$%,.2f | Bônus aniversário: R$%,.2f\n",
                                empregadoAtual.getNome(), empregadoAtual.getSobrenome(),
                                empregadoAtual.getPagamento(), recompensa);
                        }
                        else {
                            // mês não coincide: sem bônus (R$0,00)
                            recompensa = 0.00;
                            System.out.printf("Empregado: %s %s | Salário: R$%,.2f | Bônus aniversário: R$%,.2f\n",
                                empregadoAtual.getNome(), empregadoAtual.getSobrenome(),
                                empregadoAtual.getPagamento(), recompensa);
                        }
 
                    } // final do 'for' de EmpregadoComissionado

                    // percorre o array de 'EmpregadoHorista' verificando o mês de nascimento
                    for(EmpregadoHorista empregadoAtual : empregadoHorista) {

                        // variável que armazena o valor do bônus de aniversário
                        double recompensa;

                        // compara o mês informado com o mês de nascimento do empregado
                        if(diaMesAno.getMonth() == empregadoAtual.getDataNascimento().getMonth()) {
                            // mês coincide: empregado recebe bônus de R$200,00
                            recompensa = 200.00;
                            System.out.printf("Empregado: %s %s | Salário: R$%,.2f | Bônus aniversário: R$%,.2f\n",
                                empregadoAtual.getNome(), empregadoAtual.getSobrenome(),
                                empregadoAtual.getPagamento(), recompensa);
                        }
                        else {
                            // mês não coincide: sem bônus (R$0,00)
                            recompensa = 0.00;
                            System.out.printf("Empregado: %s %s | Salário: R$%,.2f | Bônus aniversário: R$%,.2f\n",
                                empregadoAtual.getNome(), empregadoAtual.getSobrenome(),
                                empregadoAtual.getPagamento(), recompensa);
                        }
 
                    } // final do 'for' de EmpregadoHorista

                    // percorre o array de 'EmpregadoComissionadoMaisFixo' verificando o mês de nascimento
                    for(EmpregadoComissionadoMaisFixo empregadoAtual : empregadoComissionadoMaisFixo) {

                        // variável que armazena o valor do bônus de aniversário
                        double recompensa;

                        // compara o mês informado com o mês de nascimento do empregado
                        if(diaMesAno.getMonth() == empregadoAtual.getDataNascimento().getMonth()) {
                            // mês coincide: empregado recebe bônus de R$200,00
                            recompensa = 200.00;
                            System.out.printf("Empregado: %s %s | Salário: R$%,.2f | Bônus aniversário: R$%,.2f\n",
                                empregadoAtual.getNome(), empregadoAtual.getSobrenome(),
                                empregadoAtual.getPagamento(), recompensa);
                        }
                        else {
                            // mês não coincide: sem bônus (R$0,00)
                            recompensa = 0.00;
                            System.out.printf("Empregado: %s %s | Salário: R$%,.2f | Bônus aniversário: R$%,.2f\n",
                                empregadoAtual.getNome(), empregadoAtual.getSobrenome(),
                                empregadoAtual.getPagamento(), recompensa);
                        }
 
                    } // final do 'for' de EmpregadoComissionadoMaisFixo

                    break;

                //opção 3
                case PROCESSAMENTO_CONJUNTO:
                    System.out.println("\n3 - Atividade 3: Processamento conjunto de objetos das classes 'Compra', 'EmpregadoAssalariado', 'EmpregadoComissionado', 'EmpregadoHorista' e 'EmpregadoComissionadoMaisFixo'");
                    System.out.println("---------------------------------------------------------------------------------------------------");

                    // cria array de objetos 'Pagavel' de dez elementos
                    Pagavel objetosPagaveis[] = new Pagavel[ 10 ];
      
                    // preenche o array com objetos que implementam 'Pagavel'

                    // Compras
                    objetosPagaveis[ 0 ] = new Compra( "01234", "power bank", 2, 375.00 );

                    objetosPagaveis[ 1 ] = new Compra( "56789", "cabo HDMI", 4, 79.95 );

                    // EmpregadoAssalariado
                    objetosPagaveis[ 2 ] =  
                        new EmpregadoAssalariado(
                            "Joel",
                            "Oliveira",
                            "555.555.555-55",
                            29,
                            2,
                            2004,
                            800.00 );

                    objetosPagaveis[ 3 ] = 
                        new EmpregadoAssalariado(
                            "Lisa",
                            "Fernandes",
                            "666.666.666-66",
                            24,
                            6,
                            1994,
                            1200.00 );

                    // EmpregadoComissionado
                    objetosPagaveis[ 4 ] =
                        new EmpregadoComissionado(
                            "Thiago",
                            "Barbosa",
                            "111.222.333-44",
                            15,
                            4,
                            1989,
                            18000.00,
                            0.11 );

                    objetosPagaveis[ 5 ] =
                        new EmpregadoComissionado(
                            "Marina",
                            "Ribeiro",
                            "222.333.444-55",
                            2,
                            8,
                            1993,
                            22000.00,
                            0.09 );

                    // EmpregadoHorista
                    objetosPagaveis[ 6 ] =
                        new EmpregadoHorista(
                            "Rafael",
                            "Cardoso",
                            "333.444.555-66",
                            20,
                            5,
                            1996,
                            40.00,
                            45.0 );

                    objetosPagaveis[ 7 ] =
                        new EmpregadoHorista(
                            "Patricia",
                            "Araujo",
                            "444.555.666-77",
                            11,
                            12,
                            1990,
                            32.00,
                            38.0 );

                    // EmpregadoComissionadoMaisFixo
                    objetosPagaveis[ 8 ] =
                        new EmpregadoComissionadoMaisFixo(
                            "Eduardo",
                            "Vieira",
                            "555.666.777-88",
                            9,
                            7,
                            1984,
                            28000.00,
                            0.08,
                            2200.00 );

                    objetosPagaveis[ 9 ] =
                        new EmpregadoComissionadoMaisFixo(
                            "Carolina",
                            "Moreira",
                            "666.777.888-99",
                            18,
                            3,
                            1992,
                            32000.00,
                            0.06,
                            1900.00 );

                    System.out.println( 
                        "Compras e Empregados processados polimorficamente:\n" ); 

                    // processa genericamente cada elemento no array 'objetosPagaveis' 
                    for ( Pagavel pagavelAtual : objetosPagaveis )
                    {
                        // gera saída de pagavelAtual e seu quantia de pagamento apropriado 
                        System.out.printf( "%s \n%s: R$%,.2f\n\n", 
                            pagavelAtual.toString(),
                            "Pagamento total", pagavelAtual.getPagamento() ); 
                    } // final do 'for'

                    // exibe os respectivos nomes das classes efetivas de cada objeto
                    System.out.println("Nome da classe efetiva de cada objeto que implementa a interface 'Pagavel':");

                    // obtém o nome do tipo de cada objeto no array 'objetosPagaveis'
                    for (int j = 0; j < objetosPagaveis.length; j++) {
                        System.out.printf("objetosPagaveis[%d] é um(a) %s\n", j,
                                objetosPagaveis[j].getClass().getName());
                    }

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
                "INTERFACES em JAVA",
                "PEDRO AFONSO PAULINA ATAIDE",
                "121 092 251 1 018");
    }

}
