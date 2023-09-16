package AsareCMS.com.AsareCMS.service;

import AsareCMS.com.AsareCMS.exception.ResourceNotFoundException;
import AsareCMS.com.AsareCMS.model.WorkHistory;
import AsareCMS.com.AsareCMS.repository.WorkHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class WorkHistoryService {

	@Autowired
	private WorkHistoryRepository workHistoryRepository;

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
}
