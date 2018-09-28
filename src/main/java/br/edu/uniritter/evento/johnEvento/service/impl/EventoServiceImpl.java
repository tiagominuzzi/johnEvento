package br.edu.uniritter.evento.johnEvento.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.uniritter.evento.johnEvento.model.Event;
import br.edu.uniritter.evento.johnEvento.repository.EventRepository;
import br.edu.uniritter.evento.johnEvento.service.EventoService;
import br.edu.uniritter.evento.johnEvento.service.exception.CampoInvalidoException;
import org.springframework.stereotype.Service;

@Service
public class EventoServiceImpl implements EventoService {

    private EventRepository repository;

    @Autowired
    public EventoServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    public Event salvar(Event event) throws CampoInvalidoException {
        validaNome(event.getNome());
        validaData(event.getData());
        return repository.save(event);
    }

    private void validaNome(String nome) throws CampoInvalidoException {
        if (nome == null || nome.isEmpty()) {
            throw new CampoInvalidoException("O nome do evento é obrigatório");
        } 
        if (nome.length() > 150) {
            throw new CampoInvalidoException("O nome permite no máximo 150 caracteres");
        }
    }

    private void validaData(LocalDateTime data) throws CampoInvalidoException {
        if (data == null) {
            throw new CampoInvalidoException("A data do evento é obrigatória");
        }
        if (data.isBefore(LocalDateTime.now())) {
            throw new CampoInvalidoException("A data do evento deve ser igual ou maior que a de hoje");
        }
    }

}