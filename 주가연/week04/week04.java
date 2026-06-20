package LikeLion;

import java.util.Scanner;

interface Submit {
    String canSubmit();
}

abstract class Member {
    protected String name;
    protected String major;
    protected String generation;
    protected String part;

    public Member(String name, String major, String generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public void getInfo() {}
}

class Lion extends Member implements Submit {
    private String stdID;

    public Lion(String name, String major, String generation, String part, String stdID) {
        super(name, major, generation, part);
        this.stdID = stdID;
    }

    @Override
    public String canSubmit() {
        return "가능";
    }

    @Override
    public void getInfo() {
        System.out.println("역할: 아기사자");
        System.out.println("이름: " + name + " | 전공: " + major + " | 기수: " + generation + " | 파트" + part);
        System.out.println("학번: " + stdID);
        System.out.println("과제 제출 가능 여부: " + canSubmit());
    }
}

class Staff extends Member implements Submit {
    private String role;

    public Staff(String name, String major, String generation, String part, String role) {
        super(name, major, generation, part);
        this.role = role;
    }

    @Override
    public String canSubmit() {
        return "불가능";
    }

    @Override
    public void getInfo() {
        System.out.println("역할: 운영진");
        System.out.println("이름: " + name + " | 전공: " + major + " | 기수: " + generation + " | 파트" + part);
        System.out.println("직책: " + role);
        System.out.println("과제 제출 가능 여부: " + canSubmit());
    }
}

public class week04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름: "); String LName = sc.next();
        System.out.print("전공: "); String Lmajor = sc.next();
        System.out.print("기수: "); String Lgen = sc.next();
        System.out.print("파트: "); String Lpart = sc.next();
        System.out.print("학번: "); String LID = sc.next();
        Member L = new Lion(LName, Lmajor, Lgen, Lpart, LID);

        System.out.print("이름: "); String SName = sc.next();
        System.out.print("전공: "); String Smajor = sc.next();
        System.out.print("기수: "); String Sgen = sc.next();
        System.out.print("파트: "); String Spart = sc.next();
        System.out.print("직책: "); String Srole = sc.next();
        Member S = new Lion(SName, Smajor, Sgen, Spart, Srole);

        System.out.println("====== 결과 출력 ======\n");
        L.getInfo();
        System.out.println("---------------------");
        S.getInfo();

        sc.close();
    }
}
