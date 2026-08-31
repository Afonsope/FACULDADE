// --------------------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : PILHAS E FILAS BASEADAS EM ARRAYDEQUE E PRIORITYQUEUE em JAVA
// Ano/S: 2026/1S
// --------------------------------------------------------------------

// Classe 'Livro'
public class Livro {

    private String titulo;
    private String sobrenomeAutor;
    private String isbn;
    private int    qtdPaginas;

    // construtor com quatro argumentos
    public Livro(
            String titulo,
            String autor,
            String isbn,
            int    qtdPaginas) {

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

    public int getQtdPaginas() {
        return this.qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = ( qtdPaginas > 0 ) ? qtdPaginas : 0; // validação mínima
    }

    // retorna a representação de String de um objeto 'Livro'
    // sobrescreve 'toString'
    public String toString() {
        return String.format("\nLivro: %s\nAutor: %s\nISBN : %s\nPágs.: %3d",
                getTitulo(), getSobrenomeAutor(), getIsbn(), getQtdPaginas());
    } // fim do método toString

} // fim da classe 'Livro'