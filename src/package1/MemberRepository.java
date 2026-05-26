package package1;
import role.Member;
import java.util.List;
import java.util.ArrayList;

public class MemberRepository {
    private List<Member> memberList = new ArrayList<>();

    public void save(Member member){ //저장
        memberList.add(member);
    }

    public Member findByName(String name){
        for (Member m : memberList){
            if (m.getName().equals(name)){
                return m;
            }
        }
        return null; //모두 순회하였지만 찾지 못 함
    }

    public List<Member> findAll(){
        return memberList;
    }

    public boolean existsByName(String name) {
        for (Member m : memberList) {
            if (m.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
