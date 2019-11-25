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
public class ItensEspeciais {
    private String[] virus;
    private String[] bomba;
    private String[][] armas;

    public ItensEspeciais(String[] virus, String[] bomba, String[][] armas) {
        this.virus = virus;
        this.bomba = bomba;
        this.armas = armas;
    }

    public String[] getVirus() {
        return virus;
    }

    public void setVirus(String[] virus) {
        this.virus = virus;
    }

    public String[] getBomba() {
        return bomba;
    }

    public void setBomba(String[] bomba) {
        this.bomba = bomba;
    }

    public String[][] getArmas() {
        return armas;
    }

    public void setArmas(String[][] armas) {
        this.armas = armas;
    }
    
}
