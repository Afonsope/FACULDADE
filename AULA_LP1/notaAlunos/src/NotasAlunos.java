import java.util.Scanner;

public class NotasAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nomeAluno = new String();
        String melhorAluno = new String();
        String piorAluno = new String();
        String alunosAprovados = new String();

        float nota = 0, maiorNota = 0, menorNota = 0, somaNotas = 0;
        int contador = 0, continuar = 1 , reprovados = 0;

        do {
            do {
                try {
                    System.out.println("Digite a nota do aluno (entre 0 e 10):");
                    nota = scanner.nextFloat();
                    if (nota < 0 || nota > 10)
                        throw new Exception("Nota invalida, a nota precisa ser entre 0 e 10");
                } catch(Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                    nota = -1;
                    scanner.nextLine();
                }
            } while (nota < 0 || nota > 10);

            System.out.println("Digite o nome do aluno:");
            scanner.nextLine(); // limpar buffer
            nomeAluno = scanner.nextLine();

            contador++;

            if( contador == 1){
                maiorNota = nota;
                melhorAluno = nomeAluno;
                menorNota = nota;
                piorAluno = nomeAluno;
            } else {
                if (nota > maiorNota) {
                    maiorNota = nota;
                    melhorAluno = nomeAluno;
                }
                if (nota < menorNota) {
                    menorNota = nota;
                    piorAluno = nomeAluno;
                }
            }

            if (nota < 6) 
                reprovados++;
            else 
                alunosAprovados += nomeAluno + " - " + nota + "\n";

            somaNotas += nota;

            System.out.println("Quer continuar? (1 - Sim / 0 - Não)");
            continuar = scanner.nextInt();

        } while (continuar == 1);

        System.out.println("Maior nota: " + maiorNota + " - Aluno: " + melhorAluno);
        System.out.println("Menor nota: " + menorNota + " - Aluno: " + piorAluno);
        System.out.printf("Média das notas: %.2f%n", (somaNotas / contador));
        System.out.println("Alunos Reprovados: " + reprovados);
        System.out.println("Alunos Aprovados:\n" + alunosAprovados.toString());

        scanner.close();
    }
}