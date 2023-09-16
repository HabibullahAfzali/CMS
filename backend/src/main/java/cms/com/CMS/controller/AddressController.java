package AsareCMS.com.AsareCMS.controller;

import AsareCMS.com.AsareCMS.model.Address;
import AsareCMS.com.AsareCMS.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("/save")
	public ResponseEntity<String> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@GetMapping("/list")
	public List<Address> listAddress() {
		return addressService.listAddress();
	}

	@GetMapping("/{id}")
	public ResponseEntity<String> findAddressById(@PathVariable Long id) {
		return addressService.findAddressById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
		return addressService.deleteAddress(id);
	}
}
