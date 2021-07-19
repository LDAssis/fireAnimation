/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class frame extends Canvas implements Runnable {

    fireStructure fs = new fireStructure(40, 30);
    boolean drawMatriz = false;
    int framesPseg = 30;

    @Override
    public void run() {
        while (true) {
            render();
            try {
                Thread.sleep(1000 / framesPseg);
            } catch (InterruptedException ex) {
                Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public frame() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                drawMatriz = !drawMatriz;
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }


    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, getWidth(), getHeight());
        if (drawMatriz) {
            fs.drawMatriz(g, getWidth(), getHeight());
        } else {
            fs.draw(g, getWidth(), getHeight());
        }
        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        frame cF = new frame();
        JFrame jf = new JFrame();
        jf.add(cF);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400, 300);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        new Thread(cF).start();
    }

}
