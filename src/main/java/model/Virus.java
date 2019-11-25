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
public class Virus {
    private String[] virus;
    
    public Virus(String[] virus) {
        this.virus = virus;
    }

    public String[] getVirus() {
        return virus;
    }

    public void setVirus(String[] virus) {
        this.virus = virus;
    }
    
}
