package Model;

public class ValidaCep {
    public static boolean validarCEP(String cep){

        if(!validaTamanho(9, 9, cep)) {
            return false;
        }

        if(cep.charAt(5) != '-') {
            return false;
        }

        for(int i = 0; i < cep.length(); i++){
        if(i != 5 && !Character.isDigit(cep.charAt(i))){
            return false;
        }
    }
        
        return true;
    }

    public static boolean validaTamanho(int minimo, int maximo, String valor) {
           if(valor.length() < minimo || valor.length() > maximo) {
                return false;
           }
           return true;
    }
}
