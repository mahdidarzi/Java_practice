public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) throws InvalidStudentDataException {
        setName(name);
        setAge(age);
        setGrade(grade);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public void setName(String name) throws InvalidStudentDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidStudentDataException("Name cannot be empty.");
        }
        this.name = name.trim();
    }

    public void setAge(int age) throws InvalidStudentDataException {
        if (age < 5 || age > 100) {
            throw new InvalidStudentDataException("Age must be between 5 and 100.");
        }
        this.age = age;
    }

    public void setGrade(double grade) throws InvalidStudentDataException {
        if (grade < 0 || grade > 20) {
            throw new InvalidStudentDataException("Grade must be between 0 and 20.");
        }
        this.grade = grade;
    }
    public void showInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}
