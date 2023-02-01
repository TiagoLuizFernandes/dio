import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Tiago Luiz Fernandes
 */

public class Problem {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner( System.in);
        List<String> listOfNames = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String name = scanner.nextLine();
            listOfNames.add(name);

        }

        System.out.println(listOfNames.get(2));
        System.out.println(listOfNames.get(6));
        System.out.println(listOfNames.get(8));

    }
}