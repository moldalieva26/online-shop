package com.neobis.onlineshop.service;

import com.neobis.onlineshop.entity.UserEntity;
import com.neobis.onlineshop.model.UserDTO;
import com.neobis.onlineshop.repository.UserRepository;
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
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//UserEntity user = userDao.findByUsername(username); //original
		UserEntity user = userRepository.findByUsername(username); //?
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public UserEntity save(UserDTO user) { // modified return type
		UserEntity newUser = new UserEntity();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(newUser); //? casted, original: 		return userDao.save(newUser);
 
	}
	//
}