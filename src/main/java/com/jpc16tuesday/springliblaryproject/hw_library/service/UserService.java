package com.jpc16tuesday.springliblaryproject.hw_library.service;

import com.jpc16tuesday.springliblaryproject.hw_library.dto.DirectorDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.dto.UserDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.mapper.GenericMapper;
import com.jpc16tuesday.springliblaryproject.hw_library.mapper.UserMapper;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Film;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Users;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.FilmRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.GenericRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
@Service
public class UserService extends GenericService<Users, UserDTO> {
    private final FilmRepository filmRepository;
    private final OrderRepository orderRepository;
    public UserService(GenericRepository<Users> repository, UserMapper mapper,
                       FilmRepository filmRepository,
                       OrderRepository orderRepository) {
        super(repository, mapper);
        this.filmRepository = filmRepository;
        this.orderRepository = orderRepository;
    }
   //   public UserDTO rentFilm(Long filmId, Long userId){
  //   Film film = filmRepository.findById(filmId).orElseThrow(() -> new NotFoundException("Книги с указаным айди не существует"));
  //    UserDTO user = getOne(userId);
  //    user.getRentedFilms().add(film.getId());
  //     return user;
  //}
}
