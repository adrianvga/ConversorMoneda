import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

    String apiKey = "edcfe9da8ca3b172ee9720c9";
    public Moneda convertirMoneda(String monedaBase, String monedaDestino, double cantidad) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/" +
                monedaBase + "/" + monedaDestino + "/" + cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No se pudo realizar la conversión de moneda: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado : " + e.getMessage());
        }




    }
}
