package entities;

import java.time.LocalDateTime;

public class ExameAtendimento {
    private AtendimentoEntity atendimento;
    private ExameEntity exame;
    private LocalDateTime dataHoraRealizacoes;
    private String laudo;
    private String observacoes;

    public ExameAtendimento() {
        atendimento = new AtendimentoEntity();
        exame = new ExameEntity();
        dataHoraRealizacoes = LocalDateTime.now();
        laudo = new String();
        observacoes = new String();
    }

    public ExameAtendimento(AtendimentoEntity atendimento, ExameEntity exame, LocalDateTime dataHoraRealizacoes,
            String laudo, String observacoes) {
        this.atendimento = atendimento;
        this.exame = exame;
        this.dataHoraRealizacoes = dataHoraRealizacoes;
        this.laudo = laudo;
        this.observacoes = observacoes;
    }

    public AtendimentoEntity getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(AtendimentoEntity atendimento) {
        this.atendimento = atendimento;
    }

    public ExameEntity getExame() {
        return exame;
    }

    public void setExame(ExameEntity exame) {
        this.exame = exame;
    }

    public LocalDateTime getDataHoraRealizacoes() {
        return dataHoraRealizacoes;
    }

    public void setDataHoraRealizacoes(LocalDateTime dataHoraRealizacoes) {
        this.dataHoraRealizacoes = dataHoraRealizacoes;
    }

    public String getLaudo() {
        return laudo;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
