import java.util.Scanner;

public class Combinacao {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int casosDeUso = Integer.parseInt(scanner.nextLine());

        for(int i = 1; i <= casosDeUso; i++) {

            StringBuilder resultado = new StringBuilder();
            String[] palavras = scanner.nextLine().split(" ");

            int maxSize = Math.max (palavras[0].length(),
                    palavras[1].length());

            for(int dados = 0; dados < maxSize; dados++) {
                if(dados < palavras[0].length()) {
                    resultado.append(palavras[0].charAt(dados));
                }
                if(dados < palavras[1].length()) {
                    resultado.append(palavras[1].charAt(dados));
                }
            }

            System.out.println(resultado);

        }

    }

}