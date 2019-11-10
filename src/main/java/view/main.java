/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.*;

/**
 *
 * @author otavi
 */
public class main {
  public static void main(String[] args) {
      Arma arma = new Arma();
      Bomba bomba = new Bomba();
      Virus virus = new Virus();
      System.out.println("Armas\n====================\n" + arma.leArquivo() + "\n");
      System.out.println("Bombas\n====================\n" + bomba.leArquivo() + "\n");
      System.out.println("Virus\n====================\n" + virus.leArquivo());
  }
}
