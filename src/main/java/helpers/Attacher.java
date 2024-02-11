package helpers;

import io.qameta.allure.Attachment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Attacher {

    @Attachment
    public static byte[] attachFileToReport(String filePath, String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(filePath, fileName));
    }
}
