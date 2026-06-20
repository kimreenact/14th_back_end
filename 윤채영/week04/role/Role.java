package role;

import policy.Policy;
public abstract class Role {

    private String name;
    private String major;
    private int generation;
    private String part;
    public Role(String name,String major, int generation, String part){
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    protected abstract Policy getPolicy();
    public boolean submit(){
        return getPolicy().submit();
    }

    public abstract String getInfo();
    protected String getCommonInfo() {
        return "이름: " + name +
                ", 전공: " + major +
                ", 기수: " + generation +
                ", 파트: " + part;
    }


}
