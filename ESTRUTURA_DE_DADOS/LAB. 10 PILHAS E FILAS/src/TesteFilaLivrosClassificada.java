// --------------------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : PILHAS E FILAS BASEADAS EM ARRAYDEQUE E PRIORITYQUEUE em JAVA
// Ano/S: 2026/1S
// --------------------------------------------------------------------
 
// classe para realização de testes com
// 'Fila' contendo objetos 'LivroClassificavel'
// --------------------------------------------

// importação para permitir o uso de 'PriorityQueue'
import java.util.PriorityQueue;
// importação para permitir o uso de 'iterator'
import java.util.Iterator;

public class TesteFilaLivrosClassificada {

    // método da classe para realização do teste
    // -----------------------------------------
    public void executaTeste() {
        
        // declaração de constante para indicar nível de 'verbosidade'
        final boolean VERBOSO = false;
        
        // instanciação de um objeto 'FilaClassificada'
        // para armazenar 'LivroClassificavel' (inicialmente vazio)
        PriorityQueue<LivroClassificavel> livrosC = new PriorityQueue<>();
        
        // instanciação de 5 objetos 'LivroClassificavel'
        // que serão armazenados num 'array' convencional
        LivroClassificavel[] livros = new LivroClassificavel[5];
        
        livros[0] = new LivroClassificavel( 
            "Estruturas de Dados com Java", 
            "Carlson", 
            "11111", 
            300 );
        
        // criar mais 4 livros
        // ...
        livros[1] = new LivroClassificavel( 
            "Bancos de Dados super-avançados", 
            "Alguém", 
            "22222", 
            100 );

         livros[2] = new LivroClassificavel(
            "Algoritmos: Teoria e Prática",
            "Cormen",
            "33333",
            926 );
        
        livros[3] = new LivroClassificavel(
            "Clean Code",
            "Martin",
            "44444",
            431 );
        
        livros[4] = new LivroClassificavel(
            "Design Patterns",
            "Gamma",
            "55555",
            395 );
        
                        
        // armazenamento de 5 objetos 'LivroClassificavel' na 'FilaClassificada'
        for ( LivroClassificavel liv : livros ) {
            
            // INSERIR ('enqueue')
            livrosC.offer(liv);

            if ( VERBOSO ) {
                System.out.println(" - 'livrosC' -> " + livrosC);
            }

        }
        
        // exibição da quantidade de elementos efetivamente armazenados
        System.out.printf("Após incluir todos os livros na Fila Classificada...\n");
        System.out.printf("Qtd. livros na Fila Classificada           : %2d\n", livrosC.size());
        System.out.printf("\nPróximo livro a sair da Fila Classificada:%s\n",  livrosC.peek());
        
        // exibição direta do conteúdo da 'FilaClassificada' (usa o método 'toString')
        System.out.println("\nExibição direta ('toString')      : " + livrosC);
        
        // exibição do conteúdo da 'FilaClassificada' por meio de 'for' abreviado
        System.out.print("\nExibição via 'for' abreviado      : [");
        for ( LivroClassificavel n : livrosC ) {
            System.out.printf("%s,",n);
        }
        System.out.println("]");
        
        // exibição do conteúdo da 'FilaClassificada' por meio de 'iterator'
        // ATENÇÃO: ordem de exibição pode ser diferente da classificação
        System.out.print("\nExibição via 'iterator' (ATENÇÃO) : [");
        Iterator< LivroClassificavel > iteradorL = livrosC.iterator();
        while ( iteradorL.hasNext() ) {
            System.out.printf("%s,",iteradorL.next());
        }
        System.out.println("]");
        
    }

}