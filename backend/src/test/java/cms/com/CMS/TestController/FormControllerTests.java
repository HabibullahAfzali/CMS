package cms.com.CMS.TestController;

import cms.com.CMS.model.Gender;
import cms.com.CMS.model.MaritalStatus;
import cms.com.CMS.model.Nationality;
import cms.com.CMS.model.PersonalInfo;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class FormControllerTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testFindAllGenders() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/genders"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		String responseJson = result.getResponse().getContentAsString();

		List<Gender> genders = objectMapper.readValue(responseJson, new TypeReference<List<Gender>>() {});
		assertThat(genders).isNotEmpty();

	}

	@Test
	public void testFindAllMaritalStatus() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/maritalStatus"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		// Parse the response JSON to check if it's a list of marital statuses
		String responseJson = result.getResponse().getContentAsString();
		List<MaritalStatus> maritalStatuses = objectMapper.readValue(responseJson, new TypeReference<List<MaritalStatus>>() {});
		assertThat(maritalStatuses).isNotEmpty();


	}

	@Test
	public void testFindAllNationalities() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/nationalities"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		// Parse the response JSON to check if it's a list of nationalities
		String responseJson = result.getResponse().getContentAsString();
		List<Nationality> nationalities = objectMapper.readValue(responseJson, new TypeReference<List<Nationality>>() {});
		assertThat(nationalities).isNotEmpty();

	}

//	@Test
//	public void testSavePersonalInfo() throws Exception {
//		// Create a PersonalInfo object and convert it to JSON
//		PersonalInfo personalInfo = new PersonalInfo();
//		personalInfo.setFirstName("John");
//		personalInfo.setLastName("Doe");
//		String personalInfoJson = objectMapper.writeValueAsString(personalInfo);
//
//		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/savePersonalInfo")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(personalInfoJson))
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andReturn();
//
//		// Parse the response JSON to check if the personalInfo was saved
//		String responseJson = result.getResponse().getContentAsString();
//		assertThat(responseJson).isEqualTo("Response from savePersonalInfo");
//
//	}


	private static String asJsonString(Object obj) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
}
