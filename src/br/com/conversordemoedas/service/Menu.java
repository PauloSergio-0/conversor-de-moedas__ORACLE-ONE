package br.com.conversordemoedas.service;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    public void menu() throws IOException, InterruptedException {
        int opcao;

        ConversorApi conversorApi = new ConversorApi();

        while(true){
            System.out.println(
            """
            ---Conversor de Moedas---
            
            1.Dolar(USD) para Real Brasileiro(BRL)
            2.Real Brasileiro(BRL) para Dolar(USD)
            3.Dolar(USD) para Euro(EUR)
            4.Euro(EUR) para Dolar(USD)
            5.Dolar(USD) para Iene Japonês(JPY)
            6.Iene Japonês(JPY) para Dolar(USD) 
            7.Histórico
            8.Outras Moedas
            9.Sair
            
            """);

            System.out.println("Escolha uma opcção:");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 9){
                System.out.println("SAINDO.......");
                break;

            } else if (opcao == 1) {
                conversorApi.conexaoApi(conversorApi.moedaConvercao("USD", "BRL"));

            }  else if (opcao == 2) {
                conversorApi.conexaoApi(conversorApi.moedaConvercao("BRL", "USD"));

            }  else if (opcao == 3) {
                conversorApi.conexaoApi(conversorApi.moedaConvercao("USD", "EUR"));

            }  else if (opcao == 4) {
                conversorApi.conexaoApi(conversorApi.moedaConvercao("EUR", "USD"));

            }  else if (opcao == 5) {
                conversorApi.conexaoApi(conversorApi.moedaConvercao("USD", "JPY"));

            }  else if (opcao == 6) {
                conversorApi.conexaoApi(conversorApi.moedaConvercao("JPY", "USD"));

            }  else if (opcao == 7) {
                conversorApi.historico();

            }  else if (opcao == 8) {
                conversorApi.conexaoApi(conversorApi.outrasMoedas());

            }

        }
    }
}
