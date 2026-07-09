/**
 * 12 — 상속 (Inheritance)
 *
 * [상속] extends — 부모(슈퍼) 클래스의 필드·메서드를 자식(서브) 클래스가 물려받음
 *   - 코드 재사용, 공통 동작을 부모에 모음 (Dog, Cat 모두 Animal의 eat() 공유)
 *   - Java는 클래스 단일 상속만 가능 (extends 하나)
 *
 * [super]
 *   - super(인자) — 부모 생성자 호출 (자식 생성자 맨 첫 줄)
 *   - super.메서드() — 13_Overriding에서 사용
 * [Object] 자바의 최상위 클래스 — 모든 class는 결국 Object를 상속함
 *
 * 컴파일 & 실행:
 *   javac oop/12_Inheritance.java
 *   java -cp oop Inheritance
 */
class Animal {

    String name;

    Animal(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println("  " + name + "이(가) 먹는다");
    }
}

class Dog extends Animal {

    String breed;

    Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    void bark() {
        System.out.println("  " + name + "(" + breed + ")이(가) 짖는다");
    }
}

class Cat extends Animal {

    boolean indoor;

    Cat(String name, boolean indoor) {
        super(name);
        this.indoor = indoor;
    }

    void meow() {
        String place = indoor ? "실내" : "야외";
        System.out.println("  " + name + "(" + place + ")이(가) 야옹한다");
    }
}

class Inheritance {

    public static void main(String[] args) {
        showExtends();
        showSuperConstructor();
    }

    static void showExtends() {
        System.out.println("=== extends ===");

        Dog dog = new Dog("바둑이", "진돗개");
        Cat cat = new Cat("나비", true);

        System.out.println("=== 물려받은 메서드 — eat() 공유 ===");
        dog.eat();
        cat.eat();
        System.out.println();

        System.out.println("=== 자식만의 메서드 — bark(), meow() ===");
        dog.bark();
        cat.meow();
    }

    static void showSuperConstructor() {
        System.out.println("=== super() — 부모 생성자 호출 ===");

        Dog dog = new Dog("초코", "푸들");
        System.out.println("  name  = " + dog.name + "  ← 부모 필드");
        System.out.println("  breed = " + dog.breed + "  ← 자식 필드");
    }
}