package com.jpc16tuesday.springliblaryproject.hw_library.mapper;

import com.jpc16tuesday.springliblaryproject.hw_library.dto.GenericDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.model.GenericModel;

import java.util.List;

public interface Mapper<E extends GenericModel, D extends GenericDTO> {
    public E toEntity(D source);
    public D toDTO(E source);
    public List<E> toEntities(List<D> dtos);
    public List<D> toDTOs(List<E> enitities);
}
