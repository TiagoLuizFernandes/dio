import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainCoracao {

    static Map<String, Integer> hashMap = new HashMap<>();
    static int cartas;
    static int[][] pilha = new int[3][102];

    static public boolean cartas(int a, int b, int c) {

        String ss = "" + a + b + c;

        if (a == b && b == c && c == cartas) {

            hashMap.putIfAbsent(ss, 1);
            return true;

        }

        int x = hashMap.getOrDefault(ss, 0);

        if (x > 0) return (x == 1);

        if (a < cartas && pilha[0][a] % 3 == 0 && cartas(a + 1, b, c)) {

            hashMap.putIfAbsent(ss, 1);
            return true;

        }

        if (b < cartas && pilha[1][b] % 3 == 0 && cartas(a, b + 1, c)) {

            hashMap.putIfAbsent(ss, 1);
            return true;

        }

        if (c < cartas && pilha[2][c] % 3 == 0 && cartas(a, b, c + 1)) {

            hashMap.putIfAbsent(ss, 1);
            return true;

        }
        if (a < cartas && b < cartas && (pilha[0][a] + pilha[1][b]) % 3 == 0 && cartas(a + 1, b + 1, c)) {

            hashMap.putIfAbsent(ss, 1);
            return true;
        }

        if (a < cartas && c < cartas && (pilha[0][a] + pilha[2][c]) % 3 == 0 && cartas(a + 1, b, c + 1)) {

            hashMap.putIfAbsent(ss, 1);
            return true;

        }

        if (b < cartas && c < cartas && (pilha[1][b] + pilha[2][c]) % 3 == 0 && cartas(a, b + 1, c + 1)) {

            hashMap.putIfAbsent(ss, 1);
            return true;

        }

        if (a < cartas && b < cartas && c < cartas && (pilha[0][a] + pilha[1][b] + pilha[2][c]) % 3 == 0 && cartas(a + 1, b + 1, c + 1)) {

            hashMap.putIfAbsent(ss, 1);
            return true;
        }

        hashMap.putIfAbsent(ss, 2);
        return false;

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true) {

            cartas = Integer.parseInt(in.nextLine());

            if (cartas == 0) break;

            for (int i = 0; i < cartas; i++) {

                StringTokenizer st = new StringTokenizer(in.nextLine());
                pilha[0][i] = Integer.parseInt(st.nextToken());
                pilha[1][i] = Integer.parseInt(st.nextToken());
                pilha[2][i] = Integer.parseInt(st.nextToken());

            }

            if (cartas(0, 0, 0)) System.out.println("1");
            else System.out.println("0");
            hashMap.clear();
        }

    }

}
