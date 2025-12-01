public class ejercicio15 {
    public static void main(String[] args) {
        String cadena = "Buenos dias";
        StringBuilder invertida = new StringBuilder();
        for (int i = cadena.length() -1; i>= 0; i--){
            invertida.append(cadena.charAt(i));


        }

        System.out.println(invertida.toString());
    }
}
