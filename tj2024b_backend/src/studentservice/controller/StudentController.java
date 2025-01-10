package studentservice.controller;

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
}
