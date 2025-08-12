package com.emirhansoylu.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU { //Insert update işlemlerinde kullanmak için
	
	private String firstName; //değişken ismini aynı veriyoruz
	
	
	private String lastName;
	
	
	private Date birthOfDate;
	
	

}
