/**
 * 15 — 추상 클래스 (Abstract Class)
 *
 * [abstract class] 직접 객체 생성 불가 — 자식 클래스가 완성
 *   - abstract 메서드 — 선언만 있고 구현 없음, 자식이 반드시 오버라이드
 *   - 일반 메서드 — 자식이 오버라이드할 수 있지만 필수는 아님 (안 하면 부모 버전 사용)
 *   - 일반 메서드·필드도 가질 수 있음 (인터페이스와 차이 — 16에서 비교)
 *
 * 컴파일 & 실행:
 *   javac oop/15_AbstractClass.java
 *   java -cp oop AbstractClass
 */
abstract class Shape {

    String name;

    Shape(String name) {
        this.name = name;
    }

    // 추상 메서드 — 자식이 area() 구현을 강제
    abstract double area();

    // 일반 메서드 — 공통 동작을 부모에 둠
    // 자식이 @Override로 재정의 가능 (선택). area()는 abstract라 반드시 구현해야 함
    void describe() {
        System.out.println("  " + name + " 넓이 = " + area());
    }
}

class Circle extends Shape {

    double radius;

    Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {

    double width;
    double height;

    Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }
}

class AbstractClass {

    public static void main(String[] args) {
        showAbstractMethod();
        showPolymorphism();
    }

    static void showAbstractMethod() {
        System.out.println("=== abstract 메서드 — 자식이 구현 ===");

        // Shape shape = new Shape("도형");  // 컴파일 에러 — 추상 클래스는 new 불가

        Circle circle = new Circle("원", 5);
        Rectangle rect = new Rectangle("직사각형", 4, 6);

        circle.describe();
        rect.describe();
        System.out.println();
    }

    static void showPolymorphism() {
        System.out.println("=== 추상 클래스 + 다형성 ===");

        Shape[] shapes = {
            new Circle("피자", 10),
            new Rectangle("모니터", 60, 34)
        };

        for (Shape shape : shapes) {
            shape.describe();  // 실제 타입의 area() 호출
        }
    }
}