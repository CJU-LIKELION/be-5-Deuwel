package package2;
import role.Member;
import java.util.List;

public interface MemberRepository {
    public abstract void save(Member member);
    public abstract Member findByName(String name);
    public abstract List<Member> findAll();
    public abstract boolean existsByName(String name);
}
