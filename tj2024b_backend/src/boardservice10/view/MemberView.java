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
			else if(choose == 2) {login();}
			else if(choose == 3) {findId();}
			else if(choose == 4) {findPwd();}
			
			
			
		}
	}
	// 1. 회원가입 화면 메소드
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
	
	// 2. 로그인 화면 메소드
	public void login() {
		// 순서 : 입력 -> 객체화(선택) -> 컨트롤러에게 전달하고 응답 결과 받기 -> 컨트롤러의 결과에 따른 처리
		System.out.println("아이디 : "); String mid = scan.next();
		System.out.println("비밀번호 : "); String mpwd = scan.next();
		MemberDto memberDto = new MemberDto();
		memberDto.setMid(mid); memberDto.setMpwd(mpwd);
		boolean result = MemberController.getInstance().login(memberDto);
		if(result) {
			System.out.println("로그인 성공");
			// BoardView 메인 메뉴 메소드 호출
			BoardView.getInstance().index();
		}
		else {System.out.println("로그인 실패");}
		
	}
	// 2-2. 로그아웃 화면 메소드
	public void logout() {
		MemberController.getInstance().logout();
		System.out.println("로그아웃 성공");
	}
	
	// 3. 아이디찾기 화면 메소드
	public void findId() {
		// [1] 입력
		System.out.println("이름: "); String mname = scan.next();
		System.out.println("전화번호: "); String mphone = scan.next();
		// [2] 객체화 // 데이터포장(view에서 controller 이동)
		// MemberDto memberDto = new MemberDto(mname, mphone);
			// 오류 : new 키워드 뒤로 생성자가 오는데 클래스에 선언된 (매개변수가 일치한)생성자만 가능
			// 1. 클래스에서 매개변수 2개의 생성자를 만든다.
			// 2. 디폴트 생성자로 인스턴스 생성 후 setter 로 값을 넣는다
		MemberDto memberDto = new MemberDto();
		memberDto.setMname(mname);
		memberDto.setMphone(mphone);
		// [3] 컨트롤러에게 전달(request/요청/매개변수)하고 응답(response/응답/리턴)결과 받기
		String result = MemberController.getInstance().findId(memberDto);
		// [4] 컨트롤러의 결과에 따른 처리
		if(result != null) {
			System.out.println("찾은 아이디 :"+ result);
		}
		else {System.out.println("동일한 정보 없습니다.");}
		
	}
	
	// 4. 비밀번호찾기 화면 메소드
	public void findPwd() {
		// [1] 입력
		System.out.println("아이디: "); String mid = scan.next();
		System.out.println("전화번호: "); String mphone = scan.next();
		// [2] 객체화 // 데이터포장(view에서 controller 이동)
		MemberDto memberDto = new MemberDto();
		memberDto.setMid(mid);
		memberDto.setMphone(mphone);
		// [3] 컨트롤러에게 전달하고 응답 결과 받기
		String result = MemberController.getInstance().findPwd(memberDto);
		// [4] 컨트롤러의 결과에 따른 처리
		if(result != null) {
			System.out.println("찾은 비밀번호" + result);
		}
		else {System.out.println("동일한 정보 없습니다.");}
		
	}
	
	// 6. 내정보 보기 화면 메소드
	public int myInfo() {
		// 받는곳 = MemberController.getInstance().myInfo(주는곳);
		MemberDto result = MemberController.getInstance().myInfo();
		System.out.println("======== 마이 페이지 ========");
		System.out.println("아이디: "+result.getMid());
		System.out.println("이름: "+result.getMname());
		System.out.println("연락처: "+result.getMphone());
		System.out.println("가입일: "+result.getMdate());
		// 서브메뉴
		while(true) {
		System.out.println("1.회원수정 2.회원탈퇴 3.뒤로가기:");
		int choose2 = scan.nextInt();
		if(choose2 == 1) {update();}
		else if(choose2 ==2) {
			int state = delete();
			if(state == 0) {return 0;}
		}
		else if(choose2 == 3) {break;} // 메뉴에서 무한반복 탈출
		}
		return 1;
	}
		
	
	// 7. 회원탈퇴 화면 메소드
	public int delete() {
		System.out.println("정말 회원 탈퇴 하시겠습니까? 0:예 1:취소");
		int choose3 = scan.nextInt();
		if(choose3 == 0) {
			MemberController.getInstance().delete(); // - 탈퇴처리 컨트롤러 요청
			logout(); // 탈퇴처리시 로그아웃하기
			return 0;
		}
		return 1;
	}
	
	// 8. 화면수정 화면 메소드
	public void update() {
		System.out.println("새로운 비밀번호: "); String mpwd = scan.next();
		System.out.println("새로운 이름: "); String mname = scan.next();
		System.out.println("새로운 전화번호: "); String mphone = scan.next();
		MemberDto memberDto = new MemberDto();
		memberDto.setMpwd(mpwd); memberDto.setMname(mname); memberDto.setMphone(mphone);
		boolean result = MemberController.getInstance().update(memberDto);
		if(result) {System.out.println("수정완료");}
		else {System.out.println("수정실패");}
	}
}
