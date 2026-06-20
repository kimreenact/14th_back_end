package week4;

public class Lion extends Member{
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }


    @Override
    SubmissionPolicy getPolicy() {
        return new LionPolicy();
    }

    @Override
    public String getInfo() {
        return "[아기사자] 이름: " + name + ", 전공: " + major
                + ", 기수: " + generation + ", 파트: " + part
                + ", 학번: " + studentId;
    }
}
