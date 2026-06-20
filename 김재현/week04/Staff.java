import java.util.Scanner;

public class Staff extends Role {

    private String position;

    @Override
    public void inputInfo(Scanner sc) {
        System.out.println("======= 🙎‍♂️ 운영진 정보 입력 =======");
        super.inputInfo(sc);
        System.out.print("⭐️ 직책 (대표/파트장/멘토): ");
        this.position = sc.nextLine();
    }

    @Override
    public String getRole() {
        return "운영진";
    }

    @Override
    protected PolicyIF getPolicy() {
        return new StaffPolicy();
    }

    @Override
    public String getDetailInfo() {
        return "🎭 역할: " + getRole()
                + "\n👤 이름: " + getName() + " | 🎓 전공: " + getMajor()
                + " | 📌 기수: " + getGeneration() + " | 💻 파트: " + getPart()
                + "\n⭐️ 직책: " + position
                + "\n📝 과제 제출 가능 여부: " + submitCheck();
    }
}