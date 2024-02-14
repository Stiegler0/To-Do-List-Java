package main;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MonAPI {
    private HttpClient client;

    public MonAPI() {
        this.client = HttpClient.newHttpClient();
    }

    public String getQuote() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://zenquotes.io/api/random"))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JSONArray jsonarray = new JSONArray(response.body());
                JSONObject jsonObject = jsonarray.getJSONObject(0);
                String Author = jsonObject.getString("q");
                return Author;
            } else {
                System.out.println("Error");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "FAiled";
        }

        return null;
    }
}