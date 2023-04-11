package com.cg.onlineassesment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineassesment.entity.Role;
import com.cg.onlineassesment.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
       
	@PostMapping({"/createNewRole"})
	public Role createNewRole(@RequestBody Role role) {
	  return roleService.createNewRole(role);
	}
}
