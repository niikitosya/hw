package com.jpc16tuesday.springliblaryproject.hw_library.mapper;

import com.jpc16tuesday.springliblaryproject.hw_library.dto.GenericDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.model.GenericModel;
import jakarta.annotation.PostConstruct;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Objects;

public abstract class GenericMapper<E extends GenericModel, D extends GenericDTO>
implements Mapper<E, D>{
    private final Class<E> entityClass;
    private final Class<D> dtoClass;
    protected final ModelMapper modelMapper;
    public GenericMapper(Class<E> entityClass, Class<D> dtoClass, ModelMapper modelMapper) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
        this.modelMapper = modelMapper;
    }

    @Override
    public E toEntity(D source) {
        return Objects.isNull(source)
                ? null
                : modelMapper.map(source, entityClass);
    }

    @Override
    public D toDTO(E source) {
        return Objects.isNull(source)
                ? null
                : modelMapper.map(source, dtoClass);
    }

    @Override
    public List<E> toEntities(List<D> dtos) {
        return dtos.stream().map(this::toEntity).toList();
    }

    @Override
    public List<D> toDTOs(List<E> entities) {
        return entities.stream().map(this::toDTO).toList();
    }
    protected Converter<D, E> toEntityConverter() {
        return mappingContext -> {
            D source = mappingContext.getSource();
            E destination = mappingContext.getDestination();
            mapSpecificFields(source, destination);
            return mappingContext.getDestination();
        };
    }
    protected Converter<E, D> toDTOConverter() {
        return mappingContext -> {
            E source = mappingContext.getSource();
            D destination = mappingContext.getDestination();
            mapSpecificFields(source, destination);
            return mappingContext.getDestination();
        };
    }
        protected abstract void mapSpecificFields (D source, E destination);
        protected abstract void mapSpecificFields(E source, D destination);
    @PostConstruct
    protected abstract void setupMapper();
    protected abstract List<Long> getIds(E entity);
}
