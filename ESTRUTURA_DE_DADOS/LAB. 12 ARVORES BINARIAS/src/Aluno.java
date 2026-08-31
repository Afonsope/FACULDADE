// -----------------------------------------------------------
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Prof.: Carlos - FATEC S J Rio Preto
// Lab. : ÁRVORES DE BUSCA BINÁRIA (TREESET E TREEMAP) em JAVA
// Ano/S: 2026/1S
// -----------------------------------------------------------

// Classe 'Aluno'
// --------------
public class Aluno implements Comparable< Aluno > {

    private String nome;  // nome social
    private String ra;    // registro acadêmico
    private Double pr;    // percentual de rendimento (notas)
    private Double pp;    // percentual de progresso (tempo)

    // construtor com quatro argumentos
    public Aluno(
            String argNome,
            String argRa,
            Double argPr,
            Double argPp) {

        nome = argNome;
        ra   = argRa;
        pr   = argPr;
        pp   = argPp;

    } // fim do construtor
        
    // 'getters' e 'setters'
    public String getNome() {
        return nome;
    }

    public void setNome(String argNome) {
        this.nome = argNome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String argRa) {
        this.ra = argRa;
    }

    public Double getPr() {
        return pr;
    }

    public void setPr(Double argPr) {
        this.pr = ( argPr > 0.0 ) ? argPr : 0.0; // validação mínima
    }

    public Double getPp() {
        return pp;
    }

    public void setPp(Double argPp) {
        this.pp = ( argPp > 0.0 ) ? argPp : 0.0; // validação mínima
    }

    // retorna a representação de String de um objeto 'Aluno'
    // sobrescreve 'toString'
    @Override
    public String toString() {
        return String.format("Aluno: %-20s - R.A.: %s - Média ponderada: %5.2f - Progresso: %6.2f\n",
                getNome(), getRa(), getPr(), getPp());
    } // fim do método toString
    
    // retorna indicativo da comparação de dois objetos 'Aluno'
    // pelo critério especificado,
    // implementanto o que foi prometido em 'implements Comparable'
    // sobrescreve 'compareTo' de 'Comparable'
    @Override
    public int compareTo(Aluno outroAluno)
    {
        // compara pelo critério do PR
        //return this.pr.compareTo(outroAluno.getPr());

        // se quiser comparar o nome ...
        return this.nome.compareTo(outroAluno.getNome());
        
        // se quiser comparar o RA ...
        //return this.ra.compareTo(outroAluno.getRa());
        
        // se quiser comparar o PP ...
        //return this.pp.compareTo(outroAluno.getPp());

    }

}
