/*
<mini_project>
  /basic에서 배운 내용을 활용하여 프로그램을 작성하세요.

  
  아래 메뉴 번호를 사용자로부터 입력받아 처리하는 프로그램을 작성하세요.
    1. 책 정보를 출력한다.
    2. 책 가격 순으로 정렬한다.
    3. 책 제목을 입력받아 검색한 결과를 출력한다
    4. 0입력 받았을 시 프로그램 종료, 그전까지는 메뉴를 반복해서 보여주고, 메뉴 번호를 입력받아 처리한다.


    책 정보 테이블
    제목 | 저자 | 가격
    --------------------
    Java | 김철수 | 10000
    C | 박민수 | 30000
    PHP | 최영희 | 40000
    Python | 이영희 | 20000
    JavaScript | 이영희 | 50000
    Ruby | 박민수 | 60000
    Go | 박민수 | 90000
    Swift | 최영희 | 70000
    Kotlin | 이영희 | 80000
</mini_project>

*/
import java.util.Scanner;

// class bookTable {
//     String title;
//     String author;
//     int price;

//     bookTable(String title, String author, int price) {
//         this.title = title;
//         this.author = author;
//         this.price = price;
//     }
// }

class MiniProject {
    public static void main(String[] args) {
        String[] titles = {"Java", "Python", "C", "PHP", "JavaScript", "Ruby", "Swift", "Kotlin", "Go"};
        String[] authors = {"김철수", "이영희", "박민수", "최영희", "이영희", "박민수", "최영희", "이영희", "박민수"};
        int[] prices = {40000, 50000, 30000, 10000, 90000, 60000, 70000, 80000, 20000};

        // 여기에 코드를 작성하세요.
        System.out.println("=== 책 정보 프로그램 ===");
        System.out.println("1. 책 정보를 출력한다.");
        System.out.println("2. 책 가격 순으로 정렬한다.");
        System.out.println("3. 책 제목을 입력받아 검색한 결과를 출력한다.");
        System.out.println("0. 프로그램 종료");
        
        System.out.print("메뉴 번호를 입력하세요 (1, 2, 3, 0): ");

        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();

        while (menu != 0) {
            if (menu == 1) {
            printBookInfo(titles, authors, prices);
        } else if (menu == 2) {
            sortBooksByPrice(titles, authors, prices);
        } else if (menu == 3) {
            searchBookByTitle(scanner, titles, authors, prices);
        } else if (menu == 0) {
            System.out.println("프로그램을 종료합니다.");
            break;
        } else {
            System.out.println("잘못된 메뉴 번호입니다.");
        }
        System.out.print("메뉴 번호를 입력하세요 (1, 2, 3, 0): ");
        menu = scanner.nextInt();
        }
        
    }

    static void printBookInfo(String[] titles, String[] authors, int[] prices) {
        System.out.println("=== 책 정보 ===");
        System.out.println("제목\t저자\t가격");
        System.out.println("--------------------");

        for (int i = 0; i < titles.length; i++) {
            System.out.println(titles[i] + "\t" + authors[i] + "\t" + prices[i]);
        }
    }

    static void sortBooksByPrice(String[] titles, String[] authors, int[] prices) {
        System.out.println("=== 책 가격 순으로 정렬 ===");
        // 여기에 가격 순으로 정렬하는 코드를 작성하세요.
        for(int i = 0; i < prices.length - 1; i++) {
            for(int j = 0; j < prices.length - 1 - i; j++) {
                if(prices[j] > prices[j + 1]) {
                    // 가격 교환
                    int tempPrice = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = tempPrice;

                    // 제목 교환
                    String tempTitle = titles[j];
                    titles[j] = titles[j + 1];
                    titles[j + 1] = tempTitle;

                    // 저자 교환
                    String tempAuthor = authors[j];
                    authors[j] = authors[j + 1];
                    authors[j + 1] = tempAuthor;
                }
            }
        }
        printBookInfo(titles, authors, prices);
        // 예: Arrays.sort(prices);
        // 정렬 후 책 정보를 출력하세요.
    }

    static void searchBookByTitle(Scanner scanner, String[] titles, String[] authors, int[] prices) {
        System.out.print("검색할 책 제목을 입력하세요: ");
        String searchTitle = scanner.next();

        boolean found = false;
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].equalsIgnoreCase(searchTitle)) {
                System.out.println("=== 검색 결과 ===");
                System.out.println("제목: " + titles[i]);
                System.out.println("저자: " + authors[i]);
                System.out.println("가격: " + prices[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("검색 결과가 없습니다.");
        }
    }
}