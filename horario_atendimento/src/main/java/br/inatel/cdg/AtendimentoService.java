package br.inatel.cdg;

import java.util.List;

public interface AtendimentoService {

    String buscaPorProfessor(String nomeProf);

    String buscaPorPredio(int predio);

    String buscaPorPeriodo(String periodo);

    String buscaPorSala(int sala);

    String buscaPorHorario(String horario);

    List<String> buscaPorDia(String dia);

    String buscaPorMateria(String materia);

    List<String> listaAtendimentos();

    void adicionaAtendimento(String atendimento);

    void removeAtendimento(String atendimento);

    void atualizaAtendimento(String atendimento);

    void limpaAtendimentos();
}
