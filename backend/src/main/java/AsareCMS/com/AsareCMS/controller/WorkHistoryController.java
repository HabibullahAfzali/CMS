package AsareCMS.com.AsareCMS.controller;

import AsareCMS.com.AsareCMS.model.WorkHistory;
import AsareCMS.com.AsareCMS.service.WorkHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/workHistory")
public class WorkHistoryController {

	@Autowired
	private WorkHistoryService workHistoryService;

	@PostMapping("/save")
	public ResponseEntity<String> saveWorkHistory(@RequestBody WorkHistory workHistory) {
		return workHistoryService.saveWorkHistory(workHistory);
	}

	@GetMapping("/list")
	public List<WorkHistory> listWorkHistory() {
		return workHistoryService.listWorkHistory();
	}

	@GetMapping("/{id}")
	public ResponseEntity<String> findWorkHistoryById(@PathVariable Long id) {
		return workHistoryService.findWorkHistoryById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteWorkHistory(@PathVariable Long id) {
		return workHistoryService.deleteWorkHistory(id);
	}
}
