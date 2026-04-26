package class3.policy;

public class LionPolicy implements AssignmentPolicy {
    @Override
    public boolean canSubmit() {
        return true;
    }
}