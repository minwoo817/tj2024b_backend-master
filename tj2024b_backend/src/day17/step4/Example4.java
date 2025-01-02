package day17.step4;

public class Example4 {
	public static void main(String[] args) {
		
		// [1] Customer 인스턴스 생성
		Customer customer = new Customer();
			// 하위 타입이 생성될때 상위 타입도 같이 참조한다.
			// Customer ---> Buy/Sell
		// [2] Customer 인스턴스가 Buy 타입으로 형 변환
		Buy buyer = customer;
		buyer.buy();
		
		// [3] Customer 인스턴스가 Sell 타입으로 형 변환
		Sell seller = customer; // (업)캐스팅
		seller.sell();
		
		// [4] 변수명 instanceof 타입 : 변수가 참조하는 인스턴스의 타입 조회
		if(seller instanceof Customer) {
			Customer customer2 = (Customer)seller; //(다운)캐스팅
			customer2.buy();
			customer2.sell();
		}
	}
}
