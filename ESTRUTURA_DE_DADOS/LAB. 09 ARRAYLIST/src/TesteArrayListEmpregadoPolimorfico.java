// ----------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : ARRANJOS DINÂMICOS em JAVA
// Ano/S: 2026/1S
// ----------------------------------------
 
// classe para realização de testes com
// 'ArrayList' contendo objetos 'EmpregadoPolimorfico'
// ---------------------------------------------------

// importação para permitir o uso de 'ArrayList'
import java.util.ArrayList;
import java.util.Iterator;


public class TesteArrayListEmpregadoPolimorfico {
    
    // método da classe para realização do teste
    public void executaTeste() {
        
        // instanciação de um objeto da classe 'MetodosAvulsos'
        // para poder acessar o método 'criaSeparadora'
        MetodosAvulsos avulso = new MetodosAvulsos();
        
        // cria objetos das subclasses de Empregado'
        // - 4 objetos da classe 'Empregado', um de cada tipo
        // - lembrar que cada 'Empregado...' tem uma 'dataNascimento'
        EmpregadoAssalariado assalariado
                = new EmpregadoAssalariado(
                    "Carlos", 
                    "Filho", 
                    "111.111.111-11",
                    13,
                    8,
                    1979,
                    800.00);

        EmpregadoHorista horista
                = new EmpregadoHorista(
                    "Marcos", 
                    "Neto", 
                    "222.222.222-22",
                    31,
                    5,
                    1991,
                    16.75, 
                    40);

        EmpregadoComissionado comissionado
                = new EmpregadoComissionado(
                        "Renato",
                        "Sobrinho", 
                        "333.333.333-33",
                        5,
                        12,
                        1998,
                        10000,
                        .06);

        EmpregadoComissionadoMaisFixo comissionadoMaisFixo
                = new EmpregadoComissionadoMaisFixo(
                        "Robert",
                        "Junior",
                        "444.444.444-44",
                        25,
                        10,
                        2001,
                        5000,
                        .04,
                        300);

        // instanciação de um objeto da classe 'ArrayList'
        // para armazenar 'Empregado' (inicialmente vazio)
        ArrayList<Empregado> empregados = new ArrayList<Empregado>();

        // armazena, no 'ArrayList', empregados dos tipos existentes (um para cada subclasse)
        empregados.add(assalariado);
        empregados.add(horista);
        empregados.add(comissionado);
        empregados.add(comissionadoMaisFixo);

        // exibição do conteúdo do 'ArrayList' (via 'Iterator')
        // - para cada elemento (objeto), também exibe o respectivo nome do tipo
        System.out.println("\nConteúdo do ArrayList de objetos de subclasses de 'Empregado' (usando ITERATOR):");
        Iterator< Empregado > iterador = empregados.iterator();
        while ( iterador.hasNext() ) {
            Empregado emp = iterador.next();
            System.out.printf("\n%s\nVencimentos: R$%,.2f\n", emp, emp.vencimentos()); // POLIMORFISMO !!!
            System.out.printf("Este Empregado é um %s\n", emp.getClass().getName());
        }
        // exibe linha separadora entre as partes do 'print' desta classe
        System.out.println(avulso.criaSeparadora("+-", 40));

        // exibição do conteúdo do 'ArrayList' (via 'for' convencional  e 'get(index)')
        // - para cada elemento (objeto), também exibe o respectivo nome do tipo
        System.out.println("\nConteúdo do ArrayList de objetos de subclasses de 'Empregado' (usando FOR e GET(index)):");
        for ( int i = 0; i < empregados.size(); i++ ) {
            Empregado emp = empregados.get(i);
            System.out.printf("\n%s\nVencimentos: R$%,.2f\n", emp, emp.vencimentos());  // POLIMORFISMO !!!
            System.out.printf("Este Empregado é um %s\n", emp.getClass().getName());
        }
        // exibe linha separadora entre as partes do 'print' desta classe
        System.out.println(avulso.criaSeparadora("+-", 40));
        
        // exibição do conteúdo do 'ArrayList' (via 'for' abreviado)
        // - para cada elemento (objeto), também exibe o respectivo nome do tipo
        System.out.println("\nConteúdo do ArrayList de objetos de subclasses de 'Empregado' (usando FOR SIMPLIFICADO):");
        for ( Empregado emp : empregados ) {
            System.out.printf("\n%s\nVencimentos: R$%,.2f\n", emp, emp.vencimentos());  // POLIMORFISMO !!!
            System.out.printf("Este Empregado é um %s\n", emp.getClass().getName());
        }
        // exibe linha separadora entre as partes do 'print' desta classe
        System.out.println(avulso.criaSeparadora("+-", 40));
        
    }

}

