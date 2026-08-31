import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int qtdAlunos = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.println("Digite a quantidade de alunos: ");
                qtdAlunos = scanner.nextInt();
                if (qtdAlunos <= 0) throw new Exception("Informe um número maior que zero.");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
                qtdAlunos = 0; // garante que o loop continua
            }
        } while (qtdAlunos <= 0);

        float[][] notasAlunos = new float[qtdAlunos][3];

        for (int i = 0; i < qtdAlunos; i++) {
            for (int j = 0; j < 3; j++) {
                do {
                    try {
                        System.out.println("Digite a nota " + (j + 1) + " do aluno " + (i + 1) + ": ");
                        notasAlunos[i][j] = scanner.nextFloat();
                        if (notasAlunos[i][j] < 0 || notasAlunos[i][j] > 10)
                            throw new Exception("Informe uma nota entre 0 e 10.");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                        scanner.nextLine();
                        notasAlunos[i][j] = -1; // força repetição do loop
                    }
                } while (notasAlunos[i][j] < 0 || notasAlunos[i][j] > 10);
            }
        }

        // Para cada nota (coluna), guarda o índice do aluno com maior e menor valor
        int[] idxMaior = new int[3];
        int[] idxMenor = new int[3];

        for (int j = 0; j < 3; j++) {
            idxMaior[j] = 0;
            idxMenor[j] = 0;
            for (int i = 1; i < qtdAlunos; i++) {
                if (notasAlunos[i][j] > notasAlunos[idxMaior[j]][j]) {
                    idxMaior[j] = i;
                }
                if (notasAlunos[i][j] < notasAlunos[idxMenor[j]][j]) {
                    idxMenor[j] = i;
                }
            }
        }

        System.out.println("\n--- Resultado ---");
        for (int j = 0; j < 3; j++) {
            System.out.println("Nota " + (j + 1) + ":");
            System.out.println("  Maior: Aluno " + (idxMaior[j] + 1) + " com " + notasAlunos[idxMaior[j]][j]);
            System.out.println("  Menor: Aluno " + (idxMenor[j] + 1) + " com " + notasAlunos[idxMenor[j]][j]);
        }

        scanner.close();
    }
}
