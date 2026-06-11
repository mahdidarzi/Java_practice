import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new Manager("Mahdi", 26, "land", 12));
        workers.add(new Employee("Mahdi", 26,"test"));
        for (Worker worker:workers) {
            worker.work();
        }
    }
}
