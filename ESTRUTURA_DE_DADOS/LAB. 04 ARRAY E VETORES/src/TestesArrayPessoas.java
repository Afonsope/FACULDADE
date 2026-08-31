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
public class TestesArrayPessoas {

    // Acionador dos testes (este método é chamado pelo 'CoordenadorExecucao')
    // (recebe como argumento o objeto 'Scanner' para a interação com o teclado)
    public void realizaTestes( Scanner teclado ) {

        // Ação 1
        // Criar um array unidimensional de Pessoa, em que cada elemento é um objeto da classe Pessoa.
        // O array deve permitir o armazenamento de dados de 4 pessoas.
        Pessoa[] pessoas = new Pessoa[4];

        // Ação 2
        // Preencher o conteúdo do array a partir de dados obtidos via teclado, uma pessoa por vez.
        // Utilizar o método construtor para transferir os dados a cada objeto da classe Pessoa.
        for(int i = 0; i < pessoas.length; i++) {
            
            // COLETAR OS DADOS DO OBJETO ALUNO
            System.out.print("Informe o nome da Pessoa: ");
            String nome = teclado.nextLine();
            System.out.print("Informe o CPF da Pessoa: ");
            String CPF = teclado.nextLine();
            System.out.print("Informe a data de nascimento da Pessoa: ");
            String dataNascimento = teclado.nextLine();
            System.out.print("Informe a cidade de nascimento da Pessoa: ");
            String cidadeNascimento = teclado.nextLine();

            // INSTANCIAR O OBJETO ALUNO, TRANSFERINDO OS DADOS PARA O CONSTRUTOR
            pessoas[i] = new Pessoa(nome, CPF, dataNascimento, cidadeNascimento);
        }

        // Ação 3
        // Exibir o conteúdo do array utilizando o comando 'for' (convencional, que utiliza um contador)
        // e os métodos 'getters' previstos na classe Pessoa.
        System.out.println("Exibindo os dados das pessoas - 'for' convencional e 'getters'");
        for(int i = 0; i < pessoas.length; i++){
            System.out.printf("Pessoas %d: \n", (i+1));
            System.out.println("- nome: " + pessoas[i].getNome());
            System.out.println("- CPF: " + pessoas[i].getCPF());
            System.out.println("- data de nascimento: " + pessoas[i].getDataNascimento());
            System.out.println("- cidade de nascimento: " + pessoas[i].getCidadeNascimento());
        }

        // Ação 4
        // Por meio dos métodos 'setters' previstos na classe Pessoa, alterar os atributos de
        // uma das pessoas cujos dados estão armazenados no array.
        pessoas[2].setNome("Carlos Magnus");
        pessoas[2].setCPF("123456");
        pessoas[2].setDataNascimento("29/03/2007");
        pessoas[2].setCidadeNascimento("São José do Rio Preto");

        // Ação 5
        // Exibir o conteúdo do array utilizando o comando 'for' (na versão simplificada, que não exige
        // um contador para iterar) e o método de impressão previsto na classe Pessoa.
        for(Pessoa a : pessoas) {
            a.exibeDadosPessoa();
        }

    }

}
