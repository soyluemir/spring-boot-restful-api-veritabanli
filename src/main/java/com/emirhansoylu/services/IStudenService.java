package com.emirhansoylu.services;

import java.util.List;

import com.emirhansoylu.entities.Student;

public interface IStudenService {
	
	public Student saveStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public Student getStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	public Student  updateStudent(Integer id, Student updateStudent);

}
