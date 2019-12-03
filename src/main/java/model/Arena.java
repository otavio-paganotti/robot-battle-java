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
    private int x;
    private int y;
    
    public Arena(int x, int y) {
        this.arena = new int[x][y];
        this.coordenadas = new int[2][2];
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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