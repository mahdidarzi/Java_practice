package com.student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    public static String getStudentFilePath() {
        Properties properties = new Properties();
        // تلاش برای خواندن از ریشه‌ی پروژه (جایی که برنامه اجرا می‌شود)
        try (InputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
            return properties.getProperty("student.file.path");
        } catch (IOException e) {
            throw new RuntimeException("فایل config.properties را در ریشه‌ی پروژه (practice) پیدا نکردم. مطمئن شو کنار فایل‌های .class هست.", e);
        }
    }
}
