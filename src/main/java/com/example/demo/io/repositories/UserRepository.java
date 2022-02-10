package com.example.demo.io.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long>{
	
	public UserEntity findByEmail(String email);
}
