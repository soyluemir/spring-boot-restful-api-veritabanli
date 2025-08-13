package com.emirhansoylu.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emirhansoylu.dto.DtoCustomer;
import com.emirhansoylu.entities.Address;
import com.emirhansoylu.entities.Customer;
import com.emirhansoylu.entities.DtoAddress;
import com.emirhansoylu.repository.CustomerRepository;
import com.emirhansoylu.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public DtoCustomer findCustomerById(Long id) {

		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();

		Optional<Customer> optional = customerRepository.findById(id); //bana böyle bir id geldi böyle bir müşteri var mı

		if (optional.isEmpty()) {
			return null;

		} // biz 1 numaralı enesi çektiğimizde enesin bağlı olduğu 77 numaralı addressi de
			// çekmiş ve dönmüş olcak
		Customer customer = optional.get(); // eğer varsa var olan değeri seç //çekmiş olduğun değerde adress var onu da aşağıdaki satırla çek
		Address address = optional.get().getAddress(); // iki değeri aldım bunları dto çevireceğim
		
		BeanUtils.copyProperties(customer, dtoCustomer);  //customeri dto customere doldur
		BeanUtils.copyProperties(address, dtoAddress);   // addressi dto addresse doldur
		
		dtoCustomer.setAddress(dtoAddress);   // doldurmuş olduğum dto addresi de  dtocustomerin içindeki addrese setle  doldur
		
		                                  //ve dto customerde artık hep customer hem address var bunu dön en son returnla
		return dtoCustomer;
	}

}
