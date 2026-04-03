public class Main {

    // 1. 클래스(Class) & 필드(Field): Main 클래스 내부에 선언된 정적 내부 클래스
    static class Book {
        String title;
        int price;
        // 2. 생성자(Constructor): 객체 생성 시 필드 초기화
        Book(String title, int price) {
            this.title = title;
            this.price = price;
        }
        // 3. 메서드(Method): 도서 정보 출력
        void displayInfo() {
            System.out.println("도서명: " + title + " | 가격: " + price + "원");
        }
        // 4. 메서드 오버로딩(Method Overloading): 매개변수가 다른 동일 이름의 메서드
        void displayInfo(String user) {
            System.out.println("[" + user + "님의 조회 결과] 도서명: " + title);
        }
    }

    public static void main(String[] args) {
        // 5. 배열(Array): 객체를 담을 수 있는 저장 공간 생성
        Book[] library = new Book[3];
        // 6. 예외 처리(Exception Handling): 런타임 에러 방지
        try {
            // 7. 객체(Object): 클래스라는 설계도로 실제 데이터 생성
            library[0] = new Book("사자의 정석", 30000);
            library[1] = new Book("멋사 입문", 22000);
            library[2] = new Book("멋대 가이드", 28000);

            System.out.println("=== 전체 도서 목록 ===");
            for (int i = 0; i < library.length; i++) {
                library[i].displayInfo(); // 일반 메서드 호출
            }

            System.out.println("\n=== 특정 사용자 맞춤 출력 (오버로딩) ===");
            library[0].displayInfo("김재현");

            // 예외 발생 유도: 존재하지 않는 5번 인덱스 접근
            System.out.println("\n=== 예외 발생 테스트 ===");
            System.out.println(library[5].title);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("경고: 배열의 크기를 벗어난 접근입니다. (Index Error)");
        } catch (Exception e) {
            System.err.println("경고: 알 수 없는 오류가 발생했습니다.");
        } finally {
            System.out.println("\n[시스템] 리소스 정리 후 프로그램을 종료합니다.");
        }
    }
}