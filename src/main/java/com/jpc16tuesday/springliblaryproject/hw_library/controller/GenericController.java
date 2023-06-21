package com.jpc16tuesday.springliblaryproject.hw_library.controller;

import com.jpc16tuesday.springliblaryproject.hw_library.dto.GenericDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.model.GenericModel;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.GenericRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.service.GenericService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Log4j
public abstract class GenericController<T extends GenericModel, D extends GenericDTO> {


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    protected GenericService<T, D> service;
    public GenericController(GenericService<T, D> service){
        this.service = service;
    }

    @Operation(description = "Получить запись по ID", method = "getOneById")
    @RequestMapping(value = "/getOneById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> getOneById(@RequestParam(value = "id") long id){
        //http://localhost:8080/authors/getOneById?id=3
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getOne(id));
    }

    @Operation(description = "Получить все записи", method = "getAll")
    @RequestMapping(value = "/getAll",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<D>> getAll(){
        //http://localhost:8080/authors/getOneById?id=3
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listAll());
    }
    @Operation(description = "Создать запись", method = "add")
    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            produces =  MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> create(@RequestBody D newEntity){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(newEntity));
    }
    @Operation(description = "обновить запиcь", method = "update")
    @RequestMapping(value =  "/update",
            method = RequestMethod.PUT,
            produces =  MediaType.APPLICATION_JSON_VALUE,
            consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> update(@RequestBody D updateEntity, @RequestParam(value = "id") Long id){
        updateEntity.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(updateEntity));
    }
    @Operation(method = "delete", description = "Удалить запись")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
}
