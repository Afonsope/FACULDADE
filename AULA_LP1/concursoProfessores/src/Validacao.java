public class Validacao {

    public static boolean validaNome(String nome){
        if(nome.length() < 3)
            return true;
        return false;
    }

    public static boolean validaIdade(int idade){
        if(idade < 18)
            return true;
        return false;
    }

    public static boolean validaTempoExperiencia(int tempoExperiencia, int idade){
        if(tempoExperiencia < 0 || tempoExperiencia > idade) 
            return true;
        return false;
    }

    public static boolean validaArea(int area){
            if(area < 1 || area > 3) 
                return true;
            return false;
    }

    public static boolean validaContinua(int continuar){
        if(continuar < 0 || continuar > 1)
            return true;
        return false;
    }

    public static boolean continua(int continuar){
        if(continuar == 1)
            return true;
        return false;
    }

    public static int calcularPontuacao(int idade, int tempoExperiencia, int area){

        if(area == 1)
            area = 5;
        else if(area == 2)
            area = 10;
        else
            area = 15;

        int pontuacao = (idade / 2) + (tempoExperiencia * 3) + area;
        
        return pontuacao;
    }
}
