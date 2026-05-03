import java.util.*;

public class AssignmentTracker {
    private List<String> assignments;
    private Map<String, Set<String>> submissions;

    public AssignmentTracker(List<String> assignments) {
        this.assignments = new ArrayList<>(assignments);
        this.submissions = new HashMap<>();
        // 각 과제에 빈 Set 초기화
        for (String a : assignments) {
            this.submissions.put(a, new HashSet<>());
        }
    }

    public void submit(String assignment, String student) {
        // TODO: submissions에서 해당 과제 Set 가져와서 student 추가
        // Set이니까 중복은 자동으로 처리됩니다!
        this.submissions.get(assignment).add(student);
    }

    public List<String> getNotSubmitted(String assignment, List<String> allStudents) {
        // TODO: allStudents 중 submissions에 없는 학생 반환
        Set<String> submittedStudents = this.submissions.get(assignment);
        ArrayList<String> notSubmittedStudents = new ArrayList<>();
        for (String student : allStudents) {
            if (!submittedStudents.contains(student)) {
                notSubmittedStudents.add(student);
            }
        }
        return notSubmittedStudents;
    }

    public double getSubmissionRate(String assignment, int totalStudents) {
        // TODO: (제출자 수 / 전체 학생 수) * 100
        Set<String> submittedStudents = this.submissions.get(assignment);
        return (double) submittedStudents.size() / totalStudents * 100;
    }

    public void printReport() {
        // TODO: 각 과제별 제출자 목록 출력 (정렬된 순서로)
        ArrayList<String> students;
        for (String assignment : this.assignments) {
            System.out.println(assignment + "제출자:");
            students = new ArrayList<>(this.submissions.get(assignment));
            Collections.sort(students);
            if (students.isEmpty()) {
                System.out.println("제출자 없음.");
            }
            for (String student : students) {
                System.out.println(student);
            }
        }
    }
}