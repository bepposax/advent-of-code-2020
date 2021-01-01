import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {
    private static File data;
    private static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        data = new File("Day6.dat");

        System.out.println("Part1 solution: " + solution1());
        System.out.println("Part2 solution: " + solution2());
    }

    private static int solution1() throws FileNotFoundException {
        sc = new Scanner(data);
        int sum = 0;
        ArrayList<Character> answers = new ArrayList<Character>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if (!line.isEmpty())
                for (int i = 0; i < line.length(); ++i) {
                    char answer = line.charAt(i);

                    if (!answers.contains(answer))
                        answers.add(answer);
                }
            else {
                sum += answers.size();
                answers.clear();
            }
        }
        if (!sc.hasNextLine()) // last line
            sum += answers.size();

        sc.close();
        return sum;
    }

    private static int solution2() throws FileNotFoundException {
        sc = new Scanner(data);
        int sum = 0;
        ArrayList<Character> commonAnswers = new ArrayList<Character>();
        boolean firstMember = true;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if (!line.isEmpty()) {
                if (firstMember) {
                    for (int i = 0; i < line.length(); ++i)
                        commonAnswers.add(line.charAt(i));
                    firstMember = false;
                } else // other members
                    for (int i = 0; i < commonAnswers.size(); ++i)
                        if (!line.contains(Character.toString(commonAnswers.get(i))))
                            commonAnswers.remove(i--);
            } else { // end of group
                sum += commonAnswers.size();
                commonAnswers.clear();
                firstMember = true;
            }
        }
        // last line
        sum += commonAnswers.size();

        sc.close();
        return sum;
    }
}