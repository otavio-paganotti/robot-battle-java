/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Arma;
import model.Bomba;
import model.Virus;

/**
 *
 * @author otavi
 */
public class LeituraArquivos {
    private ArrayList<Arma> armasList;
    private ArrayList<Bomba> bombasList;
    private ArrayList<Virus> virusList;

    public LeituraArquivos() {
        this.virusList = new ArrayList<Virus>();
        this.bombasList = new ArrayList<Bomba>();
        this.armasList = new ArrayList<Arma>();

        this.leArquivo("Virus");
        this.leArquivo("Bomba");
        this.leArquivo("Armas");
    }

    public ArrayList<Arma> getArmas() {
        return armasList;
    }

    public void setArmas(Arma arma) {
        this.armasList.add(arma);
    }

    public ArrayList<Bomba> getBombas() {
        return bombasList;
    }

    public void setBombas(Bomba bomba) {
        this.bombasList.add(bomba);
    }

    public ArrayList<Virus> getVirus() {
        return virusList;
    }

    public void setVirus(Virus virus) {
        this.virusList.add(virus);
    }
    
    public boolean leArquivo(String arquivo) {
        try {
            // Le o arquivo
            FileReader ler = new FileReader(arquivo + ".txt");
            BufferedReader reader = new BufferedReader(ler);  
            String linha;
            switch(arquivo) {
                case "Bomba":
                    String bombas[] = new String[3];
                    while( (linha = reader.readLine()) != null ){
                        bombas = linha.split(" ");
                        this.setBombas(new Bomba(bombas[0], bombas[1], bombas[2]));
                        bombas = new String[3];
                    }
                    break;
                case "Virus":
                    String virus[] = new String[3];
                    while( (linha = reader.readLine()) != null ){
                        virus = linha.split(" ");
                        this.setVirus(new Virus(virus[0], virus[1], virus[2]));
                        
                        virus = new String[3];
                    }
                    break;
                case "Armas":
                    String armas[] = new String[3];
                    while( (linha = reader.readLine()) != null ){
                        armas = linha.split(" ");
                        this.setArmas(new Arma(armas[0], armas[1], armas[2]));
                        armas = new String[3];
                    }
                    break;
            }
            reader.close();

            // Imprime confirmacao
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
