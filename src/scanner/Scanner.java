package scanner;

import java.io.File;

/**
 * Created by Vikum on 5/14/2017.
 */
public class Scanner {

    private static File directory;
    private static String[] fileNames;

    public static void showFiles(String path){
        directory = new File(path);
        fileNames = directory.list();
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

    public static String[] getAllFiles(String path){
        directory = new File(path);
        fileNames = directory.list();
        return fileNames;
    }
}
