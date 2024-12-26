package day13.boardprogram8.controller;

import day13.boardprogram8.model.dao.BoardDao;
import day13.boardprogram8.model.dto.BoardDto;

public class BoardController {
	
	// + 싱글톤
	private BoardController() {}
	private static BoardController instance = new BoardController();
	public static BoardController getInstance() {
		return instance;
	}
	// - 싱글톤
	
	// 1. 글쓰기 제어 메소드		, 함수명 : 임의 , 매개변수 : BoardDto , 리턴값 : true/false
	public boolean write(BoardDto saveDto) {
		boolean result = BoardDao.getInstance().write(saveDto); // [1] DAO 에게 저장할 객체를 전달하고 응답받기
		return result; // [2] view 에게 응답하기
	}
	// 2. 모든 글 출력 제어 메소드	, 함수명 : 임의 , 매개변수 : X , 리턴값 : BoardDto[]
	public BoardDto[] findAll() {
		BoardDto[] result = BoardDao.getInstance().findAll(); // [1] DAO 에게 모든 게시물 정보를 요청하고 응답받기
		return result; // [2] view에게 응답받기
	}
	
}
