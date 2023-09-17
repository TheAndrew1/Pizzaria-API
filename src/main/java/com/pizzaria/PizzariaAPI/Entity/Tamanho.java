package com.pizzaria.PizzariaAPI.Entity;

import lombok.Getter;

@Getter
public enum Tamanho {
    P("P", 1), M("M", 2), G("G", 3), GG("GG", 4);

    String tamanho;
    int quantidadeSabores;

    Tamanho(String tamanho, int quantidadeSabores) {
        this.tamanho = tamanho;
        this.quantidadeSabores = quantidadeSabores;
    }
}
