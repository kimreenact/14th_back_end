import role.Lion;
import role.Staff;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=====아기사자 정보 입력=====");
        System.out.print("이름 : ");
        String name = input.next();
        System.out.print("전공 : ");
        String major = input.next();
        System.out.print("기수 : ");
        int num = input.nextInt();
        System.out.print("파트 (백엔드/프론트엔드/풀스택) : ");
        String part = input.next();
        System.out.print("학번 : ");
        int id = input.nextInt();
        Lion lion = new Lion(name, major, num, part, id);

        System.out.println();
        System.out.println("=====운영진 정보 입력=====");
        System.out.print("이름 : ");
        String staffName = input.next();
        System.out.print("전공 : ");
        String staffMajor = input.next();
        System.out.print("기수 : ");
        int staffNum = input.nextInt();
        System.out.print("파트 (백엔드/프론트엔드/풀스택) : ");
        String staffPart = input.next();
        System.out.print("직책 (대표/부대표/파트장/멘토) : ");
        String staffPosition =  input.next();
        Staff staff = new Staff(staffName, staffMajor, staffNum, staffPart, staffPosition);


        System.out.println("=====결과 출력=====");
        System.out.println();
        lion.getLion();
        staff.getStaff();

        input.close();
    }
}