import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Role lion = new Lion();
        Role staff = new Staff();
        Role alumni = new Alumni();

        lion.inputInfo(sc);
        staff.inputInfo(sc);
        alumni.inputInfo(sc);

        outputInfo(lion, staff, alumni);
        sc.close();
    }

    public static void outputInfo(Role lion, Role staff, Role alumni) {
        System.out.println();
        System.out.println("======= 📋 결과 출력 =======");
        System.out.println(lion.getDetailInfo());
        System.out.println("--------------------------");
        System.out.println(staff.getDetailInfo());
        System.out.println("--------------------------");
        System.out.println(alumni.getDetailInfo());
        System.out.println("======= 🔍 조건 정책 결과 =======");
        System.out.println();
        System.out.println("📌 최소 기수 조건: 14기 이상");
        System.out.println();
        System.out.println(lion.getGenerationInfo());
        System.out.println("--------------------------");
        System.out.println(staff.getGenerationInfo());
        System.out.println("--------------------------");
        System.out.println(alumni.getGenerationInfo());
        System.out.println("--------------------------");
    }
}