package week5_2;

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

        System.out.println("===제출자 목록===");
        tracker.printReport();

        System.out.println("");
        System.out.println("===미제출자 목록===");
        System.out.println("컬렉션 실습: " + tracker.getNotSubmitted("컬렉션 실습", students));
        System.out.println("정렬 구현: " + tracker.getNotSubmitted("정렬 구현", students));
        System.out.println("Map 활용: " + tracker.getNotSubmitted("Map 활용", students));

        System.out.println("");
        System.out.println("===각 과목 제출률===");
        System.out.println("컬렉션 실습 제출률: "+tracker.getSubmissionRate("컬렉션 실습", students.size())+"%");
        System.out.println("정렬 구현 제출률: "+tracker.getSubmissionRate("정렬 구현", students.size())+"%");
        System.out.println("Map 활용 제출률: "+tracker.getSubmissionRate("Map 활용", students.size())+"%");
    }
}
