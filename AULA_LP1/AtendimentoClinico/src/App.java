import java.time.LocalDateTime;
import java.util.ArrayList;

import entities.AdminEntity;
import entities.AtendimentoEntity;
import entities.ExameAtendimento;
import entities.ExameEntity;
import entities.FuncionarioEntity;
import entities.MedicoAtendimento;
import entities.MedicoEntity;
import entities.PacienteEntity;
import entities.ProcedimentoAtendimento;
import entities.ProcedimentosEntity;
import entities.StatusEntity;

public class App {
    public static void main(String[] args) throws Exception {
        StatusEntity status = new StatusEntity(1, "ativo");
        
        //Criando o paciente
        PacienteEntity paciente1 = new PacienteEntity("1111", "Roberto", "123", status, "Unimed");
        PacienteEntity paciente2 = new PacienteEntity("2222", "Larissa", "321", status, "SulAmérica");
        PacienteEntity paciente3 = new PacienteEntity("3333", "Carlos", "213", status, "Bradesco");

        //Criando o administrador
        AdminEntity admin = new AdminEntity("4444", "Luiz", "123", status, LocalDateTime.now().plusDays(2));

        //Criando os funcionários
        FuncionarioEntity funcionario1 = new FuncionarioEntity("5555", "José", "345", status, "Bloco - A");
        FuncionarioEntity funcionario2 = new FuncionarioEntity("6666", "Maria", "543", status, "Bloco - B");

        //Criando os médicos
        MedicoEntity medico1 = new MedicoEntity("7777", "Dr. Lucas", "435", status, "1.2.3-11");
        MedicoEntity medico2 = new MedicoEntity("8888", "Dra. Marilene", "453", status, "1.3.2-12");

        //criando os procedimentos
        ProcedimentosEntity procedimento1 = new ProcedimentosEntity(1, "Raio X", "Exame de imagem básico");
        ProcedimentosEntity procedimento2 = new ProcedimentosEntity(2, "Hemograma", "Exame de sangue completo");

        //Criando os exames
        ExameEntity exame1 = new ExameEntity(1, "Raio X do dedo", "Imagem");
        ExameEntity exame2 = new ExameEntity(2, "Hemograma Completo", "Sangue");

        //Criando arrays vazios para serem armazenados no atendimento
        ArrayList<MedicoAtendimento> medicos = new ArrayList<>();
        ArrayList<ProcedimentoAtendimento> procedimentos = new ArrayList<>();
        ArrayList<ExameAtendimento> exames = new ArrayList<>();

        AtendimentoEntity atendimento = new AtendimentoEntity(
            1,
            LocalDateTime.now().plusDays(2),
            LocalDateTime.now().plusDays(4),
            "Austa Clinica",
            "Osso do dedo quebrado",
            "Ficar com dedo enfachado por 2 semanas",
            medicos,
            procedimentos,
            exames,
            paciente1,
            funcionario1
        );

        MedicoAtendimento medicoAtendimento = new MedicoAtendimento(atendimento, medico2, LocalDateTime.now().plusDays(2), "Realizamento sobre fratura de Paciente", "em andamento");

        ProcedimentoAtendimento procedimentoAtendimento = new ProcedimentoAtendimento(atendimento, procedimento1, LocalDateTime.now().plusDays(2), "Realizado com sucesso");

        ExameAtendimento exameAtendimento = new ExameAtendimento(atendimento, exame1, LocalDateTime.now().plusDays(2), "Fratura confirmada no dedo indicador", "Paciente encaminhado para imobilização");

        atendimento.adicionarMedico(medicoAtendimento);
        atendimento.adicionarProcedimento(procedimentoAtendimento);
        atendimento.adicionarExame(exameAtendimento);

        //Atendimento 2 - Paciente Larissa
        ArrayList<MedicoAtendimento> medicos2 = new ArrayList<>();
        ArrayList<ProcedimentoAtendimento> procedimentos2 = new ArrayList<>();
        ArrayList<ExameAtendimento> exames2 = new ArrayList<>();

        AtendimentoEntity atendimento2 = new AtendimentoEntity(
            2,
            LocalDateTime.now().plusDays(1),
            LocalDateTime.now().plusDays(3),
            "Unimed",
            "Dor abdominal intensa",
            "Repouso e dieta leve por 5 dias",
            medicos2,
            procedimentos2,
            exames2,
            paciente2,
            funcionario2
        );

        MedicoAtendimento medicoAtendimento2 = new MedicoAtendimento(atendimento2, medico1, LocalDateTime.now().plusDays(1), "Avaliação clínica geral do paciente", "finalizado");

        ProcedimentoAtendimento procedimentoAtendimento2 = new ProcedimentoAtendimento(atendimento2, procedimento2, LocalDateTime.now().plusDays(1), "Hemograma dentro dos valores normais");

        ExameAtendimento exameAtendimento2 = new ExameAtendimento(atendimento2, exame2, LocalDateTime.now().plusDays(1), "Resultados sem alterações significativas", "Paciente liberada com orientações");

        atendimento2.adicionarMedico(medicoAtendimento2);
        atendimento2.adicionarProcedimento(procedimentoAtendimento2);
        atendimento2.adicionarExame(exameAtendimento2);

        //Atendimento 3 - Paciente Carlos
        ArrayList<MedicoAtendimento> medicos3 = new ArrayList<>();
        ArrayList<ProcedimentoAtendimento> procedimentos3 = new ArrayList<>();
        ArrayList<ExameAtendimento> exames3 = new ArrayList<>();

        AtendimentoEntity atendimento3 = new AtendimentoEntity(
            3,
            LocalDateTime.now().plusDays(3),
            LocalDateTime.now().plusDays(5),
            "SulAmérica",
            "Entorse no tornozelo esquerdo",
            "Uso de muletas por 10 dias",
            medicos3,
            procedimentos3,
            exames3,
            paciente3,
            funcionario1
        );

        MedicoAtendimento medicoAtendimento3 = new MedicoAtendimento(atendimento3, medico1, LocalDateTime.now().plusDays(3), "Avaliação ortopédica do tornozelo", "em andamento");
        MedicoAtendimento medicoAtendimento4 = new MedicoAtendimento(atendimento3, medico2, LocalDateTime.now().plusDays(4), "Reavaliação pós imobilização", "finalizado");

        ProcedimentoAtendimento procedimentoAtendimento3 = new ProcedimentoAtendimento(atendimento3, procedimento1, LocalDateTime.now().plusDays(3), "Raio X sem fratura, apenas entorse");
        ProcedimentoAtendimento procedimentoAtendimento4 = new ProcedimentoAtendimento(atendimento3, procedimento2, LocalDateTime.now().plusDays(3), "Hemograma de rotina sem alterações");

        ExameAtendimento exameAtendimento3 = new ExameAtendimento(atendimento3, exame1, LocalDateTime.now().plusDays(3), "Sem fratura identificada", "Entorse grau 2 confirmado");

        atendimento3.adicionarMedico(medicoAtendimento3);
        atendimento3.adicionarMedico(medicoAtendimento4);
        atendimento3.adicionarProcedimento(procedimentoAtendimento3);
        atendimento3.adicionarProcedimento(procedimentoAtendimento4);
        atendimento3.adicionarExame(exameAtendimento3);

    }
}
