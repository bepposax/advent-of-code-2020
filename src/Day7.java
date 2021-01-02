package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day7 {
    private static File data;
    private static Scanner sc;
    private static final String myBag = "shiny gold";
    private static ArrayList<String> validBags = new ArrayList<String>();
    private static int found = 0;

    public static void main(String[] args) throws FileNotFoundException {
        data = new File("data/d7.txt");

        System.out.println("Part1 solution: " + solution1());
        System.out.println("Part2 solution: " + solution2());
    }

    private static int solution1() throws FileNotFoundException {
        do {
            found = search1();
        } while (search1() > found);

        return found;
    }

    private static int search1() throws FileNotFoundException {
        sc = new Scanner(data);
        String line, container;
        String[] rule, content;

        while (sc.hasNextLine()) {
            line = sc.nextLine().replaceAll("[0-9] |[.]| bag[s]*", "");

            rule = line.split(" contain ");
            container = rule[0];
            content = rule[1].split(", ");

            for (String bag : content)
                if (bag.equals(myBag) || validBags.contains(bag))
                    if (!validBags.contains(container))
                        validBags.add(container);
        }

        return validBags.size();
    }

    private static int solution2() throws FileNotFoundException {
        sc = new Scanner(data);
        return 0;
    }
}