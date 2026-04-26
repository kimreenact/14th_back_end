package class3.policy;

//정책을 클래스 내부에서 결정하지 않고 외부 인터페이스로 분리
public interface AssignmentPolicy {
    boolean canSubmit();
}