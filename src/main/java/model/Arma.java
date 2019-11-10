/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.*;

/**
 *
 * @author otavi
 */
public class Arma {
    public Arma() {
    }
    
    public boolean leArquivo() {
        try {
            // Le o arquivo
            FileReader ler = new FileReader("Armas.txt");
            BufferedReader reader = new BufferedReader(ler);  
            String linha;
            while( (linha = reader.readLine()) != null ){
                System.out.println(linha);
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
