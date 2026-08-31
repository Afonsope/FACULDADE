package View;

public class OutputView {

    public static void exibirResultadoCep(boolean valido) {
        if (valido) {
            System.out.println("CEP válido.");
        } else {
            System.out.println("CEP inválido.");
        }
    }

    public static void exibirResultadoNota(boolean valida) {
        if (valida) {
            System.out.println("Nota válida.");
        } else {
            System.out.println("Nota inválida. Digite um valor entre 0 e 10.");
        }
    }

    public static void exibirPositivoNegativo(boolean positivo) {
        if (positivo) {
            System.out.println("Valor positivo.");
        } else {
            System.out.println("Valor negativo.");
        }
    }

    public static void exibirParImpar(boolean par) {
        if (par) {
            System.out.println("Valor par.");
        } else {
            System.out.println("Valor ímpar.");
        }
    }

    public static void exibirErro(String mensagem) {
        System.out.println("Erro: " + mensagem);
    }

    public static void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
