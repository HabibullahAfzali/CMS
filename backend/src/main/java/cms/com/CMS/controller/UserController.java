package AsareCMS.com.AsareCMS.controller;
import AsareCMS.com.AsareCMS.exception.ResourceNotFoundException;
import AsareCMS.com.AsareCMS.model.Role;
import AsareCMS.com.AsareCMS.model.User;
import AsareCMS.com.AsareCMS.service.RoleService;
import AsareCMS.com.AsareCMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")

public class UserController {

	private final UserService userService;
private final RoleService roleService;
	@Autowired
	public UserController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}




@PostMapping()
	public User createUser(@RequestBody User user) {
	Role selectedRole = roleService.getAllRoles().stream().filter(role -> role.getId().equals(user.getRole().getId())).findFirst().
			orElseThrow(()->new ResourceNotFoundException("Role not found with ID: "+ user.getRole().getId()));
	user.setRole((selectedRole));
		return userService.saveUser(user);
	}
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id)
				.orElseThrow(()->new ResourceNotFoundException("User with this id is not exist" + id));
	}
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		if (userService.getUserById(id).isPresent()) {
			Role selectedRole = roleService.getAllRoles().stream()
					.filter(role -> role.getId().equals(user.getRole().getId()))
					.findFirst()
					.orElseThrow(() -> new ResourceNotFoundException("Role not found with ID: " + user.getRole().getId()));

			user.setRole(selectedRole);
			return userService.saveUser(user);
		}
		return null;
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {

		try {
			userService.deleteUser(id);
			return ResponseEntity.ok("User Successfully Deleted");
		}
		catch (ResourceNotFoundException e){

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body((e.getMessage()));
		}
	}

}
