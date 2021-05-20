package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class AuditService {
    private static AuditService INSTANCE = null;

    private AuditService(){
    }

    public static synchronized AuditService getInstance(){
        if (INSTANCE == null){
            INSTANCE  = new AuditService();
        }
        return INSTANCE;
    }
    public static void recordAction(String actionName){
        try {
            File csvFile = new File("./resources/audit.csv");
            csvFile.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader("./resources/audit.csv"));
            FileWriter fw = new FileWriter("./resources/audit.csv", true);
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
