import java.util.Scanner;

public class Alumni extends Role {

    private String job;

    @Override
    public void inputInfo(Scanner sc) {
        System.out.println("======= 🎓 알럼나이 정보 입력 =======");
        super.inputInfo(sc);
        System.out.print("💼 현재 직무: ");
        this.job = sc.nextLine();
    }

    @Override
    public String getRole() {
        return "알럼나이";
    }

    @Override
    protected PolicyIF getPolicy() {
        return new AlumniPolicy(getGeneration());
    }

    @Override
    public String getDetailInfo() {
        return "🎭 역할: " + getRole()
                + "\n👤 이름: " + getName() + " | 🎓 전공: " + getMajor()
                + " | 📌 기수: " + getGeneration() + " | 💻 파트: " + getPart()
                + "\n💼 현재 직무: " + job
                + "\n📝 과제 제출 가능 여부: " + submitCheck();
    }
}