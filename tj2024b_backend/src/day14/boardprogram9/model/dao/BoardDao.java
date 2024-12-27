package day14.boardprogram9.model.dao;

import java.util.ArrayList;
import java.util.Scanner;

import day14.boardprogram9.model.dto.BoardDto;

public class BoardDao {
	// + 싱글톤
	private BoardDao() {}
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	
	// + 게시물 리스트 선언 
	private ArrayList<BoardDto> boards = new ArrayList<>();
	
	// 1. 게시물 쓰기 처리 함수
	public boolean create(BoardDto boardDto) {
		// [1] 매개변수로 받은 객체를 add 함수를 이용하여 리스트에 저장
		boards.add(boardDto);
		// [2] 저장 결과 반환
		return true;
	}
	// 2. 게시물 반환 처리 함수
	public ArrayList<BoardDto> readAll(){
		// [1] 모든 게시물을 갖는 리스트객체 반환
		return boards;
	}
	// 3. 게시물 수정 처리 함수
	public boolean update(int uIndex, BoardDto boardDto) {
		/// [1] 리스트의 존재하지 않는 인덱스이면 실패
		if(uIndex > boards.size()-1 || uIndex < 0) {
			return false;
		}
		// [2] 지정한 인덱스에 새로운 객체 대입 , 수정함수 : .set(인덱스, 새로운요소) 함수
		boards.set(uIndex, boardDto);
		return true;
	}
	// 4. 게시물 삭제 처리 함수
	public boolean delete(int dIndex) {
		// [1] 리스트에서 특정한 인덱스를 .remove()함수 이용하여 요소 삭제한다.
		if(dIndex > boards.size()-1 || dIndex < 0) { // 만약 존재하지 않는 인덱스를 요청하면
			return false; // 실패
		}
		boards.remove(dIndex); // 삭제처리
		// [2] 삭제 결과 반환
		return true; // 성공
	}
}
