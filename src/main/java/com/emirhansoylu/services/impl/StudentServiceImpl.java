package com.emirhansoylu.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emirhansoylu.entities.Student;
import com.emirhansoylu.repository.StudentRepository;
import com.emirhansoylu.services.IStudenService;

@Service
public class StudentServiceImpl implements IStudenService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);

	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> studentList = studentRepository.findAll(); // jparepositoryden geliyor bu metot hehe :D
		// TODO Auto-generated method stub
		return studentList;
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) { // veri var mı diye kontrol ediyoruz eğer veri varsa
			return optional.get();

		}
		return null;
	}

	@Override
	public void deleteStudent(Integer id) {

		Student dbStudent = getStudentById(id);

		if (dbStudent != null) {
			studentRepository.delete(dbStudent);

		}

	}

	@Override
	public Student updateStudent(Integer id, Student updateStudent) {
	Student dbStudent =	getStudentById(id);
	
		if (dbStudent != null) {
			dbStudent.setFirstName(updateStudent.getFirstName());
			dbStudent.setLastName(updateStudent.getLastName());
			dbStudent.setBirthOfDate(updateStudent.getBirthOfDate());
			
			studentRepository.save(dbStudent); //AYNI OBJENİN ÜZERİNE YAZIYORUZ 
			
			
		}
		return null;
	}

}
