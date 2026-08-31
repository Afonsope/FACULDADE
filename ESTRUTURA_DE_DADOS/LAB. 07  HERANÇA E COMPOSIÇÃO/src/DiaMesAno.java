// ------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : COMPOSIÇÃO E HERANÇA em JAVA
// Ano/S: 2026/1S
// ------------------------------------
 
// Declaração da classe DiaMesAno.
// Usa este nome para não confundir com a classe 'Date' de java.util,
// embora não haja confusão se não fizer 'import'
// ------------------------------------------------------------------

public class DiaMesAno {

    // atributos
    private int month; // 1-12
    private int day;   // 1-31 conforme o mês
    private int year;  // qualquer ano

    // construtor: chama checkMonth para confirmar o valor adequado para month;
    // chama checkDay para confirmar o valor adequado para day
    DiaMesAno(int month, int day, int year) {
        
        this.month = checkMonth(month); // valida month
        this.year  = year; // poderia validar year
        this.day   = checkDay(day); // valida day

        System.out.printf(
                "Após construtor do objeto 'DiaMesAno', data é: %s\n", this);
    } // fim do construtor

    // 'getter' para mês
    public int getMonth() {
        return month;
    }

    // 'getter' para dia
    public int getDay() {
        return day;
    }

    // 'getter' para ano
    public int getYear() {
        return year;
    }

    // 'setter' para mês
    public void setMonth(int month) {
        this.month = checkMonth(month); // valida month
    }

    // 'setter' para dia
    public void setDay(int day) {
        this.day = checkDay(day); // valida day
    }

    // 'setter' para ano
    public void setYear(int year) {
        this.year = year; // poderia validar year se necessário
    }

    // método utilitário para confirmar o valor adequado de month
    private int checkMonth(int month) {
        if (month > 0 && month <= 12) // valida month
        {
            return month;
        } else // month é inválido
        {
            System.out.printf(
                    "Mês inválido (%d) modificado ARBITRARIAMENTE para 1.", month);
            return 1; // mantém objeto em estado consistente
        } // fim de else
    } // fim do método checkMonth

    // método utilitário para confirmar o valor adequado de day com base em month e year
    private int checkDay(int day) {
        int daysPerMonth[]
                = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // verifica se day está no intervalo para month
        if (day > 0 && day <= daysPerMonth[month]) {
            return day;
        }

        // verifica ano bissexto
        if (month == 2 && day == 29 && (year % 400 == 0
                || (year % 4 == 0 && year % 100 != 0))) {
            return day;
        }

        System.out.printf("Dia inválido (%d) modificado ARBITRARIAMENTE para 1.", day);
        return 1;  // mantém objeto em estado consistente
    } // fim do método checkDay

    // retorna uma String no formato dia/mês/ano
    public String toString() {
        return String.format("%d/%d/%d", day, month, year);
    } // fim do método toString
} // fim da classe


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Fig. 8.7: DiaMesAno.java                                               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *************************************************************************/