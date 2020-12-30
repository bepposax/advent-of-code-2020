import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static File data;
    public static Scanner sc;
    public static int min, max;
    public static String password;
    public static String[] line;

    public static void main(String[] args) throws FileNotFoundException {
        data = new File("Day2.dat");
        line = new String[4];

        System.out.print("Part 1 solution: " + validate1() + "\nPart 2 solution: " + validate2());
        sc.close();
    }

    public static int validate1() throws FileNotFoundException {
        int validPwds = 0;
        sc = new Scanner(data);

        while (sc.hasNextLine()) {
            line = sc.nextLine().replace(":", "").split(" |-");
            min = Integer.parseInt(line[0]);
            max = Integer.parseInt(line[1]);
            password = line[3].replaceAll("[^" + line[2] + "]", ""); // changes the pw to contain only the given letter

            int num = password.length(); // so the occurrences of that letter becomes equal to the length
            if (num >= min && num <= max)
                validPwds++;
        }
        return validPwds;
    }

    public static int validate2() throws FileNotFoundException {
        int validPwds = 0;
        sc = new Scanner(data);

        while (sc.hasNextLine()) {
            line = sc.nextLine().replace(":", "").split(" |-");
            min = Integer.parseInt(line[0]);
            max = Integer.parseInt(line[1]);
            char letter = line[2].charAt(0);
            password = line[3];

            if ((password.charAt(min - 1) == letter) ^ (password.charAt(max - 1) == letter))
                validPwds++;
        }
        return validPwds;
    }
}