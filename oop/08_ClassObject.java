/**
 * 08 — 클래스와 객체
 *
 * [클래스] 객체를 만들기 위한 설계도 — 필드(상태) + 메서드(동작)를 정의
 * [객체]   클래스로부터 new로 생성한 인스턴스 — 각각 독립적인 필드 값을 가짐
 * [필드]   객체의 상태를 저장하는 변수
 *   - 인스턴스 필드: 객체마다 따로 존재 (title, price 등)
 *   - static 필드  : 클래스 전체에 하나 (객체 수 카운트 등)
 * [Object] 자바의 모든 클래스가 상속하는 최상위 클래스
 *   - toString(), equals(), hashCode() 같은 기본 메서드를 제공
 *   - 대표 3개
 *     1) toString() : 객체 정보를 문자열로 확인하는 메서드
 *     2) equals()   : 두 객체가 같은지 비교하는 메서드 (== 와 다름)
 *     3) hashCode() : 해시 기반 컬렉션에서 사용하는 정수값을 반환하는 메서드
 *
 * [비교 연산자 차이]
 *   - ==       : 같은 객체(같은 박스)를 가리키는지 비교
 *   - equals() : 객체 안의 내용(값)이 같은지 비교
 *   - ===      : 자바 문법 아님 (JavaScript의 strict equality)
 *
 * 객체 생성:
 *   클래스명 변수명 = new 클래스명();
 *
 * 05_Methods에서 static을 썼던 이유 — main은 객체 없이 호출되므로,
 *   static 메서드만 main에서 직접 호출 가능. 
 *
 * 컴파일 & 실행:
 *   javac oop/08_ClassObject.java
 *   java -cp oop ClassObject
 */
class Book {

    // 인스턴스 필드 — Book 객체 하나마다 별도로 존재
    String title;
    String author;
    int price;

    // 인스턴스 메서드 — 객체를 통해 호출 (book.printInfo())
    void printInfo() {
        System.out.println("  " + title + " / " + author + " / " + price + "원");
    }

}

class ClassObject {

    // static 필드 — ClassObject 클래스 전체에 하나만 존재
    static int bookCount = 0;

    public static void main(String[] args) {
        showStaticField();
        createObjects();
        showIndependentState();
        showObjectBasics();
        showCompareOperators();
    }

    static void createObjects() {
        System.out.println("=== 객체 생성 (new) ===");

        // new — 힙에 Book 객체를 만들고, 참조를 변수에 저장
        Book book1 = new Book();
        book1.title = "Effective Java";
        book1.author = "Joshua Bloch";
        book1.price = 32000;

        Book book2 = new Book();
        book2.title = "Clean Code";
        book2.author = "Robert Martin";
        book2.price = 28000;

        System.out.println("book1:");
        book1.printInfo();  // static 없이 객체를 통해 메서드 호출
        System.out.println("book2:");
        book2.printInfo();
        System.out.println();
    }

    static void showIndependentState() {
        System.out.println("=== 객체마다 독립적인 필드 ===");

        Book a = new Book();
        a.title = "Java 기초";
        a.price = 20000;

        Book b = new Book();
        b.title = "Spring Boot";
        b.price = 35000;

        a.price = 15000;  // a만 변경

        System.out.println("a.price = " + a.price);
        System.out.println("b.price = " + b.price + "  ← b는 영향 없음");
        System.out.println();
    }

    static void showStaticField() {
        System.out.println("=== static 필드 (클래스에 하나) ===");

        bookCount = 2;
        System.out.println("bookCount = " + bookCount);
        System.out.println("ClassObject.bookCount = " + ClassObject.bookCount + "  ← 클래스명으로 접근 가능");
    }

    static void showObjectBasics() {
        System.out.println("=== Object 기본 메서드 ===");

        Book book = new Book();
        book.title = "Object in Java";
        book.author = "JDK";
        book.price = 10000;

        // 같은 객체를 참조하는 변수
        Book sameRef = book;
        
        // 다른 객체
        Book another = new Book();
        another.title = "Object in Java";
        another.author = "JDK";
        another.price = 10000;

        System.out.println("toString() 기본값: " + book.toString());
        System.out.println("객체 직접 출력: " + book); // println(book)도 내부적으로 toString() 호출
        System.out.println("equals() (sameRef): " + book.equals(sameRef)); // 같은 객체를 참조하는 변수이므로 true
        System.out.println("equals() (another): " + book.equals(another)); // 다른 객체이므로 false
        System.out.println("== (sameRef): " + (book == sameRef)); // 같은 객체를 참조하는 변수이므로 true
        System.out.println("== (another): " + (book == another)); // 다른 객체이므로 false
        System.out.println("hashCode(): " + book.hashCode());
        System.out.println("book instanceof Object = " + (book instanceof Object));
        System.out.println();
    }

    static void showCompareOperators() {
        System.out.println("=== == vs equals() vs === ===");

        String s1 = new String("java"); // new를 쓰면 문자열 내용이 같아도 새 객체 생성
        String s2 = new String("java"); // s1과 다른 객체
        String s3 = s1;                 // s1과 같은 객체를 참조

        System.out.println("identityHashCode(s1): " + System.identityHashCode(s1));
        System.out.println("identityHashCode(s2): " + System.identityHashCode(s2));
        System.out.println("identityHashCode(s3): " + System.identityHashCode(s3));
        System.out.println("s1 == s2: " + (s1 == s2) + "  ← 예상: false (서로 다른 객체)");
        System.out.println("s1 == s3: " + (s1 == s3) + "  ← 예상: true (같은 객체 참조)");
        System.out.println("s1.equals(s2): " + s1.equals(s2) + "  ← 예상: true (문자열 내용 동일)");
        System.out.println("자바에는 === 연산자가 없음 (컴파일 에러)");
        System.out.println();
    }
}