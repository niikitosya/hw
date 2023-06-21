package com.jpc16tuesday.springliblaryproject.hw_library.service;

import com.jpc16tuesday.springliblaryproject.hw_library.dto.DirectorDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.mapper.DirectorMapper;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Director;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Film;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.DirectorRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.FilmRepository;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class DirectorService extends GenericService<Director, DirectorDTO> {
    private final FilmRepository filmRepository;

    public DirectorService(DirectorRepository directorRepository,
                                           DirectorMapper mapper,
                                           FilmRepository filmRepository){
        super(directorRepository, mapper);
        this.filmRepository = filmRepository;
    }
    public DirectorDTO addFilm(Long filmId, long directorId){
        Film film = filmRepository.findById(filmId).orElseThrow(() -> new NotFoundException("Фильма с указаным айди не существует"));
        DirectorDTO director = getOne(directorId);
        director.getFilmsIds().add(film.getId());
        update(director);
        return director;
    }
}
