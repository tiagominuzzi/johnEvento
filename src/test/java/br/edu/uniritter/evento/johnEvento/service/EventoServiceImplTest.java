package br.edu.uniritter.evento.johnEvento.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.uniritter.evento.johnEvento.model.Event;
import br.edu.uniritter.evento.johnEvento.repository.EventRepository;
import br.edu.uniritter.evento.johnEvento.service.exception.CampoInvalidoException;
import br.edu.uniritter.evento.johnEvento.service.impl.EventoServiceImpl;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class EventoServiceImplTest {

    private static final String NOME_EVENTO = "Evento Teste";
    private static final String NOME_EVENTO_151_CARACTERES = "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901";
    private static final LocalDateTime DATA_EVENTO_FUTURO = LocalDateTime.of(2018, 10, 30, 9, 30);
    private static final LocalDateTime DATA_EVENTO_PASSADO = LocalDateTime.of(2017, 10, 30, 9, 30);
    private static final LocalDateTime DATA_EVENTO_ATUAL = LocalDateTime.of(2018, 9, 1, 9, 30);

    private EventoService service;

    private Event newEvent;
    private Event createdEvent;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @MockBean
    private EventRepository repository;

    @Before
    public void setup() {
        service = new EventoServiceImpl(repository);
        newEvent = new Event(null, NOME_EVENTO, DATA_EVENTO_FUTURO);
        createdEvent = new Event(1L, NOME_EVENTO, DATA_EVENTO_FUTURO);
    }

    @Test
    public void campos_nome_e_data_do_evento_devem_ser_informados_ok() throws Exception{
        when(repository.save(newEvent)).thenReturn(createdEvent);
        Event result = service.salvar(newEvent);
        assertEquals(newEvent.getNome(), result.getNome());
        assertTrue(newEvent.getData().equals(result.getData()));
    }

    @Test
    public void campo_nome_nao_informados_ao_salvar() throws Exception{
        newEvent.setNome(null);
        expectedException.expect(CampoInvalidoException.class);
        expectedException.expectMessage("O nome do evento é obrigatório");
        service.salvar(newEvent);
    }

    @Test
    public void campo_data_nao_informados_ao_salvar() throws Exception{
        newEvent.setData(null);
        expectedException.expect(CampoInvalidoException.class);
        expectedException.expectMessage("A data do evento é obrigatória");
        service.salvar(newEvent);
    }

    @Test
    public void campo_nome_com_mais_de_150_caracteres() throws Exception{
        newEvent.setNome(NOME_EVENTO_151_CARACTERES);
        expectedException.expect(CampoInvalidoException.class);
        expectedException.expectMessage("O nome permite no máximo 150 caracteres");
        service.salvar(newEvent);
    }

    @Test
    public void data_do_evento_no_passado() throws Exception{
        newEvent.setData(DATA_EVENTO_PASSADO);
        expectedException.expect(CampoInvalidoException.class);
        expectedException.expectMessage("A data do evento deve ser igual ou maior que a de hoje");
        service.salvar(newEvent);
    }

}
