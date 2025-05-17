package br.com.conversordemoedas.service;

import br.com.conversordemoedas.models.ExchangeApi;
import br.com.conversordemoedas.models.MoedaConversao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;
import java.util.Scanner;

public class ConversorApi {
    private final String API_Key = System.getenv("API_KEY_ExchangeApi"); // cmd: setx API_KEY_ExchangeApi "key"
    private final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public void conexaoApi(String moedaOperacao) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String urlExchange = "https://v6.exchangerate-api.com/v6/"+ API_Key +"/pair/" + moedaOperacao;



        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlExchange)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        String json = response.body();

        ExchangeApi exchangeApi = gson.fromJson(json, ExchangeApi.class);
        if (!exchangeApi.result().equals("error")){
            MoedaConversao moedaConvercao = new MoedaConversao(exchangeApi);

            System.out.println(moedaConvercao);

            salvarArquivo(moedaConvercao.toString());

        } else{
            System.out.println("Error ao Converter moedas");
        }

    }

    public String moedaConvercao( String moedaConverter , String moedaConvertidada){
        return  moedaConverter +"/"+moedaConvertidada;
    }

    public String outrasMoedas(){

        System.out.println("Digite Moeda (ex:USD):");
        String moedaConverter = scanner.nextLine();

        System.out.println("Digite Moeda para conversão (ex:BRL):");
        String moedaConvertidada = scanner.nextLine();

        return moedaConverter +"/"+ moedaConvertidada;
    }

    public void salvarArquivo(String menssagem){
        try(FileWriter fileWriter = new FileWriter("Log.txt",true)) {
            fileWriter.write( "[" + java.time.LocalDateTime.now()+ "]" + menssagem + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void historico(){
        try {
            FileReader historico = new FileReader("Log.txt");
            BufferedReader lerhist = new BufferedReader(historico);

            String linha ;

            System.out.println("---Histórico---");

            while ((linha= lerhist.readLine()) != null) {
                System.out.println(linha);
            }
            lerhist.close();
            historico.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
