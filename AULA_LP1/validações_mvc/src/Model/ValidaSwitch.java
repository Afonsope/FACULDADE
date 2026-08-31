package Model;

public class ValidaSwitch {
    public static boolean validaSwitch(int opcao) {
        if (opcao < 1 || opcao > 5) {
            return true;
        }
        return false;
    }
}