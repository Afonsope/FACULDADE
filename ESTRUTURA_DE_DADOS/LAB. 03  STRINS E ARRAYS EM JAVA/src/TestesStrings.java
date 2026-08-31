// ------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : STRINGS, MATH e ARRAYS JAVA
// Ano/S: 2026/1S
// ------------------------------------

// classe que implementa os testes com objetos 'String'
public class TestesStrings {

    // ATRIBUTOS
    // ---------

    // uma String para cada palavra do próprio nome
    final String NOME_1;
    final String NOME_2;
    final String NOME_3;
    final String nome4;

    // uma String para o nome da turma
    //String nomeTurma;

    // CONSTRUTOR
    // ----------
    TestesStrings() {

        // Ação 1
        // Criar uma String para cada palavra do próprio nome
        // Aqui, confunde-se com a própria definição dos atributos (constantes, no caso)
        NOME_1 = "Pedro";
        NOME_2 = "Afonso";
        NOME_3 = "Paulina";
        nome4 = "Ataide";

    }

    // MÉTODOS DA CLASSE
    // -----------------

    // 'Ponto de entrada' da classe
    // Acionador dos métodos abaixo (este método é chamado pelo
    // 'CoordenadorExecucao')
    public void realizaTestes(String nomeTurma) {

        // Ação 2 - monta o nome completo
        String nomeCompleto = montaNomeCompleto();

        // Ação 3 - exibe nome e comprimento
        exibeNomeComprimento(nomeCompleto);

        // Ação 5 - exibe frase com turma e nome
        exibeFraseTurmaNome(nomeTurma, nomeCompleto);

    }

    // Ação 2
    // Criar uma nova String que, por concatenação, resulta no nome completo
    private String montaNomeCompleto() {
        return NOME_1 + " " + NOME_2 + " " + NOME_3 + " " + nome4;
    }

    // Ação 3
    // Exibir na tela o seu nome completo e também
    // o respectivo comprimento (quantidade de caracteres)
    private void exibeNomeComprimento(String nomeCompleto) {
        System.out.println("\nO nome completo é " + nomeCompleto + " (" + nomeCompleto.length()
                + " caracteres, incluindo os espaços em branco).");
    }

    // Ação 4
    // Obter, do teclado, o nome da sua turma (exemplo: "3o_INFO_M")
    // (feito no próprio 'CoordenadorExecucao' para facilitar o uso do Scanner)

    // Ação 5
    // Exibir na tela uma frase que reúne a turma e o seu nome completo
    private void exibeFraseTurmaNome(String nomeTurma, String nomeCompleto) {
        System.out.println("\nUm dos alunos da turma '" + nomeTurma + "' é " + nomeCompleto + ".");
    }

}
