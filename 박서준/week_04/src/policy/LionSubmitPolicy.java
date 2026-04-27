package policy;

public class LionSubmitPolicy implements SubmitPolicy {
    @Override
    public boolean canSubmit() {
        return true;
    }
}