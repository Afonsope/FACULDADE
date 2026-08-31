package Model;

public class ValidaNota {
    public static boolean validaNota(float valor) {
        if(valor < 0 || valor > 10) {
            return false;
        }
        return true;
    }
}
