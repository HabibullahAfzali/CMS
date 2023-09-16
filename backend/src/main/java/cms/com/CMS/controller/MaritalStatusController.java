package cms.com.CMS.controller;

import cms.com.CMS.model.MaritalStatus;
import cms.com.CMS.service.MaritalStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/status")
public class MaritalStatusController {
	@Autowired
	private MaritalStatusService maritalStatusService;
@GetMapping
	public List<MaritalStatus> findAll(){
	return 	maritalStatusService.getStatus();
	}
}
