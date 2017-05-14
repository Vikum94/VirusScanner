package detector;

import scanner.Scanner;

import java.io.*;

/**
 * Created by Vikum on 5/14/2017.
 */
public class Comparator {
    private String[] viruses;
    private String path;

    public Comparator(String path){
        this.path = path;
        viruses = Scanner.getAllFiles(path);
    }

    private boolean findVirus(String md5Hash) throws IOException {
        for (String virus : viruses){
            FileReader fr =  new FileReader(path + "\\"+virus);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line == md5Hash) {
                    System.out.print("Virus Found: "+virus);
                    return true;
                }
            }
        }
        return false;
    }
}
