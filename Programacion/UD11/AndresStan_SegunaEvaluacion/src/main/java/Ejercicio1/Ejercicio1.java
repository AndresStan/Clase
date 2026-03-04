package Ejercicio1;

import java.lang.reflect.Array;
import java.util.*;

public class Ejercicio1 {
    public static void main(String[] args) {

        //Random random = new Random();

        ArrayList<Integer> lista = new ArrayList<>();
        LinkedHashMap<Integer, Integer> listaOrdenada = new LinkedHashMap<>();

       // for (int i = 0; i < 20; i++){

        //    lista.add(random.nextInt(50));

       // }

        lista.add(1);
        lista.add(2);
        lista.add(1);
        lista.add(3);

        for (Integer i : lista){
            listaOrdenada.put(i, listaOrdenada.containsKey(i) ? listaOrdenada.get(i) +1 : 1);
        }

        List<Map.Entry<Integer, Integer>>  listaNueva = new ArrayList<>(listaOrdenada.entrySet());





        System.out.println(listaOrdenada);



    }
}
