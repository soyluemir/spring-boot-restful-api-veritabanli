package com.emirhansoylu.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emirhansoylu.dto.DtoStudent;
import com.emirhansoylu.dto.DtoStudentIU;
import com.emirhansoylu.entities.Student;
import com.emirhansoylu.repository.StudentRepository;
import com.emirhansoylu.services.IStudenService;

@Service
public class StudentServiceImpl implements IStudenService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		DtoStudent response = new DtoStudent(); // parametre olarak gelen dtostudenIU al studentimin üzerine kopyala
		Student student = new Student(); // kopyalanmış olan veritabanına kaydet veriyi geriye dbStudent olarak dön

		BeanUtils.copyProperties(dtoStudentIU, student);
		Student dbStudent = studentRepository.save(student);
		BeanUtils.copyProperties(dbStudent, response); // ile kaydetmiş olduğun veriyi al responseyi doldur
		return response; // responseyi dönebilirsin.

	}

	@Override
	public List<DtoStudent> getAllStudents() {
		List<DtoStudent> dtoList = new ArrayList<>();

		List<Student> studentList = studentRepository.findAllStudents(); // jparepositoryden geliyor bu metot hehe :D

		for (Student student : studentList) { // veritabanından listeyi çektim üzerinde döndüm
			DtoStudent dto = new DtoStudent(); // her dönmüş olduğum studenti dto'ya setledim.
			BeanUtils.copyProperties(student, dto); // dtoyu kaybetmemek amacıyla tanımladığım listeye ekledim ve
													// listeyi döndüm
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		DtoStudent dto = new DtoStudent(); // ilk olarak dto adlı nesne türettim
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) { // veri var mı diye kontrol ediyoruz eğer veri varsa
			Student dbStudent = optional.get(); // veritabanından bulduğum dbstudenti dtoya kopyalıyorum. dtoyu geri dön
			BeanUtils.copyProperties(dbStudent, dto);

		}
		return dto;
	}

	@Override
	public void deleteStudent(Integer id) {

		Optional<Student> optional = studentRepository.findById(id);

		if (optional.isPresent()) { // delete için Student nesnesine ihtiyacım var o yüzden findById KULLANDIK
			studentRepository.delete(optional.get()); // veritabanından çektim veri varsa al o STUDENTİ SİL

		}

	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {  //geriye DtoStudent türünde dönmemi beklior

		Optional<Student> optional = studentRepository.findById(id); // idsi şu olan studenti çek

		if (optional.isPresent()) {

			DtoStudent dto = new DtoStudent(); // dto nesnesi üret
			Student dbStudent = optional.get(); // veritabanından çektiğmiiz veriyi al

			dbStudent.setFirstName(dtoStudentIU.getFirstName()); // parametre olan gelen değerleri atıyoruz
			dbStudent.setLastName(dtoStudentIU.getLastName());
			dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());

			Student updatedStudent = studentRepository.save(dbStudent); // üzerine override edip üzerine yazıyoruz
			BeanUtils.copyProperties(updatedStudent, dto);  //updatedstudenti dtoya kopyala ve dtoyu dön
			return dto;

		}
		return null;

	}

}
