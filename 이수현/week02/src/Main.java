import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Scanner 사용해서 사용자에게 입력받기.
        System.out.println("*****아기사자 출석 명단입니다****");

        System.out.println("백엔드 세션 인원을 입력해주세요 : ");
        int back_num = scanner.nextInt(); // 백엔드 세션 총 인원


        System.out.println("출석자를 입력해주세요");
        int att = scanner.nextInt(); // 참석자 수 입력


        System.out.println("결석자 수를 입력해주세요");
        int abs = scanner.nextInt(); // 결석자 수 입력하기

        if (att > abs){ // if구분 사용하기
            for(int i=0; i<=att;i++){ //for문 사용해서 현재 출석자 수 입력받기
                System.out.println("현재 출석자 수: " + i);
            }
            System.out.println("출석자 수 가 결석자 수 보다 많습니다.");
        }
        else if(att == abs){
            System.out.println("출석자와 결석자 수가 같네요...");
        }
        else{ // 결석자가 참석자 보다 큰 경우 else if(att<abs){ } <- else if를 사용했을때
            System.out.println("다음부터 더 재밌게 운영하세요.");
        }


        //데이터 낭비 방지를 위해 입력문 닫기
        scanner.close();

    }
}