package Model;

public class ValidaPositivoNegativo {
    public static boolean validaPositivoNegativo(float valor) {
        if(valor < 0) {
            return false;
        }
        return true;
    }
}
