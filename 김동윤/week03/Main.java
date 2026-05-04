package week3;

public class Main {

    static class Book {
        String title;
        int price;

        Book(String title, int price) {
            this.title = title;
            this.price = price;
        }

        void displayInfo() {
            System.out.println("도서명: " + title + " | 가격: " + price + "원");
        }

        void displayInfo(String user) {
            System.out.println("[" + user + "님의 조회 결과] 도서명: " + title);
        }
    }

    public static void main(String[] args) {
        Book library[] = new Book[3];

        try {
            library[0] = new Book("사자의 정석", 30000);
            library[1] = new Book("멋사 입문", 22000);
            library[2] = new Book("멋대 가이드", 28000);

            System.out.println("===전체 도서 목록===");
            for (int i = 0; i < library.length; i++) {
                library[i].displayInfo();
            }

            System.out.println("\n===특정 사용자 맞춤 출력 (오버로딩)===");
            library[0].displayInfo("김동윤");

            System.out.println("\n===예외 발생 테스트===");
            library[5].displayInfo();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("경고: 배열의 크기를 벗어났습니다.");
        } catch (Exception e) {
            System.err.println("경고: 알 수 없는 오류가 발생했습니다. : " + e.getMessage());
        } finally {
            System.out.println("\n[시스템] 리소스 정리 후 프로그램을 종료합니다.");
        }
    }
}
