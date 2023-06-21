package com.jpc16tuesday.springliblaryproject.hw_library.service;

import com.jpc16tuesday.springliblaryproject.hw_library.dto.OrderDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.mapper.OrderMapper;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Film;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Order;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Users;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.FilmRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.OrderRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrderService extends GenericService<Order, OrderDTO> {
  private final OrderRepository orderRepository;
  private final UserRepository userRepository;
  private final FilmRepository filmRepository;
    public OrderService(OrderRepository repository, OrderMapper mapper,
                        OrderRepository orderRepository,
                        FilmRepository filmRepository,
                        UserRepository userRepository
                        ) {
        super(repository, mapper);
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
    }
    public List<Order> getAllRents(Long userId){
        return orderRepository.findAll().stream().filter(m -> m.getUser().getId() == userId).collect(Collectors.toList());
    }
    public OrderDTO takeRent(Long userId, Long filmId, int rentTime){
        Users user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("пользователя с указаным айди не существует"));
        Film film = filmRepository.findById(userId).orElseThrow(() -> new NotFoundException("фильма с указаным айди не существует"));
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setRentDate(LocalDate.now());
        LocalDate localDate = LocalDate.now();
        orderDTO.setReturnDate(localDate.plusDays(rentTime));
        orderDTO.setUserId(user.getId());
        orderDTO.setFilmId(film.getId());
        update(orderDTO);
        return orderDTO;
    }
}
