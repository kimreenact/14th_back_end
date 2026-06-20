package week4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ── 아기사자 입력 ──────────────────────────────
        System.out.println("=== 아기사자 정보 입력 ===");
        System.out.print("이름: ");       String lionName  = sc.nextLine();
        System.out.print("전공: ");       String lionMajor = sc.nextLine();
        System.out.print("기수: ");       int lionGen      = Integer.parseInt(sc.nextLine());
        System.out.print("파트: ");       String lionPart  = sc.nextLine();
        System.out.print("학번: ");       String studentId = sc.nextLine();

        // ── 운영진 입력 ──────────────────────────────
        System.out.println("\n=== 운영진 정보 입력 ===");
        System.out.print("이름: ");       String staffName  = sc.nextLine();
        System.out.print("전공: ");       String staffMajor = sc.nextLine();
        System.out.print("기수: ");       int staffGen      = Integer.parseInt(sc.nextLine());
        System.out.print("파트: ");       String staffPart  = sc.nextLine();
        System.out.print("직책: ");       String position   = sc.nextLine();

        sc.close();

        // ── 객체 생성 (추상 클래스 타입으로 다룸) ─────
        Member lion  = new Lion(lionName,  lionMajor,  lionGen,  lionPart,  studentId);
        Member staff = new Staff(staffName, staffMajor, staffGen, staffPart, position);

        // ── 출력 ─────────────────────────────────────
        System.out.println("\n=== 결과 출력 ===");
        System.out.println(lion.getInfo());
        System.out.println("과제 제출 가능 여부: " + lion.canSubmit());

        System.out.println();
        System.out.println(staff.getInfo());
        System.out.println("과제 제출 가능 여부: " + staff.canSubmit());
    }
}