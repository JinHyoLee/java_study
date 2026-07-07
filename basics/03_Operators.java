/**
 * 03 — 연산자
 *
 * [산술]   +  -  *  /  %  (나머지)
 * [비교]   ==  !=  <  >  <=  >=  → boolean 결과
 * [논리]   &&  ||  !  (단락 평가: 앞 결과로 뒤 실행 여부 결정)
 * [복합]   +=  -=  *=  /=  ++  --
 *
 * 컴파일 & 실행:
 *   javac 03_Operators.java
 *   java Operators
 */
class Operators {

    public static void main(String[] args) {
        printArithmetic();
        printComparison();
        printLogical();
        printCompound();
    }

    static void printArithmetic() {
        System.out.println("=== 산술 연산 ===");

        int a = 10;
        int b = 3;

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b) + "  ← 정수 나눗셈");
        System.out.println("a % b = " + (a % b) + "  ← 나머지");
        System.out.println();
    }

    static void printComparison() {
        System.out.println("=== 비교 연산 ===");

        int x = 5;
        int y = 10;

        System.out.println("x == y : " + (x == y));
        System.out.println("x != y : " + (x != y));
        System.out.println("x <  y : " + (x < y));
        System.out.println("x >  y : " + (x > y));
        System.out.println("x <= y : " + (x <= y));
        System.out.println("x >= y : " + (x >= y));
        System.out.println();
    }

    static void printLogical() {
        System.out.println("=== 논리 연산 ===");

        boolean p = true;
        boolean q = false;

        System.out.println("p && q : " + (p && q) + "  ← 둘 다 true여야 true");
        System.out.println("p || q : " + (p || q) + "  ← 하나만 true면 true");
        System.out.println("!p     : " + (!p));
        System.out.println();
    }

    static void printCompound() {
        System.out.println("=== 복합·증감 연산 ===");

        int n = 5;
        System.out.println("n = " + n);

        n += 2;
        System.out.println("n += 2  → " + n);

        System.out.println("n++     → " + (n++) + " (후위: 값 먼저, 증가는 나중)");
        System.out.println("n       → " + n);

        System.out.println("++n     → " + (++n) + " (전위: 증가 후 값)");
    }
}