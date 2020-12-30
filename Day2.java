import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        File data = new File("Day2.dat");
        Scanner sc = new Scanner(data);

        int min, max, validPasswords = 0;
        String password;
        String[] line = new String[4];

        while (sc.hasNextLine()) {
            line = sc.nextLine().replace(":", "").split(" |-");
            min = Integer.parseInt(line[0]);
            max = Integer.parseInt(line[1]);
            password = line[3].replaceAll("[^" + line[2] + "]", ""); // changes the pw to contain only the given letter

            int num = password.length(); // so the occurrences of that letter becomes equal to the length
            if (num >= min && num <= max)
                validPasswords++;
        }
        sc.close();

        System.out.print(validPasswords);
    }
}