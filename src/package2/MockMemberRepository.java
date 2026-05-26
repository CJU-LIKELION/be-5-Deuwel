package package2;
import role.Lion;
import role.Member;
import role.Staff;
import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository{
    private List<Member> memberList = new ArrayList<>();

    public MockMemberRepository(){
        memberList.add(new Lion("방성윤", "인공지능학과", 3, "백엔드", "2022011911"));
        memberList.add(new Staff("김규원", "경영학과", 2, "기획", "2021011911"));
    }

    @Override
    public void save(Member member) {
        System.out.println("[알림] Mock(가짜) 저장소이므로 실제 저장은 되지 않습니다.");
    }

    @Override
    public Member findByName(String name) {
        for (Member m : memberList){
            if (m.getName().equals(name)){
                return m;
            }
        }
        return null; //모두 순회하였지만 찾지 못 함
    }

    @Override
    public List<Member> findAll() {
        return memberList;
    }

    @Override
    public boolean existsByName(String name) {
        for (Member m : memberList) {
            if (m.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
