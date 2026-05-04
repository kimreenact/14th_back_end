import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//      초급
        /*

        Scanner scanner = new Scanner(System.in);
        System.out.println("*****아기사자 출석 명단입니다****");
        //총원 구하기
        System.out.println("백엔드 세션 인원을 입력해주세요 : ");
        int all = scanner.nextInt();

        //출석자 수 구하기
        System.out.println("출석자 수를 입력해주세요");
        int attendee = scanner.nextInt();


        //결석자 수 구하기
        System.out.println("결석자 수를 입력해주세요");
        int absentee = scanner.nextInt();

        if (attendee > absentee){
            System.out.println("출석자 수 가 결석자 수 보다 많습니다.");
        }else if(attendee == absentee){
            System.out.println("출석자와 결석자 수가 같네요...");
        }else{
            System.out.println("다음부터 더 재밌게 운영하세요.");
        }

        //데이터 낭비 방지를 위해 입력문 닫기
        scanner.close();

         */

//       고급
        Scanner scanner = new Scanner(System.in);

        System.out.println("*****아기사자 출석 명단입니다****");
        //총원 구하기
        System.out.println("백엔드 세션 인원을 입력해주세요 : ");
        int all = scanner.nextInt();


        //출석자 수 구하기
        System.out.println("출석자를 입력해주세요");
        int attendee = scanner.nextInt();


        //결석자 수 구하기
        System.out.println("결석자 수를 입력해주세요");
        int absentee = scanner.nextInt();


        if (attendee > absentee){
            for(int i = 1; i<=attendee; i++){
                System.out.println("현재 출석자 수: " + i);
            }
            System.out.println("출석자 수 가 결석자 수 보다 많습니다.");
        } else if(absentee == attendee) {
            System.out.println("출석자와 결석자 수가 같네요...");
        } else{
            System.out.println("다음부터 더 재밌게 운영하세요.");
        }


        //데이터 낭비 방지를 위해 입력문 닫기
        scanner.close();


    }
}