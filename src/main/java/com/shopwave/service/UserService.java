package com.shopwave.service;

import com.shopwave.exception.UserException;
import com.shopwave.model.User;

public interface UserService {

	public User findUserProfileByJwt(String jwt) throws UserException;
	
	public User findUserByEmail(String email) throws UserException;


}
