package cms.com.CMS.controller;

import cms.com.CMS.model.Nationality;
import cms.com.CMS.service.NationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/nationalities")
public class NationalityController {
	@Autowired
	private NationalityService nationalityService;
@GetMapping
	public List<Nationality> findAll(){
		return nationalityService.getNationality();
	}


}
