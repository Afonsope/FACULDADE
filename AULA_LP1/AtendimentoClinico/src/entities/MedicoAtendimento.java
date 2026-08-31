package entities;

import java.time.LocalDateTime;

public class MedicoAtendimento {
    private AtendimentoEntity atendimento; //pk
    private MedicoEntity medico; //pk
    private LocalDateTime dataHoraInicio;
    private String observacoeString;
    private String status;

    public MedicoAtendimento() {
        atendimento = new AtendimentoEntity();
        medico = new MedicoEntity();
        dataHoraInicio = LocalDateTime.now();
        observacoeString = new String();
        status = new String();
    }

    public MedicoAtendimento(AtendimentoEntity atendimento, MedicoEntity medico, LocalDateTime dataHoraInicio, String observacoeString, String status) {
        this.atendimento = atendimento;
        this.medico = medico;
        this.dataHoraInicio = dataHoraInicio;
        this.observacoeString = observacoeString;
        this.status = status;
    }

    public AtendimentoEntity getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(AtendimentoEntity atendimento) {
        this.atendimento = atendimento;
    }

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public String getObservacoeString() {
        return observacoeString;
    }

    public void setObservacoeString(String observacoeString) {
        this.observacoeString = observacoeString;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
