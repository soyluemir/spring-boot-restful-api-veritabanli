package com.emirhansoylu.services;

import com.emirhansoylu.dto.DtoCustomer;

public interface ICustomerService {
	
	
	//idsi şu olan customeri dön
	public DtoCustomer findCustomerById(Long id);

}
