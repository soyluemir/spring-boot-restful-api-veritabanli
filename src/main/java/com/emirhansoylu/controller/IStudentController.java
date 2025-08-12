package com.emirhansoylu.controller;

import java.util.List;

import com.emirhansoylu.dto.DtoStudent;
import com.emirhansoylu.dto.DtoStudentIU;
import com.emirhansoylu.entities.Student;

public interface IStudentController {

	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

	public List<DtoStudent> getAllStudents();

	public DtoStudent getStudentById(Integer id);

	public void deleteStudent(Integer id);

	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
