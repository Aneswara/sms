package com.sms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.Address;
import com.sms.service.AddressService;

@RestController
@RequestMapping("api/address/v1")
public class AddressController {

	Logger logger = LoggerFactory.getLogger(AddressController.class);
	@Autowired
	private AddressService addressService;

	@PostMapping("/createAddress")
	public ResponseEntity<Address> createAddress(@RequestBody Address address) {
		try {
			address = addressService.createAddress(address);
			return new ResponseEntity<Address>(address, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("error created in address creation");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/updateAddress")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
		try {
			address = addressService.updateAddress(address);
			return new ResponseEntity<Address>(address, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in address updation");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findAllAddress")
	public ResponseEntity<List<Address>> findAllAddress() {
		try {
			List<Address> address = addressService.findAllAddress();
			return new ResponseEntity<List<Address>>(address, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in find all addresses");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteAddress")
	public ResponseEntity<Address> deleteByAddressId(@RequestParam Long addressId) {
		try {
			Address address = addressService.deleteByAddressId(addressId);
			return new ResponseEntity<Address>(address, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in address deletion");
			return new ResponseEntity<>(null, HttpStatus.TOO_MANY_REQUESTS);
		}
	}
}
