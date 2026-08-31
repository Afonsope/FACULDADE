// -------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : ARRAYS de OBJETOS em JAVA
// Ano/S: 2026/1S
// -------------------------------------

// classe que modela a entidade 'Pessoa'
public class Pessoa {

	// Atributos
	// ---------
	private String nome;
	private String CPF;
	private String dataNascimento;
	private String cidadeNascimento;

	// Método Construtor
	// -----------------
	Pessoa(String nome, String CPF, String dataNascimento, String cidadeNascimento){
		this.nome = nome;
		this.CPF = CPF;
		this.dataNascimento = dataNascimento;
		this.cidadeNascimento = cidadeNascimento;
	}

	// Métodos 'getters' e 'setters' (sempre 'public')
	// -----------------------------------------------
	// 1. ATRIBUTO NOME
	public String getNome(){
		return nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	// 2. ATRIBUTO CPF
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	// 3. ATRIBUTO DATA DE NESCIMENTO
	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	// 4. ATRIBUTO CIDADE DE NASCIMENTO
	public String getCidadeNascimento() {
		return cidadeNascimento;
	}

	public void setCidadeNascimento(String cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}

	// Outros métodos ('public' ou 'private', conforme a necessidade
	// -------------------------------------------------------------

	// método para exibição dos dados da Pessoa
	public void exibeDadosPessoa() {
	
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("Pessoa            : ..."); // nome   da pessoa
		System.out.println("CPF               : ..."); // CPF    da pessoa
		System.out.println("Data de nascimento: ..."); // data   de nascimento da pessoa
		System.out.println("Cidade onde nasceu: ..."); // cidade de nascimento da pessoa
		System.out.println("---------------------------------");
		System.out.println();
	
		// finalização (desnecessário neste caso, pois é procedimento 'void')
		return;	
	}
    
}
