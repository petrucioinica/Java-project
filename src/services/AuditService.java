package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class AuditService {
    public static void recordAction(String actionName){
        try {
            File csvFile = new File("./audit.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./audit.csv"));
            FileWriter fw = new FileWriter("./audit.csv", true);
            String row = br.readLine();
            if (row == null) {
                String headerStr = "action name, timestamp\n";
                fw.append(headerStr);
                fw.flush();
            }
            fw.append(actionName + "," +  LocalDateTime.now() + "\n");
            fw.flush();
            fw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
