package day16.step4;

class Car {
    Tire tire;
    public void run(){  this.tire.roll();    } // Car 필드에서 Tire 클래스 참조 (합성관계)
}
class Tire {
    public void roll(){
        System.out.println("일반 타이어가 회전합니다.");
    }
}
class HankookTire extends Tire {
    @Override //물려받은 메소드를 재정의/코드변경
    public void roll(){
        System.out.println("한국 타이어가 회전합니다.");
    }
}
class KumhoTire extends Tire {
    @Override //물려받은 메소드를 재정의/코드변경
    public void roll(){
        System.out.println("금호 타이어가 회전합니다.");
    }
}

public class Example4 {
    public static void main(String[] args) {

        Car myCar = new Car(); // myCar라는 Car 인스턴스 생성
        // myCar.run(); // this.tire가 무엇을 가리키고 있는지 정해지지 않아서 
        Car yourCar = new Car(); // yourCar라는 Car 인스턴스 생성
        yourCar.tire = new Tire(); // Tire 인스턴스 생성 // Car 인스턴스인 yourCar가 Tire 인스턴스를 참조(합성관계이므로)
        yourCar.run(); // 일반 타이어가 회전합니다.

        myCar.tire = new Tire(); // Tire 인스턴스 생성 // Car 인스턴스인 myCar가 Tire 인스턴스를 참조(합성관계이므로)
        myCar.run(); // 일반타이어가 회전합니다.

        myCar.tire = new HankookTire(); // 한국타이어 인스턴스 생성
        myCar.run(); // 한국타이어가 회전합니다.

        myCar.tire = new KumhoTire(); // 금호타이어 인스턴스 생성
        myCar.run(); // 금호타이어가 회전합니다.
        yourCar.run(); //일반타이어가 회전합니다.

        System.out.println( myCar.tire instanceof  KumhoTire  ); // true
        if( myCar.tire instanceof Tire ){ // myCar.tire가 Tire타입이면
            myCar.tire = new HankookTire(); //한국타이어 인스턴스 생성
        }
        myCar.run(); //한국타이어가 회전합니다.
    }
}