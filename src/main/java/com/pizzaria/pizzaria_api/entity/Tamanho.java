package com.pizzaria.pizzaria_api.entity;

import lombok.Getter;

@Getter
public enum Tamanho {
    P("P", 1), M("M", 2), G("G", 3), GG("GG", 4);

    String tamanhoPizza;
    int quantidadeSabores;

    Tamanho(String tamanho, int quantidadeSabores) {
        this.tamanhoPizza = tamanho;
        this.quantidadeSabores = quantidadeSabores;
    }
}
