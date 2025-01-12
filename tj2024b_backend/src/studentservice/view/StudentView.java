package studentservice.view;

import java.util.ArrayList;
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
			if(choose==1) {regist();}
			else if(choose == 2) {print();}
			else if(choose ==3) {delete();}
			else if(choose ==4) {update();}
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
	public void print() {
		ArrayList<StudentDto> result = StudentController.getInstance().print();
		System.out.println("번호\t이름\t국어점수\t영어점수\t수학점수");
		for(int i = 0; i < result.size(); i++) {
			StudentDto studentDto = result.get(i);
			System.out.print(studentDto.getSno()+"\t");
			System.out.print(studentDto.getSname()+"\t");
			System.out.print(studentDto.getKscore()+"\t");
			System.out.print(studentDto.getEscore()+"\t");
			System.out.print(studentDto.getMscore()+"\n");
		}
	}
	public void delete() {
		System.out.println("삭제할 번호"); int choose1 = scan.nextInt();
		boolean result = StudentController.getInstance().delete(choose1);
		if(result) {System.out.println("삭제 성공");}
		else {System.out.println("삭제 실패");}
	}
	public void update() {
		System.out.println("수정할 번호"); int choose2 = scan.nextInt();
		System.out.print("수정할 국어 점수");		int kscore = scan.nextInt();
		System.out.print("수정할 영어 점수");		int escore = scan.nextInt();
		System.out.print("수정할 수학 점수");		int mscore = scan.nextInt();
		StudentDto studentDto = new StudentDto();
		studentDto.setKscore(kscore);
		studentDto.setEscore(escore);
		studentDto.setMscore(mscore);
		boolean result = StudentController.getInstance().update(choose2, studentDto);
		if(result) {System.out.println("수정완료");}
		else {System.out.println("수정실패");}
	}
}
