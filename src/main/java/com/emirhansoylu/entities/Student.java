package com.emirhansoylu.entities;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter // getter setter yerine otomatik @Data da yazabiliriz.
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id //primary key yaptık
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // idleri 1er 1er otomatik arttırır
	private Integer id;
	
	@Column(name = "first_name", nullable =  false) //boş geçilemez
	private String firstName;
	
	@Column(name = "last_name", nullable =  false)
	private String lastName;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "birth_of_date", nullable =  true) // boş geçilebilir
	private Date birthOfDate;

}
