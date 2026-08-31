package entities;

public class FuncionarioEntity extends PessoaEntity {
    private String sertor;

    public FuncionarioEntity() {
        super();
        sertor = new String();
    }

    public FuncionarioEntity(String cpf, String nome, String senha, StatusEntity status, String sertor) {
        super(cpf, nome, senha, status);
        this.sertor = sertor;
    }

    public String getSertor() {
        return sertor;
    }

    public void setSertor(String sertor) {
        this.sertor = sertor;
    }

    @Override
    public String mostrarStatus() {
        return "Funcionário: " + getNome() + " - Setor: " + sertor + " - Status: " + getStatus().getDescricao();
    }
}
