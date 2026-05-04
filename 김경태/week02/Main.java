import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("총원의 수를 입력해주세요");
            int total = scanner.nextInt();

            System.out.println("출석자 수를 입력해주세요");
            int attendance = scanner.nextInt();

            System.out.println("결석자 수를 입력해주세요");
            int absent = scanner.nextInt();

            if(total == attendance+ absent){
                if (attendance > absent) {
                    for(int i =1; i <= attendance; i++){
                        System.out.println("현재 출석자 수: " + i);
                    }
                    System.out.println("출석자 수 가 결석자 수 보다 많습니다.");
                }else if (attendance == absent) {
                    System.out.println("석자와 결석자 수가 같네요...");
                }else  {
                    System.out.println("다음부터 더 재밌게 운영하세요.");
                }
                break;
            }
            else {
                System.out.println("다시 입력하세요");
            }
        }
        scanner.close();
    }
}