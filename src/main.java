import detector.Comparator;
import detector.MD5Generator;
import scanner.Scanner;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Vikum on 5/14/2017.
 */
public class main {
    private static String virusPath = "src\\Viruses";
    private static String infectedPath = "src\\TestVirus";
    private static String[] files;
    private static boolean safe = true;

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        System.out.println("Enter a folder to check for viruses: ");

        //if( args.length != 1){infectedPath = args[1];}

        System.out.println("Searching for viruses...");

        Comparator comparator = new Comparator(virusPath);
        MD5Generator generator = new MD5Generator();

        files = Scanner.getAllFiles(infectedPath);

        for(String fileName : files){
            System.out.printf("File: %s \n", fileName);
            if(comparator.findVirus(generator.generateMD5(infectedPath+"\\"+fileName))){
                safe = false;
                continue;
            }
            System.out.println("\t****File is safe****\n");
        }
        if(safe){
            System.out.println("####Safe Folder####");
        }
    }
}
