// --------------------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : PILHAS E FILAS BASEADAS EM ARRAYDEQUE E PRIORITYQUEUE em JAVA
// Ano/S: 2026/1S
// --------------------------------------------------------------------

// Classe 'Livro'
public class LivroClassificavel implements Comparable< LivroClassificavel > {

    private String  titulo;
    private String  sobrenomeAutor;
    private String  isbn;
    private Integer qtdPaginas;

    // construtor com quatro argumentos
    public LivroClassificavel(
            String  titulo,
            String  autor,
            String  isbn,
            Integer qtdPaginas) {

        this.titulo         = titulo;
        this.sobrenomeAutor = autor;
        this.isbn           = isbn;
        this.qtdPaginas     = qtdPaginas;

    } // fim do construtor

    // 'getters' e 'setters'
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSobrenomeAutor() {
        return this.sobrenomeAutor;
    }

    public void setSobrenomeAutor(String autor) {
        this.sobrenomeAutor = autor;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getQtdPaginas() {
        return this.qtdPaginas;
    }

    public void setQtdPaginas(Integer qtdPaginas) {
        this.qtdPaginas = ( qtdPaginas > 0 ) ? qtdPaginas : 0; // validação mínima
    }

    // retorna a representação de String de um objeto 'Livro'
    // sobrescreve 'toString'
    public String toString() {
        return String.format("\nLivro: %s\nAutor: %s\nISBN : %s\nPágs.: %3d",
                getTitulo(), getSobrenomeAutor(), getIsbn(), getQtdPaginas());
    } // fim do método toString

    // retorna indicativo da comparação de dois objetos 'Livro'
    // pelo critério especificado,
    // implementando o que foi prometido em 'implements Comparable'
    // sobrescreve 'compareTo' de 'Comparable'
    public int compareTo(LivroClassificavel outroLivro)
    {

        // compara pelo critério do 'titulo'
        //return this.titulo.compareTo(outroLivro.getTitulo());
        
        // compara pelo critério do 'sobrenomeAutor'
        //return this.sobrenomeAutor.compareTo(outroLivro.getSobrenomeAutor());
        
        // compara pelo critério do 'isbn'
        //return this.isbn.compareTo(outroLivro.getIsbn());
        
        // compara pelo critério da 'qtdPaginas'
        return this.qtdPaginas.compareTo(outroLivro.getQtdPaginas());
    }

} // fim da classe 'LivroClassificavel'