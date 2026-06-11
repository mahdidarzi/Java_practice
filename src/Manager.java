public class Manager extends Person implements Worker {
    private String department;
    private int teamSize;

    public Manager(String name, int age, String department, int teamSize) {
        super(name, age);
        this.department = department;
        this.teamSize = teamSize;
    }

    @Override
    void showInfo() {
        super.showInfo();
        System.out.println("department"+department);
        System.out.println("teamSize"+teamSize);
    }

    @Override
    void showRole() {
        System.out.println(name+" is a manager");

    }

    @Override
    public void work() {
        System.out.println(name+"manages"+department);
    }
}
