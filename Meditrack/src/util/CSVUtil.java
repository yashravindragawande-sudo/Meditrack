package util;



import java.io.*;

public class CSVUtil {

    public static void save(String file, String data) {

        try(PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
            pw.println(data);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}