package Entities;

public class AdminEntity extends UsuarioEntity {

    private String departamento;

    public AdminEntity() {
        departamento = new String();
    }
    
    public AdminEntity(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public AdminEntity(int id, String nome, String email, String senha, String departamento) {
        super(id, nome, email, senha);
        this.departamento = departamento;
    }

}
