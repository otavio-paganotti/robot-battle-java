/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dev-Otávio
 */
public class Log {
    private int[][] posicao;
    private Arma arma;
    private boolean pisouBomba;
    private boolean pisouVirus;
    private Robo robo;
    private int[][] novaPosicao;

    public Log(int[][] posicao, Arma arma, boolean pisouBomba, boolean pisouVirus, Robo robo, int[][] novaPosicao) {
        this.posicao = posicao;
        this.arma = arma;
        this.pisouBomba = pisouBomba;
        this.pisouVirus = pisouVirus;
        this.robo = robo;
        this.novaPosicao = novaPosicao;
    }

    public int[][] getPosicao() {
        return posicao;
    }

    public void setPosicao(int[][] posicao) {
        this.posicao = posicao;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public boolean isPisouBomba() {
        return pisouBomba;
    }

    public void setPisouBomba(boolean pisouBomba) {
        this.pisouBomba = pisouBomba;
    }

    public boolean isPisouVirus() {
        return pisouVirus;
    }

    public void setPisouVirus(boolean pisouVirus) {
        this.pisouVirus = pisouVirus;
    }

    public Robo getRobo() {
        return robo;
    }

    public void setRobo(Robo robo) {
        this.robo = robo;
    }

    public int[][] getNovaPosicao() {
        return novaPosicao;
    }

    public void setNovaPosicao(int[][] novaPosicao) {
        this.novaPosicao = novaPosicao;
    }
    
    
}
