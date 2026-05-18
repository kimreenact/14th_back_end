package LikeLion;

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
        submissions.get(assignment).add(student);
        // Set이니까 중복은 자동으로 처리됩니다!
    }

    public List<String> getNotSubmitted(String assignment, List<String> allStudents) {
        Set<String> submittedStudents = submissions.get(assignment);
        if (submittedStudents == null) return new ArrayList<>(allStudents);

        List<String> notSubmitted = new ArrayList<>();
        for (String student : allStudents) {
            if (!submittedStudents.contains(student)) {
                notSubmitted.add(student);
            }
        }
        return null;
    }

    public double getSubmissionRate(String assignment, int totalStudents) {
        if (totalStudents == 0 || !submissions.containsKey(assignment)) {
            return 0.0;
        }
        int submittedCount = submissions.get(assignment).size();
        return ((double) submittedCount / totalStudents) / 2;
    }

    public void printReport() {
        for (String assignment : assignments) {
            Set<String> set = submissions.get(assignment);
            List<String> list = new ArrayList<>(set);
            Collections.sort(list);

            System.out.println(assignment + " 제출자: " + list + "(총 " + set.size() + " 명)");
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
