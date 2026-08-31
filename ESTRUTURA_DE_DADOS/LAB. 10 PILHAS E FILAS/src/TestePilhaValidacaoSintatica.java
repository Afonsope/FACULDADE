// --------------------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : PILHAS E FILAS BASEADAS EM ARRAYDEQUE E PRIORITYQUEUE em JAVA
// Ano/S: 2026/1S
// --------------------------------------------------------------------

// importação para permitir o uso de 'ArrqyDeque'
import java.util.ArrayDeque;

// classe para realização de testes de
// VALIDAÇÃO SINTÁTICA de expressões algébricas com 'Pilha'
// --------------------------------------------------------
public class TestePilhaValidacaoSintatica {

    // método da classe para realização do teste
    // -----------------------------------------
    public void executaTeste() {

        // declaração de variáveis auxiliares para a manipulação da 'Pilha'
        boolean expressaoOK;
        char    caracter, cPop;
        int     tipoErro;

        // declaração de constante para indicar nível de 'verbosidade'
        final boolean VERBOSO = true;

        // dados para teste:
        // 'Strings' que representam expressões algébricas
        // para as quais quer-se verificar a validade
        // (todo escopo aberto foi efetivamente fechado, e na ordem certa)
        String expressao1 = "{[(A+B)*C]+[D-(E*F)]}"  ;   // correta
        String expressao2 = "{{[(A+B)*C]+[D-(E*F)]}" ;   // erro 1: abriu escopo mas não o fechou
        String expressao3 = "{[(A+B)*C]+[D-(E*F)]}}" ;   // erro 2: fechou escopo sem tê-lo aberto
        String expressao4 = "{[(A+B)*C]+[D-(E*F)])"  ;   // erro 3: caracteres de abertura e fechamento de escopo não "casam"
        
        // descrições dos erros
        String[] descricoesErros = {
            "Sem erro!",
            "Erro tipo 1: abriu escopo mas não o fechou!",
            "Erro tipo 2: fechou escopo sem tê-lo aberto!",
            "Erro tipo 3: caracteres de abertura e fechamento de escopo não 'casam'"
        };

        // instanciação de um objeto 'Pilha'
        // para armazenar 'Character' (inicialmente vazio)
        // -----------------------------------------------
        ArrayDeque<Character> pilhaChar = new ArrayDeque<>();
        System.out.println("\nPILHA por ARRAYDEQUE");
        System.out.println("---------------------------------");

        // instanciação de um vetor convencional de 'String'
        // para armazenar todas as expressões juntas
        String[] expressoes = { expressao1, expressao2, expressao3, expressao4 };
        
        // instanciação de Strings para organizar
        // os caracteres de abertura e fechamento de escopo
        final String aberturaEscopo   = "{[(";
        final String fechamentoEscopo = "}])";

        // loop de expressoes a analisar
        for ( String expr : expressoes ) {
            // exibe a expressão sob análise
            System.out.println("\nExpressão a analisar: " + expr);

            // supõe que, "a priori", a expressão passará no teste de simetria
            expressaoOK = true;
            tipoErro = 0;

            // "limpa" a 'Pilha' para esta análise
            pilhaChar.clear();

            // para cada caracter da expressão analisada
            for (int i = 0; i < expr.length()  &&  expressaoOK; i++) {

                // separa o caracter
                caracter = expr.charAt(i);

                // se é um caracter de abertura de escopo
                if ( aberturaEscopo.indexOf(caracter) != -1 ) {
                    // empilha o caracter atual
                    if (VERBOSO) {
                        System.out.printf("Operacão %2d - INSERÇÃO - Caracter %c\n", (i + 1), caracter);
                    }
                    pilhaChar.push(caracter);
                }
                // senão
                else {
                    // se é um caracter de fechamento de escopo
                    if ( fechamentoEscopo.indexOf(caracter) != -1 ) {
                        // se pilha não está vazia
                        if ( ! pilhaChar.isEmpty() ) {
                            // desempilha o caracter do topo
                            cPop = pilhaChar.pop();
                            if (VERBOSO) {
                                System.out.printf("Operação %2d - REMOÇÃO  - Caracter %c\n", (i+1),cPop);
                            }
                            // se os caracteres não correspondem ao mesmo tipo de escopo
                            if ( (cPop != '{' && caracter == '}') ||
                                 (cPop != '[' && caracter == ']') ||
                                 (cPop != '(' && caracter == ')')
                               ) {
                                // indica que a expressão não passou no teste
                                expressaoOK = false;
                                // indica tipo do erro (3 neste caso)
                                tipoErro = 3;
                            }
                            // senão, deve continuar ... nada a fazer aqui
                        }
                        // senão (pilha está vazia mas a expressão ainda não acabou)
                        else {
                            // indica que a expressão não passou no teste
                            expressaoOK = false;
                            // indica tipo do erro (2 neste caso)
                            tipoErro = 2;
                            
                        }
                    }
                    // senão (não é caracter de abertura nem fechamento)
                    // deve continuar, pois é um caracter desinteressante para a validação
                    // nada a fazer aqui
                }

            }
            
            // após a expressão analisada...
            // se a expressão ainda for tida como sintaticamente correta
            if ( expressaoOK ) {
                // se a pilha não está vazia
                if ( ! pilhaChar.isEmpty() ) {
                    // indica que a expressão não passou no teste
                    expressaoOK = false;
                    // indica tipo do erro (1 neste caso)
                    tipoErro = 1;
                }
            }
            
            // exibe o resultado do teste
            if ( expressaoOK ) {
                System.out.printf(
                    "A expressão %s é sintaticamente correta pelo critério estabelecido !!!\n",
                    expr);
            }
            else {
                System.out.printf(
                    "A expressão %s NÃO É sintaticamente correta pelo critério estabelecido !!!\n%s\n",
                    expr, 
                    descricoesErros[tipoErro]);
                
            }

        }

    }

}