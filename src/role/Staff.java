package role;

import policy.AssignmentPolicy;
import policy.StaffAssignmentPolicy;

public class Staff extends Member {
    private String position;

    //생성자
    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    public AssignmentPolicy getAssignmentPolicy(){
        return new StaffAssignmentPolicy();
    }

    @Override
    public void printInfo(){
        String status = getAssignmentPolicy().canSubmit() ? "가능" : "불가능";
        System.out.println("역할 : 운영진");
        System.out.println("이름 : "+getName()+" | 전공 : "+getMajor()+" | 기수 : "+getGeneration()+" | 파트 : "+getPart());
        System.out.println("직책 : "+position);
        System.out.println("과제 제출 가능 여부 : "+status);
    }
}
