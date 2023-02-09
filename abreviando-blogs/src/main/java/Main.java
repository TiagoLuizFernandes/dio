import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> alfabeto = new ArrayList<>(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));

        Scanner sc = new Scanner(System.in, StandardCharsets.ISO_8859_1);

        while(true) {

            String frase = sc.nextLine()
                    .trim()
                    .toLowerCase()
                    .replaceAll("\n", " ")
                    .replaceAll("\t", " ");

            if(frase.equals(".")) break;
            if(frase.length() <= 0) continue;

            List<String> vetPalavrasFrase = new ArrayList<>(Arrays.asList(frase.split(" ")));
            Map<String, String> dicionario = new HashMap<>();

            alfabeto.forEach(letra -> dicionario.put(letra, ""));

            Map<String, Map<String, Integer>> repeticaoPalavra = new HashMap<>();

            alfabeto.forEach(letra -> repeticaoPalavra.put(letra, new HashMap<>()));

            vetPalavrasFrase.forEach(palavra -> repeticaoPalavra.get(palavra.substring(0, 1)).put(palavra, 0));

            vetPalavrasFrase.forEach(palavra -> {

                int qt = repeticaoPalavra.get(palavra.substring(0, 1)).get(palavra);
                qt++;
                repeticaoPalavra.get(palavra.substring(0, 1)).put(palavra, qt);

            });


            alfabeto.forEach(letra -> {

                Map<String, Integer> map = repeticaoPalavra.get(letra);
                List<String> chaves = new ArrayList<>(map.keySet());

                int qtTotalCharPorLetra = 0;

                for (String chave : chaves) {

                    qtTotalCharPorLetra += map.get(chave) * chave.length();

                }

                int qtTotalCharMelhorCenario;
                int qtTotalCharMelhorCenarioAux = 10000;

                for (String chave : chaves) {

                    qtTotalCharMelhorCenario = (qtTotalCharPorLetra - (map.get(chave) * chave.length())) + (map.get(chave) * 2);

                    if((qtTotalCharMelhorCenarioAux > qtTotalCharMelhorCenario) && chave.length() > 2) {

                        qtTotalCharMelhorCenarioAux = qtTotalCharMelhorCenario;
                        dicionario.put(letra, chave);

                    }

                }

            });

            String fraseAbreviada = vetPalavrasFrase
                    .stream()
                    .map(palavra -> {

                        String primeiraLetra = palavra.substring(0, 1);
                        return dicionario.get(primeiraLetra).equals(palavra) ? primeiraLetra + "." : palavra;

                    }).collect(Collectors.joining(" "));

            System.out.println(fraseAbreviada);
            int quantidadeAbreviacoes = 0;

            for(String letra : alfabeto) {

                if(!dicionario.get(letra).equals("")) {

                    quantidadeAbreviacoes++;

                }

            }

            System.out.println(quantidadeAbreviacoes);

            alfabeto.forEach(letra -> {

                if(!dicionario.get(letra).equals("")) {

                    System.out.println(letra + ". = " + dicionario.get(letra) );

                }

            });

        }

    }

}
