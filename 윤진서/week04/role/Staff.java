package role;

import policy.StaffSubmissionPolicy;
import policy.SubmissionPolicy;

public class Staff extends Member {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    public SubmissionPolicy getSubmissionPolicy() {
        return new StaffSubmissionPolicy();
    }

    @Override
    public String getInfo() {
        return "역할:운영진\n"
                + "이름: " + getName()+"|"
                + "전공: " + getMajor()+"|"
                + "기수: " + getGeneration()+"|"
                + "파트: " + getPart()+"\n"
                + "직책: " + position;
    }
}