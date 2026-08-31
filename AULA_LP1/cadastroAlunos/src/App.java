import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Aluno objAluno = new Aluno();

        Aluno objAluno2 = new Aluno(123456, "Pedro Afonso", "Info", "gmail@gmail.com", "123456789-00", "12345-6789");

        objAluno2.mostrarDados();
        objAluno.cadastrar();
        objAluno.mostrarDados();

        Aluno objAluno3 = new Aluno();
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Digite o nome do aluno: ");
            objAluno3.setNome(scanner.nextLine());
        } while(objAluno3.getNome().isEmpty() || objAluno3.getNome().length() < 10);

    }
}
