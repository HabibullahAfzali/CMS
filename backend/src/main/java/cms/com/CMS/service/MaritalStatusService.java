package cms.com.CMS.service;

import cms.com.CMS.model.MaritalStatus;
import cms.com.CMS.repository.MaritalStatusRepository;
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
