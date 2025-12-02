import java.util.Scanner;

public class ejercicio22 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dime una frase");
        String frase = sc.nextLine();

        frase = frase.trim();

        System.out.println(frase.toUpperCase());
        System.out.println(frase.toLowerCase());

        StringBuilder fraseSB = new StringBuilder(frase);
        char primeraLetra = fraseSB.charAt(0);
        primeraLetra = Character.toUpperCase(primeraLetra);
        fraseSB.setCharAt(0,primeraLetra);
        for (int i = 0; i < fraseSB.length(); i++) {
            if (fraseSB.charAt(i) == ' '){
                if (fraseSB.charAt(i+1) != ' '){
                    char c = fraseSB.charAt(i+1);
                    c = Character.toUpperCase(c);
                    fraseSB.setCharAt(i+1,c);
                }
            }
        }

        System.out.println(fraseSB);


    }
}
