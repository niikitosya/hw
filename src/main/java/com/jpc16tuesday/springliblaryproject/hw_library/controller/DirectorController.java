package com.jpc16tuesday.springliblaryproject.hw_library.controller;

import com.jpc16tuesday.springliblaryproject.hw_library.dto.DirectorDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Director;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Film;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.DirectorRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.FilmRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.GenericRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.service.DirectorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;
@RestController
@RequestMapping("/directors")//куда стучаться по пути к нашему серверу http://localhost:8080/authors
@Tag(name = "Директоры", description = "Контроллер для работы с директорами фильмов, представленных в прокате")

public class DirectorController extends GenericController<Director, DirectorDTO> {
    public DirectorController(DirectorService service) {
        super(service);
    }
    @Operation(description = "Добавить автора фильма")
    @RequestMapping(value = "/addFilm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DirectorDTO> addFilm(@RequestParam(value = "directors_id") Long directorId,
                                            @RequestParam(value = "films_id") Long filmId){
       return ResponseEntity.status(HttpStatus.OK).body(((DirectorService) service).addFilm(filmId, directorId));
    }
}
