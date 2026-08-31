// ------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : COMPOSIÇÃO E HERANÇA em JAVA
// Ano/S: 2026/1S
// ------------------------------------
 
// Classe EmpregadoComissionado2 representa um empregado APENAS comissionado
// -------------------------------------------------------------------------

public class EmpregadoComissionado_Base2
{
   // atributos
   protected String nome;                              
   protected String sobrenome;                               
   protected String cpf;                   
   protected double vendasBrutas; // vendas brutas semanais       
   protected double taxaComissao; // porcentagem da comissão

   // construtor de cinco argumentos
   public EmpregadoComissionado_Base2(
           String nome,
           String sobrenome,
           String cpf,
           double vendasBrutas,
           double taxaComissao )
   {
      // chamada implícita para o construtor Object ocorre aqui              
      this.nome = nome;
      this.sobrenome = sobrenome;
      this.cpf = cpf;
      setVendasBrutas( vendasBrutas ); // valida e armazena as vendas brutas       
      setTaxaComissao( taxaComissao ); // valida e armazena a taxa de comissão
   } // fim do construtor

   // configura o nome 
   public void setNome( String nome )
   {
      this.nome = nome;
   } // fim do método setNome 

   // retorna o nome
   public String getNome()
   {
      return nome;
   } // fim do método getNome

   // configura o sobrenome 
   public void setSobrenome( String sobrenome )
   {
      this.sobrenome = sobrenome;
   } // fim do método setSobrenome 

   // retorna o sobrenome
   public String getSobrenome()
   {
      return sobrenome;
   } // fim do método getSobrenome

   // configura o CPF
   public void setCPF( String cpf )
   {
      this.cpf = cpf; // deve validar
   } // fim do método setCPF

   // retorna o CPF
   public String getCPF()
   {
      return cpf;
   } // fim do método getCPF 

   // configura a quantidade de vendas brutas
   public void setVendasBrutas( double vendasBrutas )
   {
      this.vendasBrutas = ( vendasBrutas < 0.0 ) ? 0.0 : vendasBrutas;
   } // fim do método setVendasBrutas 

   // retorna a quantidade de vendas brutas 
   public double getVendasBrutas()
   {
      return vendasBrutas;
   } // fim do método getVendasBrutas 

   // configura a taxa de comissão
   public void setTaxaComissao( double taxaComissao )
   {
      this.taxaComissao = ( taxaComissao > 0.0 && taxaComissao < 1.0 ) ? taxaComissao : 0.0;
   } // fim do método setTaxaComissao 

   // retorna a taxa de comissão 
   public double getTaxaComissao()
   {
      return taxaComissao;
   } // fim do método getTaxaComissao 

   // calcula os lucros                 
   public double vencimentos()
   {
      return taxaComissao * vendasBrutas;
   } // fim do método vencimentos              

   // retorna a representação String do objeto
   public String toString()
   {
      return String.format( "%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f", 
         "Empregado comissionado", nome, sobrenome, 
         "CPF", cpf, 
         "Vendas brutas", vendasBrutas, 
         "Taxa de comissão", taxaComissao );
   } // fim do método toString
   
} // fim da classe 


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Fig. 9.9: EmpregadoComissionado2.java                                  *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *************************************************************************/