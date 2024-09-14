package br.inatel.cdg;

import java.util.List;

public class BuscaAtendimento {

    AtendimentoService atendimentoService;

    public BuscaAtendimento(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    public String buscaPorProfessor(String nomeProf) {
        return atendimentoService.buscaPorProfessor(nomeProf);
    }

    public String buscaPorPredio(int predio) {
        return atendimentoService.buscaPorPredio(predio);
    }

    public String buscaPorPeriodo(String periodo) {
        return atendimentoService.buscaPorPeriodo(periodo);
    }

    public String buscaPorSala(int sala) {
        return atendimentoService.buscaPorSala(sala);
    }

    public String buscaPorHorario(String horario) {
        return atendimentoService.buscaPorHorario(horario);
    }

    public String buscaPorMateria(String materia) {
        return atendimentoService.buscaPorMateria(materia);
    }

    public List<String> buscaPorDia(String dia) {
        return atendimentoService.buscaPorDia(dia);
    }

    public List<String> listaAtendimentos() {
        return atendimentoService.listaAtendimentos();
    }
}
