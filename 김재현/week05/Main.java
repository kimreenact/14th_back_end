import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> hw = List.of("컬렉션 실습", "정렬 구현", "Map 활용");
        List<String> students = List.of("Alice", "Bob", "Charlie", "Diana");

        AssignmentTracker tracker = new AssignmentTracker(hw);
        tracker.submit("컬렉션 실습", "Alice");
        tracker.submit("컬렉션 실습", "Bob");
        tracker.submit("컬렉션 실습", "Alice"); // 중복 — 무시돼야 함
        tracker.submit("정렬 구현", "Charlie");

        tracker.printReport();
        System.out.println("미제출: " + tracker.getNotSubmitted("컬렉션 실습", students));
    }
}