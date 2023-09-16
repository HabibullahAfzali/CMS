package AsareCMS.com.AsareCMS.controller;

import AsareCMS.com.AsareCMS.model.MaritalStatus;
import AsareCMS.com.AsareCMS.service.MaritalStatusService;
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
