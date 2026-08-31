package View;

import java.util.Scanner;

/**
 * Responsabilidade: APENAS ler entradas do usuário.
 * Não valida, não decide, não imprime resultados — só lê.
 */
public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String lerCep() {
        System.out.print("Informe o CEP: ");
        return scanner.nextLine().trim();
    }

    public static float lerNota() {
        System.out.print("Informe a nota (0 a 10): ");
        while (!scanner.hasNextFloat()) {
            System.out.print("Digite um número válido: ");
            scanner.next();
        }
        float nota = scanner.nextFloat();
        scanner.nextLine(); // limpa o buffer
        return nota;
    }

    public static float lerValorNumerico() {
        System.out.print("Informe o valor: ");
        while (!scanner.hasNextFloat()) {
            System.out.print("Digite um número válido: ");
            scanner.next();
        }
        float valor = scanner.nextFloat();
        scanner.nextLine(); // limpa o buffer
        return valor;
    }

    public static boolean lerContinuar() {
        System.out.println("Deseja realizar outra validação? (1 - Sim / 2 - Não)");
        while (!scanner.hasNextInt()) {
            System.out.print("Digite 1 ou 2: ");
            scanner.next();
        }
        int resposta = scanner.nextInt();
        scanner.nextLine();
        return resposta == 1;
    }
}
