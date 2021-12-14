/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materials;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author CVanHau
 */
public class Truc3D extends JPanel{
    
    public void Truc3D(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.LIGHT_GRAY);
        int y=400, x=500;
        
        while(y<674){
            g2d.drawLine(0, y+5, 1104, y+5);
            y+=5;
        }
        
        y=400;
        while(y>0){
            g2d.drawLine(0, y-5, 1104, y-5);
            y-=5;
        }
        
        while(x<1104){
            g2d.drawLine(x+5, 674, x+5, 0);
            x+=5;
        }
        x=500;
        while(x>0){
            g2d.drawLine(x-5, 674, x-5, 0);
            x-=5;
        }
        g2d.drawLine(0, 400 , 500, 400);
        g2d.drawLine(500, 400, 500, 674); 
        // Tâm O(500,400)
        g2d.setPaint(Color.RED);
        //Ox 300, 301
        g2d.drawLine(500,400 , 1104, 400);
        //Oy 301, 302
        g2d.drawLine(500, 400, 500, 0); 
        g2d.drawLine(500, 400, 226, 674); 
        g2d.drawString("X", 1090, 390);
        g2d.drawString("Z", 223, 665);
        g2d.drawString("Y", 490, 20);
    }
}
