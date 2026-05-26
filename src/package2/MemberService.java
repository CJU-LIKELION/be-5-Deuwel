package package2;
import package2.MemberRepository;
import role.Member;
import java.util.List;

//MemberService는 비즈니스 로직, 즉 출력(Main)과 조회, 저장(Repository) 이외의 로직 담당.
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    //이름 중복 검사
    public boolean join(Member member){
        if (repository.existsByName(member.getName())){ //등록하려는 이름이 이미 존재한다면
            return false;
        }
        repository.save(member);
        return true;
    }

    public Member findOne(String name){
        return repository.findByName(name); //repository가 담당할 로직이므로 이양
    }

    public List<Member> findMembers(){
        return repository.findAll(); //repository의 담당 로직 이양
    }
}