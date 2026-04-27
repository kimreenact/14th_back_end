import java.util.Scanner;

public abstract class Role {

    private String name;
    private String major;
    private int generation;
    private String part;
    private PolicyIF policy;

    public void inputInfo(Scanner sc) {
        System.out.print("👤 이름: ");
        this.name = sc.nextLine();
        System.out.print("🎓 전공: ");
        this.major = sc.nextLine();
        System.out.print("📌 기수: ");
        this.generation = Integer.parseInt(sc.nextLine());
        System.out.print("💻 파트 (백엔드/프론트엔드/풀스택): ");
        this.part = sc.nextLine();
        this.policy = getPolicy();
    }

    public abstract String getRole();

    protected abstract PolicyIF getPolicy();

    public abstract String getDetailInfo();

    public String getGenerationInfo() {
        return "👤 " + name + " (" + generation + "기)"
                + "\n📝 기수 조건 충족 여부: " + generationCheck(generation);
    }

    public String submitCheck() {
        return this.policy.submitCheck();
    }

    public String generationCheck(int generation) {
        return this.policy.generationCheck(generation);
    }

    protected String getName() {
        return name;
    }

    protected String getMajor() {
        return major;
    }

    protected int getGeneration() {
        return generation;
    }

    protected String getPart() {
        return part;
    }
}