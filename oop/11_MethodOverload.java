/**
 * 11 — 메서드 오버로딩 & varargs
 *
 * [오버로딩] 같은 클래스 안에서 메서드 이름은 같고 매개변수만 다름
 *   - 매개변수 개수, 타입, 순서가 달라야 함 (반환 타입만 다르면 오버로딩 아님)
 *   - 호출 시 인자에 맞는 메서드가 자동 선택됨
 *   - 10_Constructor의 생성자 오버로딩과 같은 원리
 *
 * [varargs] 가변 인자 — 타입... 이름
 *   - 인자 0개 이상 받을 때, 내부에서는 배열처럼 사용
 *   - 오버로딩 시 고정 인자 메서드가 varargs보다 우선 매칭됨
 *
 * 컴파일 & 실행:
 *   javac oop/11_MethodOverload.java
 *   java -cp oop MethodOverload
 */
class Printer {

    void print(String message) {
        System.out.println("  [문자열] " + message);
    }

    // 개수 다름 — int 하나
    void print(int number) {
        System.out.println("  [정수]   " + number);
    }

    // 개수 다름 — String + int
    void print(String label, int number) {
        System.out.println("  [라벨]   " + label + " = " + number);
    }

    // varargs — int를 0개 이상 받음
    void print(int... numbers) {
        System.out.print("  [가변]   ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

class MethodOverload {

    public static void main(String[] args) {
        showOverloading();
        showVarargs();
    }

    static void showOverloading() {
        System.out.println("=== 메서드 오버로딩 ===");

        Printer p = new Printer();
        p.print("Hello");
        p.print(42);
        p.print("score", 95);
        System.out.println();
    }

    static void showVarargs() {
        System.out.println("=== varargs ===");

        Printer p = new Printer();
        p.print();              // 인자 0개
        p.print(1, 2, 3);       // 인자 3개
        p.print(10, 20, 30, 40); // 인자 4개
    }
}