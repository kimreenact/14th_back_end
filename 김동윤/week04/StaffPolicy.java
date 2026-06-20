package week4;

public class StaffPolicy implements SubmissionPolicy{

    @Override
    public boolean canSubmit() {
        return false;
    }
}
