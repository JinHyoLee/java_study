/**
 * 13 — 메서드 오버라이딩 (Overriding)
 *
 * [오버라이딩] 부모와 같은 메서드 시그니처를 자식에서 다시 정의
 *   - 11 오버로딩(이름 같고 매개변수 다름)과 다름 — 시그니처가 같아야 함
 *   - @Override — 선택(권장). 붙이면 부모 메서드 재정의 여부를 컴파일러가 검사 (오타 시 에러)
 *
 * [super.메서드()] 부모 버전 호출 — 기존 동작 위에 추가할 때
 * [Object 메서드도 오버라이딩 가능] 예: toString()
 *
 * 컴파일 & 실행:
 *   javac oop/13_Overriding.java
 *   java -cp oop Overriding
 */

class Animal {

    String name;

    Animal(String name) {
        this.name = name;
    }

    void doAction() {
        System.out.println("  " + name + "이(가) 행동한다");
    }

    void print() {
        System.out.println("  " + name + "은 동물이다");
    }
}

class Dog extends Animal {

    String breed;

    Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    // @Override — 부모 doAction()을 재정의
    @Override
    void doAction() {
        System.out.println("  " + name + "이(가) 산책한다");
    }

    // super.doAction() — 부모 동작을 먼저 실행한 뒤 자식 동작 추가
    @Override
    void print() {
        super.print();
        System.out.println("  품종: " + breed);
    }

    // toString() 은 Object 클래스에 있는 메서드이므로 오버라이딩 가능
    @Override
    public String toString() {
        return "Dog:name='" + name + "', breed='" + breed ;
    }
}

class Cat extends Animal {

    boolean indoor;

    Cat(String name, boolean indoor) {
        super(name);
        this.indoor = indoor;
    }

    @Override
    void doAction() {
        System.out.println("  " + name + "이(가) 그루밍한다");
    }

    @Override
    void print() {
        super.print();
        System.out.println("  생활: " + (indoor ? "실내" : "야외"));
    }
}

class Overriding {

    public static void main(String[] args) {
        showOverride();
        showSuperMethod();
        showToStringOverride();
    }

    static void showOverride() {
        System.out.println("=== @Override — 부모 메서드 재정의 ===");

        Animal animal = new Animal("동물");
        Dog dog = new Dog("바둑이", "진돗개");
        Cat cat = new Cat("나비", true);

        animal.doAction();  // Animal 버전
        dog.doAction();     // Dog 버전으로 대체
        cat.doAction();     // Cat 버전으로 대체
        System.out.println();
    }

    static void showSuperMethod() {
        System.out.println("=== super.메서드() — 부모 동작 + 자식 추가 ===");

        Dog dog = new Dog("초코", "푸들");
        Cat cat = new Cat("치즈", false);

        dog.print();  // super.print() → Animal.print() 먼저, 이후 품종 출력
        cat.print();
    }

    static void showToStringOverride() {
        System.out.println();
        System.out.println("=== toString() 오버라이딩 ===");

        Animal animal = new Animal("동물");
        Dog dog = new Dog("초코", "푸들");
        Cat cat = new Cat("나비", true);

        // 이 부분에서 오버라이딩된 toString() 메서드가 호출됨.
        System.out.println(animal); // Animal.toString()
        System.out.println(dog);    // Dog.toString()
        System.out.println(cat ); // Cat.toString()
    }
}