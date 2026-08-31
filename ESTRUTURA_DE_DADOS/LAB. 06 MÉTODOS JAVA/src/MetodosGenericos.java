// -------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : MÉTODOS GENÉRICOS em JAVA
// Ano/S: 2026/1S
// -------------------------------------

// classe que implementa os métodos genéricos
public class MetodosGenericos {

    // A, B, C. método genérico printArray
    // -----------------------------------
    public < T > void printArray( T[] inputArray ) {
        // exibe elementos do array
        for ( T element : inputArray ) {
            System.out.printf("%8s ", element);
        }
        System.out.println();
    } // fim do método printArray - versão 'genérica'

    // D, E, F. método genérico buscaArray
    // -----------------------------------
    public < T > int buscaArray( T[] inputArray, T key) {

        // busca sobre o vetor
        for( int i = 0; i < inputArray.length; i++ ) {
            // se encontrou, já pode acabar - retorna a posição i
            if ( inputArray[i].equals(key) ) {
                return i;
            }
        }

        // se terminou a busca sem encontrar, retorna -1
        return -1;

    }  // fim do método printArray - versão 'genérica'
    
}
