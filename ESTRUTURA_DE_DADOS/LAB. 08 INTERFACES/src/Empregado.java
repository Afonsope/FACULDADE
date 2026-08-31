// ----------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : INTERFACES em JAVA
// Ano/S: 2026/1S
// ----------------------------------------
 
// Superclasse ABSTRATA 'Empregado', implementa 'Pagavel' (*) e 'Recompensavel' (**)
// - contém atributos e define métodos referentes a qualquer 'Empregado'
// - apresenta um método 'abstract' que vai ser implementado nas classes derivadas
// -------------------------------------------------------------------------------

public abstract class Empregado implements Pagavel, Recompensavel
{
   // atributos que QUALQUER 'Empregado' tem
   private String    nome;
   private String    sobrenome;
   private String    cpf;
   private DiaMesAno dataNascimento; // data de nascimento - COMPOSIÇÃO

   // construtor com seis argumentos
   public Empregado(
      String argNome,
      String argSobrenome,
      String argCPF,
      int    argDay,
      int    argMonth,
      int    argYear )
   {
      nome = argNome;
      sobrenome = argSobrenome;
      cpf = argCPF;
      dataNascimento = new DiaMesAno(argMonth, argDay, argYear); // instancia objeto 'DiaMesAno'
   } // fim do construtor

   // configura o nome 
   public void setNome( String argNome )
   {
      nome = argNome;
   } // fim do método setNome 

   // retorna o nome
   public String getNome()
   {
      return nome;
   } // fim do método getNome

   // configura o sobrenome 
   public void setSobrenome( String argSobrenome )
   {
      sobrenome = argSobrenome;
   } // fim do método setSobrenome 

   // retorna o sobrenome
   public String getSobrenome()
   {
      return sobrenome;
   } // fim do método getSobrenome

   // configura o CPF 
   public void setCPF( String argCPF )
   {
      cpf = argCPF; // deve validar...
   } // fim do método setCPF

   // retorna o CPF
   public String getCPF()
   {
      return cpf;
   } // fim do método getCPF 

   // configura a data de nascimento 
   public void setDataNascimento( int argDay, int argMonth, int argYear )
   {
      dataNascimento.setMonth(argMonth); // valida e altera
      dataNascimento.setDay(argDay);
      dataNascimento.setYear(argYear);
   } // fim do método setDataNascimento

   // retorna a data de nascimento
   public DiaMesAno getDataNascimento()
   {
      return dataNascimento;
   } // fim do método getDataNascimento 

   // retorna a representação de String do objeto
   public String toString()
   {
      return String.format( "%s %s\nCPF: %s\nNascido em: %s", 
         getNome(), getSobrenome(), getCPF(), getDataNascimento() );
   } // fim do método toString

   // método abstrato sobrescrito pelas subclasses      
   public abstract double vencimentos(); // nenhuma implementação aqui !!!

   // (*)
   // Nota: NÃO implementamos o método 'getPagamento' de 'Pagavel' aqui.
   // Ele será implementado na subclasse.
   // Assim, esta classe deve ser declarada abstrata para evitar um erro de compilação.

   // (**)
   // Idem (*) para o método 'getRecompensa' de 'Recompensavel'
   
} // fim da classe abstrata

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Fig. 10.13: Employee.java                                              *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *************************************************************************/