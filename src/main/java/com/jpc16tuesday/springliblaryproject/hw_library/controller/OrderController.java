package com.jpc16tuesday.springliblaryproject.hw_library.controller;

import com.jpc16tuesday.springliblaryproject.hw_library.model.Film;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Order;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Users;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.FilmRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.GenericRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.OrderRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

@RestController
@RequestMapping("/orders")//куда стучаться по пути к нашему серверу http://localhost:8080/authors
@Tag(name = "Заказы", description = "Контроллер для работы с заказами")
public class OrderController extends GenericController<Order> {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final FilmRepository filmRepository;
    public OrderController(GenericRepository<Order> genericRepository, OrderRepository orderRepository, UserRepository userRepository, FilmRepository filmRepository) {
        super(genericRepository);
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
    }
    @Operation(description = "Создать заказ по расширенным параметрам ввода", method = "add")
    @RequestMapping(value = "/addWithFilmAndUserId",
            method = RequestMethod.POST,
            produces =  MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> addByFilmAndUserId(@RequestBody Order newEntity,
                                                    @RequestParam(value = "films.id") Long filmsId,
                                                    @RequestParam(value = "users.id") Long usersId){
        Film film = filmRepository.findById(filmsId).orElseThrow(() -> new NotFoundException("Фильма с указанным айди нет"));
        Users user = userRepository.findById(usersId).orElseThrow(() -> new NotFoundException("пользователя с указанным айди нет"));
        newEntity.setFilm(film);
        newEntity.setUser(user);
        return super.create(newEntity);
    }

}
