/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author otavi
 */
public class Robo {
    private String jogador;
    private Arma arma;
    private int vida;

    public Robo(String jogador) {
        this.jogador = jogador;
        this.vida = 100;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogadores) {
        this.jogador = jogador;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
