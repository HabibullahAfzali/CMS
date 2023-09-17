package cms.com.CMS.service;

import cms.com.CMS.exception.ResourceNotFoundException;
import cms.com.CMS.model.*;
import cms.com.CMS.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormService {
	@Autowired
	private PersonalInfoRepository personalInfoRepository;
	@Autowired
	private GenderRepository genderRepository;
	@Autowired
	private MaritalStatusRepository maritalStatusRepository;
	@Autowired
	private NationalityRepository nationalityRepository;

	// <----- PersonalInfo Service Methods ------>

	public List<Gender> listGender(){
		return genderRepository.findAll();
	}
	public List<MaritalStatus> getStatus(){
		return maritalStatusRepository.findAll();
	}

	public List<Nationality> getNationality(){
		return nationalityRepository.findAll();
	}

	public ResponseEntity<String> savePersonalInfo(PersonalInfo personalInfo) {
		try {
			personalInfoRepository.save(personalInfo);
			return new ResponseEntity<>("PersonalInfo saved successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to save PersonalInfo: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public List<PersonalInfo> listPersonalInfo(){
		return personalInfoRepository.findAll();
	}

	public ResponseEntity<String> findPersonalInfoById(Long id){

		personalInfoRepository.findById(id);
		return ResponseEntity.ok("Record Founded!"+id);
	}
	public ResponseEntity<String> deletePersonalInfo( Long id){
		Optional<PersonalInfo> personalInfoOptional = personalInfoRepository.findById(id);
		if (personalInfoOptional.isEmpty()) {
			throw new ResourceNotFoundException("Record Not Found With ID:"+id);
		}
		personalInfoRepository.deleteById(id);
		return ResponseEntity.ok("Record deleted!");
	}
	// ----- End of PersonalInfo Service Methods ------>

	@Autowired
	private EducationRepository educationRepository;

	// <----- Education Service Methods ------>

	public ResponseEntity<String> saveEducation(Education education){
		educationRepository.save(education);
		return ResponseEntity.ok("Saved Successfully!");
	}

	public List<Education> listEducation(){
		return educationRepository.findAll();
	}

	public ResponseEntity<String> findEducationById(Long id){

		educationRepository.findById(id);
		return ResponseEntity.ok("Education Found!");
	}
	public ResponseEntity<String> deleteEducation( Long id){
		Optional<Education> educationOptional = educationRepository.findById(id);
		if (educationOptional.isEmpty()) {
			throw new ResourceNotFoundException("Education Not Found With ID:"+id);
		}
		educationRepository.deleteById(id);
		return ResponseEntity.ok("Education deleted!");
	}
// <----- End of Education Service Methods ------>

	@Autowired
	private WorkHistoryRepository workHistoryRepository;

	// <------ Work History Service Methods ----->
	public ResponseEntity<String> saveWorkHistory(WorkHistory workHistory){
		workHistoryRepository.save(workHistory);
		return ResponseEntity.ok("Address Save");
	}

	public List<WorkHistory> listWorkHistory(){
		return workHistoryRepository.findAll();
	}

	public ResponseEntity<String> findWorkHistoryById(Long id){

		workHistoryRepository.findById(id);
		return ResponseEntity.ok("Record Found!");
	}
	public ResponseEntity<String> deleteWorkHistory( Long id){
		Optional<WorkHistory> workHistoryOptional = workHistoryRepository.findById(id);
		if (workHistoryOptional.isEmpty()) {
			throw new ResourceNotFoundException("Record Not Found With ID:"+id);
		}
		workHistoryRepository.deleteById(id);
		return ResponseEntity.ok("Address deleted!");
	}
	//  <------ End of Work History Service Methods ----->
	@Autowired
	private AddressRepository addressRepository;

	//  <------ Address Service Methods ----->
	public ResponseEntity<String> saveAddress(Address address){
		addressRepository.save(address);
		return ResponseEntity.ok("Address Save");
	}

	public List<Address> listAddress(){
		return addressRepository.findAll();
	}

	public ResponseEntity<String> findAddressById(Long id){

		addressRepository.findById(id);
		return ResponseEntity.ok("Address Found!");
	}
	public ResponseEntity<String> deleteAddress( Long id){
		Optional<Address> addressOptional = addressRepository.findById(id);
		if (addressOptional.isEmpty()) {
			throw new ResourceNotFoundException("Address Not Found With ID:"+id);
		}
		addressRepository.deleteById(id);
		return ResponseEntity.ok("Address deleted!");
	}
	//  <------ End of Address Service Methods ----->
}
