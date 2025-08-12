package com.emirhansoylu.services;

import java.util.List;

import com.emirhansoylu.dto.DtoStudent;
import com.emirhansoylu.dto.DtoStudentIU;
import com.emirhansoylu.entities.Student;

public interface IStudenService {
	
	public DtoStudent saveStudent(DtoStudentIU student);
	
	public List<DtoStudent> getAllStudents();
	
	public DtoStudent getStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	public DtoStudent  updateStudent(Integer id, DtoStudentIU dtoStudentIU);

}
