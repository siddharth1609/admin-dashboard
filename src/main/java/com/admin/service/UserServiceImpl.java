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

	@Override
	public User SaveUser(User user) {

		UserDTO userDTO = UserMapper.INSTANE.userToUserDT(user);

		return UserMapper.INSTANE.userToUserDT(userRepository.save(userDTO));// UserMapper.INSTANE.userToUserDT(userDTO);
	}

	@Override
	public User getUserByid(Long id) {

		return UserMapper.INSTANE.userToUserDT(userRepository.findOne(id));
	}

	@Override
	public User updateUserById(Long id, User user) {

		UserDTO finduser = userRepository.findOne(id);

		finduser = UserMapper.INSTANE.userToUserDT(user);

		return UserMapper.INSTANE.userToUserDT(userRepository.save(finduser));
	}

	@Override
	public User deleteUserByid(Long id) {
		UserDTO finduser = userRepository.findOne(id);
		userRepository.delete(finduser);
		return UserMapper.INSTANE.userToUserDT(finduser);

	}

}
