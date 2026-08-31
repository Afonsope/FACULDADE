package entities;

import java.time.LocalDateTime;

public class ProcedimentoAtendimento {
    private AtendimentoEntity atendimento;
    private ProcedimentosEntity procedimento;
    private LocalDateTime dataHoraRealizacao;
    private String resultado;

    public ProcedimentoAtendimento() {
        atendimento = new AtendimentoEntity();
        procedimento = new ProcedimentosEntity();
        dataHoraRealizacao = null;
        resultado = new String();
    }

    public ProcedimentoAtendimento(AtendimentoEntity atendimento, ProcedimentosEntity procedimento, LocalDateTime dataHoraRealizacao, String resultado) {
        this.atendimento = atendimento;
        this.procedimento = procedimento;
        this.dataHoraRealizacao = dataHoraRealizacao;
        this.resultado = resultado;
    }

    public AtendimentoEntity getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(AtendimentoEntity atendimento) {
        this.atendimento = atendimento;
    }

    public ProcedimentosEntity getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(ProcedimentosEntity procedimento) {
        this.procedimento = procedimento;
    }

    public LocalDateTime getDataHoraRealizacao() {
        return dataHoraRealizacao;
    }

    public void setDataHoraRealizacao(LocalDateTime dataHoraRealizacao) {
        this.dataHoraRealizacao = dataHoraRealizacao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
