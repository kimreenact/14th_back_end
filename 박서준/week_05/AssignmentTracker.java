package week_05;

import java.util.*;

public class AssignmentTracker {
    private List<String> assignments;
    private Map<String, Set<String>> submissions;

    public AssignmentTracker(List<String> assignments) {
        this.assignments = new ArrayList<>(assignments);
        this.submissions = new HashMap<>();
        // 각 과제에 빈 Set 초기화
        for (String a : assignments) {
            submissions.put(a, new HashSet<>());
        }
    }

    public void submit(String assignment, String student) {
        // TODO: submissions에서 해당 과제 Set 가져와서 student 추가
        // Set이니까 중복은 자동으로 처리됩니다!
        Set<String> SubmissionsSet = submissions.get(assignment);
        SubmissionsSet.add(student);

    }

    public List<String> getNotSubmitted(String assignment, List<String> allStudents) {
        // TODO: allStudents 중 submissions에 없는 학생 반환
        List<String> notSubmitted = new ArrayList<String>(allStudents);
        notSubmitted.removeAll(submissions.get(assignment));
        return notSubmitted;
    }

    public double getSubmissionRate(String assignment, int totalStudents) {
        // TODO: (제출자 수 / 전체 학생 수) * 100
            double gsRate = (submissions.get(assignment).size() / totalStudents) * 100;
        return gsRate;
    }

    public void printReport() {
        // TODO: 각 과제별 제출자 목록 출력 (정렬된 순서로)
        for(String ag: assignments){
            Set<String> set = submissions.get(ag);
            List<String> sorted = new ArrayList<>(set);
            Collections.sort(sorted);
            System.out.println(ag + ": " + sorted);
        }
    }

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
