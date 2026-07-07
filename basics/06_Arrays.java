/**
 * 06 — 배열
 *
 * [1차원 배열] 같은 타입 값을 순서대로 저장
 * [다차원 배열] 배열 안에 배열 저장 (예: int[][])
 * [length] 배열 길이(읽기 전용)
 *
 * 컴파일 & 실행:
 *   javac 06_Arrays.java
 *   java ArraysDemo
 */
class ArraysDemo {

    public static void main(String[] args) {
        printOneDimensional();
        printMultiDimensional();
    }

    static void printOneDimensional() {
        System.out.println("=== 1차원 배열 ===");

        int[] numbers = {10, 20, 30, 40};
        System.out.println("length = " + numbers.length);
        System.out.println("numbers[0] = " + numbers[0]);
        System.out.println("numbers[2] = " + numbers[2]);

        System.out.print("전체 순회: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    static void printMultiDimensional() {
        System.out.println("=== 2차원 배열 ===");

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println("행(row) 수 = " + matrix.length);
        System.out.println("열(col) 수 = " + matrix[0].length);
        System.out.println("matrix[1][2] = " + matrix[1][2]);

        System.out.println("전체 출력:");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}