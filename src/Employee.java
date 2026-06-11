public class Employee extends Person implements Worker{
    private String companyName;

    public Employee(String name, int age, String companyName) {
        super(name, age);
        this.companyName = companyName;
    }

    public void showEmployeeInfo() {
        showInfo();
        System.out.println("company" + companyName);
    }

    @Override
    public void work() {
        System.out.println(name+"is working"+companyName);
    }

    @Override
    void showRole() {
        System.out.println(name+" is a Employee");
    }
}
