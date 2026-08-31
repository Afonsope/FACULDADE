package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class AtendimentoEntity {
    private int id;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataAlta;
    private String convenio;
    private String observacaoEntrada;
    private String observacaoAlta;
    private ArrayList<MedicoAtendimento> atendimentosMedicos;
    private ArrayList<ProcedimentoAtendimento> procedimentos;
    private ArrayList<ExameAtendimento> exames;
    private PessoaEntity paciente;
    private FuncionarioEntity atendente;

    public AtendimentoEntity() {
        id = 0;
        dataAbertura = LocalDateTime.now();
        dataAlta = null;
        convenio = new String();
        observacaoEntrada = new String();
        observacaoAlta = new String();
        atendimentosMedicos = new ArrayList<>();
        procedimentos = new ArrayList<>();
        exames = new ArrayList<>();
        paciente = new PacienteEntity();
        atendente = new FuncionarioEntity();
    }

    public AtendimentoEntity(int id, LocalDateTime dataAbertura, LocalDateTime dataAlta, String convenio, String observacaoEntrada, String observacaoAlta, ArrayList<MedicoAtendimento> atendimentosMedicos, ArrayList<ProcedimentoAtendimento> procedimentos, ArrayList<ExameAtendimento> exames, PacienteEntity paciente, FuncionarioEntity atendente) {
        this.id = id;
        this.dataAbertura = dataAbertura;
        this.dataAlta = dataAlta;
        this.convenio = convenio;
        this.observacaoEntrada = observacaoEntrada;
        this.observacaoAlta = observacaoAlta;
        this.atendimentosMedicos = atendimentosMedicos;
        this.procedimentos = procedimentos;
        this.exames = exames;
        this.paciente = paciente;
        this.atendente = atendente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(LocalDateTime dataAlta) {
        this.dataAlta = dataAlta;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getObservacaoEntrada() {
        return observacaoEntrada;
    }

    public void setObservacaoEntrada(String observacaoEntrada) {
        this.observacaoEntrada = observacaoEntrada;
    }

    public String getObservacaoAlta() {
        return observacaoAlta;
    }

    public void setObservacaoAlta(String observacaoAlta) {
        this.observacaoAlta = observacaoAlta;
    }

    public ArrayList<MedicoAtendimento> getAtendimentosMedicos() {
        return atendimentosMedicos;
    }

    public void setAtendimentosMedicos(ArrayList<MedicoAtendimento> atendimentosMedicos) {
        this.atendimentosMedicos = atendimentosMedicos;
    }

    public ArrayList<ProcedimentoAtendimento> getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(ArrayList<ProcedimentoAtendimento> procedimentos) {
        this.procedimentos = procedimentos;
    }

    public ArrayList<ExameAtendimento> getExames() {
        return exames;
    }

    public void setExames(ArrayList<ExameAtendimento> exames) {
        this.exames = exames;
    }

    public PacienteEntity getPaciente() {
        return (PacienteEntity) paciente;
    }

    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }

    public FuncionarioEntity getAtendente() {
        return atendente;
    }

    public void setAtendente(FuncionarioEntity atendente) {
        this.atendente = atendente;
    }

    public void adicionarMedico(MedicoAtendimento medico) {
        atendimentosMedicos.add(medico);
    }

    public void removerMedico(MedicoAtendimento medico) {
        atendimentosMedicos.remove(medico);
    }

    public void adicionarProcedimento(ProcedimentoAtendimento procedimento) {
        procedimentos.add(procedimento);
    }

    public void removerProcedimento(ProcedimentoAtendimento procedimento) {
        procedimentos.remove(procedimento);
    }

    public void adicionarExame(ExameAtendimento exame) {
        exames.add(exame);
    }

    public void removerExame(ExameAtendimento exame) {
        exames.remove(exame);
    }
}
