package week4;

public class Staff extends Member{
    String position;
    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }


    @Override
    SubmissionPolicy getPolicy() {
        return new StaffPolicy();
    }

    @Override
    public String getInfo() {
        return "[운영진] 이름: " + name + ", 전공: " + major
                + ", 기수: " + generation + ", 파트: " + part
                + ", 직책: " + position;
    }
}
