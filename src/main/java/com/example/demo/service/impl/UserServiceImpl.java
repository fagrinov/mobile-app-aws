package com.example.demo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.io.entity.UserEntity;
import com.example.demo.io.repositories.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils util;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		if(userRepository.findByEmail(userDto.getEmail())!=null) throw new RuntimeException("User is already here!");
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		userEntity.setUserId(util.generateUserId(13));
		UserEntity storedUserDetails = userRepository.save(userEntity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		return returnValue;
		
	}

	@Override
	public UserDto getUser(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		UserDto returnedValue = new UserDto();
		BeanUtils.copyProperties(userEntity, returnedValue);
		return returnedValue;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),new ArrayList<>() );
	}

	
}
