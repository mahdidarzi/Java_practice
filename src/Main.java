import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> workers = new ArrayList<>();
        workers.add(new Manager("Mahdi", 26, "land", 12));
        workers.add(new Employee("Mahdi", 26,"test"));
        for (Person person:workers) {
            person.showInfo();
            person.showRole();
        }
    }
}
