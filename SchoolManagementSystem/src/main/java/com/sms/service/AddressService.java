package com.sms.service;

import java.util.List;

import com.sms.model.Address;

public interface AddressService {

	public Address createAddress(Address address);
	
	public Address updateAddress(Address address);
	
	public List<Address> findAllAddress();
	
	public Address  deleteByAddressId(Long addressId);
}
