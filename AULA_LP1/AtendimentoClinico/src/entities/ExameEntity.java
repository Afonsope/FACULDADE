package entities;

public class ExameEntity {
    private int codigo;
    private String descricao;
    private String tipo;

    public ExameEntity() {
        codigo = 0;
        descricao = new String();
        tipo = new String();
    }

    public ExameEntity(int codigo, String descricao, String tipo) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
