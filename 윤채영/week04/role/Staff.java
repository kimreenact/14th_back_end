package role;

import policy.Policy;
import policy.StaffPolicy;
public class Staff extends Role{
    private String position;
    public Staff(String name,String major, int generation, String part,String position){
        super(name, major, generation, part);
        this.position = position;
    }
    @Override
    protected Policy getPolicy(){
        return new StaffPolicy();
    }

    @Override
    public String getInfo() {
        String canSubmit;

        if (submit()) {
            canSubmit = "가능";
        } else {
            canSubmit = "불가능";
        }

        return "역할: 운영진\n" +
                getCommonInfo() + "\n" +
                "직책: " + position + "\n" +
                "과제 제출 가능 여부: " + canSubmit;
    }

}
