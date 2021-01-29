package com.neobis.onlineshop.service;

import com.neobis.onlineshop.entity.DAOUser;
import com.neobis.onlineshop.model.UserDTO;
import com.neobis.onlineshop.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//review

@Service("userDetailsServiceImpl") // name is required if there are 2 classes UserDetailsService & UserDetailsServiceImpl
public class UserDetailsServiceImpl implements UserDetailsService { //JwtUserDetailsService

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//DAOUser user = userDao.findByUsername(username); //original
		DAOUser user = userDao.findByUsername(username); //?
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public DAOUser save(UserDTO user) { // modified return type
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser); //? casted, original: 		return userDao.save(newUser);
 
	}
	//
}