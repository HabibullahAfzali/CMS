package AsareCMS.com.AsareCMS.service;

import AsareCMS.com.AsareCMS.model.Gender;
import AsareCMS.com.AsareCMS.repository.GenderRepository;
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
