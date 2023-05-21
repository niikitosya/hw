package com.jpc16tuesday.springliblaryproject.hw_library.controller;

import com.jpc16tuesday.springliblaryproject.hw_library.model.Director;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Film;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.DirectorRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.FilmRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.GenericRepository;
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

public class DirectorController extends GenericController<Director> {
    private final FilmRepository filmRepository;
    private final DirectorRepository directorRepository;
    public DirectorController(GenericRepository<Director> genericRepository, FilmRepository filmRepository, DirectorRepository directorRepository) {
        super(genericRepository);
        this.filmRepository = filmRepository;
        this.directorRepository = directorRepository;
    }
    @Operation(description = "Добавить автора книги")
    @RequestMapping(value = "/addFilm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Director> addFilm(@RequestParam(value = "directorsId") Long directorId,
                                            @RequestParam(value = "filmId") Long filmId){
        Film film = filmRepository.findById(filmId).orElseThrow(() -> new NotFoundException("Фильм с указанным айди не найден"));
        Director director = directorRepository.findById(directorId).orElseThrow(() -> new NotFoundException("Директор с указанным айди не найден"));
        director.getFilms().add(film);
        return ResponseEntity.status(HttpStatus.OK).body(directorRepository.save(director));
    }
}