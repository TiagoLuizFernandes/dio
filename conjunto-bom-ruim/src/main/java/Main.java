import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tiago Luiz Fernandes
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int numberOflines = 0;

        numberOflines = Integer.parseInt(bufferedReader.readLine());

        while (numberOflines != 0 ) {
            String listType = "Conjunto Bom";
            List<String> stringList = new ArrayList<>();

            for(int x = 0; x < numberOflines; x++) {
                String palavra = bufferedReader.readLine();
                stringList.add(palavra);
            }

            stringList = stringList.stream().sorted().collect(Collectors.toList());

            for (int x = 0; x < numberOflines - 1; x++) {
                if (stringList.get(x + 1).startsWith(stringList.get(x))) {
                    listType = "Conjunto Ruim";
                    break;
                }
            }

            System.out.println(listType);

            numberOflines = Integer.parseInt(bufferedReader.readLine());

        }
    }
}