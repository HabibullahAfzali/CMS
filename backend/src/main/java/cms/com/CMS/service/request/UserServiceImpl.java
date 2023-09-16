package cms.com.CMS.service.request;

import cms.com.CMS.model.RoleEntity;
import cms.com.CMS.model.UserEntity;
import cms.com.CMS.repository.RoleRepository;
import cms.com.CMS.repository.UserRepository;
import cms.com.CMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void assignRolesToUser(AssignRoleRequest assignRoleRequest) {
		Long userId = assignRoleRequest.getUserId();
		Long roleId = assignRoleRequest.getRoleId();

		UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		RoleEntity role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));

		user.addRole(role); // Add the new role to the user

		userRepository.save(user);
	}
}
