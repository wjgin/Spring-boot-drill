package hello.core.singleton;

/**
 * 싱글톤 패턴
 * static 영역에 istance를 만들어 해당 객체를 공유해서 사용
  */

public class SingletonService {

    // 자기자신의 객체를 스태틱 영역에 생성
    private static final SingletonService instance = new SingletonService();

    // 스태틱 영역의 인스턴스를 사용
    public static SingletonService getInstance(){
        return instance;
    }

    // 새로운 생성자를 만들 수 없게 private으로 정의
    private SingletonService(){}

    public void logic(){
        System.out.println("싱글톤 로직 생성");
    }
}
