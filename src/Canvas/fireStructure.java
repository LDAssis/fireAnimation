package Canvas;


import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class fireStructure {
    int matriz[][];
    Color paletFire[] = new Color[7];
    int altura = 10; // quanto menos mais alto o fogo
    boolean showMatriz = false;
    
    
    
    public fireStructure(int largura, int altura){
        matriz = new int[altura][largura];
        for (int alt = 0; alt < matriz.length; alt++) {
            for (int larg = 0; larg < matriz[0].length; larg++) {
                matriz[alt][larg] = 0;
                if(alt == matriz.length -1){
                    matriz[alt][larg] = 100;
                }
            }
        }
        paletFire[0] = new Color(0,0,0);
        paletFire[1] = new Color(149, 27, 0);
        paletFire[2] = new Color(194, 31, 0);
        paletFire[3] = new Color(209, 55, 0);
        paletFire[4] = new Color(255, 107, 0);
        paletFire[5] = new Color(255, 141, 0);
        paletFire[6] = new Color(255, 185, 0);
    }
    
    public void draw(Graphics g, int width, int heigth){
        heigth = (heigth/matriz.length);
        width = (width/matriz[0].length);
        for (int alt = 0; alt < matriz.length; alt++) {
            for (int larg = 0; larg < matriz[0].length; larg++){
                int posW = ((width*(larg+1))+(width*larg))/2;
                int posH = ((heigth*(alt+1))+(heigth*alt))/2;
                double redIntensity = (double)((double)(matriz[alt][larg]/(double)100)*(double)6);
                g.setColor(paletFire[(int)redIntensity]);
                g.fillRect(width*larg, heigth*alt, width*(larg+1), heigth*(alt+1));
            }
        }
        firePropagation();
    }
    public void drawMatriz(Graphics g, int width, int heigth){
        heigth = (heigth/matriz.length);
        width = (width/matriz[0].length);
        for (int alt = 0; alt < matriz.length; alt++) {
            for (int larg = 0; larg < matriz[0].length; larg++){
                int posW = ((width*(larg+1))+(width*larg))/2;
                int posH = ((heigth*(alt+1))+(heigth*alt))/2;
                g.drawString(""+matriz[alt][larg],posW,posH);
                double redIntensity = (double)((double)(matriz[alt][larg]/(double)100)*(double)6);
                g.setColor(Color.WHITE);
                g.drawRect(width*larg, heigth*alt, width*(larg+1), heigth*(alt+1));
            }
        }
        firePropagation();
    }
    
    public void firePropagation(){
        for (int alt = 0; alt < matriz.length-1; alt++) {
            for (int larg = 0; larg < matriz[0].length; larg++){
                double vBaixo = matriz[alt+1][larg];
                double porcentDecrease = (int)(Math.random()*101);
                double novoValor = vBaixo - ((porcentDecrease/100)*altura);
                if (novoValor > -1){
                    matriz[alt][larg] = (int)novoValor;
                }
            }
        }
    }
}
