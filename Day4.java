import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {
    private static File data;
    private static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        data = new File("Day4.dat");

        System.out.println("Part1 solution: " + solution1());
    }

    private static int solution1() throws FileNotFoundException {
        sc = new Scanner(data);
        int validPassports = 0, fields = 0;
        String line;

        while (sc.hasNextLine()) {
            line = sc.nextLine();

            if (!line.isEmpty()) {
                for (String s : line.split(" "))
                    if (!s.split(":")[0].equals("cid"))
                        fields++;
            } else {
                if (fields == 7)
                    validPassports++;
                fields = 0;
            }
        }
        if (fields == 7) // last line
            validPassports++;

        sc.close();
        return validPassports;
    }
}
