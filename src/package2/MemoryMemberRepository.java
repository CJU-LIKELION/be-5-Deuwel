package package2;
import role.Member;
import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository{
    private List<Member> memberList = new ArrayList<>();

    @Override
    public void save(Member member) {
        memberList.add(member);
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
