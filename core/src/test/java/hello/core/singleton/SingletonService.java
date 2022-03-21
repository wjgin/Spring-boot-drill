package hello.core.singleton;

/**
 * 싱글톤 패턴
 * static 영역에 istance를 만들어 해당 객체를 공유해서 사용
  */

public class SingletonService {

    // JVM 실행시 자신의 객체를 스태틱 영역에 생성
    // static은 class에 단 하나만 존재할 수 있음 -> 외부에서 생성시 복제값이 아닌 원본 사용
    private static final SingletonService instance = new SingletonService();

    // 외부에서 인스턴스를 불러올 때, 스태틱 영억의 인스턴스를 리턴 (단일 개체를 공유)
    // 이 객체 인스턴스가 필요시 외부에서는 오직 getInstance()로만 조회 가능
    public static SingletonService getInstance(){
        return instance;
    }

    // 외부에서 새로운 생성자를 만들 수 없게 private으로 정의 -> 외부에서 new 연산자로 새로운 인스턴스가 생기는 것을 막음
    private SingletonService(){}

    public void logic(){
        System.out.println("싱글톤 로직 생성");
    }
}
