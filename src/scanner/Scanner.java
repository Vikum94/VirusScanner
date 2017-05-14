package scanner;

import java.io.File;

/**
 * Created by Vikum on 5/14/2017.
 */
public class Scanner {

    private static File directory = new File("C:\\Users\\Vikum\\IdeaProjects\\VirusScanner\\src");
    private static String[] fileNames = directory.list();

    public static void showFiles(){
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

    public static String[] getAllFiles(){
        return fileNames;
    }
}
