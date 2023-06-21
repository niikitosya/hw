package com.jpc16tuesday.springliblaryproject.hw_library.controller;

import com.jpc16tuesday.springliblaryproject.hw_library.dto.UserDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Users;
import com.jpc16tuesday.springliblaryproject.hw_library.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")//куда стучаться по пути к нашему серверу http://localhost:8080/authors
@Tag(name = "Пользователи", description = "Контроллер для работы с пользователями сервиса проката фильмов")
public class UserController extends GenericController<Users, UserDTO> {

    public UserController(UserService userService) {
        super(userService);

    }
//    @Operation(description = "взять фильм в аренду")
//    @RequestMapping(value = "RentFilm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<UserDTO> addRole(@RequestParam(value = "film.id") Long filmId,
//                                         @RequestParam(value = "user.id") Long userId){
//        return ResponseEntity.status(HttpStatus.OK).body(((UserService) service).rentFilm(filmId,userId));
//    }
}