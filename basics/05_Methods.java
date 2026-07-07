/**
 * 05 — 메서드
 *
 * [메서드] 반환타입 이름(매개변수) { 본문 }
 *   - void  : 반환값 없음
 *   - return: 값 반환 후 메서드 종료
 *   - static: 클래스에 속한 메서드 — 객체 생성 없이 호출
 *             main이 static이므로, main에서 부르는 메서드도 static이어야 함
 *             (static 없으면 Methods m = new Methods(); m.greet() 형태로 호출)
 *
 * 컴파일 & 실행:
 *   javac 05_Methods.java
 *   java Methods
 */
class Methods {

    // main — static: JVM이 객체 없이 프로그램 진입점으로 호출
    public static void main(String[] args) {
        greet("Java");

        System.out.println("add(10, 20) = " + add(10, 20));
        System.out.println("square(5)   = " + square(5));
    }

    // static — main에서 객체 없이 바로 호출하기 위해 붙임 (08 클래스·객체 이후에는 생략 가능)
    static void greet(String name) {
        System.out.println("안녕, " + name);
    }

    // static + 반환값 — 계산 로직을 분리해 재사용·테스트하기 쉽게
    static int add(int a, int b) {
        return a + b;
    }

    // static + 단일 매개변수 — 같은 패턴의 연산을 이름으로 표현
    static int square(int n) {
        return n * n;
    }
}