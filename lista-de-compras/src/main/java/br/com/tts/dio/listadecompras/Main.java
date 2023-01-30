package br.com.tts.dio.listadecompras;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); // Lê a linha de entrada

        int N = Integer.parseInt(st.nextToken());

        ArrayList<String> lista = new ArrayList();
        ArrayList<String> listaOrdernada = new ArrayList();

        for(int x = 0 ; x < N ; x ++){
            String items = br.readLine();
            lista.add(items);
        }

        //System.out.println(N);

        for(String item : lista){
            String[] parts = item.split(" ");

            List<String> l = Arrays.stream(parts).sorted().distinct().collect(Collectors.toList());

            String itemOrdenado = "";
            for (int i = 0; i < l.size(); i++) {
                if (i == 0) {
                    itemOrdenado = l.get(i);
                }else{
                    itemOrdenado = itemOrdenado + " " + l.get(i);
                }
            }
            listaOrdernada.add(itemOrdenado);
        }

        for(String item2 : listaOrdernada){
            System.out.println(item2);
        }


    }

}
