package AsareCMS.com.AsareCMS.controller;

import AsareCMS.com.AsareCMS.model.Nationality;
import AsareCMS.com.AsareCMS.service.NationalityService;
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
