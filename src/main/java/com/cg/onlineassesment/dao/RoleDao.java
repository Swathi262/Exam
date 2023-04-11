package com.cg.onlineassesment.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineassesment.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

	Role save(Role role);

	
}
