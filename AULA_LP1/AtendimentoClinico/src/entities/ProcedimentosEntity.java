package entities;

public class ProcedimentosEntity {
    private int codigo;
    private String descricao;
    private String observacoes;

    public ProcedimentosEntity() {
        codigo = 0;
        descricao = new String();
        observacoes = new String();
    }

    public ProcedimentosEntity(int codigo, String descricao, String observacoes) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.observacoes = observacoes;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
