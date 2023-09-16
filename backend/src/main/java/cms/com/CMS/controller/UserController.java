package cms.com.CMS.controller;

import cms.com.CMS.repository.RoleRepository;
import cms.com.CMS.service.UserDetailsServiceImpl;
import cms.com.CMS.service.UserService;
import cms.com.CMS.service.request.AssignRoleRequest;
import cms.com.CMS.service.request.CreateUserDTO;
import cms.com.CMS.model.RoleEntity;
import cms.com.CMS.model.UserEntity;
import cms.com.CMS.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserEntity> listUsers(){
        return userDetailsService.getAllUsers();
    }


    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO){

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(createUserDTO.getEmail());
        userEntity.setUsername(createUserDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));

        userRepository.save(userEntity);

        return ResponseEntity.ok("User registered successfully.");
    }
    @PostMapping("/assign-roles")
    public ResponseEntity<?> assignRolesToUser(@RequestBody AssignRoleRequest assignRoleRequest) {

        try {
            userService.assignRolesToUser(assignRoleRequest);
            return ResponseEntity.ok("Roles assigned successfully");

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error assigning role: " + e.getMessage());
        }
    }
    @GetMapping("/roles")
    public List<RoleEntity> getRoles() {
      return roleRepository.findAll();
    }


    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String id){
        userRepository.deleteById(Long.parseLong(id));
        return "User deleted with ID: "+(id);
    }
}
