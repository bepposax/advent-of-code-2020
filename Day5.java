import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5 {
    private static File data;
    private static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        data = new File("Day5.dat");

        System.out.println("Part1 solution: " + solution1());
        System.out.println("Part2 solution: " + solution2());
    }

    private static int solution1() throws FileNotFoundException {
        sc = new Scanner(data);
        int maxId = 0;

        while (sc.hasNextLine()) {
            String pass = sc.nextLine();
            int min = 0, max = 127;
            int row = 0, column = 0;
            int id = 0;

            for (int i = 0; i < 7; ++i) {
                int range = max - min;
                if (pass.charAt(i) == 'F')
                    max = min + range / 2;
                else if (pass.charAt(i) == 'B')
                    min = min + range / 2 + 1;
            }
            row = min;

            min = 0;
            max = 7;

            for (int i = 7; i < 10; ++i) {
                int range = max - min;
                if (pass.charAt(i) == 'L')
                    max = min + range / 2;
                else if (pass.charAt(i) == 'R')
                    min = min + range / 2 + 1;
            }
            column = min;

            if ((id = row * 8 + column) > maxId)
                maxId = id;
        }

        return maxId;
    }

    private static int solution2() throws FileNotFoundException {
        return 0;
    }
}
