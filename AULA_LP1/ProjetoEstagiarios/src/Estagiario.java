import java.util.Scanner;

public class Estagiario {
    private String nome;
    private String curso;
    private float mediaGeral;
    private String email;
    private int idade;
    private String sexo;

    
    public String getNome() {
        return nome;
    }
    public String getCurso() {
        return curso;
    }
    public float getMediaGeral() {
        return mediaGeral;
    }
    public String getEmail() {
        return email;
    }
    public int getIdade() {
        return idade;
    }
    public String getSexo() {
        return sexo;
    }
    public void cadastrar(Scanner ler){
        System.out.println("\n\n---- Cadastro de Estagiário ----");
        do{
            System.out.println("Digite o nome do estagiário, com no mínimo 10 caracteres:");
            nome = ler.nextLine();
        }while(nome.length()<10);//não mostra mensagem
        do{
            System.out.println("Digite o curso do estagiário, com no mínimo 2 caracteres:");
            curso = ler.nextLine();
        }while(curso.length()<2);
        do{
            try{
                System.out.println("Digite a média geral do estagiário:");
                mediaGeral = ler.nextFloat();
            }catch(Exception e){
                System.out.println("Entrada inválida. Digite um número válido.");
                ler.nextLine(); // Limpar o buffer
            }
        }while(mediaGeral<0 || mediaGeral>10);
        ler.nextLine(); // Limpar o buffer
        do{
            System.out.println("Digite o email do estagiário:");
            email = ler.nextLine();
        }while(!email.contains("@") || !email.contains(".") || email.length()<10);
        do{
            try{
                System.out.println("Digite a idade do estagiário:");
                idade = ler.nextInt();
            }catch(Exception e){
                System.out.println("Entrada inválida. Digite um número válido.");
                ler.nextLine(); // Limpar o buffer
            }
        }while(idade<=0);
        ler.nextLine(); // Limpar o buffer
        do{
            System.out.println("Digite o sexo do estagiário (M|F|O):");
            sexo = ler.next();
            sexo = ""+sexo.toUpperCase().charAt(0);
        }while(sexo.isEmpty() || (!sexo.equals("M") && !sexo.equals("F") && !sexo.equals("O")));
        System.out.println("\n\n---- Cadastro concluído com sucesso! ----\n\n");
    }
    public void exibir(){
        System.out.println("\n\n---- Dados do Estagiário ----");
        System.out.println("Nome: " + nome);
        System.out.println("Curso: " + curso);
        System.out.println("Média Geral: " + mediaGeral);
        System.out.println("Email: " + email);
        System.out.println("Idade: " + idade);
        System.out.println("Sexo: " + sexo);
    }
    
    public Estagiario() {
        nome = new String();
        curso = new String();
        mediaGeral = 0.0f;
        email = new String();
        idade = 0;
        sexo = new String();
    }
    public Estagiario(String nome, String curso, float mediaGeral, String email, int idade, String sexo) {
        this.nome = nome;
        this.curso = curso;
        this.mediaGeral = mediaGeral;
        this.email = email;
        this.idade = idade;
        this.sexo = sexo;
    }
    
}