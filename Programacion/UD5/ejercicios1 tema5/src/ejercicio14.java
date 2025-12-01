import java.util.Arrays;
import java.util.Scanner;

public class ejercicio14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r;
        boolean seguir = true;

        String[] Teruel = new String[0];
        String[] Zaragoza = new String[0];
        String[] Huesca = new String[0];
        String[] Todos = new String[0];
        while (seguir){


        System.out.println("Mostrar pueblos por provincia    (1)");
        System.out.println("Introducir pueblos por provincia (2)");
        System.out.println("Mostrar todos los pueblos        (3)");
        System.out.println("Buscar pueblo                    (4)");
        System.out.println("Salir                            (5)");

        r = sc.nextInt();
        sc.nextLine();

        switch (r){
            case 1:
                int re = 0;

                System.out.println("Elije la provincia");
                System.out.println("Huesca   (1)");
                System.out.println("Teruel   (2)");
                System.out.println("Zaragoza (3)");

                re = sc.nextInt();
                sc.nextLine();
                switch (re){
                    case 1:
                        Arrays.sort(Huesca);
                        for (int i = 0; i < Huesca.length; i++){
                            System.out.println(Huesca[i]);
                        }
                        System.out.println(" ");
                        break;
                    case 2:
                        Arrays.sort(Teruel);
                        for (int i = 0; i < Teruel.length; i++){
                            System.out.println(Teruel[i]);
                        }
                        System.out.println(" ");
                        break;
                    case 3:
                        Arrays.sort(Zaragoza);
                        for (int i = 0; i < Zaragoza.length; i++){
                            System.out.println(Zaragoza[i]);
                        }
                        System.out.println(" ");
                        break;

                    default:
                        System.out.println("Error, numero incorrecto");
                        break;
                }
                break;
            case 2:


                int cantidad = 0;
                System.out.println("Elije la provincia");
                System.out.println("Huesca   (1)");
                System.out.println("Teruel   (2)");
                System.out.println("Zaragoza (3)");

                re = sc.nextInt();

                sc.nextLine();

                switch (re){
                    case 1:
                        System.out.println("Dime la cantidad de pueblos a ingresar");
                        cantidad = sc.nextInt();
                        sc.nextLine();
                        int longitud = Huesca.length;
                        Huesca = Arrays.copyOf(Huesca,Huesca.length+cantidad);
                        for (int i = longitud; i < longitud+cantidad; i++){
                            System.out.println("Ingresa el nombre" );
                                Huesca[i] = sc.next();
                                sc.nextLine();
                        }
                        break;
                    case 2:
                        System.out.println("Dime la cantidad de pueblos a ingresar");
                        cantidad = sc.nextInt();
                        sc.nextLine();
                        int longitud2 = Teruel.length;
                        Teruel = Arrays.copyOf(Teruel,Teruel.length+cantidad);
                        for (int i = longitud2; i < longitud2+cantidad; i++){
                            System.out.println("Ingresa el nombre" );
                            Teruel[i] = sc.next();
                            sc.nextLine();
                        }
                        break;
                    case 3:
                        System.out.println("Dime la cantidad de pueblos a ingresar");
                        cantidad = sc.nextInt();
                        sc.nextLine();
                        int longitud3 = Zaragoza.length;
                        Zaragoza = Arrays.copyOf(Zaragoza,Zaragoza.length+cantidad);
                        for (int i = longitud3; i < longitud3+cantidad; i++){
                            System.out.println("Ingresa el nombre" );
                            Zaragoza[i] = sc.next();
                            sc.nextLine();
                        }
                        break;

                    default:
                        System.out.println("Error, numero incorrecto");
                        break;
                }
                break;
            case 3:
                Arrays.sort(Huesca);
                System.out.println("Pueblos de Huesca:");
                for (int i = 0; i < Huesca.length; i++){
                    System.out.println(Huesca[i]);
                }
                System.out.println(" ");

                Arrays.sort(Teruel);
                System.out.println("Pueblos de Teruel:");
                for (int i = 0; i < Teruel.length; i++){
                    System.out.println(Teruel[i]);
                }
                System.out.println(" ");

                Arrays.sort(Zaragoza);
                System.out.println("Pueblos de Zaragoza:");
                for (int i = 0; i < Zaragoza.length; i++){
                    System.out.println(Zaragoza[i]);
                }
                System.out.println(" ");



                break;
            case 4:

                break;
            case 5:
                System.out.println("Hasta luego!");
                seguir = false;
                break;
            default:
                System.out.println("Error, numero incorrecto");
                break;
        }
        }
    }




}
