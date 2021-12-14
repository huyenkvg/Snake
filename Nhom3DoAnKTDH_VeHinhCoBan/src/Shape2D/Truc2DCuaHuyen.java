/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Nhóm 3 - Nguyễn Đỗ Yến Chi - Châu Văn Hậu - Lê Thị Thu Hương - Nguyễn
 * Thị Thanh Huyền - Nguyễn Thị Thảo Nguyên
 */
public class Truc2DCuaHuyen extends JPanel {

    public boolean AxisVisible = true;


    public Truc2DCuaHuyen() {
    
    }
    
    private void Truc2DCuaHuyen(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (AxisVisible) {
            g2d.setColor(Color.LIGHT_GRAY);
            int y = 5, x = 5;

            while (y < 650) {
                g2d.drawLine(0, y, 1100, y);
                y += 5;
            }

            while (x < 1100) {
                g2d.drawLine(x, 650, x, 0);
                x += 5;
            }

            g2d.setPaint(Color.blue);
            //Ox 300, 301
            g2d.drawLine(0, 327, 1100, 327);
            //Oy 301, 302
            g2d.drawLine(552, 0, 552, 650);

        }
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Truc2DCuaHuyen(g);
    }
    
    
               
        
    public void VeTrucToaDo(){
//        AxisVisible = (true);
        repaint();
    }

}
