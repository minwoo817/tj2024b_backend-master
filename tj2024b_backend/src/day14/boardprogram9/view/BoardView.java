package day14.boardprogram9.view;

import java.util.ArrayList;
import java.util.Scanner;

import day14.boardprogram9.controller.BoardController;
import day14.boardprogram9.model.dto.BoardDto;

public class BoardView {
	// + 싱글톤
	private BoardView() {}
	private static BoardView instance = new BoardView();
	public static BoardView getInstance() {
		return instance;
	}
	// + 입력객체(현재 클래스 내부의 모든 함수들에서 사용하기 위해 멤버변수에 선언)
	private Scanner scan = new Scanner(System.in);
	// 1. 메인페이지 표현  함수
	public void run() {
		while(true) {
			System.out.println("게시물 1.Create 2.Read 3.Update 4.Delete ");
			int choose = scan.nextInt();
			if(choose == 1) {create();}
			else if(choose == 2) {readAll();}
			else if(choose == 3) {update();}
			else if(choose == 4) {delete();}
		}
	}
	// 2. 게시물 쓰기 페이지 함수
	public void create() {
		System.out.println("[Create]");
		
		// [1] 저장할 게시물 정보를 입력받는다
		System.out.println("제목 : "); String title = scan.next();
		System.out.println("내용 : "); String content = scan.next();
		System.out.println("작성자 : "); String writer = scan.next();
		// [2] 게시물 정보를 하나의 객체로 만든다 생성자를 이용하여 빠른 초기화
		BoardDto boardDto = new BoardDto(title, content, writer);
		// [3] 객체를 컨트롤러에게 전달하고 쓰기 결과는 받는다.
		boolean result = BoardController.getInstance().create(boardDto);
		// [4] 받은 결과에 따른 메시지 출력한다.
		if(result == true) {System.out.println("등록 성공");}
		else {System.out.println("등록 실패");}
	}
	// 3. 게시물 출력 페이지 함수
	public void readAll() {
		System.out.println("[Read]");
		// [1] 컨트롤러에게 모든 게시물 정보를 요청한다.
		ArrayList<BoardDto> result = BoardController.getInstance().readAll();
		// [2] 요청받은 모든 게시물 정보를 출력한다.
		System.out.println("순번\t작성자\t제목\t내용\t");
		for(int index = 0; index < result.size(); index++) {
			BoardDto board = result.get(index);
			System.out.printf("%d\t%s\t%s\t%s \n", index, 
							board.getWriter(), board.getTitle(), board.getContent() );
		}
	}
	// 4. 게시물 수정 페이지 함수
	public void update() {
		System.out.println("[Update]");
		// [1] 수정할 정보들을 입력받는다.
		System.out.println("수정할 게시물 번호 "); int uIndex = scan.nextInt();
		System.out.println("수정할 게시물 제목"); String title = scan.next();
		System.out.println("수정할 게시물 내용"); String content = scan.next();
		System.out.println("수정할 게시물 작성자"); String writer = scan.next();
		// [2] 입력받은 값들을 객체로 만든다
		BoardDto boardDto = new BoardDto(title, content, writer);
		// [3] 컨트롤러에게 수정할 인덱스와 수정할 객체를 전달하고 결과를 받는다.
		boolean result = BoardController.getInstance().update(uIndex, boardDto);
		// [4] 결과에 따른 메시지 출력
		if(result == true) {System.out.println("수정 성공");}
		else {System.out.println("수정 실패");}
		
	}
	// 5. 게시물 삭제 페이지 함수
	public void delete() {
		System.out.println("[Delete]");
		// [1] 삭제할 인덱스(식별)번호를 입력받는다.
		System.out.println("삭제할 게시물 번호 "); int dIndex = scan.nextInt();
		// [2] 삭제할 번호를 컨트롤러에게 전달하고 처리결과 받는다.
		boolean result = BoardController.getInstance().delete(dIndex);
		// [3] 처리결과에 따른 메시지 출력
		if(result == true) {System.out.println("삭제 성공");}
		else {System.out.println("삭제 실패");}
	}
	
}
