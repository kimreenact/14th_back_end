package LIkeLion;

import java.util.Scanner; //python하고는 다르게 자바는 신고식을 함(입력의 출처를 분명하게 하려고)

public class Week2Advanced {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //in --> standard input(키보드로 입력하겠다는 말)
        //Scanner -> class 와 같은 거(입력 받을 수 있음) . scanner -> 변수명. new Scanner -> 새로운 Scanner 생성, (이제 sysetm.in 인 Scanner)

        System.out.println("*****아기사자 출석 명단입니다****");

        //총원 구하기
        System.out.print("백엔드 세션 인원을 입력해주세요: ");
        int total = scanner.nextInt();

        //출석자 수 구하기
        System.out.print("출석자를 입력해주세요: ");
        int presentee = scanner.nextInt();

        //결석자 수 구하기
        System.out.print("결석자 수를 입력해주세요: ");
        int absentee = scanner.nextInt();


        if (presentee > absentee){
            for(int i = 1; i <= presentee; i++){
                //i 는 iteration 의 약자, 시작점 초기식 int i=1, 도착점 조건식(i가 참석자값과 같아질 떄까지)으로 설정.
                // 이후 증감식으로 1씩 증가 이후 i>presentee 가 되기 전까지 실행, 넘으면 탈출

                System.out.println("현재 출석자 수: " + i);
                /* System.out.println("현재 출석자 수: " + i);
                +i 가 없으면 "현재 출석자 수"를 for 에서 i 번 반복한 횟수만큼 반복이 됨
                ex. 현재 출석자 수: 1 / 현재 출석자 수: 2 / 현재 출석자 수: 3 ....
                    i 가 없으면. 현재 출석자수: / 현재 출석자 수: / 현재 출석자 수:
                현재 코드에서 없어도 될 것 같습니다.
                 */
            }
            System.out.println("-----------------------------------"); //있는게 결과값을 보기  더 편해보여서....
            System.out.println("출석자 수 가 결석자 수 보다 많습니다.");
        }
        else if (presentee == absentee) {
            System.out.println("-----------------------------------");
            System.out.println("결석자와 결석자 수가 같네요... 잡아오세요");
        }
        else {
            //예외처리
            System.out.println("-----------------------------------");
            System.out.println("다음부터 더 재밌게 운영하세요.");
        }

        //데이터 낭비 방지를 위해 입력문 닫기
        scanner.close();
    }
}
