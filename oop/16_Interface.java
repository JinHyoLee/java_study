/**
 * 16 — 인터페이스 (Interface)
 *
 * [interface] 구현해야 할 메서드 목록(계약) — 객체 생성 불가
 *   - implements — 클래스가 인터페이스를 구현
 *   - 클래스는 extends 하나, implements는 여러 개 가능
 *   - extends + implements 동시 가능 — 공통 코드는 부모 클래스, 계약(능력)은 인터페이스
 *
 * [추상 클래스(15)와 차이]
 *   - 인터페이스: 필드 없음(상수만), 구현 메서드 없음(기본 메서드 제외)
 *   - 추상 클래스: 필드·생성자·일반 메서드 가능, 단일 상속만
 *
 * [언제 인터페이스를 쓰나]
 *   - "무엇을 할 수 있는가"(능력/계약)만 정의할 때 — Email, SMS처럼 구현체마다 방식은 다르지만 send()는 같음
 *   - 구현을 바꿔 끼울 때 — Notifiable 타입만 알면 EmailNotifier → SmsNotifier 교체 가능
 *   - 여러 역할을 한 클래스에 붙일 때 — SmsNotifier가 Notifiable + Auditable 동시 구현
 *   - Spring에서 @Service, JpaRepository 등도 결국 인터페이스 기반 — 테스트 시 가짜 구현으로 대체하기 쉬움
 *   - 반면 "공통 필드·상태 + 일부 공통 구현"이 필요하면 추상 클래스(15)가 더 적합
 *
 * [인터페이스와 추상클래스를 동시에 사용 가능]
 *   - 인터페이스와 추상클래스를 동시에 사용 가능하다.
 *   - 인터페이스는 계약(능력)만 정의하고, 추상클래스는 공통 코드와 일부 구현을 제공한다.
 *   - 인터페이스와 추상클래스를 동시에 사용하면, 계약(능력)과 공통 코드를 분리할 수 있다.

* 컴파일 & 실행:
 *   javac oop/16_Interface.java
 *   java -cp oop Interface
 */

// interface는 필드 없음(상수만), 구현된 메서드 없음. 프로토타입만 정의한다.
interface Notifiable {

    void send(String message);
}

// interface는 필드 없음(상수만), 구현된 메서드 없음. 프로토타입만 정의한다.
interface Auditable {

    void audit(String action);
}

// 추상 클래스는 필드, 생성자, 일반 메서드 가능. 단일 상속만 가능하다.
abstract class BaseNotifier {

    String sender;

    BaseNotifier(String sender) {
        this.sender = sender;
    }

    void log(String action) {
        System.out.println("  [발신자: " + sender + "] " + action);
    }
}


// implements 하나 — Notifiable
class EmailNotifier implements Notifiable {

    String to;

    EmailNotifier(String to) {
        this.to = to;
    }

    @Override
    public void send(String message) {
        System.out.println("  [이메일 → " + to + "] " + message);
    }
}

// implements 여러 개 — Notifiable + Auditable
class SmsNotifier implements Notifiable, Auditable {

    String phone;

    SmsNotifier(String phone) {
        this.phone = phone;
    }

    @Override
    public void send(String message) {
        System.out.println("  [SMS → " + phone + "] " + message);
    }

    @Override
    public void audit(String action) {
        System.out.println("  [감사로그] " + phone + " — " + action);
    }
}

// extends + implements — 부모의 공통 코드 + 인터페이스 계약
class PushNotifier extends BaseNotifier implements Notifiable, Auditable {

    PushNotifier(String sender) {
        super(sender);
    }

    @Override
    public void send(String message) {
        log("푸시 발송");
        System.out.println("  [푸시] " + message);
    }

    @Override
    public void audit(String action) {
        System.out.println("  [감사로그] " + sender + " — " + action);
    }
}

//메인

class Interface {

    public static void main(String[] args) {
        showImplements();
        showPolymorphism();
        showMultipleInterfaces();
        showExtendsAndImplements();
    }

    static void showImplements() {
        System.out.println("=== implements — 인터페이스 구현 ===");

        // Notifiable n = new Notifiable();  // 컴파일 에러 — 인터페이스는 new 불가

        EmailNotifier email = new EmailNotifier("user@example.com");
        email.send("회원가입 완료");
        System.out.println();
    }

    static void showPolymorphism() {
        System.out.println("=== 인터페이스 다형성 ===");

        Notifiable[] channels = {
            new EmailNotifier("admin@example.com"),
            new SmsNotifier("010-1234-5678")
        };

        for (Notifiable channel : channels) {
            channel.send("주문이 접수되었습니다");  // 실제 타입의 send() 호출
        }
        System.out.println();
    }

    static void showMultipleInterfaces() {
        System.out.println("=== implements 여러 개 ===");

        SmsNotifier sms = new SmsNotifier("010-9999-8888");
        sms.send("인증번호: 123456");
        sms.audit("SMS 발송");
    }

    static void showExtendsAndImplements() {
        System.out.println("=== extends + implements ===");

        // PushNotifier extends BaseNotifier + implements Notifiable, Auditable
        Notifiable push = new PushNotifier("앱서버");
        push.send("새 댓글이 달렸습니다");

        PushNotifier pushNotifier = new PushNotifier("앱서버");
        pushNotifier.audit("푸시 발송");
    }
}