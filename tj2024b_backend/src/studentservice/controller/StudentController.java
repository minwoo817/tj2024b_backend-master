package studentservice.controller;

import java.util.ArrayList;

import studentservice.model.dao.StudentDao;
import studentservice.model.dto.StudentDto;

public class StudentController {
	private static StudentController instance = new StudentController();
	private StudentController() {}
	public static StudentController getInstance() {return instance;}
	
	public boolean regist(StudentDto studentDto) {
		boolean result = StudentDao.getInstance().regist(studentDto);
		return result;
	}
	public ArrayList<StudentDto> print(){
		ArrayList<StudentDto> result = StudentDao.getInstance().print();
		return result;
	}
	public boolean delete(int choose1) {
		boolean result = StudentDao.getInstance().delete(choose1);
		return result;
	}
	public boolean update(int choose2, StudentDto studentDto) {
		boolean result = StudentDao.getInstance().update(choose2, studentDto);
		return result;
	}
}
