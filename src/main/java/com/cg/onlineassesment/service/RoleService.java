package com.cg.onlineassesment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineassesment.dao.RoleDao;
import com.cg.onlineassesment.entity.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;
   
	public Role createNewRole(Role role) {
		return roleDao.save(role);
		
	}
}
