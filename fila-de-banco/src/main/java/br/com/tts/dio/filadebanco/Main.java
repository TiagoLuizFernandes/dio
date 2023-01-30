package br.com.tts.dio.filadebanco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int testes =  0;

        testes = scanner.nextInt();

        for (int i = 0; i < testes; i++) {

            List<Integer> intList = new ArrayList<>();
            List<Integer> intListOrd = new ArrayList<>();

            //scanner.nextLine();
            int clientes = scanner.nextInt();

            for (int j = 0; j < clientes; j++) {
                intList.add(scanner.nextInt());
            }

            intListOrd = intList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

            int jj=0;
            for (int j = 0; j < intList.size() ; j++) {
                if (Objects.equals(intList.get(j), intListOrd.get(j))) {
                    jj++;
                }
            }
            System.out.println(jj);
        }

    }

}
