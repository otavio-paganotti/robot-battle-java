/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author otavi
 */
public class ItensEspeciais {
    private ArrayList<Virus> virus;
    private ArrayList<Bomba> bomba;
    private ArrayList<Arma> armas;

    public ItensEspeciais(ArrayList<Virus> virus, ArrayList<Bomba> bomba, ArrayList<Arma> armas) {
        this.virus = virus;
        this.bomba = bomba;
        this.armas = armas;
    }

    public ArrayList<Virus> getVirus() {
        return virus;
    }

    public void setVirus(ArrayList<Virus> virus) {
        this.virus = virus;
    }

    public ArrayList<Bomba> getBomba() {
        return bomba;
    }

    public void setBomba(ArrayList<Bomba> bomba) {
        this.bomba = bomba;
    }

    public ArrayList<Arma> getArmas() {
        return armas;
    }

    public void setArmas(ArrayList<Arma> armas) {
        this.armas = armas;
    }

    public int getVirusSize() {
        return this.virus.size();
    }

    public int getBombaSize() {
        return this.bomba.size();
    }

    public int getArmaSize() {
        return this.armas.size();
    }
    
}
