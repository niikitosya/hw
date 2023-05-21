package com.jpc16tuesday.springliblaryproject.hw_library.controller;

import com.jpc16tuesday.springliblaryproject.hw_library.model.GenericModel;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.GenericRepository;
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
public abstract class GenericController<T extends GenericModel> {
    private GenericRepository<T> genericRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public GenericController(GenericRepository<T> genericRepository){
        this.genericRepository = genericRepository;
    }


    @Operation(description = "Получить запись по ID", method = "getOneById")
    @RequestMapping(value = "/getOneById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> getOneById(@RequestParam(value = "id") long id){
        //http://localhost:8080/authors/getOneById?id=3
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(genericRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Данные по переданному айди не представлены")));
    }

    @Operation(description = "Получить все записи", method = "getAll")
    @RequestMapping(value = "/getAll",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<T>> getAll(){
        //http://localhost:8080/authors/getOneById?id=3
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(genericRepository.findAll());
    }
    @Operation(description = "Создать запись", method = "add")
    @RequestMapping(value = "/add",
                    method = RequestMethod.POST,
                    produces =  MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> create(@RequestBody T newEntity){
        log.info(newEntity.toString());
        newEntity.setCreatedWhen(LocalDateTime.now());
        genericRepository.save(newEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEntity);
    }
    @Operation(description = "обновить запиь", method = "update")
    @RequestMapping(value =  "/update",
                    method = RequestMethod.PUT,
                    produces =  MediaType.APPLICATION_JSON_VALUE,
                    consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> update(@RequestBody T updateEntity, @RequestParam(value = "id") Long id){
        updateEntity.setId(id);
        genericRepository.save(updateEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(updateEntity);
    }
    @Operation(method = "delete", description = "Удалить запись")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        genericRepository.deleteById(id);
    }
}
