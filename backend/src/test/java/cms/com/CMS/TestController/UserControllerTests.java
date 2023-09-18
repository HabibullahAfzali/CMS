package cms.com.CMS.TestController;

import cms.com.CMS.model.UserEntity;
import cms.com.CMS.repository.UserRepository;
import cms.com.CMS.service.request.AssignRoleRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserControllerTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserRepository userRepository;

	@BeforeEach
	public void setUp() {

	}

	@Test
	public void testCreateUser() throws Exception {
		MockMultipartFile file = new MockMultipartFile(
				"image",
				"test-image.jpg",
				MediaType.IMAGE_JPEG_VALUE,
				"Some image data".getBytes()
		);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.multipart("/api/createUser")
						.file(file)
						.param("email", "test@example.com")
						.param("username", "testUser")
						.param("password", "testPassword"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		assertThat(result.getResponse().getContentAsString()).isEqualTo("User Created Successfully!");

	}

	@Test
	public void testListUsers() throws Exception {
		// You can use mockMvc to simulate HTTP requests and test the listUsers endpoint
		mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").isArray()); // Assuming the response is a JSON array


	}

	@Test
	public void testUpdateUser() throws Exception {
		Long userIdToUpdate = 1L;
		UserEntity updatedUser = new UserEntity();
		updatedUser.setEmail("updated@example.com");
		updatedUser.setUsername("updatedUser");

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/api/updateUser/{id}", userIdToUpdate)
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(updatedUser))) // Convert the updatedUser to JSON
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		assertThat(result.getResponse().getContentAsString()).isEqualTo("User updated with ID: " + userIdToUpdate);

	}

	@Test
	public void testDeleteUser() throws Exception {
		// Assuming you have a user with ID 1 in the database
		Long userIdToDelete = 1L;

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/api/deleteUser/{id}", userIdToDelete))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		assertThat(result.getResponse().getContentAsString()).isEqualTo("User deleted with ID: " + userIdToDelete);

	}

	@Test
	public void testAssignRolesToUser() throws Exception {
		AssignRoleRequest assignRoleRequest = new AssignRoleRequest();
		assignRoleRequest.setUserId(1L);
		assignRoleRequest.setRoleId(1L);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/assign-roles")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(assignRoleRequest))) // Convert the assignRoleRequest to JSON
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		assertThat(result.getResponse().getContentAsString()).isEqualTo("Roles assigned successfully");

		// Add additional assertions if needed
	}


	@Test
	public void testGetRoles() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/roles"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

	}

	private static String asJsonString(Object obj) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

}
