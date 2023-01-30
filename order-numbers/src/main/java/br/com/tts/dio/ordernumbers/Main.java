package br.com.tts.dio.ordernumbers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();


        List<Integer> paresList   = new ArrayList<>();
        List<Integer> imparesList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int value = s.nextInt();
            if ( (value % 2) == 0 ) {
                paresList.add(value);
            }else {
                imparesList.add(value);
            }
        }

        CompareNumber compareNumber = new CompareNumber();

        paresList.sort(compareNumber);
        imparesList.sort(compareNumber.reversed());

        for (Integer par : paresList) {
            System.out.println(par);
        }

        for (Integer imp : imparesList) {
            System.out.println(imp);
        }

        //System.out.println(paresList);
        //System.out.println(imparesList);

    }

    static class CompareNumber implements Comparator<Integer>
    {
        public int compare(Integer a, Integer b)
        {
            if (a < b) return -1;
            if (a > b) return 1;
            else return 0;
        }
    }

}
