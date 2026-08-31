// ----------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : INTERFACES em JAVA
// Ano/S: 2026/1S
// ----------------------------------------

// Classe 'Compra' que implementa 'Pagavel'
// ----------------------------------------

public class Compra implements Pagavel, Recompensavel
{
   // atributos de uma 'Compra'
   private String codigoProduto; 
   private String descricaoProduto;
   private int    quantidade;
   private double precoUnitario;

   // construtor com quatro argumentos
   public Compra(
           String argCodigoProduto,
           String argDescricaoProduto,
           int    argQuantidade,
           double argPrecoUnitario )
   {
      codigoProduto    = argCodigoProduto;
      descricaoProduto = argDescricaoProduto;
      setQuantidade( argQuantidade ); // valida e armazena a quantidade
      setPrecoUnitario( argPrecoUnitario ); // valida e armazena o preço por item
   } // fim do construtor

   // configura número (id) da peça
   public void setcodigoProduto( String argCodigoProduto )
   {
      codigoProduto = argCodigoProduto;  
   } // fim do método setcodigoProduto

   // obtém o número (id) da peça
   public String getcodigoProduto()
   {
      return codigoProduto;
   } // fim do método getcodigoProduto

   // configura a descrição
   public void setDescricaoProduto( String argDescricaoProduto )
   {
      descricaoProduto = argDescricaoProduto;
   } // fim do método setDescricaoProduto

   // obtém a descrição
   public String getDescricaoProduto()
   {
      return descricaoProduto;
   } // fim do método getDescricaoProduto

   // configura a quantidade
   public void setQuantidade( int argQuantidade )
   {
      quantidade = ( argQuantidade < 0 ) ? 0 : argQuantidade; // quantidade não pode ser negativa
   } // fim do método setQuantidade

   // obtém quantidade
   public int getQuantidade()
   {
      return quantidade;
   } // fim do método getQuantidade

   // configura preço por item (unitário)
   public void setPrecoUnitario( double argPrecoUnitario )
   {
      precoUnitario = ( argPrecoUnitario < 0.0 ) ? 0.0 : argPrecoUnitario; // valida preço
   } // fim do método setPrecoUnitario

   // obtém preço por item
   public double getPrecoUnitario()
   {
      return precoUnitario;
   } // fim do método getPrecoUnitario

   // retorno da representação de String do objeto
   public String toString()
   {
      return String.format( "%s: \n%s: %s (%s) \n%s: %d \n%s: R$%,.2f", 
         "Compra", "Código do produto", getcodigoProduto(), getDescricaoProduto(), 
         "Quantidade", getQuantidade(), "Preço unitário", getPrecoUnitario() );
   } // fim do método toString

   // método requerido para 'executar o contrato' com a interface 'Pagavel'     
   public double getPagamento()                                    
   {                                                                   
      return getQuantidade() * getPrecoUnitario(); // calcula preço total
   } // fim do método getMontantePagamento

   // método requerido do recompensado
   public double getRecompensa() {
      return getPagamento();
   }
   
} // fim da classe

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Fig. 10.12: Invoice.java                                               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *************************************************************************/