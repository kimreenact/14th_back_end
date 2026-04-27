import java.util.Scanner;

public class Lion extends Role {

    private int studentNum;

    @Override
    public void inputInfo(Scanner sc) {
        System.out.println("======= 🦁 아기사자 정보 입력 =======");
        super.inputInfo(sc);
        System.out.print("🆔 학번: ");
        this.studentNum = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String getRole() {
        return "아기사자";
    }

    @Override
    protected PolicyIF getPolicy() {
        return new LionPolicy();
    }

    @Override
    public String getDetailInfo() {
        return "🎭 역할: " + getRole()
                + "\n👤 이름: " + getName() + " | 🎓 전공: " + getMajor()
                + " | 📌 기수: " + getGeneration() + " | 💻 파트: " + getPart()
                + "\n🆔 학번: " + studentNum
                + "\n📝 과제 제출 가능 여부: " + submitCheck();
    }
}