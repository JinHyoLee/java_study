/**
 * 09 — 캡슐화 (Encapsulation)
 *
 * [캡슐화] 필드를 private으로 숨기고, getter/setter로만 접근
 *   - 외부에서 잘못된 값(음수 가격 등)을 막을 수 있음
 *   - 내부 구현을 바꿔도 외부 코드는 getter/setter만 쓰면 됨
 *
 * [접근 제어자]
 *   private   — 같은 클래스 안에서만
 *   (default) — 같은 패키지 (접근자 없음)
 *   protected — 같은 패키지 + 자식 클래스
 *   public    — 어디서나
 *
 * [this] 현재 객체(인스턴스)를 가리키는 참조
 *   - setter에서 매개변수 이름(name)과 필드 이름(name)이 같을 때 구분
 *     this.name → 이 객체의 필드 / name → 매개변수
 *   - static 메서드 안에는 '현재 객체'가 없으므로 this 사용 불가 (컴파일 에러)
 *   - static 필드는 클래스에 속함 — this는 인스턴스용이므로 Product.totalCount처럼 클래스명으로 접근
 *
 * 컴파일 & 실행:
 *   javac oop/09_Encapsulation.java
 *   java -cp oop Encapsulation
 */
class Product {

    // 인스턴스 필드 — 객체마다 따로 존재, this로 접근
    private String name;
    private int price;

    // static 필드 — 클래스에 하나, this가 아닌 클래스명으로 접근
    private static int totalCount = 0;

    // getter — 필드 값을 읽기만 허용
    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }

    // setter — 값을 넣을 때 검증 가능
    // 매개변수 name과 필드 name이 같으므로 this로 필드를 구분
    void setName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("  [입력오류] 이름은 비울 수 없습니다");
            return;
        }
        this.name = name;  // this = 이 Product 객체 / name = 매개변수
        totalCount++;      // static 필드 — 같은 클래스 안에서는 이름만으로도 접근 가능
        // this.totalCount++;  // 컴파일은 되지만 비권장 — static은 인스턴스가 아닌 클래스 소속
    }

    void setPrice(int price) {
        if (price < 0) {
            System.out.println("  [입력오류] 가격은 0 이상이어야 합니다: " + price);
            return;
        }
        this.price = price;  // this.price = 필드 / price = 매개변수
    }

    void printInfo() {
        System.out.println("  " + name + " / " + price + "원");
    }

    // static 메서드 — 객체 없이 호출, this가 존재하지 않음
    static int getTotalCount() {
        return totalCount;       // OK — static끼리 접근
        // return this.totalCount;  // 컴파일 에러 — static 메서드에서 this 사용 불가
    }
}

class Encapsulation {

    public static void main(String[] args) {
        useGetterSetter();
        showValidation();
        showThisVsStatic();
    }

    static void useGetterSetter() {
        System.out.println("=== getter / setter ===");

        Product p = new Product();
        p.setName("노트북");
        p.setPrice(1200000);

        // p.price = 500;  // 컴파일 에러 — private 필드 직접 접근 불가
        System.out.println("getName()  = " + p.getName());
        System.out.println("getPrice() = " + p.getPrice());
        p.printInfo();
        System.out.println();
    }

    static void showValidation() {
        System.out.println("=== setter로 잘못된 값 차단 ===");

        Product p = new Product();
        p.setName("");           // 거부
        p.setPrice(-5000);       // 거부
        p.setName("키보드");
        p.setPrice(89000);

        p.printInfo();
    }

    static void showThisVsStatic() {
        System.out.println("=== this vs static ===");

        Product a = new Product();
        a.setName("마우스");
        a.setPrice(45000);

        Product b = new Product();
        b.setName("모니터");
        b.setPrice(320000);

        // static — 클래스에 하나, 객체 수와 무관하게 누적
        System.out.println("등록된 상품 수 = " + Product.getTotalCount());
        // this는 static main 안에서도 사용 불가
        // System.out.println(this);  // 컴파일 에러
    }
}