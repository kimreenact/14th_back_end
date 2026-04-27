package role;

import policy.SubmitPolicy;

public abstract class Role {
    private String name;
    private String major;
    private int num;
    private String part;

    public Role(String name, String major, int num, String part) {
        this.name  = name;
        this.major = major;
        this.num   = num;
        this.part  = part;
    }

    public String getName()  { return name; }
    public String getMajor() { return major; }
    public int    getNum()   { return num; }
    public String getPart()  { return part; }

    public abstract SubmitPolicy getPolicy();

    public boolean canSubmitAssignment() {
        return getPolicy().canSubmit();
    }

    public abstract String getInfo();
}