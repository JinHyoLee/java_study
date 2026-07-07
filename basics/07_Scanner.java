/**
 * 07 — Scanner (콘솔 입력)
 *
 * [Scanner] java.util.Scanner — 입력을 읽는 클래스
 *   - new Scanner(System.in) : 키보드에서 읽음
 *   - close()                : 사용 후 닫기
 *
 * 입력 종류별로 메서드가 다름 — 변수 타입에 맞는 메서드를 쓴다
 *
 *   [문자 char]     next().charAt(0)  — 예: A 입력 → 'A' (첫 글자만, nextChar() 없음)
 *   [문자열 String] next()            — 예: hello world 입력 → "hello" (공백 전까지)
 *                   nextLine()        — 예: hello world 입력 → "hello world" (줄 전체)
 *   [숫자]          nextInt()         — 예: 10 입력 → 10
 *                   nextLong()        — 예: 1000000 입력 → 1000000L
 *                   nextDouble()      — 예: 3.14 입력 → 3.14
 *   [논리]          nextBoolean()     — 예: true 입력 → true (true / false만 인식)
 *
 * [주의] next() / nextInt() 등 뒤에 nextLine() 쓸 때
 *   - next(), nextInt() 등은 줄바꿈(\n)을 버퍼에 남김 → 바로 nextLine() 하면 빈 문자열
 *   - nextLine() 쓰기 전에 scanner.nextLine() 한 번으로 남은 \n 비우기
 *
 * [주의] 타입에 맞지 않는 입력
 *   - nextInt() 등에 숫자가 아닌 값을 넣으면 InputMismatchException → 예외 처리 없으면 프로그램 종료
 *     예: int 입력에 abc 입력 → InputMismatchException 발생
 *   - 이 예제는 단순히 보여주기만 함. 실무에서는 hasNextInt() / try-catch로 재입력 처리
 *
 * 컴파일 & 실행:
 *   javac 07_Scanner.java
 *   java ScannerDemo
 */
import java.util.Scanner;

class ScannerDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        readChar(scanner);
        readStringWord(scanner);
        readStringLine(scanner);
        readNumbers(scanner);
        readBoolean(scanner);

        scanner.close();
    }

    // --- 문자 (char) ---
    static void readChar(Scanner scanner) {
        System.out.println("=== 문자 (char) ===");

        System.out.print("문자 하나 입력 (예: A): ");
        char grade = scanner.next().charAt(0);
        scanner.nextLine();  // 입력 후 남은 \n 제거

        System.out.println("char grade = " + grade);
        System.out.println();
    }

    // --- 문자열 (String) ---
    static void readStringWord(Scanner scanner) {
        System.out.println("=== 문자열 — 단어 (next) ===");

        System.out.print("단어 입력 (공백 전까지, 예: hello): ");
        String word = scanner.next();
        scanner.nextLine();  // next()가 남긴 \n 제거 — 없으면 아래 nextLine()이 빈 문자열

        System.out.println("String word = " + word);
        System.out.println("  \"Hello World\" 입력 시 → Hello 만 읽힘");
        System.out.println();
    }

    static void readStringLine(Scanner scanner) {
        System.out.println("=== 문자열 — 한 줄 (nextLine) ===");

        System.out.print("문장 입력 (띄어쓰기 가능, 예: hello world): ");
        String line = scanner.nextLine();

        System.out.println("String line = " + line);
        System.out.println();
    }

    // --- 숫자 ---
    // nextInt() 등 — 숫자가 아닌 값 입력 시 InputMismatchException (위 주석 참고)
    static void readNumbers(Scanner scanner) {
        System.out.println("=== 숫자 (int / long / double) ===");

        System.out.print("int 입력 (예: 10): ");
        int count = scanner.nextInt();

        System.out.print("long 입력 (예: 1000000): ");
        long population = scanner.nextLong();

        System.out.print("double 입력 (예: 3.14): ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // 마지막 숫자 뒤 \n 제거

        System.out.println("int    count      = " + count);
        System.out.println("long   population = " + population);
        System.out.println("double price      = " + price);
        System.out.println();
    }

    // --- boolean ---
    static void readBoolean(Scanner scanner) {
        System.out.println("=== boolean ===");

        System.out.print("true 또는 false 입력 (예: true): ");
        boolean active = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("boolean active = " + active);
        System.out.println();
    }
}