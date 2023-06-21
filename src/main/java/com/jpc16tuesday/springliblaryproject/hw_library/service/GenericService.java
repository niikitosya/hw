package com.jpc16tuesday.springliblaryproject.hw_library.service;

import com.jpc16tuesday.springliblaryproject.hw_library.dto.GenericDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.mapper.GenericMapper;
import com.jpc16tuesday.springliblaryproject.hw_library.model.GenericModel;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.GenericRepository;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public abstract class GenericService<M extends GenericModel, D extends GenericDTO> {

    protected final GenericRepository<M> repository;
    protected final GenericMapper<M, D> mapper;

    public GenericService(GenericRepository<M> repository, GenericMapper<M, D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<D> listAll(){
        return mapper.toDTOs(repository.findAll());
    }
    public D getOne(final Long id){
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Пользователя с данным айди = " + id +" нет")));
    }
    public D create(D newObject){
        newObject.setCreatedWhen(LocalDateTime.now());
        return mapper.toDTO(repository.save(mapper.toEntity(newObject)));
    }
    public D update(D updatedObject){
        return mapper.toDTO(repository.save((mapper.toEntity(updatedObject))));
    }
    public void delete(final Long id){
        repository.deleteById(id);
    }
}
