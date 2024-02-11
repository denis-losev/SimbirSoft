package helpers;

import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableToCsv {

    public static void writeDataToCsv(String filePath, WebElement table) {
        File file = new File(filePath);
        try {
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile);
            List<String[]> data = parseTable(table);
            writer.writeAll(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String[]> parseTable(WebElement table) {
        List<String[]> data = new ArrayList<>();
        List<String> header = new ArrayList<>();
        table.findElements(By.xpath("//thead//td")).forEach(col -> header.add(col.getText()));
        data.add(header.toArray(String[]::new));

        int iterator = 1;
        for (WebElement tr : table.findElements(By.xpath("//tbody//tr"))) {
            data.add(tr.findElements(By.xpath("(//tbody/tr)[" + iterator + "]/td"))
                    .stream()
                    .map(WebElement::getText).toArray(String[]::new));
            iterator++;
        }

        return data;
    }
}
