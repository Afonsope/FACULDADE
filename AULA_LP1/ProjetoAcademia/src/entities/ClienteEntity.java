package entities;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public final class ClienteEntity extends PessoaEntity implements Impressao {

    private String email;
    private String cpf;
    private List<TreinoEntity> treinos;

    public ClienteEntity() {
        super();
        email = "";
        cpf = "";
        treinos = new ArrayList<>();
    }

    public ClienteEntity(int id, String nome, String telefone, String email, String cpf, List<TreinoEntity> treinos) {
        super(id, nome, telefone);
        this.email = email;
        this.cpf = cpf;
        this.treinos = treinos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<TreinoEntity> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<TreinoEntity> treinos) {
        this.treinos = treinos;
    }

    public void adicionarTreino(TreinoEntity treino) {
        this.treinos.add(treino);
    }
    
    public void removerTreino(TreinoEntity treino) {
        this.treinos.remove(treino);
    }

    @Override
    public void imprimirTreino() {
        System.out.println(CABECALHO);
        for (TreinoEntity treino : treinos) {
            System.out.println("Treino do dia: " + treino.getDataTreino());
            for (ExerciciosEntity exercicio : treino.getExercicios()) {
                System.out.println("- " + exercicio.getNome() + ": " + exercicio.getDescricao());
            }
        }
    }

    @Override
    public void imprimirTreino(LocalDate data) {
        System.out.println(CABECALHO);
        for (TreinoEntity treino : treinos) {
            if (treino.getDataTreino().equals(data)) {
                System.out.println("Treino do dia: " + treino.getDataTreino());
                for (ExerciciosEntity exercicio : treino.getExercicios()) {
                    System.out.println("- " + exercicio.getNome() + ": " + exercicio.getDescricao());
                }
            }
        }
    }

}
