package cms.com.CMS.controller;

import cms.com.CMS.exception.ResourceNotFoundException;
import cms.com.CMS.model.Gender;
import cms.com.CMS.model.MaritalStatus;
import cms.com.CMS.model.Nationality;
import cms.com.CMS.model.PersonalInfo;
import cms.com.CMS.service.GenderService;
import cms.com.CMS.service.MaritalStatusService;
import cms.com.CMS.service.NationalityService;
import cms.com.CMS.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/personalInfo")
public class PersonalInfoController {
	private static final Logger logger = LoggerFactory.getLogger(PersonalInfoController.class);

	@Autowired
	private PersonalInfoService personalInfoService;
	@Autowired
	private GenderService genderService;
	@Autowired
	private NationalityService nationalityService;
	@Autowired
	private MaritalStatusService maritalStatusService;

	@PostMapping("/save")
	public ResponseEntity<String> savePersonalInfo(@RequestBody PersonalInfo personalInfo) {
		List<Gender> genders = genderService.listGender();
		List<Nationality> nationalities = nationalityService.getNationality();
		List<MaritalStatus> maritalStatusList = maritalStatusService.getStatus();

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
		return personalInfoService.savePersonalInfo(personalInfo);
	}



	@GetMapping("/list")
	public List<PersonalInfo> listPersonalInfo() {
		return personalInfoService.listPersonalInfo();
	}
	@GetMapping("/{id}")
	public ResponseEntity<String> findPersonalInfoById(@PathVariable Long id) {
		return personalInfoService.findPersonalInfoById(id);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePersonalInfo(@PathVariable Long id) {
		return personalInfoService.deletePersonalInfo(id);
	}
}
