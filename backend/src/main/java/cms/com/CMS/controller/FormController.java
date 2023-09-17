package cms.com.CMS.controller;
import cms.com.CMS.exception.ResourceNotFoundException;
import cms.com.CMS.model.*;
import cms.com.CMS.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class FormController {
	private static final Logger logger = LoggerFactory.getLogger(FormController.class);
	@Autowired
	private FormService formService;

//  <----- PersonalInfo Methods ------>

	@GetMapping("/genders")
	public List<Gender> findAllGenders() {
		return formService.listGender();
	}

	@GetMapping("/maritalStatus")
	public List<MaritalStatus> findAllMaritalStatus(){
		return 	formService.getStatus();
	}

	@GetMapping("/nationalities")
	public List<Nationality> findAllNationalities(){
		return formService.getNationality();
	}

	@PostMapping("/savePersonalInfo")
	public ResponseEntity<String> savePersonalInfo(@RequestBody PersonalInfo personalInfo) {
		List<Gender> genders = formService.listGender();
		List<Nationality> nationalities = formService.getNationality();
		List<MaritalStatus> maritalStatusList = formService.getStatus();

		// Find the selected Gender by ID
		Gender selectedGender = genders.stream()
				.filter(gender -> gender.getId().equals(personalInfo.getGender().getId()))
				.findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("Gender not found with ID: " + personalInfo.getGender().getId()));

		// Find the selected Nationality by ID
		Nationality selectedNationality = nationalities.stream()
				.filter(nationality -> nationality.getId().equals(personalInfo.getNationality().getId()))
				.findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("Nationality not found with ID: " + personalInfo.getNationality().getId()));

		// Find the selected MaritalStatus by ID
		MaritalStatus selectedMaritalStatus = maritalStatusList.stream()
				.filter(maritalStatus -> maritalStatus.getId().equals(personalInfo.getMaritalStatus().getId()))
				.findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("Marital status not found with ID: " + personalInfo.getMaritalStatus().getId()));

		personalInfo.setGender(selectedGender);
		personalInfo.setNationality(selectedNationality);
		personalInfo.setMaritalStatus(selectedMaritalStatus);
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warning message");
		logger.error("Error message");
		return formService.savePersonalInfo(personalInfo);
	}
	@GetMapping("/listPersonalInfo")
	public List<PersonalInfo> listPersonalInfo() {
		return formService.listPersonalInfo();
	}
	@GetMapping("/findPersonalInfoById/{id}")
	public ResponseEntity<String> findPersonalInfoById(@PathVariable Long id) {
		return formService.findPersonalInfoById(id);
	}
	@DeleteMapping("/deletePersonalInfo/{id}")
	public ResponseEntity<String> deletePersonalInfo(@PathVariable Long id) {
		return formService.deletePersonalInfo(id);
	}
	//  <----- End of PersonalInfo Methods ----->

// <----- Education Methods ----->
	@PostMapping("/saveEducation")
	public ResponseEntity<String> saveEducation(@RequestBody Education education) {
		return formService.saveEducation(education);
	}

	@GetMapping("/educationList")
	public List<Education> listEducation() {
		return formService.listEducation();
	}

	@GetMapping("/findEducationById/{id}")
	public ResponseEntity<String> findEducationById(@PathVariable Long id) {
		return formService.findEducationById(id);
	}

	@DeleteMapping("/deleteEducation/{id}")
	public ResponseEntity<String> deleteEducation(@PathVariable Long id) {
		return formService.deleteEducation(id);
	}

	// <----- End of Education Methods ----->

// <----- Work History Methods ----->
	@PostMapping("/saveWorks")
	public ResponseEntity<String> saveWorkHistory(@RequestBody WorkHistory workHistory) {
		return formService.saveWorkHistory(workHistory);
	}

	@GetMapping("/worksList")
	public List<WorkHistory> listWorkHistory() {
		return formService.listWorkHistory();
	}

	@GetMapping("/findWordById/{id}")
	public ResponseEntity<String> findWorkHistoryById(@PathVariable Long id) {
		return formService.findWorkHistoryById(id);
	}

	@DeleteMapping("/deleteWork/{id}")
	public ResponseEntity<String> deleteWorkHistory(@PathVariable Long id) {
		return formService.deleteWorkHistory(id);
	}
	// ----- End of Work Methods ----->

	//	<----- Address Methods ----->
@PostMapping("/saveAddress")
public ResponseEntity<String> saveAddress(@RequestBody Address address) {
	return formService.saveAddress(address);
}

	@GetMapping("/listAddress")
	public List<Address> listAddress() {
		return formService.listAddress();
	}

	@GetMapping("/findAddressById/{id}")
	public ResponseEntity<String> findAddressById(@PathVariable Long id) {
		return formService.findAddressById(id);
	}

	@DeleteMapping("/deleteAddress/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
		return formService.deleteAddress(id);
	}

	//  <----- End of Address Methods ----->

}
