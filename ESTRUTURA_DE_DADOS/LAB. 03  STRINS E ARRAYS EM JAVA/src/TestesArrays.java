// ------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : STRINGS, MATH e ARRAYS JAVA
// Ano/S: 2026/1S
// ------------------------------------

// classe que implementa os testes com 'arrays'
public class TestesArrays {

    // "Ponto de entada da classe'
    // Acionador dos métodos abaixo (este método é chamado pelo 'CoordenadorExeucao')
    public void realizaTestes() {

        // Ação 1 - monta array de String e exibe o nome completo
        exibeNomeCompleto();

        // Ação 2 - exibe array de números inteiros gerados randomicamente
        exibeArrayInt();

        // Ação 3 - exibe array bidimensional
        exibeArrayBidimensional();
        
        // Ação 4 - exibe array bidimensional de 'String'
        exibeArrayBidimensionalStrings();
    }
    
    // Ação 1
    // Criar um array unidimensional de String, em que cada elemento é uma palavra do seu nome.
    // Utilizar o comando for (convencional, que utiliza um contador) e a propriedade length
    // para exibir o seu nome completo.
    private void exibeNomeCompleto() {

        // declaração do array de Strings
        String[] nomes = { "Pedro", "Afonso", "Paulina", "Ataide" };

        // percurso do array para exibição do nome
        System.out.print("\nMeu nome completo é");
        // AQUI ...
        // UTILIZANDO 'FOR' CONVENCIONAL
        for(int i = 0; i < nomes.length; i++) {
            System.out.println(" " + nomes[i]);
        }
        System.out.println(".");

    }
    
    // Ação 2
    // Criar um array unidimensional (vetor), inicialmente vazio, que pode armazenar
    // 10 números inteiros. Preencher os elementos desse vetor com números randômicos entre 10 e 50.
    // Utilizar o comando for (na versão simplificada, que não exige um contador para iterar)
    // para exibir o conteúdo do vetor.
    private void exibeArrayInt() {

        // declaração do array de int
        // AQUI ...
        int[] numeros = new int[10];
        
        // criação de uma instância (objeto) da classe 'MetodosAvulsos' para permitir o acesso
        // aos respectivos métodos
        // AQUI ...
        MetodosAvulsos avulsos = new MetodosAvulsos();
        
        // preenchimento dos valores dos elementos do array com números randômicos
        // AQUI ...
        for(int i = 0; i < numeros.length; i++) {
            numeros[i] = avulsos.geraNumeroRandomico(10, 50);
        }
        
        // percurso do array para exibição dos números
        System.out.print("\nOs números gerados foram:");
        // AQUI ...
        // USANDO 'FOR' ABREVIADO ('ENHANCED'), QUE PERCORRRE O CONTEÚDO
        for(int n : numeros) {
            System.out.print(" " + n);
        }
        System.out.println();

    }

    // Ação 3
    // Criar um array bidimensional (matriz) de 3 linhas e 4 colunas,
    // já preenchido com valores arbitrários. Utilizar o comando for
    // (convencional, que utiliza um contador) e a propriedade length
    // para exibir o conteúdo da matriz.
    private void exibeArrayBidimensional() {

        // declaração do array bidimensional 3x4 de int
        int matriz[][] = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12} };

        // percurso do array bidimensional para exibição dos números
        System.out.println("\nOs números armazenados na matriz são:");
        // AQUI ...
        // USANDO 'FOR' CONVENCIONAL (BASEADO EM POSIÇÃO)
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                System.out.print(" " + matriz[i][j]);
            }
            System.err.println();
        }
        System.out.println();

    }

    // Ação 4
    // Criar um array bidimensional (matriz) de 3 linhas e 2 colunas,
    // inicialmente vazio, para armazenar objetos 'String'.
    // Cada linha corresponde a um aluno.
    // A primeira coluna armazena o RA e a segunda armazena o nome.
    // Preencha a matriz com valores arbitrários.
    // Utilizar o comando 'for' (convencional, que utiliza um contador)
    // e a propriedade 'length' para exibir o conteúdo da matriz.
    private void exibeArrayBidimensionalStrings() {

        // declaração do array bidimensional 3x2 de 'String', inicialmente vazio
        String[][] alunos = new String[3][2];

        System.out.println("\nOs dados dos alunos armazenados na matriz são:");
        // AQUI ...
        System.out.println();

        // preenchimento com valores arbitrários (TRÊS LINHAS, 2 COLUNAS -> 6 NOMES)
        // AQUI...
        alunos[0][0] = "Gabriel Fernandes Rigueto";
        alunos[0][1] = "Arthur Gabriel de Mendonça";
        alunos[1][0] = "Matheus de Paula";
        alunos[1][1] = "Matheus Mortari Leite";
        alunos[2][0] = "Mariana Firmo";
        alunos[2][1] = "Eduardo José Aidar";

        for(int i = 0; i < alunos.length; i++) {
            for(int j = 0; j < alunos[i].length; j++) {
                System.out.print(" " + alunos[i][j] + "\n");
            }
            System.err.println();
        }
        System.out.println();        

    }

}
