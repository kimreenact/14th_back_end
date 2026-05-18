package week5_2;

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
        submissions.get(assignment).add(student);
    }

    public List<String> getNotSubmitted(String assignment, List<String> allStudents) {
        // TODO: allStudents 중 submissions에 없는 학생 반환
        Set<String> submittedStudents = submissions.get(assignment);
        List<String> notSubmitted = new ArrayList<>();
        for (String student : allStudents) {
            if(!(submittedStudents.contains(student))) {
                notSubmitted.add(student);
            }
        }
        return notSubmitted;
    }

    public double getSubmissionRate(String assignment, int totalStudents) {
        // TODO: (제출자 수 / 전체 학생 수) * 100
        if (totalStudents != 0) {
            return (double) submissions.get(assignment).size() / totalStudents * 100;
        }
        return 0.0;
    }

    public void printReport() {
        // TODO: 각 과제별 제출자 목록 출력 (정렬된 순서로)
        for (String s : assignments) {
            List<String> sorted = new ArrayList<>(submissions.get(s));
            Collections.sort(sorted);

            System.out.println(s + ": " + sorted);
        }
    }
}
