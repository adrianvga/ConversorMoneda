import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public void mostrarMenu(){

        String usd = "USD";
        String ars = "ARS";
        String brl = "BRL";
        String cop = "COP";

        ConsultaApi consulta = new ConsultaApi();
        boolean salir = false;

        try{

            while (!salir) {

                System.out.println("Conversor de Moneda");

                System.out.println("""
                    
                    1.- Dolar a Peso argentino.
                    2.- Peso argentino a Dolar.
                    3.- Dolar a Real brasileño.
                    4.- Real brasileño a Dolar.
                    5.- Dolar a Peso colombiano.
                    6.- Peso colombiano a Dolar.
                    7.- Salir
                    
                    Elija una opción válida: 
                    """);
                int opcion = Integer.parseInt(new Scanner(System.in).nextLine());

                System.out.print("Ingresa el valor que deseas convertir: ");
                var cantidad = Double.parseDouble(new Scanner(System.in).nextLine());

                switch (opcion) {
                    case 1 -> {
                        Moneda moneda = consulta.convertirMoneda(usd, ars, cantidad);
                        System.out.println("La cantidad de " + cantidad + moneda);
                    }
                    case 2 -> {
                        Moneda moneda = consulta.convertirMoneda(ars, usd, cantidad);
                        System.out.println("La cantidad de " + cantidad + moneda);

                    }
                    case 3 -> {
                        Moneda moneda = consulta.convertirMoneda(usd, brl, cantidad);
                        System.out.println("La cantidad de " + cantidad + moneda);
                    }
                    case 4 -> {
                        Moneda moneda = consulta.convertirMoneda(brl, usd, cantidad);
                        System.out.println("La cantidad de " + cantidad + moneda);
                    }
                    case 5 -> {
                        Moneda moneda = consulta.convertirMoneda(usd, cop, cantidad);
                        System.out.println("La cantidad de " + cantidad + moneda);
                    }
                    case 6 -> {
                        Moneda moneda = consulta.convertirMoneda(cop, usd, cantidad);
                        System.out.println("La cantidad de " + cantidad + moneda);
                    }
                    case 7 -> {
                        System.out.print("Finalizando el programa...");
                        salir = true;
                    }
                    default -> System.out.println("Opcion invalida: " + opcion);
                }


                System.out.println();
            }

        }catch(NumberFormatException e) {
            System.out.println("Opcion Invalida " + e.getMessage());
        }catch(RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando el programa...");
        }
    }

}
