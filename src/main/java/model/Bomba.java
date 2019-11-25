/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author otavi
 */
public class Bomba {
    
    private String[] bombas;

    public Bomba(String[] bombas) {
        this.bombas = bombas;
    }

    public String[] getBombas() {
        return bombas;
    }

    public void setBombas(String[] bombas) {
        this.bombas = bombas;
    }
    
}
