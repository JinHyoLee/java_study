/**
 * 02 — 변수와 데이터 타입
 *
 * [기본형] 값 자체를 저장
 * 
 * [참조형] 변수에는 객체 자체가 아니라 힙(Heap)에 있는 객체의 주소(참조)가 저장됨
 *   - 종류: String, 배열, 클래스로 만든 객체 등 (기본형을 제외한 대부분)
 *   - 변수 크기: 참조값 4 또는 8바이트 (JVM·힙 설정에 따라)
 *   - 객체 크기: String 길이, 배열 길이 등에 따라 가변
 *   - 같은 객체를 여러 변수가 가리킬 수 있음 (복사는 주소만 복사)
 *   - null: 아무 객체도 가리키지 않음
 *   - 기본형은 값 복사, 참조형은 주소 복사 → 배열·객체는 한쪽 수정이 다른 쪽에도 반영될 수 있음
 * 
 * [final]  한 번 할당 후 재할당 불가 
 *  - Java에는 const 없음, final 사용
 *   지역 상수   final 타입 이름 = 값;           (메서드 안)
 *   클래스 상수 static final 타입 이름 = 값;   (클래스 필드, 관례: 대문자)
 *
 * 기본형 종류와 크기 (바이트) — Wrapper.BYTES 상수로 확인
 *   byte    1    short   2    char    2
 *   int     4    float   4
 *   long    8    double  8
 *   boolean JVM마다 다름 (보통 1)
 *
 * 참조형 종류와 크기(바이트)
 *   String, 배열, 클래스 인스턴스 등
 *   변수(참조) = 4 또는 8바이트 / 실제 객체 = 힙에 별도 저장, 크기 가변
 *
 * 컴파일 & 실행:
 *   javac 02_Variables.java
 *   java Variables
 */
class Variables {

    // 클래스 상수 — static final, 대문자 스네이크 케이스 관례
    static final int MAX_USERS = 1000;
    static final String APP_NAME = "Portfolio";

    public static void main(String[] args) {
        printPrimitives();
        printReferences();
        printFinal();
    }

    static void printPrimitives() {
        System.out.println("=== 기본형 ===");

        int age = 25; // 4 bytes    
        long population = 51_000_000_000L; // 8 bytes
        double pi = 3.14; // 8 bytes
        boolean isActive = true; // 1 byte
        char grade = 'A'; // 2 bytes

        System.out.println("int     (" + Integer.BYTES + " bytes)  age        = " + age); // 4 bytes
        System.out.println("long    (" + Long.BYTES + " bytes)  population = " + population); // 8 bytes
        System.out.println("double  (" + Double.BYTES + " bytes)  pi         = " + pi); // 8 bytes  
        System.out.println("boolean (~1 byte)  isActive   = " + isActive); // 1 byte    
        System.out.println("char    (" + Character.BYTES + " bytes) grade      = " + grade); // 2 bytes
        System.out.println();
    }

    static void printReferences() {
        System.out.println("=== 참조형 ===");
        System.out.println("변수 → 힙의 객체를 가리키는 주소(참조)를 저장");
        System.out.println();

        // String — 참조 재할당
        String name = "Java";
        String alias = name;

        System.out.println("String (ref 4|8 bytes) name  = " + name);
        System.out.println("String (ref 4|8 bytes) alias = " + alias + "  ← name과 같은 객체");
        alias = "Kotlin";
        System.out.println("alias에 새 객체 할당 후");
        System.out.println("  name  = " + name + "  (변경 없음)");
        System.out.println("  alias = " + alias);
        System.out.println();

        // 배열 — 같은 객체를 공유하면 요소 변경이 함께 반영됨
        int[] scores = {90, 85, 88};
        int[] sameRef = scores;

        System.out.println("int[] (ref 4|8 bytes) scores  = " + scores[0] + ", " + scores[1] + ", " + scores[2]);
        sameRef[0] = 100;
        System.out.println("sameRef[0] = 100 실행 후");
        System.out.println("  scores[0] = " + scores[0] + "  ← 같은 배열을 가리키므로 함께 변경");
        System.out.println();

        // null — 참조가 없는 상태
        String empty = null;
        System.out.println("String empty = " + empty + "  ← null은 객체 없음");
        // System.out.println(empty.length());  // NullPointerException
    }

    static void printFinal() {
        System.out.println("=== 상수 (final) ===");

        // 지역 상수 — 메서드 안에서 final
        final int retryLimit = 3;

        final String defaultLang = "ko";

        System.out.println("[클래스 상수] MAX_USERS = " + MAX_USERS);
        System.out.println("[클래스 상수] APP_NAME  = " + APP_NAME);
        System.out.println("[지역 상수]   retryLimit = " + retryLimit);
        System.out.println("[지역 상수]   defaultLang = " + defaultLang);
        // retryLimit = 5;  // 컴파일 에러 — final은 재할당 불가
    }
}