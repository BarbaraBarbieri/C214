package br.inatel.cdg;

public class Atendimento {

    private String professor;
    private String horario;
    private String periodo;
    private String dia;
    private String materia;
    private int predio;
    private int sala;

    public Atendimento() {}

    public Atendimento(String professor, String horario, String dia, String materia, String periodo, int sala, int predio) {
        this.professor = professor;
        this.horario = horario;
        this.dia = dia;
        this.materia = materia;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = predio;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getPredio() {
        return predio;
    }

    public void setPredio(int predio) {
        this.predio = predio;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }
}
