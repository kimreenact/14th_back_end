package class3.role;

import class3.policy.AssignmentPolicy;
import class3.policy.StaffPolicy;

public class Staff extends Member {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    public AssignmentPolicy getPolicy() {
        return new StaffPolicy();
    }

    @Override
    public String getRoleInfo() {
        return "역할: 운영진\n" +
                "이름: " + getName() + " | 전공: " + getMajor() + " | 기수: " + getGeneration() + " | 파트: " + getPart() + "\n" +
                "직책: " + position;
    }
}