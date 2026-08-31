package Entities;

public class EmpresaEntity extends UsuarioEntity {

    private String site;
    private String contato;
    private String telefone;
    private String CNPJ;
    private String IE; // INSCRIÇÃO ESTADUAL

    public EmpresaEntity() {
        super();
        site = new String();
        contato = new String();
        telefone = new String();
        CNPJ = new String();
        IE = new String();
    }

    public EmpresaEntity(int id, String nome, String email, String senha, String site, String contato, String telefone,
            String cNPJ, String iE) {
        super(id, nome, email, senha);
        this.site = site;
        this.contato = contato;
        this.telefone = telefone;
        CNPJ = cNPJ;
        IE = iE;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    
}
