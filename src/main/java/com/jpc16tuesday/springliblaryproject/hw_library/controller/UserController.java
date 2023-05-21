package com.jpc16tuesday.springliblaryproject.hw_library.controller;

import com.jpc16tuesday.springliblaryproject.hw_library.model.Roles;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Users;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.GenericRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.RolesRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;
@RestController
@RequestMapping("/users")//куда стучаться по пути к нашему серверу http://localhost:8080/authors
@Tag(name = "Пользователи", description = "Контроллер для работы с пользователями сервиса проката фильмов")
public class UserController extends GenericController<Users> {
    private final RolesRepository rolesRepository;
    private final UserRepository userRepository;

    public UserController(GenericRepository<Users> genericRepository, RolesRepository rolesRepository, UserRepository userRepository) {
        super(genericRepository);
        this.rolesRepository = rolesRepository;
        this.userRepository = userRepository;
    }
    @Operation(description = "выдать роль пользователю")
    @RequestMapping(value = "addRole", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> addRole(@RequestParam(value = "users.id") Long userId,
                                         @RequestParam(value = "role.id") Long roleId){
        Roles role = rolesRepository.findById(roleId).orElseThrow(() -> new NotFoundException("Роль с указанным id не найдена"));
        Users user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("Пользователь с указанным id не найден"));
        user.setRole(role);
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
    }
}