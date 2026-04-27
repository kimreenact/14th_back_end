import role.Lion;
import role.Role;
import role.Staff;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 아기사자 입력
        System.out.println("======== 아기사자 정보 입력 ========");
        System.out.print("이름: ");
        String lName = sc.nextLine();
        System.out.print("전공: ");
        String lMajor = sc.nextLine();
        System.out.print("기수: ");
        int lNum = Integer.parseInt(sc.nextLine());
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String lPart = sc.nextLine();
        System.out.print("학번: ");
        String studentId = sc.nextLine();

        // 운영진 입력
        System.out.println("\n======== 운영진 정보 입력 ========");
        System.out.print("이름: ");
        String sName = sc.nextLine();
        System.out.print("전공: ");
        String sMajor = sc.nextLine();
        System.out.print("기수: ");
        int sNum = Integer.parseInt(sc.nextLine());
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String sPart = sc.nextLine();
        System.out.print("직책 (대표/부대표/파트장/멘토): ");
        String position = sc.nextLine();

        // 추상 타입으로 관리
        Role[] members = {
                new Lion(lName, lMajor, lNum, lPart, studentId),
                new Staff(sName, sMajor, sNum, sPart, position)
        };

        // 결과 출력
        System.out.println("\n======== 결과 출력 ========");
        for (Role r : members) {
            System.out.println(r.getInfo());
            System.out.println("과제 제출 가능 여부: " + (r.canSubmitAssignment() ? "가능" : "불가능"));
            System.out.println();
        }

        sc.close();
    }
}