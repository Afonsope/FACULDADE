// --------------------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : PILHAS E FILAS BASEADAS EM ARRAYDEQUE E PRIORITYQUEUE em JAVA
// Ano/S: 2026/1S
// --------------------------------------------------------------------
 
// classe para realização de testes com
// 'Fila' contendo objetos 'Livro'
// ------------------------------------

// importação para permitir o uso de 'ArrayDeque'
import java.util.ArrayDeque;
// importação para permitir o uso de 'iterator'
import java.util.Iterator;

public class TesteFilaLivros {

    // método da classe para realização do teste
    // -----------------------------------------
    public void executaTeste() {
        
        // declaração de constante para indicar nível de 'verbosidade'
        final boolean VERBOSO = false;
        
        // instanciação de um objeto 'Fila'
        // para armazenar 'Livro' (inicialmente vazio)
        ArrayDeque<Livro> livrosD = new ArrayDeque<>();
        
        // instanciação de 5 objetos 'Livro'
        // que serão armazenados num 'array' convencional
        Livro[] livros = new Livro[5];
        
        livros[0] = new Livro( 
            "Estruturas de Dados com Java", 
            "Carlson", 
            "11111", 
            300 );
        
        livros[1] = new Livro(
            "Bancos de Dados super-avançados",
            "Alguém",
            "22222",
            100 );
        
        livros[2] = new Livro(
            "Algoritmos: Teoria e Prática",
            "Cormen",
            "33333",
            926 );
        
        livros[3] = new Livro(
            "Clean Code",
            "Martin",
            "44444",
            431 );
        
        livros[4] = new Livro(
            "Design Patterns",
            "Gamma",
            "55555",
            395 );
        
                        
        // armazenamento de 5 objetos 'Livro' na 'Fila'
        for ( Livro liv : livros ) {
            
            // INSERIR ('enqueue')
            livrosD.offer(liv);

            if ( VERBOSO ) {
                System.out.println(" - 'livrosD' -> " + livrosD);
            }

        }
        
        // exibição da quantidade de elementos efetivamente armazenados
        System.out.printf("Após incluir todos os livros na fila...\n");
        System.out.printf("Qtd. livros na Fila            : %2d\n", livrosD.size());
        System.out.printf("\nPróximo livro a sair da Fila :%s\n",  livrosD.peek());
        
        // exibição direta do conteúdo da 'Fila' (usa o método 'toString')
        System.out.println("\nExibição direta ('toString')   : " + livrosD);
        
        // exibição do conteúdo da 'Fila' por meio de 'for' abreviado
        System.out.print("\nExibição via 'for' abreviado   : [");
        for ( Livro n : livrosD ) {
            System.out.printf("%s,",n);
        }
        System.out.println("]");
        
        // exibição do conteúdo da 'Fila' por meio de 'iterator'
        System.out.print("\nExibição via 'iterator'        : [");
        Iterator< Livro > iteradorL = livrosD.iterator();
        while ( iteradorL.hasNext() ) {
            System.out.printf("%s,",iteradorL.next());
        }
        System.out.println("]");

        // exibicao do conteudo da 'fila' por meio do 'ForEach' e 'funcao lambda' com codigo
        System.out.print("\nExibição via 'forEach'        : [");
        livrosD.forEach(livro -> 
          {
            if( !livro.equals(livrosD.peekLast())) {
                System.out.println(livro + ",");
            }
            else {
                System.out.println(livro);
            }
          }
        );
        System.out.println("]");
        
    }

}