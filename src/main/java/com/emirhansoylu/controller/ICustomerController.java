package com.emirhansoylu.controller;

import com.emirhansoylu.dto.DtoCustomer;

public interface ICustomerController {
	public DtoCustomer findCustomerById(Long id);

}
