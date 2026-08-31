import java.util.Scanner;

public class Aluno {
    // ATRIBUTOS
    private int RA;
    private String nome;
    private String curso;
    private String email;
    private String CPF;
    private String telefone;

    // CONSTRUTOR
    public Aluno(){
        // INICIALIZAR OS ATRIBUTOS
        RA = 0;
        nome = new String();
        curso = new String();
        email = new String();
        CPF = new String();
        telefone = new String();
    }

    // CONSTRUTOR
    public Aluno(int RA, String nome, String curso, String email, String CPF, String telefone){
        // INICIALIZAR OS ATRIBUTOS
        this.RA = RA;
        this.nome = nome;
        this.curso = curso;
        this.email = email;
        this.CPF = CPF;
        this.telefone = telefone;
    }

    // METODOS
    public void mostrarDados(){
        System.out.println("RA: " + RA);
        System.out.println("Nome: " + nome);
        System.out.println("Curso: " + curso);
        System.out.println("Email: " + email);
        System.out.println("CPF: " + CPF);
        System.out.println("Telefone: " + telefone);
    }

    public void cadastrar(){
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Digite o RA do aluno: ");
            RA = scanner.nextInt();
            scanner.nextLine();
        } while(RA <= 0);
        do {
            System.out.println("Digite o nome do aluno: ");
            nome = scanner.nextLine();
        } while(nome.isEmpty() || nome.length() < 10);
        do {
            System.out.println("Digite o curso do aluno: ");
            curso = scanner.nextLine();
        } while(curso.isEmpty() || curso.length() < 3);
        do {
            System.out.println("Digite o email do aluno: ");
            email = scanner.nextLine();
        } while(email.isEmpty() || email.length() < 10 || !email.contains(".") || !email.contains("@"));
        do {
            System.out.println("Digite o CPF do aluno: ");
            CPF = scanner.nextLine();
        } while(CPF.isEmpty() || CPF.length() < 11);
        do {
            System.out.println("Digite o telefone do aluno: ");
            telefone = scanner.nextLine();
        } while(telefone.isEmpty() || telefone.length() < 11);
    }

    public int getRA() {
        return RA;
    }

    public void setRA(int RA) {
        this.RA = RA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
