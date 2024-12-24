package day07;

import java.security.Identity;
import java.util.Scanner;

/*
	주제 : 회원 서비스 구현하기
		- 문법 : 변수, 입출력함수, 연산자, 제어문(조건문/반복문), 클래스(멤버변수)/객체
		- 회원은 최대 3명까지 저장할 수 있다.
		- 회원정보는 아이디, 비밀번호, 닉네임을 갖습니다.
		- 회원 클래스를 정의하고 회원객체 활용하여 구현한다.
		- 프로그램 초기 메뉴 : 1. 회원가입 2. 로그인 :
			1 선택시 : 아이디, 비밀번호, 닉네임 3개의 각 정보를 입력받아 저장하기
			2 선택시 : 아이디, 비밀번호를 입력받아 기존의 저장된 정보와 일치한 정보가 있으면 '로그인성공' 아니면 '로그인실패' 출력한다.
		
		1. 코드 구현
		2. 구현된 코드에서 문법 찾기

*/
public class Example3 {

	public static void main(String[] args) {
		Member member1 = null; Member member2 = null; Member member3 = null;
		while(true) {
			System.out.println("1.회원가입 2. 로그인: ");
			Scanner scan = new Scanner(System.in);
			int choose = scan.nextInt();
			if(choose == 1) {
				System.out.println("아이디 : ");
				String id = scan.next();
				System.out.println("비밀번호 : ");
				String pw = scan.next();
				System.out.println("닉네임 : ");
				String name = scan.next();
				Member member = new Member();
				member.id = id; member.pw = pw; member.name = name;
				if(member1 == null) {
					member1 = member;
				}
				else if(member2 == null) {
					member2 = member;
				}
				else if(member3 == null) {
					member3 = member;
				}
				else {
					System.out.println("회원은 최대 3명까지 저장할 수 있습니다.");
				}
			}
			else if(choose == 2) {
				System.out.println("아이디 : ");
				String id1 = scan.next();
				System.out.println("비밀번호 : ");
				String pw1 = scan.next();
				if(member1 != null && member1.id.equals(id1) && member1.pw.equals(pw1)) {
					System.out.println("로그인 성공");
				}
				else if(member2 != null && member2.id.equals(id1) && member2.pw.equals(pw1)) {
					System.out.println("로그인 성공");
				}
				else if(member3 != null && member3.id.equals(id1) && member3.pw.equals(pw1)) {
					System.out.println("로그인 성공");
				}
				else {
					System.out.println("로그인 실패");
				}
			}
		}

	}

}
