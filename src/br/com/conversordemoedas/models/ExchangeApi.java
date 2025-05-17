package br.com.conversordemoedas.models;

import java.util.Map;

public record ExchangeApi(String result, String base_code, String target_code , double conversion_rate) {
}
