// ----------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : ARRANJOS DINÂMICOS em JAVA
// Ano/S: 2026/1S
// ----------------------------------------

 // classe para realização de testes com
// 'ArrayList' contendo objetos 'EmpregadoComissionadoMaisFixo'
// ------------------------------------------------------------

// importação para permitir o uso de 'ArrayList'
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Iterator;

public class TesteArrayListEmpregadoComissionadoMaisFixo {
    
    // método da classe para realização do teste
    public void executaTeste() {
        
        // instanciação de um objeto da classe 'ArrayList'
        // para armazenar 'EmpregadoComissionadoMaisFixo' (inicialmente vazio)
        ArrayList<EmpregadoComissionadoMaisFixo> empreados_cf = new ArrayList<>();
        
        // cria 4 objetos da classe EmpregadoComissionadoMaisFixo'
        EmpregadoComissionadoMaisFixo empregado1 =
                new EmpregadoComissionadoMaisFixo(
                        "Fernanda",
                        "Montenegro",
                        "123.123.123-12",
                        12,
                        3,
                        1990,
                        5000,
                        .04,
                        300 );

        EmpregadoComissionadoMaisFixo empregado2 =
                new EmpregadoComissionadoMaisFixo(
                        "Carlos",
                        "Magnus",
                        "222.222.222-22",
                        13,
                        8,
                        1970,
                        10000,
                        .04,
                        500 );

        EmpregadoComissionadoMaisFixo empregado3 =
                new EmpregadoComissionadoMaisFixo(
                        "Marcos",
                        "Renato",
                        "333.333.333-33",
                        31,
                        3,
                        1992,
                        8000,
                        .04,
                        400 );

        EmpregadoComissionadoMaisFixo empregado4 =
                new EmpregadoComissionadoMaisFixo(
                        "Josué",
                        "Silveira",
                        "444.444.444-44",
                        2,
                        5,
                        2000,
                        4000,
                        .06,
                        200 );

        // INCLUSÃO DOS OBJETOS 'EmpregadoComissionadoMaisFixo' NO 'ARRAYLIST'
        empreados_cf.add(empregado1);
        empreados_cf.add(empregado2);
        empreados_cf.add(empregado3);
        empreados_cf.add(empregado4);
        
        // exibição do conteúdo do 'ArrayList' via 'toString' de 'ArrayList'
        System.out.println("\nConteúdo do 'ArrayList' de objetos 'EmpregadoComissionadoMaisFixo' (exibiçao via 'toString')");
        System.out.println(empreados_cf);

        // exibição do conteúdo do 'ArrayList' via 'interator'
        System.out.println("\nConteúdo do 'ArrayList' de objetos 'EmpregadoComissionadoMaisFixo' (exibiçao via 'interator')");
        Iterator<EmpregadoComissionadoMaisFixo> iterador = empreados_cf.iterator();
        while (iterador.hasNext()) {
            EmpregadoComissionadoMaisFixo emp = iterador.next();
            System.out.printf("\n%s\nVencimentos: R$ %.2f",emp,emp.vencimentos());
        }
        // ??? classificação dos elementos do 'ArrayList'
        //Collection.sort(empreados_cf);
        
        // ??? exibição do conteúdo classificado do 'ArrayList'
        
        // ??? realização de buscas por:
        // - objetos efetivamente armazenados no 'ArrayList'
        // - objetos não armazenados no 'ArrayList'
        EmpregadoComissionadoMaisFixo[] buscados = {empregado1, empregado2, empregado4};

        for (EmpregadoComissionadoMaisFixo emp : buscados) {
        System.out.printf("\nO ArrayList contém '%s'? --> ", emp.getNome());
        if (empreados_cf.contains(emp)) {
                System.out.println("SIM !!!");
        } else {
                System.out.println("Não !!!");
        }
        }
                
        // transferência do conteúdo para um vetor convencional
        EmpregadoComissionadoMaisFixo[] empregados_cf2 = new EmpregadoComissionadoMaisFixo[empreados_cf.size()];

        //armazenando os empregados com for
        for (int i = 0; i < empregados_cf2.length; i++) {
            empregados_cf2[i] = empreados_cf.get(i);  // pega do ArrayList pelo índice
        }

        // exibição do conteúdo do vetor convencional
        System.out.println("\nConteúdo do vetor convencional (copiado do ArrayList):");
        for (EmpregadoComissionadoMaisFixo emp : empregados_cf2) {
            System.out.printf("\n%s\nVencimentos: R$ %.2f\n", emp, emp.vencimentos());
        }
        
    }

}

