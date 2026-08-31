// ----------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : INTERFACES em JAVA
// Ano/S: 2026/1S
// ----------------------------------------
 
// Classe 'EmpregadoAssalariado' que é herança de 'Empregado' (a qual implementa 'Pagavel')
// - contém atributo e define métodos específicos de 'EmpregadoAssalariado'
// - implementa (define) o método que era 'abstract' em 'Empregado' (ou 'Pagavel', no caso)
// - por ser herança de 'Empregado', não precisa indicar o 'implements'
// ----------------------------------------------------------------------------------------

public class EmpregadoAssalariado extends Empregado 
{
   // atributo(s) específico(s) deste tipo de 'Empregado'
   private double salarioSemanal;

   // construtor com sete argumentos
   public EmpregadoAssalariado(
      String    argNome,
      String    argSobrenome,
      String    argCPF,
      int       argDay,
      int       argMonth,
      int       argYear,
      double    argSalarioSemanal )
   {
      super( argNome, argSobrenome, argCPF, argDay, argMonth, argYear ); // passa para o construtor de 'Empregado'
      setSalarioSemanal( argSalarioSemanal ); // valida e armazena o salário
   } // fim do construtor

   // configura o salário
   public void setSalarioSemanal( double argSalarioSemanal )
   {
      salarioSemanal = argSalarioSemanal < 0.0 ? 0.0 : argSalarioSemanal;
   } // fim do método setSalarioSemanal

   // retorna o salário
   public double getSalarioSemanal()
   {
      return salarioSemanal;
   } // fim do método getSalarioSemanal

   // calcula os rendimentos; sobrescreve o método 'vencimentos' em 'Empregado'
   public double vencimentos()                                            
   {                                                                   
      return getSalarioSemanal();                                        
   } // fim do método vencimentos              

   // calcula vencimentos; implementa o método 'getPagamento' da interface 'Pagavel',
   // resolvendo o 'contrato' firmado entre a interface e a superclasse abstrata 'Empregado'                                
   public double getPagamento()                                  
   {                                                                 
      return vencimentos();                                      
   } // fim do método getPagamento
   
   // calcula recompensa; implementa o método 'getRecompensa' da interface 'Recompensa',
   // resolvendo o 'contrato' firmado entre a interface e a superclasse abstrata 'Empregado'                                
   public double getRecompensa()                                  
   {                                                                 
      return vencimentos();    // CORRIGIR, colocando o estabelecimento na tarefa                                  
   } // fim do método getPagamento
   

   // retorna a representação String do objeto SalariedEmployee   
   public String toString()
   {
      return String.format( "Empregado assalariado: %s\n%s: R$%,.2f\n%s: R$%,.2f", 
         super.toString(), "Salário semanal", getSalarioSemanal(),
         "Vencimentos", vencimentos() );
   } // fim do método toString
   
} // fim da classe

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Fig. 10.14: SalariedEmployee.java                                      *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *************************************************************************/