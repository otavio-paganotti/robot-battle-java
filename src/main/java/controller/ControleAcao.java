/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.*;

/**
 *
 * @author otavi
 */
public class ControleAcao {
    private Arena arena;
    private Robo robo;
    private String posicao;

    public ControleAcao(Arena arena, Robo robo, String posicao) {
        this.arena = arena;
        this.robo = robo;
        this.posicao = posicao;
    }
    
    public boolean mover(Robo robo, String posicao) {
        
        /*
        * O robô irá se movimentar pela arena respeitando os limites da mesma.
        * Se o robô enviar seta p/ baixo, o robô se moverá para uma posição abaixo na matriz, e assim sucessivamente.
        * Dentre essas posições da matriz, poderá ter armas, vírus e bombas pelo mapa, então dependendo de onde o personagem se mover, poderá ganhar uma arma nova, ou sofrer dano.
        *      . . .  .  .  .  .  .  .  .  .  .  .  .
        *      . _________________________________  .
        *      . | .  .  .  .  a  .  .  b  .  .  |  .
        *      . | .  .  1  a  .  .  .  v  .  .  |  .
        *      . | .  .  .  .  .  .  .  .  .  v  |  .
        *      . | .  .  .  .  .  .  .  2  .  a  |  .
        *      . | .  .  .  .  .  .  v  .  .  .  |  .
        *      . _________________________________  .
        *      . . .  .  .  .  .  .  .  .  .  .  .  .
        *
        * O jogo será realizado em turnos. Cada jogador, tem direito a 3 movimentos por turno, a não ser que o jogador inimigo esteja em seu range.
        * O jogador poderá se movimentar em 4 direções distintas, e caso ultrapasse os limites da arena, sofrerá dano de forma exponencial.
        * Se o jogador encostar na bomba, sofrerá imediatamente 90 de dano.
        * Se o jogador encostar no vírus, sofrerá imediatamente 40 de dano.
        * Se o jogador encostar na arma, deverá aparecer uma opção de escolha se o usuário quer ou não equipar a arma.
        * Se o jogador colidir com o outro jogador, o mesmo irá spawnar aleatóriamente no mapa.
        * Cada jogador terá 100 pontos de vida.
        * Se o jogador estiver em condições de ataque do outro jogador, poderá efetuar o ataque.
        */
        
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
    
}
