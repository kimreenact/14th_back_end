import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AssignmentTracker {
    //캡슐화 이용 외부 접근 x
    //변수타입을 List 와 map 으로 선언하여 유연성 증가 -> 다형성
    private List<String> assignments;
    //Map 안에 Set을 넣어서 과제명 -> 제출한 학생 명단 구조를 만들기
    private Map<String, Set<String>> submissions;

    public AssignmentTracker(List<String> assignments) {
        //외부에서 넘어온 리스트를 그대로 쓰지 않고 새 리스트에 복사함 원본 훼손 방지하기
        this.assignments = new ArrayList<>(assignments);
        this.submissions = new HashMap<>();
        //각 과제에 빈 Set 초기화
        //모든 과제에 '빈 박스(Set)'를 미리 세팅함 -> 오류 안 나게 하려고
        for (String a : assignments) {
            submissions.put(a, new HashSet<>());
        }
    }

    //과제 제출(Set으로 중복사용방지)
    public void submit(String assignment, String student) {
        // TODO: submissions에서 해당 과제 Set 가져와서 student 추가
        //Set은 중복 자동처리
        if (submissions.containsKey(assignment)) {
            //containsKey는 Map에 해당 과제가 진짜 존재하는지 먼저 확인
            submissions.get(assignment).add(student);
        } else {
            System.out.println("존재하지 않는 과제입니다: " + assignment);
        }
    }

    //제출과 관리: 미제출자
    public List<String> getNotSubmitted(String assignment, List<String> allStudents) {
        // TODO: allStudents 중 submissions에 없는 학생 반환
        //원본 리스트 보호를 위해 새로운 ArrayList 생성
        List<String> notSubmitted = new ArrayList<>(allStudents);

        if (submissions.containsKey(assignment)) {
            //removeAll로 차집합 연산 전체 - 제출한 학생
            notSubmitted.removeAll(submissions.get(assignment));
        }
        return notSubmitted;
    }

    //제출률(%) 반환
    public double getSubmissionRate(String assignment, int totalStudents) {
        // TODO: (제출자 수 / 전체 학생 수) * 100
        if (totalStudents == 0)
            return 0.0; //0으로 나누는 것 방지(오류)

        int submittedCount = 0;
        if (submissions.containsKey(assignment)) {
            submittedCount = submissions.get(assignment).size();
        }
        //double 로 버려지는 소수점도 구하기
        return ((double) submittedCount / totalStudents) * 100.0;
    }

    //과제별 제출 현황 출력
    public void printReport() {
        // TODO: 각 과제별 제출자 목록 출력 (정렬된 순서로)
        System.out.println("=== 과제 제출 현황 ===");
        //Map 은 순서 보장이 없으니까 처음 입력한 과제 순서를 기준으로 반복문
        for (String assignment : assignments) {
            //Set은 순서가 없어서 정렬이 불가능하니 ArrayList로 변환시켜서 정렬하기
            List<String> sortedStudents = new ArrayList<>(submissions.get(assignment));

            //정렬 도구 Collections.sort()를 사용
            Collections.sort(sortedStudents);
            System.out.println("- " + assignment + ": " + sortedStudents);
        }
    }

    public static void main(String[] args) {
        //List.of 로 고정 리스트 만들기
        List<String> hw = List.of("컬렉션 실습", "정렬 구현", "Map 활용");
        List<String> students = List.of("Alice", "Bob", "Charlie", "Diana");

        //제출 시뮬레이션
        AssignmentTracker tracker = new AssignmentTracker(hw);
        tracker.submit("컬렉션 실습", "Alice");
        tracker.submit("컬렉션 실습", "Bob");
        tracker.submit("컬렉션 실습", "Alice"); //중복 - 무시돼야 함
        tracker.submit("정렬 구현", "Charlie");

        //현재 상태 출력
        tracker.printReport();

        //과제별 미제출자 및 제출률 확인(컬렉션과 정렬 구분짓기 위해서 [] 추가로 붙여주기)
        System.out.println("\n[컬렉션 실습] 미제출: " + tracker.getNotSubmitted("컬렉션 실습", students));
        System.out.println("[컬렉션 실습] 제출률: " + tracker.getSubmissionRate("컬렉션 실습", students.size()) + "%");

        System.out.println("[정렬 구현] 미제출: " + tracker.getNotSubmitted("정렬 구현", students));
        System.out.println("[정렬 구현] 제출률: " + tracker.getSubmissionRate("정렬 구현", students.size()) + "%");
    }
}