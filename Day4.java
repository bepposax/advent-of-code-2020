import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {
    private static File data;
    private static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        data = new File("Day4.dat");

        System.out.println("Part1 solution: " + solution1());
        System.out.println("Part2 solution: " + solution2());
    }

    private static int solution1() throws FileNotFoundException {
        sc = new Scanner(data);
        int validPassports = 0, validFields = 0;
        String line;

        while (sc.hasNextLine()) {
            line = sc.nextLine();

            if (!line.isEmpty()) {
                for (String s : line.split(" "))
                    if (!s.split(":")[0].equals("cid"))
                        validFields++;
            } else {
                if (validFields == 7)
                    validPassports++;
                validFields = 0;
            }
        }
        if (validFields == 7) // last line
            validPassports++;

        sc.close();
        return validPassports;
    }

    private static int solution2() throws FileNotFoundException {
        sc = new Scanner(data);
        int validPassports = 0, validFields = 0;
        String line;

        while (sc.hasNextLine()) {
            line = sc.nextLine();

            if (!line.isEmpty()) {
                for (String s : line.split(" ")) {
                    String[] field = s.split(":");
                    String key = field[0], value = field[1];

                    if (!key.equals("cid"))
                        switch (key) {
                            case ("byr"):
                                if (value.length() == 4) {
                                    int year = Integer.parseInt(value);
                                    if (year >= 1920 && year <= 2002)
                                        validFields++;
                                }
                                break;
                            case ("iyr"):
                                if (value.length() == 4) {
                                    int year = Integer.parseInt(value);
                                    if (year >= 2010 && year <= 2020)
                                        validFields++;
                                }
                                break;
                            case ("eyr"):
                                if (value.length() == 4) {
                                    int year = Integer.parseInt(value);
                                    if (year >= 2020 && year <= 2030)
                                        validFields++;
                                }
                                break;
                            case ("hgt"):
                                String unity = value.substring(value.length() - 2);
                                if (!(unity.equals("cm") || unity.equals("in")))
                                    break;
                                int quantity = Integer.parseInt(value.substring(0, value.length() - 2));
                                int max, min;

                                if (unity.equals("cm")) {
                                    min = 150;
                                    max = 193;
                                } else if (unity.equals("in")) {
                                    min = 59;
                                    max = 76;
                                } else
                                    break;
                                if (quantity >= min && quantity <= max)
                                    validFields++;
                                break;
                            case ("hcl"):
                                if (value.matches("^#[[0-9]|[a-f]]{6}"))
                                    validFields++;
                                break;
                            case ("ecl"):
                                String[] colors = { "amb", "blu", "brn", "gry", "grn", "hzl", "oth" };
                                for (String color : colors)
                                    if (value.equals(color)) {
                                        validFields++;
                                        break;
                                    }
                                break;
                            case ("pid"):
                                if (value.matches("[0-9]{9}"))
                                    validFields++;
                                break;
                        }
                }
            } else {
                if (validFields == 7)
                    validPassports++;
                validFields = 0;
            }
        }
        if (validFields == 7) // last line
            validPassports++;

        sc.close();
        return validPassports;
    }
}
