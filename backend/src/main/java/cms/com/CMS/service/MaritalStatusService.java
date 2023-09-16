package AsareCMS.com.AsareCMS.service;

import AsareCMS.com.AsareCMS.model.MaritalStatus;
import AsareCMS.com.AsareCMS.repository.MaritalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaritalStatusService {
	@Autowired
	private MaritalStatusRepository maritalStatusRepository;

	public List<MaritalStatus> getStatus(){
		return maritalStatusRepository.findAll();
	}
}
