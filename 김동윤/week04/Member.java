package week4;

public abstract class Member {
    String name;
    String major;
    int generation;
    String part;

    public Member(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }
    public boolean canSubmit() {
        return getPolicy().canSubmit();
    }

    abstract SubmissionPolicy getPolicy();

    abstract String getInfo();
}
