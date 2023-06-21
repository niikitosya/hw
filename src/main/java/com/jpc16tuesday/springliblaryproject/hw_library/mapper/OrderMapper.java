package com.jpc16tuesday.springliblaryproject.hw_library.mapper;

import com.jpc16tuesday.springliblaryproject.hw_library.dto.DirectorDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.dto.FilmDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.dto.OrderDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Director;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Film;
import com.jpc16tuesday.springliblaryproject.hw_library.model.GenericModel;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Order;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.FilmRepository;
import com.jpc16tuesday.springliblaryproject.hw_library.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Component
public class OrderMapper extends GenericMapper<Order, OrderDTO> {
    private final UserRepository userRepository;
    private final FilmRepository filmRepository;
    public OrderMapper(Class<Order> entityClass, Class<OrderDTO> dtoClass,
                          ModelMapper modelMapper,
                          UserRepository userRepository,
                       FilmRepository filmRepository) {
        super(entityClass, dtoClass, modelMapper);
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
    }

    @Override
    protected void mapSpecificFields(OrderDTO source, Order destination) {
        if(!Objects.isNull(source.getUserId()) && !Objects.isNull(source.getFilmId())) {
                destination.setUser(userRepository.getOne(source.getUserId()));
        }
        if(!Objects.isNull(source.getUserId()) && !Objects.isNull(source.getFilmId())) {
            destination.setFilm(filmRepository.getOne(source.getFilmId()));
        }
    }
    @Override
    protected void mapSpecificFields(Order source, OrderDTO destination) {
        destination.setFilmId(source.getFilm().getId());
        destination.setUserId(source.getUser().getId());
    }

    @PostConstruct
    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(Order.class, OrderDTO.class)
                .addMappings(m -> m.skip(OrderDTO::setFilmId)).
        addMappings(m -> m.skip(OrderDTO::setUserId)).setConverter(toDTOConverter());
        modelMapper.createTypeMap(OrderDTO.class, Order.class)
                .addMappings(m -> m.skip(Order::setFilm)).addMappings(m -> m.skip(Order::setUser)).
                setConverter(toEntityConverter());
    }

    @Override
    protected List<Long> getIds(Order entity) {
        return null;
    }
}
