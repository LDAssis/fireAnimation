package jFrame;


import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class frame extends JFrame implements Runnable{
    fireStructure fs = new fireStructure(50, 50);
    
    public frame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setVisible(true);
    }
    
    public void paint(Graphics g){
        g.clearRect(0, 0, getWidth(), getHeight());
        fs.draw(g, getWidth(), getHeight());
    }
    
    public static void main(String[] args) {
        frame f = new frame();
        f.setVisible(true);
        Thread t = new Thread(f);
        t.start();
    }

    @Override
    public void run() {
        while(true){
            repaint();
            try {
                Thread.sleep(1000/10);
            } catch (InterruptedException ex) {
                Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
