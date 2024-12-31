package day16.step3;

class Parent{ // 상위 클래스
	String field1;
	
	public void method1() {System.out.println("Parent method1");}
	public void method2() {System.out.println("Parent method2");}
}
class Child extends Parent{ // 하위클래스
	String field2;
	public void method3() {System.out.println("Parent method3");}
	// * 물려받은/상위클래스 메소드를 재정의/코드변경 = 오버라이딩
		// 주의할점 : 메소드의 선언부는 동일하게 작성 , { } 안에 있는 코드만 재정의
	// 멤버변수가 동일하면 this/super 로 구분 , 메소드명이 동일하면 왜? this/super 안쓰는 이유
	// ---> 멤버변수는 인스턴스마다 할당 , 메소드는 모든 인스턴스가 하나의 메소드를 공유해서 사용하기 때문이다.
	@Override // 오버라이딩 어노테이션 // 생략 가능하다.	
	public void method1() {System.out.println("Child method1");}
	public void method2() {System.out.println("Child method2");}
}
public class Example3 {
	public static void main(String[] args) {
		
		// 1. 자식 인스턴스 생성
		Child child = new Child();
		child.method1();	// 자식 인스턴스는 부모클래스의 메소드를 사용할 수 있다. 단] 오버라이딩 메소드인 경우 한 인스턴스의 메소드 호출된다.
		child.method2();	// 부모 메소드가 아닌 본인 메소드 우선순위 갖는다. 즉] 오버라이딩이 최우선 호출 대상이 된다.
		child.method3();
		
		// 2. 자식 클래스의 인스턴스가 부모 클래스로 타입 변환
		Parent parent = child; 	// 타입변환
		parent.method1();		// 타입이 변환된다고 해서 인스턴스가 바뀌는건 아니다.
		parent.method2();		// 타입변환시 하위 타입의 멤버에 접근할 수 없다.
		// parent.method3();
		
		// 3. 부모 클래스의 타입에서 자식 클래스의 타입 변환
		Child child2 = (Child)parent; 	// 부모타입 --> 자식타입 OK
		child2.method1();
		child2.method2();
		child2.method3();
		
		// 4. 부모 클래스의 인스턴스 생성
		Parent parent2 = new Parent();
		parent2.method1();
		// * 태생검사
		if(parent2 instanceof Child) { // parent2 변수가 가리키는 인스턴스가 Child 타입을 참조하고 있나? X
			Child child3 = (Child)parent2;
		}
		else {
			System.out.println("타입변환 안됩니다.");
		}
	}
}
