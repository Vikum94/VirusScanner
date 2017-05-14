package detector;

import scanner.Scanner;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Vikum on 5/14/2017.
 */
public class MD5Generator {
    String md5Hash;

    public String generateMD5(String fileName) throws NoSuchAlgorithmException {

        MessageDigest msgDigest = MessageDigest.getInstance("md5");
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            BufferedInputStream bufIn = new BufferedInputStream(fileIn);
            DigestInputStream digestIn = new DigestInputStream(bufIn, msgDigest);

            while (digestIn.read() != -1) {
            }

        } catch (IOException ex) {
            System.out.println("Error while reading " + fileName);
        }

        // md5 digestion
        byte[] hash = msgDigest.digest();

        // to hex convert
        final StringBuilder builder = new StringBuilder();
        for (byte b : hash) {
            builder.append(String.format("%02x", b));
        }
        md5Hash = builder.toString();
        System.out.printf("Generated MD5 Hash for the file: %s", md5Hash);
        return md5Hash;

    }

}
