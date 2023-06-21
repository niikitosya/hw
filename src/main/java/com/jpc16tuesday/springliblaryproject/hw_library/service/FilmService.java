package com.jpc16tuesday.springliblaryproject.hw_library.service;

import com.jpc16tuesday.springliblaryproject.hw_library.dto.DirectorDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.dto.FilmDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.mapper.FilmMapper;
import com.jpc16tuesday.springliblaryproject.hw_library.mapper.GenericMapper;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Director;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Film;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.DirectorRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.FilmRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.GenericRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
@Service
public class FilmService extends GenericService<Film, FilmDTO> {
    private final DirectorRepository directorRepository;
    public FilmService(FilmRepository repository,
                       FilmMapper mapper,
                       DirectorRepository directorRepository) {
        super(repository, mapper);
        this.directorRepository = directorRepository;
    }
    public FilmDTO addDirector(final Long filmId, final Long directorId){
        Director director = directorRepository.findById(directorId).orElseThrow(() -> new NotFoundException("Книги с указаным айди не существует"));
        FilmDTO film = getOne(filmId);
        film.getDirectorIds().add(director.getId());
        update(film);
        return film;
    }
}
