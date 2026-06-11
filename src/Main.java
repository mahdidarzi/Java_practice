import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            FileWriter writer=new FileWriter("data.txt");
            writer.write("Hello Java File!\n");
            writer.write("This is line 2.\n");
            writer.write("This is line 3.\n");
            writer.close();

            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing file.");
        } finally {
        }
    }
}
