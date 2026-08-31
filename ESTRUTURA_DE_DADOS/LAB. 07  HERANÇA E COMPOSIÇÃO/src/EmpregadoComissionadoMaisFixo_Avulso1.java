// ------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : COMPOSIÇÃO E HERANÇA em JAVA
// Ano/S: 2026/1S
// ------------------------------------
 
// A classe EmpregadoComissionadoMaisFixo representa um empregado que
// recebe um salário-base além da comissão
// ------------------------------------------------------------------

public class EmpregadoComissionadoMaisFixo_Avulso1
{
   // atributos
   private String nome;
   private String sobrenome;
   private String cpf;
   private double vendasBrutas; // vendas brutas semanais       
   private double taxaComissao; // porcentagem da comissão
   private double salarioFixo; // salário-base por semana

   // construtor de seis argumentos
   public EmpregadoComissionadoMaisFixo_Avulso1(
           String nome,
           String sobrenome,
           String cpf,
           double vendasBrutas,
           double taxaComissao,
           double salarioFixo )
   {
      // chamada implícita para o construtor Object ocorre aqui              
      this.nome = nome;
      this.sobrenome = sobrenome;
      this.cpf = cpf;
      setVendasBrutas( vendasBrutas ); // valida e armazena as vendas brutas       
      setTaxaComissao( taxaComissao ); // valida e armazena a taxa de comissão
      setSalarioFixo( salarioFixo ); // valida e armazena salário-base
   } // fim do construtor EmpregadoComissionadoMaisFixo_Avulso1 de seis argumentos

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

   // calcula os vencimentos do empregado                 
   public double vencimentos()
   {
      return salarioFixo + ( taxaComissao * vendasBrutas );
   } // fim do método vencimentos              

   // retorna a representação de String do objeto
   public String toString()
   {
      return String.format( 
         "%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f\n%s: %.2f", 
         "Empregado comissionado + fixo", nome, sobrenome,
         "CPF", cpf,
         "Vendas brutas", vendasBrutas,
         "Taxa de comissão", taxaComissao, 
         "Salário fixo", salarioFixo);
   } // fim do método toString
   
} // fim da classe


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Fig. 9.6: EmpregadoComissionadoMaisFixo.java                           *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *************************************************************************/