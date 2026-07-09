/**
 * 14 — 다형성 (Polymorphism)
 *
 * [다형성] 부모 타입 참조로 자식 객체를 다루고, 실제 객체에 맞는 메서드가 실행됨
 *   - 13 오버라이딩이 있어야 런타임에 자식 버전이 호출됨
 *
 * [업캐스팅] 자식 → 부모 참조 (자동)
 *   Animal animal = new Dog(...);
 *
 * [다운캐스팅] 부모 참조 → 자식 타입 (명시적 캐스트)
 *   Dog dog = (Dog) animal;
 *   - instanceof로 타입 확인 후 캐스트 (ClassCastException 방지)
 *
 * 컴파일 & 실행:
 *   javac oop/14_Polymorphism.java
 *   java -cp oop Polymorphism
 */
class Animal {

    String name;

    Animal(String name) {
        this.name = name;
    }

    void doAction() {
        System.out.println("  " + name + "이(가) 행동한다");
    }
}

class Dog extends Animal {

    String breed;

    Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    @Override
    void doAction() {
        System.out.println("  " + name + "이(가) 산책한다");
    }

    void bark() {
        System.out.println("  " + name + "이(가) 짖는다");
    }
}

class Cat extends Animal {

    Cat(String name) {
        super(name);
    }

    @Override
    void doAction() {
        System.out.println("  " + name + "이(가) 그루밍한다");
    }

    void meow() {
        System.out.println("  " + name + "이(가) 야옹한다");
    }
}

class Polymorphism {

    public static void main(String[] args) {
        showUpcasting();
        showArrayPolymorphism();
        showDowncasting();
    }

    static void showUpcasting() {
        System.out.println("=== 업캐스팅 — 부모 타입 참조, 자식 객체 ===");

        Animal dog = new Dog("바둑이", "진돗개");  // Dog → Animal (자동)
        Animal cat = new Cat("나비"); // Cat → Animal (자동)

        dog.doAction();  // 실제 객체가 Dog → Dog.doAction() 실행
        cat.doAction();  // 실제 객체가 Cat → Cat.doAction() 실행
        System.out.println();

        // 컴파일 에러 — Animal에는 bark() 와 meow() 없음
        //dog.bark();  // 컴파일 에러 — Animal에는 bark() 없음
        //cat.meow();  // 컴파일 에러 — Animal에는 meow() 없음
    }

    static void showArrayPolymorphism() {
        System.out.println("=== 다형성 배열 — Animal[]에 자식 객체 ===");

        Animal[] animals = {
            new Dog("초코", "푸들"),
            new Cat("치즈"),
            new Dog("몽이", "말티즈")
        };

        for (Animal animal : animals) {
            animal.doAction();  // 각 객체 타입에 맞는 메서드 호출
        }
        System.out.println();
    }

    static void showDowncasting() {
        System.out.println("=== 다운캐스팅 — instanceof 확인 후 캐스트 ===");

        Animal animal = new Dog("해피", "리트리버");

        // animal.bark();  // 컴파일 에러 — Animal에는 bark() 없음

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;  // 명시적 다운캐스팅
            dog.bark();
            System.out.println("  breed = " + dog.breed);
        }

        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;  // 실행되지 않음 — 실제 타입은 Dog
            cat.meow();
        }
    }
}