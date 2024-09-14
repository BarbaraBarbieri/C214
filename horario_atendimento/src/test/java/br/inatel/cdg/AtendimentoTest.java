package br.inatel.cdg;

import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class AtendimentoTest {

    @Mock
    private AtendimentoService service;
    private BuscaAtendimento buscaAtendimento;

    @Before
    public void setup() {
        this.buscaAtendimento = new BuscaAtendimento(service);
    }

    @Test
    public void testeBuscaPorNome() {
        Mockito.when(service.buscaPorProfessor("Christopher Lima")).thenReturn(AtendimentoConst.CHRIS);

        String atendimentoJson = buscaAtendimento.buscaPorProfessor("Christopher Lima");
        JsonObject atendimento = JsonParser.parseString(atendimentoJson).getAsJsonObject();

        assertEquals("Christopher Lima", atendimento.get("professor").getAsString());
        assertEquals("15:30", atendimento.get("horario").getAsString());
        assertEquals("Segunda", atendimento.get("dia").getAsString());
        assertEquals("C214", atendimento.get("materia").getAsString());
        assertEquals("Integral", atendimento.get("periodo").getAsString());
        assertEquals(15, atendimento.get("sala").getAsInt());
        assertEquals(3, atendimento.get("predio").getAsInt());
    }

    @Test
    public void testeBuscaPorPredio() {
        Mockito.when(service.buscaPorPredio(2)).thenReturn(AtendimentoConst.BERNARDO);

        String atendimentoJson = buscaAtendimento.buscaPorPredio(2);
        JsonObject atendimento = JsonParser.parseString(atendimentoJson).getAsJsonObject();

        assertEquals("Bernardo Campos", atendimento.get("professor").getAsString());
        assertEquals("15:30", atendimento.get("horario").getAsString());
        assertEquals("Segunda", atendimento.get("dia").getAsString());
        assertEquals("C206-Lab", atendimento.get("materia").getAsString());
        assertEquals("Integral", atendimento.get("periodo").getAsString());
        assertEquals(2, atendimento.get("sala").getAsInt());
        assertEquals(1, atendimento.get("predio").getAsInt());
    }

    @Test
    public void testeBuscaPorPeriodo() {
        Mockito.when(service.buscaPorPeriodo("Noturno")).thenReturn(AtendimentoConst.CYSNEIROS);

        String atendimentoJson = buscaAtendimento.buscaPorPeriodo("Noturno");
        JsonObject atendimento = JsonParser.parseString(atendimentoJson).getAsJsonObject();

        assertEquals("Marcelo Cysneiros", atendimento.get("professor").getAsString());
        assertEquals("19:30", atendimento.get("horario").getAsString());
        assertEquals("Terça", atendimento.get("dia").getAsString());
        assertEquals("C216", atendimento.get("materia").getAsString());
        assertEquals("Noturno", atendimento.get("periodo").getAsString());
        assertEquals(19, atendimento.get("sala").getAsInt());
        assertEquals(4, atendimento.get("predio").getAsInt());
    }

    @Test
    public void testeBuscaPorSala() {
        Mockito.when(service.buscaPorSala(26)).thenReturn(AtendimentoConst.MARCONDES);

        String atendimentoJson = buscaAtendimento.buscaPorSala(26);
        JsonObject atendimento = JsonParser.parseString(atendimentoJson).getAsJsonObject();

        assertEquals("Guilherme Marcondes", atendimento.get("professor").getAsString());
        assertEquals("19:30", atendimento.get("horario").getAsString());
        assertEquals("Sexta", atendimento.get("dia").getAsString());
        assertEquals("C201", atendimento.get("materia").getAsString());
        assertEquals("Noturno", atendimento.get("periodo").getAsString());
        assertEquals(26, atendimento.get("sala").getAsInt());
        assertEquals(6, atendimento.get("predio").getAsInt());
    }

    @Test
    public void testeBuscaPorDia() {
        List<String> atendimentos = Arrays.asList(AtendimentoConst.BARBARA);
        Mockito.when(service.buscaPorDia("Quinta")).thenReturn(atendimentos);

        List<String> atendimentoJsons = buscaAtendimento.buscaPorDia("Quinta");
        JsonObject atendimento = JsonParser.parseString(atendimentoJsons.get(0)).getAsJsonObject();

        assertEquals("Barbara Barbieri", atendimento.get("professor").getAsString());
        assertEquals("21:30", atendimento.get("horario").getAsString());
        assertEquals("Quinta", atendimento.get("dia").getAsString());
        assertEquals("C205", atendimento.get("materia").getAsString());
        assertEquals("Noturno", atendimento.get("periodo").getAsString());
        assertEquals(23, atendimento.get("sala").getAsInt());
        assertEquals(5, atendimento.get("predio").getAsInt());
    }

    // Failure cases (exception handling)
    @Test(expected = IllegalArgumentException.class)
    public void testeBuscaPorNomeNaoEncontrado() {
        Mockito.when(service.buscaPorProfessor("Phyll Lima"))
                .thenThrow(new IllegalArgumentException("Professor não encontrado"));

        buscaAtendimento.buscaPorProfessor("Phyll Lima");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeBuscaPorPredioNaoEncontrado() {
        Mockito.when(service.buscaPorPredio(7)).thenThrow(new IllegalArgumentException("Predio não encontrado"));

        buscaAtendimento.buscaPorPredio(7);
    }
}
