package com.jpc16tuesday.springliblaryproject.hw_library.controller;

import com.jpc16tuesday.springliblaryproject.hw_library.model.Roles;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.GenericRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequestMapping(value = "/roles")//куда стучаться по пути к нашему серверу http://localhost:8080/authors
@Tag(name = "Роли", description = "Контроллер для работы с ролями пользователей")
public class RoleController{//extends GenericController<Roles,RolesDTO> {
    //public class RoleController GenericRepository<Roles> genericRepository) {
   //     super(genericRepository);
  //  }
  //  }
}
