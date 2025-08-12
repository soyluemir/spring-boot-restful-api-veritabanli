package com.emirhansoylu.dto;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.PackagePrivate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU { //Insert update işlemlerinde kullanmak için
	
	
	@NotEmpty(message = "firstname alanı boş bırakılamaz")
	private String firstName; //değişken ismini aynı veriyoruz //null ve empty olamaz
	
	@Size(min = 3 , max = 30)
	private String lastName;
	
	
	private Date birthOfDate;
	
	@Email(message = "email formatında veri giriniz")
	private String email;
	
	@Size(min = 11, max = 11 , message = "tckn alanı 11 karakter olmalıdır")
	@NotEmpty(message = "tckn alanını boş geçemezsiniz")
	private String tckn;
	
	

}
