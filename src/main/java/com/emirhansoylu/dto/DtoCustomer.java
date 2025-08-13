package com.emirhansoylu.dto;

import com.emirhansoylu.entities.DtoAddress;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoCustomer {
	
	
	private Long id;
	
	
	
	private String name;
	
	
	private DtoAddress address;

}
