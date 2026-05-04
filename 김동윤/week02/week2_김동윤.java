package main;

import java.util.Scanner;

public class week2_김동윤_고급 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //변수 선언
        int member, attendee;


        System.out.println("아기사자 출석 명단");
        System.out.println("백엔드 세션 인원을 입력해주세요 : ");
        member = sc.nextInt();

        System.out.println("출석자 수를 입력해주세요 :");
        attendee = sc.nextInt();

        while (member != attendee) {
            if (member > attendee) {
                System.out.println("아직 전인원이 오지 않았습니다. 추가로 온 인원수를 적어주세요. : ");
                attendee += sc.nextInt();

                int latecomer = member - attendee;
                System.out.println("현재 출석자 수: " + attendee + "명, " + "결석자 수: " + latecomer + "명");
            } else {
                System.out.println("출석명단보다 참석자가 많다..? 귀신..?");
                break;
            }
        }

        if (member == attendee) {
            System.out.println("현재 출석자 수: " + attendee + "명, " + "결석자 수: 0명");
            System.out.println("수업을 시작합니다.");
        }
    }
}
