package br.com.tts.dio.ordernapalavras;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Número de frases: ");
        int linhas = Integer.parseInt(br.readLine());

        for (int i = 0; i < linhas; i++) {
            System.out.println("Informe a frase " + (i + 1) + ": ");
            var palavras = br.readLine();
            List<String> listaPalavras =
                    new ArrayList<>(Arrays.stream(palavras.split(" ")).collect(Collectors.toList()));
            var listaOrdenada = listaPalavras.stream()
                    .sorted(Comparator.comparingInt(String::length).reversed()
                            .thenComparing(String::compareTo)).collect(Collectors.joining(" "));

            System.out.println(listaOrdenada);

        }
    }
}