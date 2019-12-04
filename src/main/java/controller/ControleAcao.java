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
    private ItensEspeciais especiais;
    private ArrayList<Log> logs;
    private boolean pBomba = false;
    private boolean pVirus = false;

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

    public boolean mover(boolean turno, Arena arena) {

        /*
         * O robô irá se movimentar pela arena respeitando os limites da mesma. Se o
         * robô enviar seta p/ baixo, o robô se moverá para uma posição abaixo na
         * matriz, e assim sucessivamente. Dentre essas posições da matriz, poderá ter
         * armas, vírus e bombas pelo mapa, então dependendo de onde o personagem se
         * mover, poderá ganhar uma arma nova, ou sofrer dano
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

        
        int i = 0;
        int x = turno == true ? 0 : 1;
        int[][] coordenadas = arena.getCoordenadas();
        boolean continua = true;
        arena.setElement(coordenadas[x][0], coordenadas[x][1], 0);
        Scanner scan = new Scanner(System.in);
        
        do {
            String tecla = scan.nextLine();
            try {
                switch (tecla) {
                    case "w":
                        continua = this.checkColision(this.verificaOQueTem(arena, coordenadas[x][0] - 1, coordenadas[x][1]), x);
                        if (this.verificaOQueTem(arena, coordenadas[x][0] - 1, coordenadas[x][1]) == 1 || this.verificaOQueTem(arena, coordenadas[x][0] - 1, coordenadas[x][1]) == 2) {
                            coordenadas = this.colisao(this.verificaOQueTem(arena, coordenadas[x][0] - 1, coordenadas[x][1]), x);
                        } else {
                            if (coordenadas[x][0] - 1 < 0) {
                                throw new ArrayIndexOutOfBoundsException("movimento para fora da arena");
                            }
                            coordenadas[x][0] = coordenadas[x][0] - 1;
                        }
                        break;
                    case "s":
                        continua = this.checkColision(this.verificaOQueTem(arena, coordenadas[x][0]  + 1, coordenadas[x][1]), x);
                        if (this.verificaOQueTem(arena, coordenadas[x][0]  + 1, coordenadas[x][1]) == 1 || this.verificaOQueTem(arena, coordenadas[x][0]  + 1, coordenadas[x][1]) == 2) {
                            coordenadas = this.colisao(this.verificaOQueTem(arena, coordenadas[x][0]  + 1, coordenadas[x][1]), x);
                        } else {
                            if (coordenadas[x][0] + 1 > this.arena.getY()) {
                                throw new ArrayIndexOutOfBoundsException("movimento para fora da arena");
                            }
                            coordenadas[x][0] = coordenadas[x][0] + 1;
                        }
                        break;
                    case "d":
                        continua = this.checkColision(this.verificaOQueTem(arena, coordenadas[x][0], coordenadas[x][1] + 1), x);
                        if (this.verificaOQueTem(arena, coordenadas[x][0], coordenadas[x][1] + 1) == 1 || this.verificaOQueTem(arena, coordenadas[x][0], coordenadas[x][1] + 1) == 2) {
                            coordenadas = this.colisao(this.verificaOQueTem(arena, coordenadas[x][0], coordenadas[x][1] + 1), x);
                        } else {
                            if (coordenadas[x][1] + 1 > this.arena.getX()) {
                                throw new ArrayIndexOutOfBoundsException("movimento para fora da arena");
                            }
                            coordenadas[x][1] = coordenadas[x][1] + 1;
                        }
                        break;
                    case "a":
                        continua = this.checkColision(this.verificaOQueTem(arena, coordenadas[x][0], coordenadas[x][1] - 1), x);
                        if (this.verificaOQueTem(arena, coordenadas[x][0], coordenadas[x][1] - 1) == 1 || this.verificaOQueTem(arena, coordenadas[x][0], coordenadas[x][1] - 1) == 2) {
                            coordenadas = this.colisao(this.verificaOQueTem(arena, coordenadas[x][0], coordenadas[x][1] - 1), x);
                        } else {
                            if (coordenadas[x][1] - 1 < 0) {
                                throw new ArrayIndexOutOfBoundsException("movimento para fora da arena");
                            }
                            coordenadas[x][1] = coordenadas[x][1] - 1;
                        }

                        break;
                    default:
                        System.out.println("Aperte as Teclas W A S D para se mover!!!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("O jogador " + this.robo.get(x).getJogador() + " excedeu os limites da arena! Acabou de perder 20 de vida!\n");
                System.out.println("O jogador " + this.robo.get(x).getJogador() + " foi realocado para sua posição anterior.");
                this.robo.get(x).setVida((this.robo.get(x).getVida() - 20));
            }
            i++;
            arena.setCoordenadas(coordenadas[x][0], coordenadas[x][1], x);
            int player = x == 0 ? 1 : 2;
            arena.setElement(coordenadas[x][0], coordenadas[x][1], player);
            this.logs.add(new Log(coordenadas, this.robo.get(x).getArma(), this.pBomba, this.pVirus, this.robo.get(x), arena.getCoordenadas()));
            this.imprimirMatriz(arena);
            
        } while (i < 1);
        
        // scan.close();
        
        if (continua) {
          this.trocaTurno();
            return true;  
        }
        
        this.imprimeSerializado();
        
        return false;
    }
    
    public void imprimeSerializado() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n\n\n O jogo acabou, deseja ver os Logs do jogo? (0) Para sim, (1) Para não \n\n\n");
        
        int r = scan.nextInt();
        
        if (r == 0) {
            for(int l = 0; l < this.logs.size(); l++) {
                System.out.println("===============================================\n");
                System.out.println("Round " + (l + 1) + ": \n");
                System.out.println("Posição Inicial: \n");
                System.out.println("| " + this.logs.get(l).getPosicao()[0][0] + " " + this.logs.get(l).getPosicao()[0][1] + " |\n");
                System.out.println("| " + this.logs.get(l).getPosicao()[1][0] + " " + this.logs.get(l).getPosicao()[1][1] + " |\n");
                System.out.println("Arma: " + this.logs.get(l).getArma().getNome() + "\n");
                System.out.println("Pisou na bomba? " + this.logs.get(l).isPisouBomba() + "\n");
                System.out.println("Pisou no vírus? " + this.logs.get(l).isPisouVirus() + "\n");
                System.out.println("Vida do Robô " + this.logs.get(l).getRobo().getJogador() + ": " + this.logs.get(l).getRobo().getVida() + "\n");
                System.out.println("Posição Final: \n");
                System.out.println("| " + this.logs.get(l).getNovaPosicao()[0][0] + " " + this.logs.get(l).getNovaPosicao()[0][1] + " |\n");
                System.out.println("| " + this.logs.get(l).getNovaPosicao()[1][0] + " " + this.logs.get(l).getNovaPosicao()[1][1] + " |\n");
            }
        }
        
        scan.close();
    }
    
    public int verificaOQueTem(Arena arena, int i, int j) {
        return arena.getElement(i, j);
    }

    public boolean atacar() {
        return true;
    }

    public boolean pisouBomba(int tipo, int player) {
        Bomba b = this.especiais.getBomba().get((tipo % 10));
        int vida = this.robo.get(player).getVida();
        int dano = Integer.parseInt(b.getDano());
        
        this.robo.get(player).setVida((vida - dano));
        System.out.println("\n\n O jogador " + this.robo.get(player).getJogador() + " pisou na Boma " + b.getNome() + " e perdeu " + b.getDano() + " de vida, restando " + (vida - dano) + " de vida.\n\n");
        if (vida <= 0) {
            System.out.println("\n\n Jogador " + this.robo.get(player).getJogador() + " perdeu!!!\n\n");
            return false;
        }
        return true;
    }

    public boolean pisouVirus(int tipo, int player) {
        Virus v = this.especiais.getVirus().get((tipo % 10));
        int vida = this.robo.get(player).getVida();
        int dano = Integer.parseInt(v.getDano());
        
        this.robo.get(player).setVida(vida - dano);
        System.out.println("\n\n O jogador " + this.robo.get(player).getJogador() + " pisou no Vírus " + v.getNome() + " e perdeu " + v.getDano() + " de vida, restando " + (vida - dano) + " de vida.\n\n");
        if ((vida - dano) <= 0) {
            System.out.println("\n\n Jogador " + this.robo.get(player).getJogador() + " perdeu!!! \n\n");
            return false;
        }
        return true;
    }

    public boolean pisouArma(int tipo, int player) {
        Scanner scan = new Scanner(System.in);
        Arma a = this.especiais.getArmas().get((tipo % 10));
        int r;
        do {
            System.out.println("\n\n Você pisou em cima da arma " + a.getNome() + ". Deseja equipá-la no lugar da sua " + this.robo.get(player).getArma().getNome() + "? (0) para Sim, (1) para Não." );
            r = scan.nextInt();
            System.out.println(r);
        } while (r < 0 || r > 1);
        
        if (r == 0) {
            this.robo.get(player).setArma(a);
            System.out.println("\nArma trocada com sucesso!! \n");
            return true;
        }
        
        return true;
    }

    public int[][] colisao(int tipo, int player) {
        int[][] coordenadas = new int[2][2];
        Random rand = new Random();
        int x = rand.nextInt(this.arena.getX());
        int y = rand.nextInt(this.arena.getY());
        
        coordenadas[player][0] = x;
        coordenadas[player][1] = y;
        
        return coordenadas;
    }

    public void imprimirMatriz(Arena arena) {
        for(int i = 0; i < arena.getX(); i++) {
            System.out.printf("|");
            for (int j = 0; j < arena.getY(); j++) {
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

            this.arena = new Arena(x, y);

            LeituraArquivos arquivos = new LeituraArquivos();

            this.especiais = new ItensEspeciais(arquivos.getVirus(), arquivos.getBombas(), arquivos.getArmas());

            System.out.println("Agora vamos criar os robôs: \n");
            System.out.println("============================\n");
            System.out.println("Qual o nome assustador do Robô nº 1? \n");
            String r1 = scan.next();
            System.out.println("Com qual arma o " + r1 + " vai jogar? \n");
            for(int i = 0; i < arquivos.getArmas().size(); i ++) {
                System.out.printf("\n");
                System.out.println("Nome: " + arquivos.getArmas().get(i).getNome());
                System.out.println("Dano: " + arquivos.getArmas().get(i).getDano());
                System.out.println("Raio: " + arquivos.getArmas().get(i).getRaio());
                System.out.printf("Opção: " + i + "\n\n");
            }
            int a1 = scan.nextInt();
            System.out.println("Leeeeeegaaaaaaallll!!! \nAgora nos mostre o nome do Robô que enfrentará o grandioso " + r1 + " \n");
            String r2 = scan.next();
            System.out.println("Com qual arma o " + r1 + " vai jogar? \n");
            for(int i = 0; i < arquivos.getArmas().size(); i ++) {
                System.out.printf("\n");
                System.out.println("Nome: " + arquivos.getArmas().get(i).getNome());
                System.out.println("Dano: " + arquivos.getArmas().get(i).getDano());
                System.out.println("Raio: " + arquivos.getArmas().get(i).getRaio());
                System.out.printf("Opção: " + i + "\n\n");
            }
            int a2 = scan.nextInt();
            System.out.println("Se preparem " + r1 + " e " + r2 + ", pois enfrentarão uma batalha até a morte!!!!");

            Robo robo1 = new Robo(r1);
            Robo robo2 = new Robo(r2);
            robo1.setArma(arquivos.getArmas().get(a1));
            robo2.setArma(arquivos.getArmas().get(a2));

            ArrayList<Robo> robos = new ArrayList<Robo>();

            robos.add(robo1);
            robos.add(robo2);
            
            this.robo = robos;
            
            this.posicionarElementos(especiais);
            
            this.imprimirMatriz(this.arena);
            
            Random randomNum = new Random();
            int vez = randomNum.nextInt(2);
            
            this.logs = new ArrayList<Log>();
            this.logs.add(new model.Log(this.arena.getCoordenadas(), this.robo.get(vez).getArma(), false, false, this.robo.get(vez), new int[2][2]));
            
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
        System.out.println("\n\n\nVez do jogador " + this.robo.get(valor).getJogador() + " - Vida: " + this.robo.get(valor).getVida() + " - Arma: " + this.robo.get(valor).getArma().getNome() + "\n\n\n");
        this.mover(this.isTurno(), this.arena);
        return true;
    }
    
    public void trocaTurno() {
        this.setTurno(!this.isTurno());
        int vez = this.turno == true ? 0 : 1;
        System.out.println("\n\n\nVez do jogador " + this.robo.get(vez).getJogador() + " - Vida: " + this.robo.get(vez).getVida() + " - Arma: " + this.robo.get(vez).getArma().getNome() + "\n\n\n");
        this.mover(this.isTurno(), this.arena);
    }
    
    public void posicionarElementos(ItensEspeciais especiais) {
        int densidade = (this.arena.getX() * this.arena.getY())/8;
        Random rand = new Random();

        int i = 0;

        do {
            int x = rand.nextInt(this.arena.getX());
            int y = rand.nextInt(this.arena.getY());

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
            System.out.println("Posição do jogador " + robo.get(q).getJogador() + " (x, y)");
            System.out.printf("|");
            for (int w = 0; w < 2; w++) {
                System.out.printf(" %d ", this.arena.getCoordenadas()[q][w]);
            }
            System.out.printf("|\n");
        }
        System.out.println("\n");
    }
    
    public boolean checkColision(int tipo, int x) {
        this.pBomba = false;
        this.pVirus = false;
        switch(tipo) {
            case 10:
                return this.pisouArma(tipo, x);
            case 11:
                return this.pisouArma(tipo, x);
            case 12:
                return this.pisouArma(tipo, x);
            case 20:
                this.pBomba = true;
                return this.pisouBomba(tipo, x);
            case 30:
                this.pVirus = true;
                return this.pisouVirus(tipo, x);
            default:
                break;
        }
        return true;
    }
}
