package day17.step3;


class Car {
    Tire tire; // 인터페이스 타입의 변수 생성, 타이어 변수 선언
    public void run(){  this.tire.roll();    }
}
interface Tire { // 타이어 인터페이스 생성
    void roll(); // 추상메소드 생성
}
class HankookTire implements Tire { // 타이어 인터페이스를 한국타이어 클래스가 구현
    @Override
    public void roll(){
        System.out.println("한국 타이어가 회전합니다.");
    }
}
class KumhoTire implements Tire { // 타이어 인터페이스를 금호타이어 클래스가 구현
    @Override
    public void roll(){
        System.out.println("금호 타이어가 회전합니다.");
    }
}


public class Example3 {
    public static void main(String[] args) {

        Car myCar = new Car(); // Car 타입의 myCar라는 Car 인스턴스 생성
        // myCar.run();
        Car yourCar = new Car(); // Car 타입의 yourCar라는 Car 인스턴스 생성
        // yourCar.tire = new Tire(); // 인터페이스에는 객체가 없기 때문에 생성 불가 
        // yourCar.run();

        // myCar.tire = new Tire(); // 인터페이스에는 객체가 없기 때문에 생성 불가 
        // myCar.run();

        myCar.tire = new HankookTire(); // 한국타이어 인스턴스 생성
        myCar.run(); // 한국타이어가 회전합니다.

        myCar.tire = new KumhoTire(); // 금호타이어 인스턴스 생성
        myCar.run(); // 금호타이어가 회전합니다.
        // yourCar.run();

        System.out.println( myCar.tire instanceof KumhoTire); // 금호타이어 인스턴스 생성 후 타입확인하므로 true
        if( myCar.tire instanceof Tire){ // myCar.tire는 타이어 인터페이스를 구현하고 있으므로 true
            myCar.tire = new HankookTire(); // 한국타이어 인스턴스 생성
        }
        myCar.run(); // 한국타이어가 회전합니다.
    }
}