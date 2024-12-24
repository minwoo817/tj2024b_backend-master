package day12.boardprogram7;

import java.util.Scanner;

public class BoardService {
	
	// 게시물 등록함수
	public void boardAdd(Scanner scan , BoardDto[] boards, String loginId) {
		System.out.println("제목: "); String title = scan.next();
		System.out.println("내용: "); String content = scan.next();
		System.out.println("작성자는 현재 로그인된 아이디로 대체합니다. "); 
		String writer = loginId; // 로그인아이디를 작성자에 대입한다.
		// * 생성자를 이용한 빠른 객체 생성
		BoardDto boardDto = new BoardDto(title, content, writer);
		for(int index = 0; index < boards.length; index++) {
			if(boards[index] == null) {
				boards[index] = boardDto;
				System.out.println("게시물 등록 성공");
				return;
			}
		}
	}
	
	// 게시물 출력함수
	public void boardPrint(BoardDto[] boards) {
		System.out.println("순번\t작성자\t제목\t내용");
		for(int index = 0; index<boards.length; index++) {
			if(boards[index] != null) {
				System.out.printf("%d \t %s \t %s \t %s \n",
						index+1, boards[index].gerWriter(),
						boards[index].gerContent(),
						boards[index].gerTitle());
			}
		}
	}
	
}
