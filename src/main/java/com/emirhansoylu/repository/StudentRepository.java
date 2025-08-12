package com.emirhansoylu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emirhansoylu.entities.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{  
	
	//BURALARA KENDİ ÖZEL METOTLARIMIZI YAZABİLİRİZZZZZZZZZZZZZZZZZZZ
	
	//HQL Hibernate Query Language demektir. //HQL : Sınıfın ismi ve değişken isimleir kullanılaak sorgular yazılır nativesi false
	// SQL Structure Query Language demektir . // SQL :  TABLO İSMİVE TABLO İÇERİSİNDEKİ KOLON İSİMLERİYLER SORGULAR YAZILIR nativeQuerysi true
	@Query(value = "from Student", nativeQuery =  false)//CUSTOM SQL SORGUSU YAZDIK.  STUDENT CLASSINI VERDİK 
	 List<Student> findAllStudents();
	
	// SQL YAZACAK OLSAK Select * from student.student (tablo ismi) + (şema ismi) üsttekinde sınıf ismiydi
	
	
	
	//jparepository içinde save gibi komutlar var
//jparepository hibernate ile gelen interfacedir içinde komutlar var. sayesinde metotları biz yazmıyoruz.
	
	//direkt crudrepository de extends  edilebilirdi
	// student sınıfında integer türünde idlerim var diye belirttik <> arasına
}
