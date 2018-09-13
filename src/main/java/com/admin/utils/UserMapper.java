package com.admin.utils;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.admin.datamodel.User;
import com.admin.datamodel.UserDTO;

@Mapper
public interface UserMapper {

	UserMapper INSTANE = Mappers.getMapper(UserMapper.class);

	User userToUserDT(UserDTO userDTO);

	// @Mapping(source = "numberOfSeats", target = "seatCount")
	// CarDto carToCarDto(Car car); 2

	List<User> listUserToUserDTO(List<UserDTO> dtolist);
}
