package role;

import policy.StaffSubmitPolicy;
import policy.SubmitPolicy;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int num, String part, String position) {
        super(name, major, num, part);
        this.position = position;
    }

    @Override
    public SubmitPolicy getPolicy() {
        return new StaffSubmitPolicy();
    }

    @Override
    public String getInfo() {
        return "역할: 운영진\n"
                + "이름: " + getName() + " | 전공: " + getMajor()
                + " | 기수: " + getNum() + " | 파트: " + getPart() + "\n"
                + "직책: " + position;
    }
}