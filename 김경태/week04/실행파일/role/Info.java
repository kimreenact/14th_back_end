package role;

import java.util.Scanner;

abstract class Info {
    private String name;
    private String major;
    private int num;
    private String part;

    public Info(String name, String major, int num, String part) {
        this.name = name;
        this.major = major;
        this.num = num;
        this.part = part;
    }

    abstract Boolean Status();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    public String getPart() {
        return part;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public void ifStatus(Boolean status) {
        if (status==true) {
            System.out.println("가능");
        }
        else {
            System.out.println("불가능");
        }
    }
}
