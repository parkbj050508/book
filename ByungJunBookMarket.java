package bookmarket;
import java.util.Scanner;

public class ByungJunBookMarket {

    static String[][] bookList = {
            {"ID2401", "쉽게 배우는 자바 프로그래밍 2판", "우종정", "한빛아카데미", "20,000원"},
            {"ID2402", "코딩 자율학습 HTML+CSS+자바스크립트", "김기수", "길벗", "30,000원"},
            {"ID2403", "Do It! 자료구조와 함께 배우는 알고리즘 입문 - 자바편", "보요시바타", "이지스퍼블리싱", "25,000원"}
    };

    static int[] cartList = {0, 0, 0};
    static int numCartItem = 0;

    public static void main(String[] args) {
        displayWelcome();
        boolean bookTF = true;
        while (bookTF) {
            switch (menuGetNumber()) {
                case 1:
                    menuBookList();
                    break;
                case 2:
                    menuCartList();
                    break;
                case 3:
                    menuAddCartList();
                    break;
                case 4:
                    menuClearCart();
                    break;
                case 0:
                    menuExit();
                    bookTF = false;
                    break;
                default:
                    break;
            }
        }
    }

    static void displayWelcome() {
        System.out.println("*****************************************\r\n"
                + "*    Welcome to ByungJun Book Market    *\r\n" + "*****************************************");
    }

    static int menuGetNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================================\r\n" + "1. 도서 목록 보기\r\n" + "2. 장바구니 보기\r\n"
                + "3. 장바구니에 도서 추가\r\n" + "4. 장바구니 비우기\r\n" + "0. 종료\r\n"
                + "=========================================\r\n" + ">> 메뉴 선택 : ");
        return sc.nextInt();
    }

    static void menuExit() {
        System.out.println("ByungJun Book Market을 종료합니다. ");
    }

    static void menuBookList() {
        System.out.println(">> 도서 목록\r\n" + "------------------------------------------------------------------------");
        for (int i = 0; i < bookList.length; i++) {
            System.out.printf("%s. %s (%s원)\n", bookList[i][0], bookList[i][1], bookList[i][4]);
        }
        System.out.println("------------------------------------------------------------------------");
    }

    static void menuCartList() {
        System.out.println(">> 장바구니 보기\r\n" + "------------------------------------------------------------------------");
        for (int i = 0; i < cartList.length; i++) {
            if (cartList[i] > 0) {
                System.out.printf("%s. %s (%s원)\n", bookList[i][0], bookList[i][1], bookList[i][4]);
            }
        }
        System.out.println("------------------------------------------------------------------------");
    }

    static void menuAddCartList() {
        Scanner sc = new Scanner(System.in);
        System.out.println(">> 도서 목록");
        menuBookList();
        System.out.println("장바구니에 추가할 도서의 ID를 입력하세요: ");
        String bookID = sc.next();
        boolean found = false;
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i][0].equals(bookID)) {
                cartList[i]++;
                found = true;
                System.out.println("장바구니에 도서가 추가되었습니다.");
                break;
            }
        }
        if (!found) {
            System.out.println("해당 ID의 도서를 찾을 수 없습니다.");
        }
    }

    static void menuClearCart() {
        for (int i = 0; i < cartList.length; i++) {
            cartList[i] = 0;
        }
        System.out.println("장바구니가 비워졌습니다.");
    }
}
