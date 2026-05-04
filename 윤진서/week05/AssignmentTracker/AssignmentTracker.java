import java.util.*;

public class AssignmentTracker {
    //과제 이름 목록
    private List<String> assignments;
    //제출자 관리
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
        Set<String> studentSet = submissions.get(assignment);
        if (studentSet!= null){
            studentSet.add(student);
        }

    }

    public List<String> getNotSubmitted(String assignment, List<String> allStudents) {
        // TODO: allStudents 중 submissions에 없는 학생 반환'
        Set<String> submittedStudents = submissions.get(assignment);
        if (submittedStudents == null) return new ArrayList<>(allStudents);

        List<String> notSubmitted = new ArrayList<>(allStudents);
        notSubmitted.removeAll(submittedStudents);

        return notSubmitted;

    }

    public double getSubmissionRate(String assignment, int totalStudents) {
        // TODO: (제출자 수 / 전체 학생 수) * 100
        Set<String> studentSet = submissions.get(assignment);
        if (studentSet==null || totalStudents==0){
            return 0.0;
        }
        return((double)studentSet.size()/totalStudents)*100;
    }

    public void printReport() {
        // TODO: 각 과제별 제출자 목록 출력 (정렬된 순서로)
        for (String a : assignments) {
            Set<String> studentSet = submissions.get(a);
            List<String> sortedStudents = new ArrayList<>(studentSet);
            Collections.sort(sortedStudents);

            System.out.println(a+"제출자:"+sortedStudents);

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
        System.out.printf("제출률(컬렉션 실습): %.1f%%\n", tracker.getSubmissionRate("컬렉션 실습", students.size()));
    }
}