package class3;

import class3.role.Member;
import class3.role.Lion;
import class3.role.Staff;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("====== 아기사자 정보 입력 ======");
        System.out.print("이름: ");
        String lionName = scanner.nextLine();
        System.out.print("전공: ");
        String lionMajor = scanner.nextLine();
        System.out.print("기수: ");
        int lionGen = scanner.nextInt();
        // 개행 문자 비우기
        scanner.nextLine();
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String lionPart = scanner.nextLine();
        System.out.print("학번: ");
        String lionId = scanner.nextLine();

        System.out.println("\n====== 운영진 정보 입력 ======");
        System.out.print("이름: ");
        String staffName = scanner.nextLine();
        System.out.print("전공: ");
        String staffMajor = scanner.nextLine();
        System.out.print("기수: ");
        int staffGen = scanner.nextInt();
        // 개행 문자 비우기
        scanner.nextLine();
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String staffPart = scanner.nextLine();
        System.out.print("직책 (대표/부대표/파트장/멘토): ");
        String staffPosition = scanner.nextLine();

        System.out.println("\n====== 결과 출력 ======\n");

        //사자 객체와 운영진 객체를 모두 Member라는 동일한 타입으로 제어
        Member member1 = new Lion(lionName, lionMajor, lionGen, lionPart, lionId);
        Member member2 = new Staff(staffName, staffMajor, staffGen, staffPart, staffPosition);

        //출력 메서드 하나에 사자든 운영진이든 집어넣으면 스스로 알아서 작동
        printMemberStatus(member1);
        printMemberStatus(member2);

        scanner.close();
    }

    public static void printMemberStatus(Member member) {
        // 객체 스스로 문자열을 조립하게 시킴(getRoleInfo)
        System.out.println(member.getRoleInfo());

        // 객체 스스로 정책 객체를 통해 가능 여부를 판단하게 시킴(canSubmitAssignment)
        String submitStatus = member.canSubmitAssignment() ? "가능" : "불가능";
        System.out.println("과제 제출 가능 여부: " + submitStatus);
        System.out.println("------------------------");
    }
}