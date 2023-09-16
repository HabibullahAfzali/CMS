package cms.com.CMS.service;

import cms.com.CMS.model.Nationality;
import cms.com.CMS.repository.NationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationalityService {
	@Autowired
	private NationalityRepository nationalityRepository;


	public List<Nationality> getNationality(){
		return nationalityRepository.findAll();
	}
}
