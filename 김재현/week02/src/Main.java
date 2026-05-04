import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int total, attendees, absentees = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****아기사자 출석 명단입니다****");

        // 무한 루프
        while(true){
            //총원 구하기
            System.out.println("백엔드 세션 인원을 입력해주세요 : ");
            total = scanner.nextInt();

            //출석자 수 구하기
            System.out.println("출석자를 입력해주세요");
            attendees = scanner.nextInt();

            //결석자 수 구하기
            System.out.println("결석자 수를 입력해주세요");
            absentees = scanner.nextInt();

            if(attendees + absentees == total){
                if (attendees > absentees){
                    for (int i = 1; i <= attendees; i++){
                        System.out.println("현재 출석자 수: " + i);
                    }
                    System.out.println("출석자 수 가 결석자 수 보다 많습니다.");
                } else if (attendees == absentees){
                    System.out.println("출석자와 결석자 수가 같네요...");
                } else {
                    System.out.println("다음부터 더 재밌게 운영하세요.");
                }
                // 출석자 수 + 결석자 수 = 총원일 때 반복문 탈출하면서 프로그램 종료
                break;
            } else {
                // 프로그램 처음으로 돌아가 다시 질의
                System.out.println("총인원이 일치하지 않습니다.");
            }
        }
        //데이터 낭비 방지를 위해 입력문 닫기
        scanner.close();

    }
}