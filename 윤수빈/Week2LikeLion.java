import java.util.Scanner; //scanner를 가져온다는 느낌

public class Week2LikeLion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Scanner라는 도구로 새 Scanner를 만들고 키보드(System.in)에 연결

        System.out.println("***** 아기사자 출석 명단입니다 *****");

        // 1. 총원, 출석자 결석자 수 받기
        //총원 구하기
        System.out.print("백엔드 세션 총 인원을 입력해주세요: "); //println 과 달리 줄을 바꾸지 않음 --> 바로 총원 값을 받으려고 사용하는 거임
        int total = scanner.nextInt(); //숫자니까 nextInt() 사용 경우에 따라 next() or nextLine()

        //출석자 수 구하기
        System.out.print("출석자 수를 입력해주세요: "); //얘도 총인원 값 받는 것처럼 동일함
        int presentee = scanner.nextInt();

        //결석자 수 구하기
        System.out.print("결석자 수를 입력해주세요: ");
        int absentee = scanner.nextInt(); // 출석자 수와 같은 방식, 변수 선언&초기화

        //if-else 조건문 이용해서 3가지 상황 정하기
        if (presentee > absentee) {
            // 조건확인하는 거 p>a 면 {] 안에 코드 실행
            // 1. 참석자가 결석자보다 많은 경우
            System.out.println("출석자 수가 결석자 수보다 많습니다."); // 얘는 수 입력하는 거랑 다르게 줄을 바꿈

        } else if (presentee == absentee) {
            // 2. 참석자와 결석자 수가 같은 경우
            System.out.println("출석자와 결석자 수가 같네요... 빨리 잡아오세요.");
            // 조건문 = 는 대입 ==는 비교

        } else {
            // 3.결석자가 더 많은 경우(둘 다 아닌 경우)
            System.out.println("결석자가 더 많습니다. 다음부터 더 재밌게 운영하세요.");
        } // 조건문 종료
        scanner.close();  //데이터 낭비 방지를 위해 입력문 닫기 --> 메모리 낭비 막아줌
    } // main시작점 끝
} //class 종료
