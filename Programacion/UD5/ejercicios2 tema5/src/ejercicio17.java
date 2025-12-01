public class ejercicio17 {
    static void main(String[] args) {

        String cadenaMia = "Buenos dias a todos!";

        StringBuilder cadena = new StringBuilder(cadenaMia);

        for (int i = 0; i < cadena.length() -1; i++){
            if (cadena.charAt(i) == ' ') {
                cadena.deleteCharAt(i);
            }
        }

        System.out.println(cadena.toString());
    }
}
