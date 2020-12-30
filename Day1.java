import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        File data = new File("Day1.dat");
        Scanner sc = new Scanner(data);

        while (sc.hasNextInt())
            list.add(sc.nextInt());

        Collections.sort(list);

        boolean found = false;
        int sum;

        do
            for (int i = list.size() - 1; i >= 0; --i)
                for (int j = 0; j <= i; j++)
                    for (int k = j + 1; k < i; k++) {
                        sum = list.get(i) + list.get(j) + list.get(k);
                        if (sum == 2020) {
                            found = true;
                            System.out.println(list.get(i) + " + " + list.get(j) + " + " + list.get(k) + " = " + sum
                                    + "\n" + list.get(i) + " * " + list.get(j) + " * " + list.get(k) + " = "
                                    + list.get(i) * list.get(j) * list.get(k));
                            break;
                        } else if (sum > 2020)
                            break;
                    }
        while (!found);

        sc.close();
    }
}