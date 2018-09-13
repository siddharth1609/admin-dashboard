package com.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.datamodel.User;
import com.admin.datamodel.UserDTO;
import com.admin.repository.UserRepository;
import com.admin.utils.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() {

		List<UserDTO> listdto = new ArrayList();
		List<UserDTO> udto = userRepository.findAll();

		System.out.println(udto);

		return UserMapper.INSTANE.listUserToUserDTO(userRepository.findAll());
	}

}
// given
// Car car = new Car( "Morris", 5, CarType.SEDAN );

// when
// CarDto carDto = CarMapper.INSTANCE.carToCarDto( car );