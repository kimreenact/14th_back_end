import java.util.Scanner;

public class Main {
    interface Policy {

        default void summit() {

        }
    }
    static abstract class Role implements Policy {

        private String name;
        private String major;
        private int number;
        private String part;

        public String getName() {
            return name;
        }

        public String getMajor() {
            return major;
        }

        public String getPart() {
            return part;
        }

        public int getNumber() {
            return number;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPart(String part) {
            this.part = part;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        void inputInfo(Scanner scanner) {
            System.out.print("이름: ");
            setName(scanner.nextLine());
            System.out.print("전공: ");
            setMajor(scanner.nextLine());
            System.out.print("기수: ");
            setNumber(scanner.nextInt());
            scanner.nextLine();
            System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
            setPart(scanner.nextLine());
        }

        void printInfo() {
            System.out.println("===== 결과출력 ===== ");
            System.out.println();
            System.out.println("이름: " + getName());
            System.out.println("전공: " + getMajor());
            System.out.println("기수: " + getNumber());
            System.out.println("파트: " + getPart());

        }

    }

        static class Lion extends Role {

            String id;


            void printInfo() {
                super.printInfo();
                System.out.println("학번 : " + id);

            }


            public void summit() {
                System.out.println("과제 제출 여부 : 가능");
            }
        }

        static class Staff extends Role {

            String work;

            void inputWork(String work) {
                this.work = work;
            }

            void printInfo() {
                System.out.println();
                super.printInfo();
                System.out.println("직책: " + work);

            }


            public void summit() {

                System.out.println("과제 제출 여부 : 불가능");
            }
        }


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            Lion lion = new Lion();

            System.out.println("===== 아기사자 정보 입력 =====");
            lion.inputInfo(scanner);
            System.out.print("학번: ");
            lion.id = scanner.nextLine();
            System.out.println();


            Staff staff = new Staff();

            System.out.println("===== 운영진 정보 입력 =====");

            staff.inputInfo(scanner);
            System.out.print("직책 (대표/부대표/파트장/멘토): ");
            staff.inputWork(scanner.nextLine());

            Role[] prints = {lion, staff};
            for(Role output : prints){
                output.printInfo();
                output.summit();
                System.out.println("----------------------");
            }

        }

    }