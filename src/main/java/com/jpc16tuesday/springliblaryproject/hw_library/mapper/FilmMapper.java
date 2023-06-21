package com.jpc16tuesday.springliblaryproject.hw_library.mapper;

import com.jpc16tuesday.springliblaryproject.hw_library.dto.DirectorDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.dto.FilmDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Director;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Film;
import com.jpc16tuesday.springliblaryproject.hw_library.model.GenericModel;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.DirectorRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Component
public class FilmMapper extends GenericMapper<Film, FilmDTO> {
    private final DirectorRepository directorRepository;
    public FilmMapper(
                      ModelMapper modelMapper,
                      DirectorRepository directorRepository) {
        super(Film.class, FilmDTO.class, modelMapper);
        this.directorRepository = directorRepository;
    }

    @Override
    protected void mapSpecificFields(FilmDTO source, Film destination) {
        if (!Objects.isNull(source.getDirectorIds())){
            destination.setDirectors(directorRepository.findAllById(source.getDirectorIds()));
        }
        else {
            destination.setDirectors(Collections.emptyList());
        }
    }

    @Override
    protected void mapSpecificFields(Film source, FilmDTO destination) {
        destination.setDirectorIds(getIds(source));
    }

    @PostConstruct
    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(Film.class, FilmDTO.class)
                .addMappings(m -> m.skip(FilmDTO::setDirectorIds)).setConverter(toDTOConverter());
        modelMapper.createTypeMap(FilmDTO.class, Film.class)
                .addMappings(m -> m.skip(Film::setDirectors)).setConverter(toEntityConverter());
    }

    @Override
    protected List<Long> getIds(Film entity) {
        return Objects.isNull(entity) || Objects.isNull(entity.getDirectors())
                ? Collections.emptyList()
                : entity.getDirectors().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toList());
    }
}
