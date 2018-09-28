package br.edu.uniritter.evento.johnEvento.service;

import br.edu.uniritter.evento.johnEvento.model.Event;
import br.edu.uniritter.evento.johnEvento.service.exception.CampoInvalidoException;

public interface EventoService {
    Event salvar(Event event) throws CampoInvalidoException;
}