// -------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: CARLOS MAGNUS CARLSON FILHO
// Lab. : BUSCA e CLASSIFICAÇÃO EM ARRAYS JAVA
// Ano/S: 2026/1S
// -------------------------------------------

public class MeuVetor {

    // ATRIBUTOS
    // ---------
    private int[] vetor;       // vetor que será classificado
    private int qtdElementos;  // tamanho do vetor que será classificado

    // método CONSTRUTOR
    // -----------------
    MeuVetor(int tamanho, int preenchimento) {

        // alocação de memória para o vetor
        if (tamanho == 0) {
            // 420000
            qtdElementos = 40000;
        } else {
            qtdElementos = 80000;
        }
        vetor = new int[qtdElementos];

        // preenchimento do conteúdo dos elementos do vetor
        if (preenchimento == 0) {
            // aleatório
            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = 1 + (int) (Math.random() * 2 * qtdElementos);
            }

        } else {
            // decrescente
            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = qtdElementos - i;
            }

        }

    }

    // DEMAIS métodos
    // --------------
    
    // metodo de classificação por seleção
    // ---- Método da SELEÇÃO - Selection Sort --- 
    // ------------------------------------------- 
    public void selectionSort() {

        // declaração de variáveis
        int passo;      // contador de passos
        int i, i_menor; // auxiliares de posição 
        int menor;      // auxiliar de menor valor 
        int barra = 0;  // posição da barra, inicialmente antes do primeiro elemento 

        // loop de passos 
        for (passo = 1; passo < vetor.length; passo++) {
            /*
            if (imprimir) {
                cout << "Passo " << p << endl;
            }*/

            // encontra o menor valor dentre os elementos não classificados 
            menor = vetor[barra];
            i_menor = barra;
            for (i = barra + 1; i < vetor.length; i++) {
                if (vetor[i] < menor) {
                    menor = vetor[i];
                    i_menor = i;
                }
            }

            // troca o menor com o elemento ao lado direito da barra 
            vetor[i_menor] = vetor[barra];
            vetor[barra] = menor;

            // avança a barra em uma posição 
            barra++;

            /*
            if (imprimir) {
                cout << "Valor    de V1: [ ";
                for (i = 0; i < n; i++) {
                    cout << a[i] << "  ";
                }
                cout << " ]" << endl;;
                cout << endl;
            }*/
        }
    }

    // método de classificação por inserção
    // ---- Método da INSERÇÃO - Insertion Sort --- 
    // -------------------------------------------- 
    public void insertionSort() {

        // declaração de variáveis
        int passo, i;      // contador de passos, auxiliar de posição 
        int barra = 1;     // posição da barra, inicialmente depois do primeiro elemento 

        // loop de passos 
        for (passo = 1; passo < vetor.length; passo++) {
            /*
            if ( imprimir ) cout << "Passo " << p << endl;*/

            // transfere o elemento ao lado direito da barra para 
            // o lado esquerdo da barra (classificados) 
            //elemento = vetor[barra];
            // percorre o vetor para trás dentro da barra
            for (i = barra; i > 0 && vetor[i - 1] > vetor[i]; i--) {
                // troca a posição dos dois elementos adjacentes 
                int t = vetor[i];
                vetor[i] = vetor[i - 1];
                vetor[i - 1] = t;
            }

            // avança a barra em uma posição 
            barra++;

            /*
            if ( imprimir ) {
                cout << "Valor    de V1: [ " ;
                for (i=0; i<n; i++) {
                    cout << a[i] << "  ";
                }
                cout << " ]"  << endl;;
                cout << endl;
            }*/
        }
    }

    // método de classificação por bolha direto
    // ---- Método da BOLHA - Bubble Sort - Percurso Esquerda -> Direita --- 
    // --------------------------------------------------------------------- 
    public void bubbleSort() {

        // declaração de variáveis
        int i;                    // auxiliar de posição
        boolean trocou;           // indica se houve troca ou não
        int barra = vetor.length; // posição da barra, inicialmente após o último elemento 

        // loop de passos (repetir enquanto houver pelo menos uma troca de posição)
        do {
            // indica que neste passo ainda não houve troca 
            trocou = false;
            // traz a barra em uma posição 
            --barra;

            /*
            if (imprimir) {
                cout << "Passo " << n - barra << endl;
            }*/
            // loop de trocas dentro do passo, até a barra 
            for (i = 0; i < barra; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    // troca a posição dos dois elementos adjacentes 
                    int t = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = t;
                    // indica que houve troca neste passo
                    trocou = true;
                }
            }

            /*
            if (imprimir) {
                cout << "Valor    de V1: [ ";
                for (i = 0; i < n; i++) {
                    cout << a[i] << "  ";
                }
                cout << " ]" << endl;;
                cout << endl;
            }*/
        } while (trocou);
    }

    // método de classificação por bolha inverso
    // ---- Método da BOLHA - Bubble Sort - Percurso Direita -> Esquerda --- 
    // --------------------------------------------------------------------- 
    public void bubbleSortInvertido() {

        // declaração de variáveis
        int i;             // auxiliar de posição
        boolean trocou;    // indica se houve troca ou não
        int barra = -1;    // posição da barra, inicialmente antes do primeiro elemento 

        // loop de passos (repetir enquanto houver pelo menos uma troca de posição)
        do {
            // indica que neste passo ainda não houve troca 
            trocou = false;
            // avança a barra em uma posição 
            ++barra;

            /*
            if (imprimir) {
                cout << "Passo " << (barra + 1) << endl;
            }*/
            // loop de trocas dentro do passo, até a barra 
            for (i = vetor.length - 1; i > barra; i--) {
                if (vetor[i] < vetor[i - 1]) {
                    // troca a posição dos dois elementos adjacentes 
                    int t = vetor[i];
                    vetor[i] = vetor[i - 1];
                    vetor[i - 1] = t;
                    // indica que houve troca neste passo
                    trocou = true;
                }
            }

            /*
            if (imprimir) {
                cout << "Valor    de V1: [ ";
                for (i = 0; i < n; i++) {
                    cout << a[i] << "  ";
                }
                cout << " ]" << endl;;
                cout << endl;
            }*/
        } while (trocou);
    }

    // metodo auxiliar de classificação por seleção para a mesclagem (abaixo)
    // ---------------------------------------------------------------------- 
    private void selectionSortEspecial(int[] v) {

        // declaração de variáveis
        int passo;      // contador de passos
        int i, i_menor; // auxiliares de posição 
        int menor;      // auxiliar de menor valor 
        int barra = 0;  // posição da barra, inicialmente antes do primeiro elemento 

        // loop de passos 
        for (passo = 1; passo < v.length; passo++) {

            // encontra o menor valor dentre os elementos não classificados 
            menor = v[barra];
            i_menor = barra;
            for (i = barra + 1; i < v.length; i++) {
                if (v[i] < menor) {
                    menor = v[i];
                    i_menor = i;
                }
            }

            // troca o menor com o elemento ao lado direito da barra 
            v[i_menor] = v[barra];
            v[barra] = menor;

            // avança a barra em uma posição 
            barra++;

        }
    }

    // método auxiliar para verificação da correção da classificação para a mesclagem
    // ------------------------------------------------------------------------------
    /*
    private boolean verificaClassificacaoEspecial(int[] v) {
        for (int kk = 1; kk < v.length; kk++) {
            if (v[kk - 1] > v[kk]) {
                System.out.printf("ERRO - Elemento %d  (valor %d) maior que elemento %d (valor %d) !!!\n", kk - 1, v[kk - 1], kk, v[kk]);
                return false;
            }
        }
        System.out.println("Sucesso na classificação!");
        return true;
    }*/

    // método de classificação por mesclagem
    // ---- Método da MESCLAGEM - Merge Sort --- versão iterativa
    // ----------------------------------------------------------
    public void mergeSortIterativo() {

        // declaração de variáveis
        int i = 0, j = 0, p = 0; // auxiliares de posição: i (primeira metade), j(segunda metade), p (vetor final)

        int[] a; // vetor (na prática: ponteiro para o início do vetor) - primeira metade
        int na; // tamanho da primeira metade

        int[] b; // vetor (na prática: ponteiro para o início do vetor) - segunda metade
        int nb; // tamanho da segunda metade

        // alocação dos vetores auxiliares - primeira metade
        na = vetor.length / 2;
        a = new int[na];
        // segunda metade
        nb = vetor.length - na;
        b = new int[nb];

        // preenchimento inicial dos vetores auxiliares
        for (int k = 0; k < na; k++) {
            a[k] = vetor[k];
            b[k] = vetor[k + na];
        }

        // classificação de cada metade do vetor
        selectionSortEspecial(a);
        //verificaClassificacaoEspecial(a);
        selectionSortEspecial(b);
        //verificaClassificacaoEspecial(b);

        // loop de passos (enquanto não construir todo o vetor final classificado)
        while (p < (na + nb)) {

            /*
            if (imprimir) {
                cout << "Passo " << (p + 1) << endl;
            }*/
            if (a[i] <= b[j]) {
                vetor[p] = a[i];
                i++;
                if (i == na) {
                    while (j < nb) {
                        p++;
                        vetor[p] = b[j];
                        j++;
                    }
                }
            } else {
                vetor[p] = b[j];
                j++;
                if (j == nb) {
                    while (i < na) {
                        p++;
                        vetor[p] = a[i];
                        i++;
                    }
                }
            }

            p++;

            /*
            if (imprimir) {
                int pp; // auxiliar de impressão
                cout << "Valor    de V1: [ ";
                for (pp = 0; pp < (na + nb); pp++) {
                    cout << f[pp] << "  ";
                }
                cout << " ]" << endl;;
                cout << endl;
            }*/
        }
    }

    // método de classificação por mesclagem
    // ---- Método da MESCLAGEM - Merge Sort - Versão Recursiva ----
    // -------------------------------------------------------------
    public void mergeSortRecursivoWrapper() {

        // aciona o 'merge sort'
        mergeSortRecursivo(vetor);

    }

    private void mergeSortRecursivo(int[] f) {

        /* impressão opcional */
        /*
        if (imprimir) {
            int pp; // auxiliar de impressão
            cout << "ENTRADA - Valor    de f: [ ";
            for (pp = 0; pp < nf; pp++) {
                cout << f[pp] << "  ";
            }
            cout << " ]" << endl;;
            cout << endl;
        }*/
        /* f é vetor que será efetivamente classificado, recebendo os valores mesclados das duas metades */
        // CASO BASE: nf == 1 (nada a fazer)
        if (f.length == 1) {
            return;
        }
        /* RECURSÃO */
        int[] a;
        /* vetor (na prática: ponteiro para o início do vetor) - primeira metade */
        int na;
        /* tamanho da primeira metade - já está classificada */
        int[] b;
        /* vetor (na prática: ponteiro para o início do vetor) - segunda metade */
        int nb;
        /* tamanho da segunda metade  - já está classificada */
        int i, j, p;/* auxiliares de posição: i (primeira metade), j(segunda metade), p (vetor final) */

        /* cria a primeira metade do vetor */
        na = f.length / 2;
        a = new int[na];
        for (i = 0; i < na; i++) {
            a[i] = f[i];
        }
        /* impressão opcional */
        /*
        if (imprimir) {
            int pp; // auxiliar de impressão
            cout << "ENTRADA - Valor    de a: [ ";
            for (pp = 0; pp < na; pp++) {
                cout << a[pp] << "  ";
            }
            cout << " ]" << endl;;
            cout << endl;
        }*/

        /* cria a segunda metade do vetor */
        nb = f.length - na;
        b = new int[nb];
        for (j = na; j < f.length; j++) {
            b[j - na] = f[j];
        }
        /* impressão opcional */
        /*
        if (imprimir) {
            int pp; // auxiliar de impressão
            cout << "ENTRADA - Valor    de b: [ ";
            for (pp = 0; pp < nb; pp++) {
                cout << b[pp] << "  ";
            }
            cout << " ]" << endl;;
            cout << endl;
        }*/

        /* aciona a classificação recursiva para cada metade */
        mergeSortRecursivo(a);
        mergeSortRecursivo(b);

        /* mescla as metades, reconstruindo f */
        /* loop de passos */
        i = 0;
        j = 0;
        p = 0;
        while (p < f.length) {
            /*
            if (imprimir) {
                cout << "Passo " << (p + 1) << endl;
            }*/

            if (a[i] <= b[j]) {
                f[p] = a[i];
                i++;
                if (i == na) {
                    while (j < nb) {
                        p++;
                        f[p] = b[j];
                        j++;
                    }
                }
            } else {
                f[p] = b[j];
                j++;
                if (j == nb) {
                    while (i < na) {
                        p++;
                        f[p] = a[i];
                        i++;
                    }
                }
            }

            p++;

        }
        /* impressão opcional */
 /*
        if (imprimir) {
            int pp; // auxiliar de impressão
            cout << "SAIDA - Valor    de f: [ ";
            for (pp = 0; pp < nf; pp++) {
                cout << f[pp] << "  ";
            }
            cout << " ]" << endl;;
            cout << endl;
        }*/

        // desnecessário neste caso
        return;
    }

    /* ---- Método da PARTIÇÃO - Quick Sort - Versão Recursiva ---- */
    /* ------------------------------------------------------------ */
    public void quickSortRecursivoWrapper() {

        // aciona o 'quick sort' - padrão
        quickSortRecursivo( vetor, 0, (vetor.length - 1) );

    }

    // Recebe vetor v[p..r] com p < r. Rearranja os elementos do vetor e
    // devolve j em p..r tal que v[p..j-1] <= v[j] < v[j+1..r].
    private int separa(int[] v, int p, int r) {
        
        int c = v[p], i = p + 1, j = r, t;
        
        while (/*A*/i <= j) {
            if (v[i] <= c) {
                ++i;
            }
            else if (c < v[j]) {
                --j;
            }
            else {
                t    = v[i];
                v[i] = v[j];
                v[j] = t;
                ++i;
                --j;
            }
        }
        // agora i == j+1                 
        v[p] = v[j];
        v[j] = c;

        /*
        if (imprimir) {
            cout << "Valor    de V1: [ ";
            for (i = 0; i < 8; i++) {
                cout << v[i] << "  ";
            }
            cout << " ]" << endl;;
            cout << endl;
        }*/

        return j;
    }

    // Recursão comum
    // A função recebe um vetor v[p..r], com p <= r+1,
    // e rearranja o vetor em ordem crescente.
    private void quickSortRecursivo(int[] v, int p, int r) {
        
        int j;                                 // 1
        if (p < r) {                           // 2
            j = separa(v, p, r);               // 3
            quickSortRecursivo(v, p, j - 1);   // 4
            quickSortRecursivo(v, j + 1, r);   // 5
        }
        return;
    }
    
    public void quickSortRecursivoTail_1_Wrapper() {

        // aciona o 'quick sort' tail - versão 1
        quickSortRecursivoTail_1( vetor, 0, (vetor.length - 1) );

    }

    // Recursão em 'cauda' (TAIL) - versão 1
    // Utiliza loop 'while' e só chama um de cada vez
    private void quickSortRecursivoTail_1(int[] arr, int low, int high) 
    {
        while (low < high)
        { 
            // pi é o índice (posição) da partição
            // arr[p] is now at right place
            int pi = separa(arr, low, high); 

            // classifica SEPARADAMENTE elementos 'antes' e 'depois' da partição 
            quickSortRecursivoTail_1(arr, low, pi - 1); 

            low = pi+1;
        } 
    } 
    // See below link for complete running code 
    // https://ide.geeksforgeeks.org/qrlM31 

    public void quickSortRecursivoTail_2_Wrapper() {

        // aciona o 'quick sort' tail - versão 2
        quickSortRecursivoTail_2( vetor, 0, (vetor.length - 1) );

    }

    // Recursão em 'cauda' (TAIL) - versão 2
    // Requer espaço auxiliar O(Log n) no pior caso !
    private void quickSortRecursivoTail_2(int[] arr, int low, int high) 
    {
        while (low < high) { 
            // pi é o índice (posição) da partição
            // arr[p] is now at right place
            int pi = separa(arr, low, high); 

            // Se parte à esquerda é menor, tratá-la recursivamente
		// e lidar com a parte à dreita iterativamente 'while' 
            if (pi - low < high - pi) {
                quickSortRecursivoTail_2(arr, low, pi - 1);
                low = pi + 1; 
            } 

            // Caso contrário: recursão à direita, iteração à esquerda 
            else {
                quickSortRecursivoTail_2(arr, pi + 1, high);
                high = pi - 1; 
            }
        } 
    } 
    // See below link for complete running code 
    // https://ide.geeksforgeeks.org/LHxwPk 

    // método para verificação da correção da classificação
    public boolean verificaClassificacao() {
        for (int kk = 1; kk < vetor.length; kk++) {
            if (vetor[kk - 1] > vetor[kk]) {
                System.out.printf("ERRO - Elemento %d  (valor %d) maior que elemento %d (valor %d) !!!\n", kk - 1, vetor[kk - 1], kk, vetor[kk]);
                return false;
            }
        }
        System.out.println("Sucesso na classificação!");
        return true;
    }

}
