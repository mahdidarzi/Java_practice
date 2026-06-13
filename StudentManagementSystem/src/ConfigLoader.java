import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static final String CONFIG_PATH = "config.properties";

    public static String getStudentFilePath() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_PATH)) {
            properties.load(fis);
            return properties.getProperty("db.file.path", "default_students.txt");
        } catch (IOException e) {
            System.err.println("Could not load config.properties, using default path.");
            return "students.txt";
        }
    }
}
