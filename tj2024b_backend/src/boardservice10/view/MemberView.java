package boardservice10.view;


import java.util.Scanner;

import boardservice10.controller.MemberController;
import boardservice10.model.dto.MemberDto;

public class MemberView {
	// + 싱글톤
	private static MemberView instance = new MemberView();
	private MemberView() {}
	public static MemberView getInstance() {return instance;}

	private Scanner scan = new Scanner(System.in);
	public void run() {
		while(true) {
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			int choose = scan.nextInt();
			if(choose == 1) {signup();}
			if(choose == 2) {}
			if(choose == 3) {}
			if(choose == 4) {}
			
		}
	}
	public void signup() {
		System.out.println("아이디");	String mid = scan.next(); 
		System.out.println("비밀번호"); String mpwd = scan.next();
		System.out.println("이름"); String mname = scan.next();
		System.out.println("연락처"); String mphone = scan.next();
		MemberDto memberDto = new MemberDto(mid, mpwd, mname, mphone);
		boolean result = MemberController.getInstance().signup(memberDto);
		if(result) {System.out.println("회원가입성공");}
		else {System.out.println("회원가입실패");}
	}
}
