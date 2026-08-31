package entities;

public final class TreinadorEntity extends PessoaEntity {

    private String especialidade;

    public TreinadorEntity() {
        super();
        especialidade = "";
    }

    public TreinadorEntity(int id, String nome, String telefone, String especialidade) {
        super(id, nome, telefone);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

}
