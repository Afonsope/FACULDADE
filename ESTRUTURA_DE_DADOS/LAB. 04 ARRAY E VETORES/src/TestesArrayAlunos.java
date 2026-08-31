// -------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : ARRAYS de OBJETOS em JAVA
// Ano/S: 2026/1S
// -------------------------------------

// importação de class para leitura de dados do teclado
import java.util.Scanner;

// classe que realiza os testes solicitados
// ----------------------------------------
public class TestesArrayAlunos {

    // Acionador dos testes (este método é chamado pelo 'CoordenadorExecucao')
    // (recebe como argumento o objeto 'Scanner' para a interação com o teclado)
    public void realizaTestes( Scanner teclado ) {

        // Ação 1
        // Criar um array unidimensional de Aluno, em que cada elemento é um objeto da classe Aluno.
        // O array deve permitir o armazenamento de dados de 4 alunos.
        Aluno[] alunos = new Aluno[4];

        // Ação 2
        // Preencher o conteúdo do array a partir de dados obtidos via teclado, um aluno por vez.
        // Utilizar o método construtor para transferir os dados a cada objeto da classe Aluno.
        for(int i = 0; i < alunos.length; i++) {
            
            // COLETAR OS DADOS DO OBJETO ALUNO
            System.out.print("Informe o nome do aluno: ");
            String nome = teclado.nextLine();
            System.out.print("Informe o RA do aluno: ");
            String RA = teclado.nextLine();
            System.out.print("Informe o curso do aluno: ");
            String curso = teclado.nextLine();

            // INSTANCIAR O OBJETO ALUNO, TRANSFERINDO OS DADOS PARA O CONSTRUTOR
            alunos[i] = new Aluno(nome, RA, curso);
        }

        // Ação 3
        // Exibir o conteúdo do array utilizando o comando 'for' (convencional, que utiliza um contador)
        // e os métodos 'getters' previstos na classe Aluno.
        System.out.println("Exibindo os dados dos alunos - 'for' convencional e 'getters'");
        for(int i = 0; i < alunos.length; i++){
            System.out.printf("Alunos %d: \n", (i+1));
            System.out.println("- nome: " + alunos[i].getNome());
            System.out.println("- RA: " + alunos[i].getRA());
            System.out.println("- curso: " + alunos[i].getCurso());
        }

        // Ação 4
        // Por meio dos métodos 'setters' previstos na classe Aluno, alterar os atributos de
        // um dos alunos cujos dados estão armazenados no array.
        alunos[2].setNome("Carlos Magnus");
        alunos[2].setRA("123456");
        alunos[2].setNome("Engenharia");

        // Ação 5
        // Exibir o conteúdo do array utilizando o comando 'for' (na versão simplificada, que não exige
        // um contador para iterar) e o método de impressão previsto na classe Aluno.
        for(Aluno a : alunos) {
            a.exibeDadosAluno();
        }

    }

}
