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

    public boolean findVirus(String md5Hash) throws IOException {
        for (String virus : viruses){
            FileReader fr =  new FileReader(path + "\\"+virus);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(md5Hash)) {
                    System.out.println("\t####Virus Found");
                    System.out.printf("\t\t%s\\%s\n",path,virus);
                    System.out.printf("\t%s\n",line);

                    return true;
                }
            }
            br.close();
        }
        return false;
    }
}
