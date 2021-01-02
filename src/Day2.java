package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static File data;
    public static Scanner sc;
    public static int min, max;
    public static char letter;
    public static String password;
    public static String[] line;

    public static void main(String[] args) throws FileNotFoundException {
        data = new File("data/d2.txt");
        line = new String[4];

        System.out.print("Part 1 solution: " + validate1() + "\nPart 2 solution: " + validate2());
    }

    public static void read() throws FileNotFoundException {
        line = sc.nextLine().replace(":", "").split(" |-");
        min = Integer.parseInt(line[0]);
        max = Integer.parseInt(line[1]);
        letter = line[2].charAt(0);
        password = line[3];
    }

    public static int validate1() throws FileNotFoundException {
        int validPwds = 0;
        sc = new Scanner(data);

        while (sc.hasNextLine()) {
            read();
            // change the pw to contain only the given letter so the occurrences of that
            // letter becomes equal to the length
            int occurrences = password.replaceAll("[^" + letter + "]", "").length();
            if (occurrences >= min && occurrences <= max)
                validPwds++;
        }
        sc.close();
        return validPwds;
    }

    public static int validate2() throws FileNotFoundException {
        int validPwds = 0;
        sc = new Scanner(data);

        while (sc.hasNextLine()) {
            read();
            if ((password.charAt(min - 1) == letter) ^ (password.charAt(max - 1) == letter))
                validPwds++;
        }
        sc.close();
        return validPwds;
    }
}