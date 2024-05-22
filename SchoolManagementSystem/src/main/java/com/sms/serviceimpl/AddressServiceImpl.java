package com.sms.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dao.AddressRepository;
import com.sms.model.Address;
import com.sms.service.AddressService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	Logger logger=LoggerFactory.getLogger(AddressServiceImpl.class);
	@Autowired
	AddressRepository addressRepository;
	
	public Address createAddress(Address address) {
		try {
			address=addressRepository.save(address);
			return address;
		} catch (Exception e) {
			logger.error("address is not created");
			return null;
		}
	}

	public Address updateAddress(Address address) {
		try {
			address=addressRepository.save(address);
			return address;
		} catch (Exception e) {
			logger.error("address is not updated");
			return null;
		}
	}

	
	public List<Address> findAllAddress() {
		try {
			List<Address> address=addressRepository.findAll();
			return address;
		} catch (Exception e) {
			logger.error("addresses not found");
			return null;
		}
	}

	
	public Address deleteByAddressId(Long addressId) {
		try {
			Address address=addressRepository.deleteByAddressId(addressId);
			return address;
		} catch (Exception e) {
			logger.error("address is not deleted");
			return null;
		}
	}

}
