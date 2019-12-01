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
public class Arena {

    private int[][] arena;
    private int[][] coordenadas = new int[2][2];
    private int altura;
    private int largura;
    
    public Arena(int altura, int largura) {
        this.arena = new int[altura][largura];
        this.coordenadas = new int[2][2];
        this.altura = altura;
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int[][] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(int x, int y, int i) {
        this.coordenadas[i][0] = x;
        this.coordenadas[i][1] = y;
    }

    public int getElement(int i, int j) {
        return this.arena[i][j];
    }

    public void setElement(int i, int j, int value) {
        this.arena[i][j] = value;
    }
}