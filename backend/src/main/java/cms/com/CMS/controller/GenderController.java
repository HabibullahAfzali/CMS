package cms.com.CMS.controller;
import cms.com.CMS.model.Gender;
import cms.com.CMS.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/genders")
public class GenderController {
	@Autowired
	private GenderService genderService;
	@GetMapping
	public List<Gender> findAll() {
		return genderService.listGender();
	}
}
