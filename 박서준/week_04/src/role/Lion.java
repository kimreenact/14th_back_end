package role;

import policy.LionSubmitPolicy;
import policy.SubmitPolicy;

public class Lion extends Role {
    private String studentId;

    public Lion(String name, String major, int num, String part, String studentId) {
        super(name, major, num, part);
        this.studentId = studentId;
    }

    @Override
    public SubmitPolicy getPolicy() {
        return new LionSubmitPolicy();
    }

    @Override
    public String getInfo() {
        return "역할: 아기사자\n"
                + "이름: " + getName() + " | 전공: " + getMajor()
                + " | 기수: " + getNum() + " | 파트: " + getPart() + "\n"
                + "학번: " + studentId;
    }
}