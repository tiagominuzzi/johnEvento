package br.edu.uniritter.evento.johnEvento.resource;

import br.edu.uniritter.evento.johnEvento.model.ErrorWrapper;
import br.edu.uniritter.evento.johnEvento.model.Event;
import br.edu.uniritter.evento.johnEvento.service.EventoService;
import br.edu.uniritter.evento.johnEvento.service.exception.CampoInvalidoException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evento")
public class EventoResource {

    private EventoService service;

    @Autowired
    public EventoResource(EventoService service) {
        this.service = service;
    }

    @ApiOperation(value = "Inclusão de novos eventos", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Evento criado com sucesso"),
            @ApiResponse(code = 400, message = "Requisição inválida")
    })
    @PostMapping
    public ResponseEntity<Event> add(@RequestBody Event event) throws CampoInvalidoException {
        Event newEvent = service.salvar(event);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    @ExceptionHandler(CampoInvalidoException.class)
    public ResponseEntity<ErrorWrapper> handleUnicidadeCpfException(CampoInvalidoException e) {
        return new ResponseEntity<>(new ErrorWrapper(e.getMessage()), HttpStatus.BAD_REQUEST);
    }    

}