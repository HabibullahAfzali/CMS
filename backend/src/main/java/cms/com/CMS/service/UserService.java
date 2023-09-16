package AsareCMS.com.AsareCMS.service;

import AsareCMS.com.AsareCMS.exception.ResourceNotFoundException;
import AsareCMS.com.AsareCMS.model.User;
import AsareCMS.com.AsareCMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public User saveUser(User user) {
		return userRepository.save(user);
	}
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public void deleteUser(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		if(userOptional.isEmpty()){
			throw new ResourceNotFoundException("User not found with ID: "+id);
		}
		userRepository.deleteById(id);
	}

}
