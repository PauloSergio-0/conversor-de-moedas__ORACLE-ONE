package br.com.conversordemoedas.models;

public class MoedaConversao {
    private String resultado;
    private String moeda;
    private String moedaConvertida;
    private Double valorConvertido;

    public MoedaConversao(ExchangeApi exchangeApi){
        this.resultado = exchangeApi.result();
        this.moeda = exchangeApi.base_code();
        this.moedaConvertida = exchangeApi.target_code();
        this.valorConvertido = exchangeApi.conversion_rate();
    }

    @Override
    public String toString() {
        return "\nMoeda: " + this.moeda
                +"\nMoeda Convertida: " +  this.moedaConvertida
                +"\nValor converção: " + this.valorConvertido
                +"\n";
    }
}
