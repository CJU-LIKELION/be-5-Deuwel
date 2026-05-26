package role;
import policy.AssignmentPolicy;

public abstract class Member {
    //공통되는 속성은 이름, 전공, 기수, 파트
    private String name;
    private String major;
    private int generation;
    private String part;

    //생성자
    public Member(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    //추상 메서드
    public abstract AssignmentPolicy getAssignmentPolicy();
    public abstract void printInfo();

    //자식 메서드에게 정보 전달을 위한 메서드
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
}
