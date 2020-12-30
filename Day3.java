import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {
    public static File data;
    public static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        data = new File("Day3.dat");

        System.out.println("Part1 solution: " + solution1(3, 1));
        System.out.println("Part2 solution: " + solution2());
    }

    public static long solution1(int rightHops, int downHops) throws FileNotFoundException {
        sc = new Scanner(data);
        int col = 0, trees = 0, length = sc.nextLine().length();

        do {
            col = (col + rightHops) % length;
            for (int i = 1; i < downHops; i++)
                sc.nextLine();
            if (sc.nextLine().charAt(col) == '#')
                trees++;
        } while (sc.hasNextLine());

        sc.close();
        return trees;
    }

    public static long solution2() throws FileNotFoundException {
        return solution1(1, 1) * solution1(3, 1) * solution1(5, 1) * solution1(7, 1) * solution1(1, 2);
    }
}
