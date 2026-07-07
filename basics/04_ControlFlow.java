/**
 * 04 — 제어문
 *
 * [if / else]     조건이 true일 때 분기
 * [switch]        값에 따라 여러 갈래 중 하나 실행 (case / break)
 * [for]           횟수·범위가 정해진 반복
 * [while]         조건이 true인 동안 반복 (선 검사)
 * [do-while]      한 번 실행 후 조건 검사 (후 검사)
 *
 * 컴파일 & 실행:
 *   javac 04_ControlFlow.java
 *   java ControlFlow
 */
class ControlFlow {

    public static void main(String[] args) {
        printIfElse();
        printSwitch();
        printFor();
        printWhile();
        printDoWhile();
    }

    static void printIfElse() {
        System.out.println("=== if / else ===");

        int score = 85;

        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B  ← score=" + score);
        } else {
            System.out.println("C 이하");
        }
        System.out.println();
    }

    static void printSwitch() {
        System.out.println("=== switch ===");

        int day = 3;
        String dayName;

        switch (day) {
            case 1:
                dayName = "월";
                break;
            case 2:
                dayName = "화";
                break;
            case 3:
                dayName = "수";
                break;
            default:
                dayName = "기타";
        }

        System.out.println("day=" + day + " → " + dayName);
        System.out.println();
    }

    static void printFor() {
        System.out.println("=== for ===");

        System.out.print("1~5: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
    }

    static void printWhile() {
        System.out.println("=== while ===");

        int count = 1;
        System.out.print("count 1→3: ");
        while (count <= 3) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();
        System.out.println();
    }

    static void printDoWhile() {
        System.out.println("=== do-while ===");

        int n = 1;
        System.out.print("최소 1회 실행: ");
        do {
            System.out.print(n + " ");
            n++;
        } while (n <= 3);
        System.out.println();
    }
}