package hello.core.singleton;

/**
 * 싱글톤 패턴 사용시 주의 사항
 * 스피링 빈은 항상 무상태(Stateless)를 유지해야한다.
 * 특정 고객에 의존적인 필드가 존재해서는 안된다.
 * 고객이 특정 필드를 변경하게 해서는 안된다.
 * 가급적 읽기만 해야한다.
 *
 * 유지 상태 stateful 예시
 * */
public class StatefulService {

    // private int price;  // 상태를 유지하는 필드 무상태 유지를 위해서 사용하지 않는다.

    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        // this.price = price; // 문제 발생 -> 공유하는 필드를 만들지 않고 지역변수 등으로 문제를 해결하라
        return price;   // 지역변수로 설정할 수 있게 필요값을 리턴함
    }

 /*   public int getPrice(){
        return price;
    }*/
}
