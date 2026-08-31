package View;

import java.util.Scanner;

/**
 * Responsabilidade: exibir o menu e retornar a escolha do usuário.
 * Não valida a lógica de negócio, não chama validadores de CEP, nota etc.
 * A única "validação" aqui é garantir que o número digitado está no range do menu.
 */
public class MenuView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int exibirMenuEObterEscolha() {
        int escolha = 0;

        do {
            System.out.println("\nEscolha qual tipo de validação deseja realizar:");
            System.out.println("1 - Validar CEP");
            System.out.println("2 - Validar Nota");
            System.out.println("3 - Validar Positivo ou Negativo");
            System.out.println("4 - Validar Ímpar ou Par");
            System.out.println("5 - Sair");

            try {
                if (!scanner.hasNextInt()) {
                    scanner.next(); // descarta entrada inválida
                    throw new Exception("Digite apenas números.");
                }
                escolha = scanner.nextInt();
                scanner.nextLine();

                if (escolha < 1 || escolha > 5) {
                    throw new Exception("Opção inválida. Escolha entre 1 e 5.");
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                escolha = 0; // força repetição do loop
            }

        } while (escolha < 1 || escolha > 5);

        return escolha;
    }
}
