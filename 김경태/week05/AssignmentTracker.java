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
        // Map의 Value(Set)의 정보 얻은 후, 학생 이름 넣기
        submissions.get(assignment).add(student);
        // Set이니까 중복은 자동으로 처리됩니다!
    }

    public List<String> getNotSubmitted(String assignment, List<String> allStudents) {
        // TODO: allStudents 중 submissions에 없는 학생 반환
        // temp ArrayList 선언 후, 배열에 모든 학생의 이름 넣은 후, 차집합
        // 차집합 시행 시, 배열의 구조가 바뀌니, temp 필요
        List<String> temp = new ArrayList<>();
        temp.addAll(allStudents);
        temp.removeAll(submissions.get(assignment));

        Collections.sort(temp);
        return temp;
    }

    public double getSubmissionRate(String assignment, int totalStudents) {
        // TODO: (제출자 수 / 전체 학생 수) * 100
        int temp = submissions.get(assignment).size();
        // 1/2 => 0 * 100 => 0.0, Double형 변환 필요
        return ((double) temp /totalStudents) * 100;
    }

    public void printReport() {
        // TODO: 각 과제별 제출자 목록 출력 (정렬된 순서로)
        for(Map.Entry<String, Set<String>> entry : submissions.entrySet()) {
            // entrySet으로 순회
            List<String> temp = new ArrayList<>();
            String k = entry.getKey();
            Set<String> v = entry.getValue();

            temp.addAll(v);
            Collections.sort(temp);
            System.out.println(k + "의 제출자" + temp);
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
        System.out.println("컬렉션 실습 미제출: " + tracker.getNotSubmitted("컬렉션 실습", students));
        System.out.println("컬렉션 실습 제출율: " + tracker.getSubmissionRate("컬렉션 실습", students.size()));
    }
}