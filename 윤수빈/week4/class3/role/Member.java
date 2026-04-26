package class3.role;

import class3.policy.AssignmentPolicy;

public abstract class Member {
    //캡슐화 - 자식 클래스라도 부모의 필드에 직접 접근해 값을 바꾸지 못하도록 막기
    private String name;
    private String major;
    private int generation;
    private String part;

    public Member(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    //Getter 메서드 - 필드가 private이므로 자식 클래스가 값을 읽을 수 있게 하기
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }

    public abstract AssignmentPolicy getPolicy();

    //판단 로직 - Main에서 if문으로 묻지 않고 객체가 스스로 Policy에게 물어보고 대답
    public boolean canSubmitAssignment() {
        return getPolicy().canSubmit();
    }

    public abstract String getRoleInfo();
}