package AsareCMS.com.AsareCMS.controller;

import AsareCMS.com.AsareCMS.model.Education;
import AsareCMS.com.AsareCMS.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/education")
public class EducationController {

	@Autowired
	private EducationService educationService;

	@PostMapping("/save")
	public ResponseEntity<String> saveEducation(@RequestBody Education education) {
		return educationService.saveEducation(education);
	}

	@GetMapping("/list")
	public List<Education> listEducation() {
		return educationService.listEducation();
	}

	@GetMapping("/{id}")
	public ResponseEntity<String> findEducationById(@PathVariable Long id) {
		return educationService.findEducationById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEducation(@PathVariable Long id) {
		return educationService.deleteEducation(id);
	}
}
