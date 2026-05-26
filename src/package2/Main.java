package package2;
import role.Lion;
import role.Member;
import role.Staff;
import java.util.Scanner;
import java.util.List;

public class Main {

    //Scanner 선언, MemberService 객체 선언 (저장, 검증 이양)
    private static Scanner sc = new Scanner(System.in);
    private static MemberRepository repository;
    private static MemberService memberService;

    public static void main(String[] args) {
        boolean isRunning = true;
        System.out.println("저장소를 선택하세요!");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");
        int repoSelection = Integer.parseInt(sc.next());

        if (repoSelection == 1){
            repository = new MemoryMemberRepository();
            System.out.println("실제 저장소에 저장합니다.");
        } else if (repoSelection == 2) {
            repository = new MockMemberRepository();
            System.out.println("MockMemberRepository에 저장합니다.");
        }
        memberService = new MemberService(repository);
        while (isRunning){
            System.out.println("===== 멤버 관리 시스템 =====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택 : ");

            int selection = Integer.parseInt(sc.next());
            switch(selection){
                case 1 -> registerMember(); //Switch Expressions로 깔끔하게 정리
                case 2 -> showAllMembers();
                case 3 -> searchByName();
                case 4 -> {
                    System.out.println("프로그램을 종료합니다.");
                    isRunning = false;
                }
                default -> System.out.println("1~4 사이의 수를 입력해 주세요.");
            }
        }
    }

    private static void registerMember(){
        Member newMember = null;
        System.out.println("--멤버 등록--");
        System.out.print("역할 선택 : (1: 아기사자, 2: 운영진)");
        int roleSelection = Integer.parseInt(sc.next());

        System.out.print("이름: ");
        String name = sc.next();
        System.out.print("전공: ");
        String major = sc.next();
        System.out.print("기수: ");
        int gen = Integer.parseInt(sc.next());
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String part = sc.next();

        if (roleSelection == 1){ //아기사자 등록
            System.out.print("학번: ");
            String studentId = sc.next();
            newMember = new Lion(name, major, gen, part, studentId);
        } else if (roleSelection == 2){ //운영진 등록
            System.out.print("직책: ");
            String role = sc.next();
            newMember = new Staff(name, major, gen, part, role);
        }
        if (memberService.join(newMember)){
            System.out.println("등록 완료!");
        } else {
            System.out.println("중복된 이름입니다.");
        }
    }

    private static void showAllMembers(){
        System.out.println("--전체 멤버 목록--");
        List<Member> members = memberService.findMembers();
        for (int i = 0; i < members.size(); i++){
            Member m = members.get(i);
            String roleName = (m instanceof Lion) ? "아기사자" : "운영진";
            System.out.println((i + 1) + ". [" + roleName + "] " + m.getName() + " - " + m.getGeneration() + "기");
        }
        System.out.println("총 "+members.size()+"명");
    }

    private static void searchByName(){
        System.out.println("--이름으로 검색--");
        System.out.print("검색할 이름 : ");
        String searchingName = sc.next();
        Member m = memberService.findOne(searchingName);

        if (m != null){
            m.printInfo();
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }
}
