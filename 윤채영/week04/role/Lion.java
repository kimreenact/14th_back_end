package role;
import policy.LionPolicy;
import policy.Policy;

public class Lion extends Role{
    private String studentId;
    public Lion(String name,String major, int generation, String part,String studentId){
        super(name, major, generation, part);
        this.studentId = studentId;
    }
    @Override
    protected Policy getPolicy(){
        return new LionPolicy();
    }

    @Override
    public String getInfo() {
        String canSubmit;

        if (submit()) {
            canSubmit = "가능";
        } else {
            canSubmit = "불가능";
        }

        return "역할: 아기사자\n" +
                getCommonInfo() + "\n" +
                "학번: " + studentId + "\n" +
                "과제 제출 가능 여부: " + canSubmit;
    }

}
