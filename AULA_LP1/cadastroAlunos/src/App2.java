import java.util.ArrayList;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        ArrayList<Aluno> listaAlunos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        String resposta = new String();

        // CADASTRANDO UMA QUANTIDADE INDETERMINADA DE ALUNOS
        do{
            Aluno objAluno = new Aluno();
            objAluno.cadastrar();
            listaAlunos.add(objAluno);

            System.out.println("Deseja cadastrar outro aluno? (S/N)");
            resposta = scanner.nextLine();
        } while(resposta.equalsIgnoreCase("S"));

        // MOSTRA OS DADOS DE TODOS OS ALUNOS CADASTRADOS
        for(Aluno aluno : listaAlunos){
            aluno.mostrarDados();
            System.out.println("----------------------------------");
        }
    }
}
