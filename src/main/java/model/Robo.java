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
    private String J1;
    private String J2;
    private Arma arma;
    private Arena posicao;
    private int vida;

    public Robo(Arma arma, Arena posicao, int vida) {
        this.J1 = "Jogador 1";
        this.J2 = "Jogador 2";
        this.arma = arma;
        this.posicao = posicao;
        this.vida = vida;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Arena getPosicao() {
        return posicao;
    }

    public void setPosicao(Arena posicao) {
        this.posicao = posicao;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    
}
