import java.io.*;
import java.util.ArrayList;

/**
 * Created by raijin on 2/4/16.
 */

public class hw1 {
    public static void hw1(String inFile, String outFile) throws IOException {
        String line = null;
        try{
            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(outFile);
            BufferedWriter bw = new BufferedWriter(fw);
            while ((line = br.readLine()) != null){
                line.replace(" ", "");
                if (line.length() < 26) {
                    bw.write("false\n");
                }
                else{
                    bw.write(pangramTest(line) + "\n");
                }
            }
            br.close();
            bw.close();
            fr.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected static String pangramTest(String s){
        char temp = 'a';
        int alpCount = 0;
        for (int i = 0; i < 26; i++){
            for (int j = 0; j < s.length(); j++){
                if (s.charAt(j) == temp){
                    alpCount++;
                    temp++;
                    break;
                }
                else{
                    continue;
                }
            }
        }
        if (alpCount == 26)
            return "true";
        else
            return "false";
    }
}