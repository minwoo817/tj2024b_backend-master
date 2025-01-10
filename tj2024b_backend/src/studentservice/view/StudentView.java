package studentservice.view;

import java.util.Scanner;

import studentservice.controller.StudentController;
import studentservice.model.dto.StudentDto;

public class StudentView {
	private static StudentView instance = new StudentView();
	private StudentView() {}
	public static StudentView getInstance() {return instance;}
	
	private Scanner scan = new Scanner(System.in);
	public void run() {
		while(true) {
			System.out.println("1.점수등록 2.전체학생점수조회 3.점수삭제 4.점수수정");
			int choose = scan.nextInt();
			if(choose==1) {}
			else if(choose == 2) {}
			else if(choose ==3) {}
			else if(choose ==4) {}
		}
	}
	
	public void regist() {
		System.out.println("이름"); String sname = scan.next();
		System.out.println("국어 점수"); int kscore = scan.nextInt();
		System.out.println("영어 점수"); int escore = scan.nextInt();
		System.out.println("수학 점수"); int mscore = scan.nextInt();
		StudentDto studentDto = new StudentDto(sname, kscore, escore, mscore);
		boolean result = StudentController.getInstance().regist(studentDto);
		if(result) {System.out.println("점수등록 완료");}
		else {System.out.println("점수등록실패");}
	}
}
