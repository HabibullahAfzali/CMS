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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

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

    public static String uploadDirectory = System.getProperty("user.dir")+ "/src/main/webapp/Images";

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @ModelAttribute CreateUserDTO createUserDTO,
                                        @RequestParam("image") MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        Path fileNameAndPath = Paths.get(uploadDirectory,originalFilename);
        try {
            Files.write(fileNameAndPath,file.getBytes());

            UserEntity userEntity = new UserEntity();
            userEntity.setProfilePicture(originalFilename);
            userEntity.setEmail(createUserDTO.getEmail());
            userEntity.setUsername(createUserDTO.getUsername());
            userEntity.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));

            userRepository.save(userEntity);
            return ResponseEntity.ok("User Created Successfully!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> listUsers(){
        List<UserEntity> userEntities = userDetailsService.getAllUsers();
        return  ResponseEntity.ok(userEntities);
    }
    @GetMapping("/users/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Long id){
        return  userRepository.findById(id);

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


    @PutMapping("/updateUser/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserEntity userEntity, @PathVariable  Long id){
        if(userRepository.findById(id).isPresent()){

            userRepository.save(userEntity);
        }
        return ResponseEntity.ok( "User updated with ID: "+id);
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
        userRepository.deleteById((id));
        return "User deleted with ID: "+(id);
    }


}
