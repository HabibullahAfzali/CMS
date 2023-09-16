package cms.com.CMS.service;

import cms.com.CMS.exception.ResourceNotFoundException;
import cms.com.CMS.model.Address;
import cms.com.CMS.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public ResponseEntity<String> saveAddress(Address address){
		 addressRepository.save(address);
		 return ResponseEntity.ok("Address Save");
	}

	public List<Address> listAddress(){
		return addressRepository.findAll();
	}

	public ResponseEntity<String> findAddressById(Long id){

		addressRepository.findById(id);
		return ResponseEntity.ok("Address Found!");
	}
	public ResponseEntity<String> deleteAddress( Long id){
		Optional<Address> addressOptional = addressRepository.findById(id);
		if (addressOptional.isEmpty()) {
			throw new ResourceNotFoundException("Address Not Found With ID:"+id);
		}
		addressRepository.deleteById(id);
		return ResponseEntity.ok("Address deleted!");
	}

}
