package br.edu.uniritter.evento.johnEvento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.uniritter.evento.johnEvento.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
}