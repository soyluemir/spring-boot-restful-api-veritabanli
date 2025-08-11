package com.emirhansoylu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emirhansoylu.entities.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{  
	
	//BURALARA KENDİ ÖZEL METOTLARIMIZI YAZABİLİRİZZZZZZZZZZZZZZZZZZZ
	
	//jparepository içinde save gibi komutlar var
//jparepository hibernate ile gelen interfacedir içinde komutlar var. sayesinde metotları biz yazmıyoruz.
	
	//direkt crudrepository de extends  edilebilirdi
	// student sınıfında integer türünde idlerim var diye belirttik <> arasına
}
