import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NovoHttpClient {

    /**
     * Implementado no Java 11
     */
    public static void main(String[] args) {
        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder(criarUri()).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private static URI criarUri() {
        return URI.create("https://viacep.com.br/ws/36050000/json/");
    }
}