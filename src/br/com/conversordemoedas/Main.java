package br.com.conversordemoedas;

import br.com.conversordemoedas.service.ConversorApi;
import br.com.conversordemoedas.service.Menu;
import com.google.gson.Gson;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Menu menu = new Menu();
        menu.menu();
    }
}
