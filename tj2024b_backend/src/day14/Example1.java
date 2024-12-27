package day14;

import java.util.ArrayList;

public class Example1 {
	public static void main(String[] args) {
		
		// [1] 배열의 길이를 변경할 수 없다. 고정길이
		String[] names = new String[3]; // String 객체 3개를 저장할 수 있는 배열
		// [2] 배열에 객체(요소) 대입
		names[0] = "유재석";
		names[1] = "강호동";
		names[2] = "신동엽";
		// [3] 배열내 모든 요소를 순회/조회
		for(int index = 0; index<names.length; index++) {
			System.out.println(names[index]);
		}
		// [4] 배열내 길이 이상의 요소 대입 , 길이가 3이면 인덱스 0~2가 존재한다.
		// names[3] = "하하"; // Index 3 out of bounds for length 3
		
		// [5] 배열내 중간 요소 삭제
		names[1] = null; // 고정길이 , 삭제 개념이 존재하지 않는다. 
		// 요소값을 null 로 비워서 사용이 가능하지만 요소 자체 삭제 불가능 
		
		// [1] ArrayList 클래스 , 배열과 다르게 가변길이로 사용이 가능하다.단점 : 라이브러리는 느리다.
			// import java.util.ArrayList;
			// <제네릭 타입> : 리스트에 저장할 객체의 타입
				// ArrayList<요소타입> 변수명 = new ArrayList<>();
		ArrayList<String> nameList = new ArrayList<>();
		
		// [2] .add(요소) : 리스트에 요소 추가 함수
		nameList.add("유재석");
		nameList.add("강호동");
		nameList.add("신동엽");
		
		// [3] .size() : 리스트의 요소 총 개수 반환 함수, .get(인덱스) : 리스트의 지정한 인덱스 요소값 반환 함수
		for(int index = 0; index <nameList.size(); index++) {
			System.out.println(nameList.get(index));
		}
		
		// [4] .add(요소) : 리스트에 요소 추가 함수
		nameList.add("하하"); // 배열과 다르게 리스트는 가변길이 이므로 자동으로 길이가 조정된다.
		
		// [5] .remove(인덱스) : 리스트에 지정한 인덱스 요소 삭제 함수
		nameList.remove(1); // index 가 1인 "강호동" 요소 삭제 // 배열과 다르게 리스트는 가변길이 이므로 요소 삭제 가능
		
		// [6] 확인
		System.out.println(nameList);
		
		// 실습 , Book 클래스 객체들을 저장하는 리스트 객체 생성
			// [1] 리스트 객체 선언
		ArrayList<Book> library = new ArrayList<>();
			// [2] .add() 이용한 리스트객체 내 요소객체 추가
		library.add(new Book("태백산맥" , "조정래"));
		library.add(new Book("데미안" , "헤르만 헤세"));
		library.add(new Book("어떻게 살 것인가?" , "유시민"));
		Book book1 = new Book("토지", "박경리");
		library.add(book1);
		Book book2 = new Book("어린왕자" , "생택쥐베리");
		library.add(book2);
		
			// [3] .size() ; 리스트 객체내 요소 총개수 반환함수
			// .get(인덱스) : 리스트 객체내 지정한 인덱스 요소객체 반환 함수
		for(int index = 0; index < library.size(); index++) {
			Book book = library.get(index);
			System.out.println(book);
		}
		System.out.println(library);
	}
}
