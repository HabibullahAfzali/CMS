package AsareCMS.com.AsareCMS.controller;

import AsareCMS.com.AsareCMS.model.Role;
import AsareCMS.com.AsareCMS.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/roles")
public class RoleController {

	private  final RoleService roleService;
@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	@GetMapping
	public List<Role> getAllRoles(){
		return roleService.getAllRoles();
	}
}
