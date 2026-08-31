public class Exemplo {
    private int contador = 0;
    public final String CURSO = "Info";

    public int getContador() {
        return contador;
    }

    void mostrar() {
        System.out.println("Atributo: " + contador + " - " + CURSO);
        contador++;
    }

    void contar() {
        System.out.println("Rodou linha 15");
        int contador = 0;
        contador++;
        System.out.println("Linha 18 (Variável): " + contador);
    }

    void contar(int contador) {
        System.out.println("Rodou linha 22");
        contador++;
        System.out.println("Linha 24 (Variável): " + contador);
    }

    public void contarUtilização() {
        System.out.println("Rodou linha 28");
        contador++;
    }

    void contarUtilização(int contador){
        System.out.println("Rodou linha 33");
        this.contador++;
        contador++;
         System.out.println("Linha 36 (Atributo): " + this.contador);
        System.out.println("Linha 37 (Variável): " + contador);
    }
}
