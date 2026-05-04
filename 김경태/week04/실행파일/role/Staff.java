package role;

import policy.StaffPolicy;

public class Staff extends Info {
    String position;

    public Staff(String name, String major, int num, String part, String position) {
        super(name, major, num, part);
        this.position = position;
    }

    @Override
    public Boolean Status() {
        StaffPolicy policy = new StaffPolicy();
        return policy.Status();
    }

    public void getStaff() {
        System.out.println("역할 : 운영진");
        System.out.println("이름 : " +getName() +" | 전공 : " +getMajor() +" | 기수 : "+getNum() +" | 파트 : " +getPart());
        System.out.println("직책 : "+ position);
        System.out.print("과제 제출 가능 여부 : ");
        ifStatus(Status());
        System.out.println("------------------");
    }
}
