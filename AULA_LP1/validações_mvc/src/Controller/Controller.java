package Controller;

import Model.ValidaCep;
import Model.ValidaNota;
import Model.ValidaParImpar;
import Model.ValidaPositivoNegativo;
import View.InputView;
import View.MenuView;
import View.OutputView;

/**
 * Responsabilidade: coordenar o fluxo entre View e Model (Validações).
 *
 * REGRAS do Controller:
 *  - NÃO usa Scanner diretamente → delega ao InputView
 *  - NÃO usa System.out diretamente → delega ao OutputView
 *  - NÃO contém lógica de validação → delega às classes de Validacao
 *  - SÓ coordena: pede dado à View, manda pro Model, devolve resultado à View
 */
public class Controller {

    public static void executar() {
        boolean continuar = true;

        while (continuar) {
            limparTela();

            int opcao = MenuView.exibirMenuEObterEscolha();

            switch (opcao) {
                case 1:
                    tratarCep();
                    break;

                case 2:
                    tratarNota();
                    break;

                case 3:
                    tratarPositivoNegativo();
                    break;

                case 4:
                    tratarParImpar();
                    break;

                case 5:
                    {
                    OutputView.exibirMensagem("Encerrando...");
                    return;
                }
            }

            continuar = InputView.lerContinuar();
        }
    }

    // ---------------------------------------------------------------
    // Métodos privados: cada um trata UM caso de uso
    // ---------------------------------------------------------------

    private static void tratarCep() {
        String cep;
        boolean cepValido = false;

        do {
            cep = InputView.lerCep();

            if (cep.isEmpty()) {
                OutputView.exibirErro("O CEP não pode ser vazio.");
                continue;
            }

            cepValido = ValidaCep.validarCEP(cep);
            OutputView.exibirResultadoCep(cepValido);

        } while (!cepValido);
    }

    private static void tratarNota() {
        float nota;
        boolean notaValida = false;

        do {
            nota = InputView.lerNota();
            notaValida = ValidaNota.validaNota(nota);
            OutputView.exibirResultadoNota(notaValida);
        } while (!notaValida);
    }

    private static void tratarPositivoNegativo() {
        float valor = InputView.lerValorNumerico();
        boolean positivo = ValidaPositivoNegativo.validaPositivoNegativo(valor);
        OutputView.exibirPositivoNegativo(positivo);
    }

    private static void tratarParImpar() {
        float valor = InputView.lerValorNumerico();
        boolean par = ValidaParImpar.validaParImpar(valor);
        OutputView.exibirParImpar(par);
    }

    private static void limparTela() {
        // Funciona em terminais Unix/Windows com ANSI
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
