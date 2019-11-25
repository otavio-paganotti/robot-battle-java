/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author otavi
 */
public class Arena {

    private int[][] arena;
    private int[][] coordenadas = new int[2][2];
    private int altura;
    private int largura;
    private int comprimento;
    
    public Arena(int altura, int largura) {
        this.arena = new int[altura][largura];
        this.coordenadas = new int[2][2];
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
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

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public int[][] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(int[][] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public int getElement(int i, int j) {
        return this.arena[i][j];
    }
}