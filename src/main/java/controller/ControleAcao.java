/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import model.*;

/**
 *
 * @author otavi
 */
public class ControleAcao {
    private Arena arena;
    private ArrayList<Robo> robo;
    private boolean turno;

    public ControleAcao(Arena arena, ArrayList<Robo> robo) {
        this.arena = arena;
        this.robo = robo;
        this.turno = true;
    }

    public ControleAcao() {

    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public ArrayList<Robo> getRobo() {
        return robo;
    }

    public void setRobo(ArrayList<Robo> robo) {
        this.robo = robo;
    }

    public boolean mover(boolean turno, int[][] coordenadas) {

        /*
         * O robô irá se movimentar pela arena respeitando os limites da mesma. Se o
         * robô enviar seta p/ baixo, o robô se moverá para uma posição abaixo na
         * matriz, e assim sucessivamente. Dentre essas posições da matriz, poderá ter
         * armas, vírus e bombas pelo mapa, então dependendo de onde o personagem se
         * mover, poderá ganhar uma arma nova, ou sofrer dano. . . . . . . . . . . . . .
         * . . _________________________________ . . | . . . . a . . b . . | . . | . . 1
         * a . . . v . . | . . | . . . . . . . . . v | . . | . . . . . . . 2 . a | . . |
         * . . . . . . v . . . | . . _________________________________ . . . . . . . . .
         * . . . . . .
         *
         * O jogo será realizado em turnos. Cada jogador, tem direito a 3 movimentos por
         * turno, a não ser que o jogador inimigo esteja em seu range. O jogador poderá
         * se movimentar em 4 direções distintas, e caso ultrapasse os limites da arena,
         * sofrerá dano de forma exponencial. Se o jogador encostar na bomba, sofrerá
         * imediatamente 90 de dano. Se o jogador encostar no vírus, sofrerá
         * imediatamente 40 de dano. Se o jogador encostar na arma, deverá aparecer uma
         * opção de escolha se o usuário quer ou não equipar a arma. Se o jogador
         * colidir com o outro jogador, o mesmo irá spawnar aleatóriamente no mapa. Cada
         * jogador terá 100 pontos de vida. Se o jogador estiver em condições de ataque
         * do outro jogador, poderá efetuar o ataque.
         */

        Scanner scan = new Scanner(System.in);
        int i = 0;

        do {

            String tecla = scan.nextLine();
            switch (tecla) {
            case "w":
                System.out.println("Apertou a tecla W");
                this.imprimirMatriz(this.arena);
                break;
            case "W":
                System.out.println("Apertou a tecla w");
                this.imprimirMatriz(this.arena);
                break;
            case "a":
                System.out.println("Apertou a tecla a");
                this.imprimirMatriz(this.arena);
                break;
            case "A":
                System.out.println("Apertou a tecla A");
                this.imprimirMatriz(this.arena);
                break;
            case "s":
                System.out.println("Apertou a tecla s");
                this.imprimirMatriz(this.arena);
                break;
            case "S":
                System.out.println("Apertou a tecla S");
                this.imprimirMatriz(this.arena);
                break;
            case "d":
                System.out.println("Apertou a tecla d");
                this.imprimirMatriz(this.arena);
                break;
            case "D":
                System.out.println("Apertou a tecla D");
                this.imprimirMatriz(this.arena);
                break;
            default:
                System.out.println("Aperte as Teclas W A S D para se mover!!!");
            }
            i++;
        } while (i < 1);

        // scan.close();

        this.trocaTurno();
        return true;

    }

    public boolean atacar() {
        return true;
    }

    public boolean pisouBomba() {
        return true;
    }

    public boolean pisouVirus() {
        return true;
    }

    public boolean pisouArma() {
        return true;
    }

    public boolean colisao() {
        return true;
    }

    public boolean excederLimiteMovimento() {
        // Terá uma classe própria para tratar os erros de limite de movimento
        // ./ControleExcecaoLimiteMovimento.java
        return true;
    }

    public boolean excedorLimiteArena() {
        // Terá uma classe própria para tratar os erros de limite de arena
        // ./ControleExcecaoLimiteArena.java
        return true;
    }

    public void imprimirMatriz(Arena arena) {
        for(int i = 0; i < arena.getAltura(); i++) {
            System.out.printf("|");
            for (int j = 0; j < arena.getLargura(); j++) {
                System.out.printf(" %2d ", arena.getElement(i, j));
            }
            System.out.printf("|\n");
        }
    }
    
    public boolean InicializarJogo() {
        try {
            System.out.println("\n");
            System.out.println("Bem-vindo a Batalha de Robôs!!\n");
            System.out.println("==============================\n");
            System.out.println("\n");

            System.out.println("Entre com o tamanho da arena que deseja batalhar até a morte:\n");

            Scanner scan = new Scanner(System.in);

            System.out.println("Largura: \n");
            int x = scan.nextInt();
            System.out.println("\n");
            System.out.println("Altura: \n");
            int y = scan.nextInt();
            System.out.println("\n");

            Arena arena = new Arena(x, y);

            LeituraArquivos arquivos = new LeituraArquivos();

            ItensEspeciais especiais = new ItensEspeciais(arquivos.getVirus(), arquivos.getBombas(), arquivos.getArmas());

            System.out.println("Agora vamos criar os robôs: \n");
            System.out.println("============================\n");
            System.out.println("Qual o nome assustador do Robô nº 1? \n");
            String r1 = scan.next();
            System.out.println("Leeeeeegaaaaaaallll!!! \nAgora nos mostre o nome do Robô que enfrentará o grandioso " + r1 + " \n");
            String r2 = scan.next();
            System.out.println("Se preparem " + r1 + " e " + r2 + ", pois enfrentarão uma batalha até a morte!!!!");

            Robo robo1 = new Robo(r1);
            Robo robo2 = new Robo(r2);

            ArrayList<Robo> robos = new ArrayList<Robo>();

            robos.add(robo1);
            robos.add(robo2);
            
            this.arena = arena;
            this.robo = robos;
            
            this.posicionarElementos(especiais);
            
            this.imprimirMatriz(this.arena);
            
            Random randomNum = new Random();
            int vez = randomNum.nextInt(2);
            this.iniciaTurno(vez);
            scan.close();
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();                    
            return false;
        }
    }
    
    public boolean iniciaTurno(int valor) {
        if (valor == 0) {
            this.setTurno(true);
        } else {
            this.setTurno(false);
        }
        System.out.println("\n\n\nVez do jogador " + this.robo.get(valor).getJogador() + " \n\n\n");
        this.mover(this.isTurno(), this.arena.getCoordenadas());
        return true;
    }
    
    public void trocaTurno() {
        this.setTurno(!this.isTurno());

        this.mover(this.isTurno(), this.arena.getCoordenadas());
    }
    
    public void posicionarElementos(ItensEspeciais especiais) {
        int densidade = (this.arena.getAltura() * this.arena.getLargura())/8;
        Random rand = new Random();

        int i = 0;

        do {
            int x = rand.nextInt(this.arena.getAltura());
            int y = rand.nextInt(this.arena.getLargura());

            if (this.arena.getElement(x, y) == 0) {
                int value = 0;
                if (i < this.robo.size()) {
                    value = i + 1;
                    this.arena.setElement(x, y, value);
                    this.arena.setCoordenadas(x, y, i);
                } else {
                    int itemEspecial = rand.nextInt(3);
    
                    switch(itemEspecial) {
                        case 0:
                            value = 10 + rand.nextInt(especiais.getArmaSize());
                            break;
                        case 1:
                            value = 20 + rand.nextInt(especiais.getBombaSize());
                            break;
                        case 2:
                            value = 30 + rand.nextInt(especiais.getVirusSize());
                            break;
                    }
                    this.arena.setElement(x, y, value);
                }
            }

            i++;
        } while(i < (densidade + this.robo.size()));

        for (int q = 0; q < 2; q++) {
            System.out.println("Posição do jogador " + (q + 1) + " (x, y)");
            System.out.printf("|");
            for (int w = 0; w < 2; w++) {
                System.out.printf(" %d ", this.arena.getCoordenadas()[q][w]);
            }
            System.out.printf("|\n");
        }
        System.out.println("\n");
    }
}