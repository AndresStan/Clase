import java.io.File;
import java.lang.runtime.TemplateRuntime;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HashMap<Character, Long> map = new HashMap<>();
        Path rutaJSON = Path.of("src/json.json");
        File fileJSON = rutaJSON.toFile();

        Path rutaXML = Path.of("src/xml.xml");
        File fileXML = rutaXML.toFile();


        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Introduce una frase");
            String frase = sc.nextLine();
            frase = frase.replace(" ", "");
            for (Character c : frase.toCharArray()){
                map.put(c, map.containsKey(c) ? map.get(c) +1 : 1);
            }
            System.out.println(map);
        }



        // Deserializar JSON

    }
}