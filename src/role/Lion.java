package role;

import policy.AssignmentPolicy;
import policy.LionAssignmentPolicy;

public class Lion extends Member{
    private String studentId;

    //생성자
    public Lion(String name, String major, int generation, String part, String studentId){
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    public AssignmentPolicy getAssignmentPolicy(){
        return new LionAssignmentPolicy();
    }

    @Override
    public void printInfo(){
        String status = getAssignmentPolicy().canSubmit() ? "가능" : "불가능";
        System.out.println("역할 : 아기사자");
        System.out.println("이름 : "+getName()+" | 전공 : "+getMajor()+" | 기수 : "+getGeneration()+" | 파트 : "+getPart());
        System.out.println("학번 : "+studentId);
        System.out.println("과제 제출 가능 여부 : "+status);
    }
}
