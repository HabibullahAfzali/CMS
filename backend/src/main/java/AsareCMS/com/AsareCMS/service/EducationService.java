package AsareCMS.com.AsareCMS.service;

import AsareCMS.com.AsareCMS.exception.ResourceNotFoundException;
import AsareCMS.com.AsareCMS.model.Education;
import AsareCMS.com.AsareCMS.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EducationService {

	@Autowired
	private EducationRepository educationRepository;

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

}
