package br.com.conversordemoedas.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConversorApi {
    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;

    public void conexaoApi() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String test = "";

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(test)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
