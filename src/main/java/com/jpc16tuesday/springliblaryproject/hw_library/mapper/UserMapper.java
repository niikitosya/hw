package com.jpc16tuesday.springliblaryproject.hw_library.mapper;

import com.jpc16tuesday.springliblaryproject.hw_library.dto.UserDTO;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Director;
import com.jpc16tuesday.springliblaryproject.hw_library.model.GenericModel;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Users;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Component
public class UserMapper extends GenericMapper<Users, UserDTO> {
    public UserMapper(Class<Users> entityClass, Class<UserDTO> dtoClass, ModelMapper modelMapper) {
        super(entityClass, dtoClass, modelMapper);
    }
    @Override
    protected void mapSpecificFields(UserDTO source, Users destination) {
        modelMapper.createTypeMap(Users.class, UserDTO.class)
                .setConverter(toDTOConverter());
        modelMapper.createTypeMap(UserDTO.class, Users.class)
                .setConverter(toEntityConverter());
    }
    @Override
    protected void mapSpecificFields(Users source, UserDTO destination) {

    }
    @Override
    protected void setupMapper() {
    }
    @Override
    protected List<Long> getIds(Users entity) {
        return Objects.isNull(entity) || Objects.isNull(entity.getRentedFilms())
                ? Collections.emptyList()
                : entity.getRentedFilms().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toList());
    }
}
