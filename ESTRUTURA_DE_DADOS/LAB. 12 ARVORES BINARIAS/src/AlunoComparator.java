// -----------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : ÁRVORES DE BUSCA BINÁRIA (TREESET E TREEMAP) em JAVA
// Ano/S: 2026/1S
// -----------------------------------------------------------
 
// definição de uma CLASSE que implementa a INTERFACE 'Comparator'
// ---------------------------------------------------------------

// importação para permitir o uso de 'comparator'
import java.util.Comparator;
    
public class AlunoComparator implements Comparator<Aluno> {

    // atributos: critérios possíveis de comparação
    final private int CRITERIO_NOME = 0;
    final private int CRITERIO_RA   = 1;
    final private int CRITERIO_PR   = 2;
    final private int CRITERIO_PP   = 3;

    final private int SENTIDO_CRESCENTE   = 0;
    //final private int SENTIDO_DECRESCENTE = 1;  // desnecessário

    private int criterioEscolhido;
    private int sentidoEscolhido;

    // construtor com quatro argumentos
    public AlunoComparator( int argCriterioEscolhido, int argSentidoEscolhido ) {

        criterioEscolhido = argCriterioEscolhido;
        sentidoEscolhido  = argSentidoEscolhido;

    } // fim do construtor

    public int compare(Aluno aluno1, Aluno aluno2) {
            
        int valor =  comparaAlunos( aluno1, aluno2, criterioEscolhido );
        //aluno1.compareTo(aluno2);
            
        // estabelece ordem decrescente de valor de PR
        if ( valor > 0 ) {
            // PR do aluno 1 é maior e portanto mais prioritário
            return sentidoEscolhido == SENTIDO_CRESCENTE ? 1 : -1;  // para ordem crescente, inverter o sinal
        }
        else if (valor < 0) {
            // PR do aluno 2 é maior e portanto mais prioritário
            return sentidoEscolhido == SENTIDO_CRESCENTE ? -1 : 1;  // para ordem crescente, inverter o sinal
        }
        else {
            // PR do aluno 1 é igual ao do aluno 2
            return 0;
        }
    }


    private int comparaAlunos ( Aluno aluno1, Aluno aluno2, int criterio ) {

        // compara dois alunos de acordo com o critério escolhido
        switch ( criterio ) {
            case CRITERIO_NOME:
                return aluno1.getNome().compareTo(aluno2.getNome());
            case CRITERIO_RA:
                return aluno1.getRa().compareTo(aluno2.getRa());
            case CRITERIO_PR:
                return aluno1.getPr().compareTo(aluno2.getPr());
            case CRITERIO_PP:
                return aluno1.getPp().compareTo(aluno2.getPp());
            default:
                return aluno1.getNome().compareTo(aluno2.getNome());
        }
    }

}  // fim da classe 'AlunoComparator'

