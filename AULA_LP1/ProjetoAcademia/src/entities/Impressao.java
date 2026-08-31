package entities;

import java.time.LocalDate;

public interface Impressao {

    public static final String CABECALHO = "========================== EXERCÍCIOS DO DIA =======================";
    public void imprimirTreino();
    public void imprimirTreino(LocalDate data);
    
}
