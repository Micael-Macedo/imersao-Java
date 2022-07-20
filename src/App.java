import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\u001b[1m Filme: \u001b[m" + filme.get("title"));
            System.out.println("\u001b[1m Imagem: \u001b[m" + filme.get("image"));
            System.out.println("\u001b[43m \u001b[1m Nota:" + filme.get("imDbRating") + "\u001b[m");
            System.out.println();
        }
    }
}
