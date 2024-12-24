package day12.boardprogram7;

import java.util.Scanner;

public class MemberService {
	// 1. 멤버변수 // 2. 생성자
	// 3. 메소드
	public void signup(Scanner scan , MemberDto[] members ) {
		System.out.println("아이디: "); String id = scan.next();
		System.out.println("비밀번호: "); String pw = scan.next();
		System.out.println("닉네임: "); String name = scan.next();
		// * 객체화 . 생성자 이용한 빠른 객체 생성
		MemberDto memberDto = new MemberDto(id, pw, name);
		for(int index = 0; index<members.length; index++) {
			if(members[index] == null) {
				members[index] = memberDto;
				System.out.println("**회원가입 성공**");
				return;
			}
		}
	}
	
	public String login(Scanner scan , MemberDto[] members) {
		System.out.println("아이디: "); String id = scan.next();
		System.out.println("비밀번호: "); String pw = scan.next();
		// * 기존회원목록에서 방급 입력받은 값과 비교하여 동일값 찾기
		
		for(int index = 0; index < members.length; index++) {
			MemberDto memberDto = members[index];
			if(members[index] != null) {
				if(memberDto.getId().equals(id) && memberDto.getPw().equals(pw)) {
					System.out.println("로그인 성공");
					return memberDto.getId(); // 로그인 성공한 아이디 반환
				}
			}
		}
		System.out.println("로그인실패");
		return null; // 로그인 실패시 null 반환
	}
	
}
