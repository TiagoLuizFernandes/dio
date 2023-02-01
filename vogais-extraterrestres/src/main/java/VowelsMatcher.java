import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Tiago Luiz Fernandes
 */

public class VowelsMatcher {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner( System.in);

        while ( scanner.hasNextLine() ) {

            String vowel;
            String sentence;
            AtomicInteger count = new AtomicInteger(0);

            vowel = scanner.nextLine();

            sentence = scanner.nextLine();

            for (int i = 0; i < vowel.length() ; i++) {
                for (int j = 0; j < sentence.length(); j++) {
                    if (sentence.charAt(j) == vowel.charAt(i)) {
                        count.incrementAndGet();
                    }
                }
            }

            System.out.println(count.get());

        }

    }
}