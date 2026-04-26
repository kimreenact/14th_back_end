package class3.policy;

public class StaffPolicy implements AssignmentPolicy {
    @Override
    public boolean canSubmit() {
        return false;
    }
}