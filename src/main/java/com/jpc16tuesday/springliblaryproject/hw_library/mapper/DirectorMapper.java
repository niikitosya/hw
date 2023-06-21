package com.jpc16tuesday.springliblaryproject.hw_library.mapper;

import com.jpc16tuesday.springliblaryproject.hw_library.dto.DirectorDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Director;
import com.jpc16tuesday.springliblaryproject.hw_library.model.GenericModel;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.FilmRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Component
public class DirectorMapper extends GenericMapper<Director, DirectorDTO> {
    private final FilmRepository filmRepository;
    public DirectorMapper(Class<Director> entityClass, Class<DirectorDTO> dtoClass,
                          ModelMapper modelMapper,
                          FilmRepository filmRepository) {
        super(entityClass, dtoClass, modelMapper);
        this.filmRepository = filmRepository;
    }

    @Override
    protected void mapSpecificFields(DirectorDTO source, Director destination) {
    if (!Objects.isNull(source.getFilmsIds())){
        destination.setFilms(filmRepository.findAllById(source.getFilmsIds()));
    }
    destination.setFilms(Collections.emptyList());
    }

    @Override
    protected void mapSpecificFields(Director source, DirectorDTO destination) {
        destination.setFilmsIds(getIds(source));
    }
    @PostConstruct
    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(Director.class, DirectorDTO.class)
                .addMappings(m -> m.skip(DirectorDTO::setFilmsIds)).setConverter(toDTOConverter());
        modelMapper.createTypeMap(DirectorDTO.class, Director.class)
                .addMappings(m -> m.skip(Director::setFilms)).setConverter(toEntityConverter());
    }

    @Override
    protected List<Long> getIds(Director entity) {
        return Objects.isNull(entity) || Objects.isNull(entity.getFilms())
                ? Collections.emptyList()
                : entity.getFilms().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toList());
    }
}
