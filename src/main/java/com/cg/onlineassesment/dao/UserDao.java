package com.cg.onlineassesment.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineassesment.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String>{

	User findByUserName(String username);
}
