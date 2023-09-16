package cms.com.CMS.service;

import cms.com.CMS.model.Gender;
import cms.com.CMS.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {
	@Autowired
	private GenderRepository genderRepository;

	public List<Gender> listGender(){
		return genderRepository.findAll();
	}
}
