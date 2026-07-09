/**
 * 10 — 생성자 (Constructor)
 *
 * [생성자] new 할 때 자동 호출되는 메서드 — 객체 초기 상태를 설정
 *   - 이름 = 클래스명과 같음, 반환 타입 없음
 *   - 작성하지 않으면 컴파일러가 기본 생성자(매개변수 없음)를 자동 추가
 *   - 생성자를 하나라도 직접 쓰면 기본 생성자는 자동 생성되지 않음 (중요)
 *
 * [this]
 *   - this(인자) — 같은 클래스의 다른 생성자 호출 (생성자 체이닝)
 *   - this.필드   — 매개변수와 필드 이름이 같을 때 구분 (09와 동일)
 *   - this()는 생성자 맨 첫 줄에만 쓸 수 있음
 *
 * 컴파일 & 실행:
 *   javac oop/10_Constructor.java
 *   java -cp oop Constructor
 */
class User {

    private String name; // 인스턴스 필드 default value: "게스트"
    private int age; // 인스턴스 필드 default value: 20

    // 기본 생성자 — 필드만 기본값(게스트, 20)으로 둘 때
    // 원래 컴파일러가 기본 생성자를 자동 추가하지만, 생성자를 하나라도 직접 쓰면 자동 생성되지 않음
    User() {
        this("게스트", 20); // 기본 생성자에서 다른 생성자 호출
    }

    // 생성자 오버로딩 — 이름만 받을 때
    User(String name) {
        this(name, 20);  // this()로 아래 생성자에 위임 (중복 코드 제거)
    }

    // 생성자 오버로딩 — 이름 + 나이
    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void printInfo() {
        System.out.println("  " + name + " / " + age + "세");
    }
}

class Constructor {

    public static void main(String[] args) {
        showDefaultConstructor();
        showParameterizedConstructor();
        showConstructorChaining();
    }

    static void showDefaultConstructor() {
        System.out.println("=== 기본 생성자 ===");

        User guest = new User();  // User() 호출
        guest.printInfo();
        System.out.println();
    }

    static void showParameterizedConstructor() {
        System.out.println("=== 매개변수 있는 생성자 ===");

        User user = new User("민수", 28);
        user.printInfo();
        System.out.println();
    }

    static void showConstructorChaining() {
        System.out.println("=== this() 생성자 체이닝 ===");

        // new User("지영") → User(String) → this("지영", 20) → User(String, int)
        User user = new User("지영");
        user.printInfo();
        System.out.println("  이름만 넘기면 나이는 기본값 20으로 설정됨");
    }
}