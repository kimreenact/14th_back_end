package policy;

public class StaffSubmitPolicy implements SubmitPolicy {
    @Override
    public boolean canSubmit() {
        return false;
    }
}