package role;

import policy.LionPolicy;

public class Lion extends Info {
    int id;

    public Lion(String name, String major, int num, String part, int id) {
        super(name, major, num, part);
        this.id = id;
    }

    @Override
    public Boolean Status() {
        LionPolicy policy = new LionPolicy();
        return policy.Status();
    }

    public void getLion() {
        System.out.println("역할 : 아기사자");
        System.out.println("이름 : " +getName() +" | 전공 : " +getMajor() +" | 기수 : "+getNum() +" | 파트 : " +getPart());
        System.out.println("학번 : "+ id);
        System.out.print("과제 제출 가능 여부 : ");
        ifStatus(Status());
        System.out.println("------------------");
    }
}
