/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author otavi
 */
public class LeituraArquivos {
    private String[][] armas;
    private String[] bombas;
    private String[] virus;

    public LeituraArquivos(String[][] armas, String[] bombas, String[] virus) {
        this.armas = armas;
        this.bombas = bombas;
        this.virus = virus;
    }
    public LeituraArquivos() {
        
    }

    public String[][] getArmas() {
        return armas;
    }

    public void setArmas(String[][] armas) {
        this.armas = armas;
    }

    public String[] getBombas() {
        return bombas;
    }

    public void setBombas(String[] bombas) {
        this.bombas = bombas;
    }

    public String[] getVirus() {
        return virus;
    }

    public void setVirus(String[] virus) {
        this.virus = virus;
    }
    
    public boolean leArquivo(String arquivo) {
        try {
            // Le o arquivo
            FileReader ler = new FileReader(arquivo + ".txt");
            BufferedReader reader = new BufferedReader(ler);  
            String linha;
            int i = 0;
            switch(arquivo) {
                case "Bomba":
                    i = 0;
                    String[] bombas = new String[3];
                    while( (linha = reader.readLine()) != null ){
                        bombas[i] = linha;
                        i++;
                    }
                    this.setBombas(bombas);
                    break;
                case "Virus":
                    i = 0;
                    String[] virus = new String[3];
                    while( (linha = reader.readLine()) != null ){
                        virus[i] = linha;
                        i++;
                    }
                    this.setVirus(virus);
                    break;
                case "Armas":
                    String[][] armas = new String[3][3];
                    for (i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if ((linha = reader.readLine()) != null) {
                                armas[i][j] = linha;
                            }
                        }
                    }
                    this.setArmas(armas);
                    break;
            }

            // Imprime confirmacao
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
