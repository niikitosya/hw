package com.jpc16tuesday.springliblaryproject.hw_library.controller;

import com.jpc16tuesday.springliblaryproject.hw_library.dto.OrderDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Film;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Order;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Users;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.FilmRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.GenericRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.OrderRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.UserRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

@RestController
@RequestMapping("/orders")//куда стучаться по пути к нашему серверу http://localhost:8080/authors
@Tag(name = "Заказы", description = "Контроллер для работы с заказами")
public class OrderController extends GenericController<Order, OrderDTO> {
    public OrderController(OrderService orderService){
        super(orderService);
    }
    @Operation(description = "Создать заказ по расширенным параметрам ввода", method = "add")
    @RequestMapping(value = "/addWithFilmAndUserId",
            method = RequestMethod.POST,
            produces =  MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDTO> addByFilmAndUserId(@RequestBody Order newEntity,
                                                       @RequestParam(value = "films.id") Long filmsId,
                                                       @RequestParam(value = "users.id") Long usersId
                                                       ){
        return ResponseEntity.status(HttpStatus.OK).body(((OrderService)service).takeRent(usersId, filmsId,1));
    }

}
