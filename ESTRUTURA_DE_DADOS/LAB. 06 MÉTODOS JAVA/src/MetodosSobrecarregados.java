// -------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : MÉTODOS GENÉRICOS em JAVA
// Ano/S: 2026/1S
// -------------------------------------

// classe que implementa os MÉTODOS SOBRECARREGADOS
public class MetodosSobrecarregados {

    // A. método printArray para imprimir um array de 'int'
    // ----------------------------------------------------
    public void printArray(int[] inputArray) {
        for (int element : inputArray) {
            System.out.printf("%8s ", element);       // exibe elementos do array
        }
        System.out.println();
    } // fim do método printArray – versão 'int'

    // B. método printArray para imprimir um array de 'double'
    // -------------------------------------------------------
    public void printArray(double[] inputArray) {
        for (double element : inputArray) {
            System.out.printf("%8s ", element);       // exibe elementos do array
        }
        System.out.println();
    } // fim do método printArray – versão 'double'

    // C. método printArray para imprimir um array de 'String'
    // -------------------------------------------------------
    public void printArray(String[] inputArray) {
        for (String element : inputArray) {
            System.out.printf("%8s ", element);       // exibe elementos do array
        }
        System.out.println();
    } // fim do método printArray – versão 'String'

    // D. método buscaArray para buscar um conteúdo ('key') num array de 'int'
    // retorna a posição em que o conteúdo foi encontrado no array ou -1 se não encontrou
    // ----------------------------------------------------------------------------------
    public int buscaArray(int[] inputArray, int key) {

        // busca sobre o vetor
        for( int i = 0; i < inputArray.length; i++ ) {
            // se encontrou, já pode acabar - retorna a posição i
            if ( inputArray[i] == key ) {
                return i;
            }
        }

        // se terminou a busca sem encontrar, retorna -1
        return -1;

    }  // fim do método buscaArray - versão 'int'

    // E. método buscaArray para buscar um conteúdo ('key') num array de 'double'
    // retorna a posição em que o conteúdo foi encontrado no array ou -1 se não encontrou
    // ----------------------------------------------------------------------------------
    public int buscaArray(double[] inputArray, double key) {

        // tolerância: se a diferença estiver abaixo, os números são considerados iguais
        final double TOLERANCIA = 0.00001;

        // busca sobre o vetor
        for( int i = 0; i < inputArray.length; i++ ) {
            // se encontrou, já pode acabar - retorna a posição i
            if ( Math.abs(inputArray[i] - key) < TOLERANCIA) {
                return i;
            }
        }

        // se terminou a busca sem encontrar, retorna -1
        return -1;

    }  // fim do método buscaArray - versão 'double'

    // F. método buscaArray para buscar um conteúdo ('key') num array de 'String'
    // retorna a posição em que o conteúdo foi encontrado no array ou -1 se não encontrou
    // ----------------------------------------------------------------------------------
    public int buscaArray(String[] inputArray, String key) {

        // busca sobre o vetor
        for( int i = 0; i < inputArray.length; i++ ) {
            // se encontrou, já pode acabar - retorna a posição i
            if ( inputArray[i].equals(key) ) {
                return i;
            }
        }

        // se terminou a busca sem encontrar, retorna -1
        return -1;

    }  // fim do método buscaArray - versão 'string'

}
