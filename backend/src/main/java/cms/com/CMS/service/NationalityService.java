package AsareCMS.com.AsareCMS.service;

import AsareCMS.com.AsareCMS.model.Nationality;
import AsareCMS.com.AsareCMS.repository.NationalityRepository;
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
