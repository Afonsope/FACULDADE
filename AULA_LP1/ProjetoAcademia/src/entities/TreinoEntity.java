package entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public final class TreinoEntity {


    private int id;
    private ClienteEntity cliente;
    private TreinadorEntity treinador;
    private LocalDate dataTreino;
    private LocalDateTime dataHoraFim;
    private List<ExerciciosEntity> exercicios;

    public TreinoEntity() {
        id = 0;
        cliente = new ClienteEntity();
        treinador = new TreinadorEntity();
        dataTreino = LocalDate.now();
        dataHoraFim = LocalDateTime.now();
        exercicios = new ArrayList<>();
    }

    public TreinoEntity(int id, ClienteEntity cliente, TreinadorEntity treinador, ExerciciosEntity exercicio, LocalDate dataTreino, LocalDateTime dataHoraFim) {
        this.id = id;
        this.cliente = cliente;
        this.treinador = treinador;
        this.dataTreino = dataTreino;
        this.dataHoraFim = dataHoraFim;
        this.exercicios = new ArrayList<>();
        this.exercicios.add(exercicio);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public TreinadorEntity getTreinador() {
        return treinador;
    }

    public void setTreinador(TreinadorEntity treinador) {
        this.treinador = treinador;
    }

    public LocalDate getDataTreino() {
        return dataTreino;
    }

    public void setDataTreino(LocalDate dataTreino) {
        this.dataTreino = dataTreino;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public List<ExerciciosEntity> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<ExerciciosEntity> exercicios) {
        this.exercicios = exercicios;
    }

    public void addExercicio(ExerciciosEntity exercicio) {
        this.exercicios.add(exercicio);
    }

    public void removeExercicio(ExerciciosEntity exercicio) {
        this.exercicios.remove(exercicio);
    }
}
