import role.Lion;
import role.Role;
import role.Staff;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===아기사자 정보 입력 ===");

        System.out.print("이름 :");
        String name = scanner.next();

        System.out.print("전공 :");
        String major = scanner.next();

        System.out.print("기수 :");
        int generation = scanner.nextInt();

        System.out.print("파트 (프론트/백엔드/풀스텍):");
        String part = scanner.next();

        System.out.print("학번 :");
        String studentId = scanner.next();

        Role lion = new Lion(name, major, generation, part, studentId);

        System.out.println();
        System.out.println("=== 운영진 정보 입력 ===");

        System.out.print("이름: ");
        name = scanner.next();

        System.out.print("전공: ");
        major = scanner.next();

        System.out.print("기수: ");
        generation = scanner.nextInt();

        System.out.print("파트 (프론트/백엔드/풀스텍): ");
        part = scanner.next();

        System.out.print("직책 (대표/파트장/멘토): ");
        String position = scanner.next();

        Role staff = new Staff(name, major, generation, part, position);
        scanner.close();

        System.out.println();
        System.out.println("=== 결과 출력 ===");

        System.out.println(lion.getInfo());
        System.out.println();

        System.out.println(staff.getInfo());



    }
}