package AsareCMS.com.AsareCMS.service;

import AsareCMS.com.AsareCMS.exception.ResourceNotFoundException;
import AsareCMS.com.AsareCMS.model.PersonalInfo;
import AsareCMS.com.AsareCMS.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonalInfoService {

	@Autowired
	private PersonalInfoRepository personalInfoRepository;

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
}
