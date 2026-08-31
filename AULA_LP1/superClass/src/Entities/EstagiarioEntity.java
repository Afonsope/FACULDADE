package Entities;

public class EstagiarioEntity extends UsuarioEntity {

    private int idade;
    private String sexo;
    private String curso;
    private float media;

    public EstagiarioEntity(){
        super();
        idade = 0;
        sexo = new String();
        curso = new String();
        media = 0.0f;
    }

    public EstagiarioEntity(int id, String nome, String email, String senha, int idade, String sexo, String curso,
            float media) {
        super(id, nome, email, senha);
        this.idade = idade;
        this.sexo = sexo;
        this.curso = curso;
        this.media = media;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    
}
