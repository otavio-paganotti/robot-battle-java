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
 * @author otavi, kardek, jose
 */
public class Arma {
    private String[][] armas;

    public Arma(String[][] armas) {
        this.armas = armas;
    }

    public String[][] getArmas() {
        return armas;
    }

    public void setArmas(String[][] armas) {
        this.armas = armas;
    }
    
}
