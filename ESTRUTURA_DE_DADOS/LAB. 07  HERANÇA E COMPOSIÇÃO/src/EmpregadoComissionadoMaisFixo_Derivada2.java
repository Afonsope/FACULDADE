// ------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : COMPOSIÇÃO E HERANÇA em JAVA
// Ano/S: 2026/1S
// ------------------------------------
 
// EmpregadoComissionadoMaisFixo_Derivada2 herda de EmpregadoComissionado_Base2 e tem
// acesso a membros protected de EmpregadoComissionado_Base2.
// ----------------------------------------------------------------------------------

public class EmpregadoComissionadoMaisFixo_Derivada2 extends EmpregadoComissionado_Base2
{
   // atributos
   private double salarioFixo; // salário-base por semana

   // construtor de seis argumentos
   public EmpregadoComissionadoMaisFixo_Derivada2(
           String nome,
           String sobrenome,
           String cpf,
           double vendasBrutas,
           double taxaComissao,
           double salarioFixo )
   {
      super( nome, sobrenome, cpf, vendasBrutas, taxaComissao );
      setSalarioFixo( salarioFixo ); // valida e armazena salário-base
   } // fim do construtor
   
   // configura o salário-base                                    
   public void setSalarioFixo( double salarioFixo )
   {
      this.salarioFixo = ( salarioFixo < 0.0 ) ? 0.0 : salarioFixo;
   } // fim do método setSalarioFixo                         

   // retorna o salário-base                                   
   public double getSalarioFixo()
   {
      return salarioFixo;
   } // fim do método getSalarioFixo                            

   // calcula os lucros                 
   public double vencimentos()
   {
      return salarioFixo + ( taxaComissao * vendasBrutas );
   } // fim do método vencimentos              

   // retorna a representação String do objeto
   public String toString()
   {
      return String.format(                                           
         "%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f\n%s: %.2f",           
         "Empregado comissionado + fixo", nome, sobrenome,    
         "CPF", cpf,              
         "Vendas brutas", vendasBrutas,
         "Taxa de comissao", taxaComissao,
         "Salário fixo", salarioFixo );                                 
   } // fim do método toString
   
} // fim da classe


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Fig. 9.10: EmpregadoComissionadoMaisFixo3.java                         *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *************************************************************************/