package com.admin.service;

import java.util.List;

import com.admin.datamodel.User;

public interface UserService {

	List<User> getAllUser();

	User SaveUser(User user);

	User getUserByid(Long id);

	User updateUserById(Long id, User user);

	User deleteUserByid(Long id);

	String getPincode(Long id, User user);

}
